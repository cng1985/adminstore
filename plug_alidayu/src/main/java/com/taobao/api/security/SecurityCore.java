package com.taobao.api.security;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.internal.util.Base64;
import com.taobao.api.internal.util.LruHashMap;
import com.taobao.api.internal.util.NamedThreadFactory;
import com.taobao.api.internal.util.StringUtils;

/**
 * 加、解密核心类
 * 
 * @author changchun
 * @since 2016年2月26日 下午5:15:17
 */
public class SecurityCore {

    private static final Log log = LogFactory.getLog(SecurityCore.class);
    private String randomNum;// 伪随机码
    // 缓存用户单独分配秘钥
    private static final LruHashMap<String, SecretContext> appUserSecretCache = new LruHashMap<String, SecretContext>(16,
            65536 * 2);
    
    private static final Map<String, SecretContext> appSecretCache = new HashMap<String, SecretContext>();
    // 异步更新秘钥
    private ExecutorService asynUpdateSecret;
    private DefaultTaobaoClient defaultTaobaoClient;
    private Set<String> asynQueneKey = new HashSet<String>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static final long DEFAULT_INTERVAL = 300;// 5分钟
    private static final long DEFAULT_MAX_INTERVAL = 600;// 10分钟
    
    public SecurityCore(DefaultTaobaoClient defaultTaobaoClient, String randomNum, int corePoolSize, int maxPoolSize, int maxQueue) {
        this.defaultTaobaoClient = defaultTaobaoClient;
        this.randomNum = randomNum;
        init(corePoolSize, maxPoolSize, maxQueue);
    }

    /**
     * 初始化线程池
     * 
     * @param corePoolSize
     * @param maxPoolSize
     * @param maxQueue
     */
    private void init(int corePoolSize, int maxPoolSize, int maxQueue) {
        if (corePoolSize <= 0 || maxPoolSize <= 0 || maxQueue <= 0 || corePoolSize > maxPoolSize) {
            throw new IllegalArgumentException("param error");
        }
        asynUpdateSecret = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(maxQueue), new NamedThreadFactory("taobao sdk asyn update secret", true),
                new AbortPolicy());
    }

    public void setRandomNum(String randomNum) {
        this.randomNum = randomNum;
    }

    /**
     * 
     * @param session
     * @param secretVersion
     * @return
     * @throws ApiException
     */
    public SecretContext getSecret(String session, Long secretVersion) throws ApiException {
        SecretContext secretContext = getSecret(session, generateSecretKey(session, secretVersion));
        if (secretContext != null) {
            if (secretContext.isValid()) {
                return secretContext;
            }

            if (secretContext.isMaxValid()) {
                // 异步更新秘钥
                asynUpdateSecret(session, secretVersion);
                return secretContext;
            }
            // 同步调用获取秘钥
            return callSecretApi(session, secretVersion);
        } else {
            // 同步调用获取秘钥
            return callSecretApi(session, secretVersion);
        }
    }

    /**
     * @param session
     * @param secretVersion
     * @return
     */
    private String generateSecretKey(String session, Long secretVersion) {
        if (secretVersion == null) {
            return session;
        }

        return session + "_" + secretVersion;
    }

    /**
     * @param session
     * @param cacheKey
     * @return
     */
    private SecretContext getSecret(String session, String cacheKey) {
        SecretContext secretContext;
        if (session != null) {
            secretContext = appUserSecretCache.get(cacheKey);
        } else {
            secretContext = appSecretCache.get(cacheKey);
        }
        return secretContext;
    }

    /**
     * 调用获取秘钥api
     * 
     * @param session
     * @param secretVersion
     */
    private SecretContext callSecretApi(String session, Long secretVersion) throws ApiException {
        // 获取伪随机码
        if (StringUtils.isEmpty(randomNum)) {
            throw new IllegalArgumentException("randomNum can`t be empty");
        }

        TopSecretGetRequest request = new TopSecretGetRequest();
        request.setRandomNum(randomNum);
        request.setSecretVersion(secretVersion);
        TopSecretGetResponse response;
        response = defaultTaobaoClient.execute(request, session);
        if (response.isSuccess() && response.getSecret() != null) {
            SecretContext secretContext = new SecretContext();
            long currentTime = System.currentTimeMillis();
            secretContext.setInvalidTime(currentTime + (response.getInterval() * 1000));
            secretContext.setMaxInvalidTime(currentTime + (response.getMaxInterval() * 1000));
            secretContext.setSecret(Base64.decode(response.getSecret()));
            secretContext.setSecretVersion(response.getSecretVersion());
            String cacheKey = generateSecretKey(session, secretVersion);
            if (session != null) {
                appUserSecretCache.put(cacheKey, secretContext);
            } else {
                appSecretCache.put(cacheKey, secretContext);
            }
            return secretContext;
        } else {
            // 查找不到历史秘钥
            if ("20005".equals(response.getSubCode())) {
                SecretContext secretContext = new SecretContext();
                long currentTime = System.currentTimeMillis();
                secretContext.setInvalidTime(currentTime + (DEFAULT_INTERVAL * 1000));
                secretContext.setMaxInvalidTime(currentTime + (DEFAULT_MAX_INTERVAL * 1000));
                String cacheKey = generateSecretKey(session, secretVersion);
                if (session != null) {
                    appUserSecretCache.put(cacheKey, secretContext);
                } else {
                    appSecretCache.put(cacheKey, secretContext);
                }
                return secretContext;
            }
            throw new ApiException(response.getSubCode(), response.getSubMsg());
        }
    }

    /**
     * 异步更新秘钥
     * 
     * @param session
     * @param secretVersion
     */
    private void asynUpdateSecret(final String session, final Long secretVersion) {
        final String cacheKey = generateSecretKey(session, secretVersion);

        if (readWriteLock.writeLock().tryLock()) {
            try {
                // 不需要重复提交秘钥请求
                if (asynQueneKey.contains(cacheKey)) {
                    return;
                }
                asynQueneKey.add(cacheKey);

                asynUpdateSecret.submit(new Runnable() {
                    public void run() {
                        try {
                            callSecretApi(session, secretVersion);
                        } catch (ApiException e) {
                            if (log.isErrorEnabled()) {
                                log.error("asyn update secret error", e);
                            }
                        } finally {
                            if (readWriteLock.writeLock().tryLock()) {
                                asynQueneKey.remove(cacheKey);
                                readWriteLock.writeLock().unlock();
                            }
                        }
                    }
                });
            } catch (RuntimeException e) {
                // 可能会抛出RejectedExecutionException 、NullPointerException等异常
                asynQueneKey.remove(cacheKey);
                throw e;
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }

    }

    /**
     * 获取秘钥版本、加密原始数据
     * 
     * @param data
     * @param separatorChar
     * 
     * @return
     */
    public static SecretData getSecretData(String data, char separatorChar) {
        SecretData secretData = new SecretData();
        if (SecurityClient.PHONE_SEPARATOR_CHAR == separatorChar) {
            for (int i = data.length() - 2; i > 1; i--) {
                char value = data.charAt(i);
                if (separatorChar == value) {
                    // 手机号码前缀
                    int phonePrefixIndex = data.indexOf(separatorChar, 1);
                    if (phonePrefixIndex != i) {
                        secretData.setPrefixValue(data.substring(1, phonePrefixIndex));
                        secretData.setOriginalBase64Value(data.substring(phonePrefixIndex + 1, i));
                    }
                    secretData.setSecretVersion(Long.valueOf(data.substring(i + 1, data.length() - 1)));
                    break;
                }
            }
        } else {
            for (int i = data.length() - 2; i > 1; i--) {
                char value = data.charAt(i);
                if (separatorChar == value) {
                    secretData.setOriginalBase64Value(data.substring(1, i));
                    secretData.setSecretVersion(Long.valueOf(data.substring(i + 1, data.length() - 1)));
                    break;
                }
            }
        }
        return secretData;
    }

}
