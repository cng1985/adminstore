package com.taobao.api.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.SecretException;
import com.taobao.api.internal.util.Base64;
import com.taobao.api.internal.util.StringUtils;
import com.taobao.api.internal.util.TaobaoUtils;

/**
 * 加、解密客户端(单例使用，不要初始化多个)
 * 
 * @author changchun
 * @since 2016年2月26日 下午5:15:17
 */
public class SecurityClient {

    public static final String NICK = "nick";
    public static final String PHONE = "phone";
    public static final String NORMAL = "normal";
    public static final char NICK_SEPARATOR_CHAR = '~';
    public static final String NICK_SEPARATOR = String.valueOf(NICK_SEPARATOR_CHAR);
    public static final char PHONE_SEPARATOR_CHAR = '$';
    public static final String PHONE_SEPARATOR = String.valueOf(PHONE_SEPARATOR_CHAR);
    public static final char NORMAL_SEPARATOR_CHAR = (char) 0x01;
    public static final String NORMAL_SEPARATOR = String.valueOf(NORMAL_SEPARATOR_CHAR);
    public static final Map<String,Character> CHAR_MAP = new HashMap<String, Character>();
    static {
        CHAR_MAP.put(NICK, NICK_SEPARATOR_CHAR);
        CHAR_MAP.put(NORMAL, NORMAL_SEPARATOR_CHAR);
        CHAR_MAP.put(PHONE, PHONE_SEPARATOR_CHAR);
    }
    
    // 秘钥管理核心类
    private SecurityCore secretCore;

    /**
     * 
     * @param defaultTaobaoClient
     *            serverUrl必须是https协议
     * @param randomNum
     *            伪随机码
     */
    public SecurityClient(DefaultTaobaoClient defaultTaobaoClient, String randomNum) {
        this(defaultTaobaoClient, randomNum, 2, 8, Integer.MAX_VALUE);
    }

    /**
     * 
     * @param defaultTaobaoClient
     *            serverUrl必须是https协议
     * @param randomNum
     *            伪随机码
     * @param corePoolSize
     *            核心线程数
     * @param maxPoolSize
     *            最大线程数
     * @param maxQueue
     *            线程池最大队列
     */
    public SecurityClient(DefaultTaobaoClient defaultTaobaoClient, String randomNum, int corePoolSize, int maxPoolSize,
            int maxQueue) {
        secretCore = new SecurityCore(defaultTaobaoClient, randomNum, corePoolSize, maxPoolSize, maxQueue);
    }

    /**
     * 初始化秘钥（如果半小时内会调用加、解密方法，建议先初始化秘钥）。所有用户共用秘钥
     * 
     * @throws ApiException
     */
    public void initSecret() throws ApiException {
        secretCore.getSecret(null, null);
    }

    public void setRandomNum(String randomNum) {
        this.secretCore.setRandomNum(randomNum);
    }

    /**
     * 初始化秘钥（如果半小时内会调用加、解密方法，建议先初始化秘钥）。每个用户单独分配秘钥
     * 
     * @param session
     * @throws ApiException
     */
    public void initSecret(String session) throws ApiException {
        secretCore.getSecret(session, null);
    }

    /**
     * 批量解密（所有用户共用秘钥）
     * 
     * @see #decrypt(List, String, String)
     * @param dataList
     * @param type
     * @throws SecretException
     */
    public Map<String, String> decrypt(List<String> dataList, String type) throws SecretException {
        return decrypt(dataList, type, null);
    }

    /**
     * 批量解密（每个用户单独分配秘钥）
     * 
     * @see #decrypt(String, String, String)
     * @param dataList
     * @param type
     * @param session
     * @return key=密文数据，value=明文数据
     * @throws SecretException
     */
    public Map<String, String> decrypt(List<String> dataList, String type, String session) throws SecretException {
        if (dataList == null || dataList.isEmpty()) {
            throw new SecretException("dataList can`t be empty");
        }
        Map<String, String> resultMap = new HashMap<String, String>();
        for (String data : dataList) {
            String decryptValue = decrypt(data, type, session);
            resultMap.put(data, decryptValue);
        }
        return resultMap;
    }

    /**
     * 解密（所有用户共用秘钥）
     * 
     * @see #decrypt(String, String, String)
     * 
     * @param data
     * @param type
     * @return
     * @throws SecretException
     */
    public String decrypt(String data, String type) throws SecretException {
        return decrypt(data, type, null);
    }

    /**
     * 解密（每个用户单独分配秘钥）
     * 
     * @param data
     *            密文数据 手机号码格式：$手机号码前3位明文$base64(encrypt(phone后8位置))$111$
     *            nick格式：~base64(encrypt(nick))~111~
     * @param type
     *            解密字段类型(例如：nick\phone)
     * @param session
     *            用户身份,用户级加密必填
     * @return
     */
    public String decrypt(String data, String type, String session) throws SecretException {
        if (StringUtils.isEmpty(data) || data.length() < 4) {
            return data;
        }

        SecretData secretDataDO = null;
        if (NICK.equals(type)) {
            if (!(data.startsWith(NICK_SEPARATOR) && data.endsWith(NICK_SEPARATOR))) {
                return data;
            }
            secretDataDO = SecurityCore.getSecretData(data, NICK_SEPARATOR_CHAR);
        } else if (PHONE.equals(type)) {
            if (!(data.startsWith(PHONE_SEPARATOR) && data.endsWith(PHONE_SEPARATOR))) {
                return data;
            }
            secretDataDO = SecurityCore.getSecretData(data, PHONE_SEPARATOR_CHAR);
        } else if (NORMAL.equals(type)) {
            if (!(data.startsWith(NORMAL_SEPARATOR) && data.endsWith(NORMAL_SEPARATOR))) {
                return data;
            }
            secretDataDO = SecurityCore.getSecretData(data, NORMAL_SEPARATOR_CHAR);
        } else {
            throw new SecretException("type error");
        }

        try {
            SecretContext secretContextDO = secretCore.getSecret(session, secretDataDO.getSecretVersion());
            String decryptValue = TaobaoUtils.aesDecrypt(secretDataDO.getOriginalBase64Value(), secretContextDO.getSecret());
            if (PHONE.equals(type)) {
                // 加上手机号前3位，手机号只加密了后8位
                return secretDataDO.getPrefixValue() + decryptValue;
            }
            return decryptValue;
        } catch (ApiException e) {
            throw new SecretException("get secret error", e);
        }

    }
    
    /**
     * 判断list原始是否全部为密文数据
     * 
     * @see #isEncryptData(String, String)
     * 
     * @param dataList
     * 
     * @param type
     *            加密字段类型(例如：nick\phone)
     * @return
     * @throws SecretException
     */
    public static boolean isEncryptData(List<String> dataList, String type) throws SecretException {
        if (dataList == null || dataList.isEmpty()) {
            return false;
        }
        boolean result = false;
        for (String data : dataList) {
            result = isEncryptData(data, type);
            if (!result) {
                return false;
            }
        }
        return result;
    }

    /**
     * 判断是否密文数据
     * 
     * @param data
     * 
     * @param type
     *            加密字段类型(例如：nick\phone)
     * @return
     * @throws SecretException
     */
    public static boolean isEncryptData(String data, String type) throws SecretException {
        if (StringUtils.isEmpty(data) || data.length() < 4) {
            return false;
        }

        Character charValue = CHAR_MAP.get(type);
        if (charValue == null) {
            throw new SecretException("type error");
        }
        char separatorChar = charValue.charValue();
        if ((separatorChar == NICK_SEPARATOR_CHAR) || (separatorChar == NORMAL_SEPARATOR_CHAR)) {
            if (data.charAt(0) == separatorChar && data.charAt(data.length() - 1) == separatorChar) {
                for (int i = data.length() - 3; i > 1; i--) {
                    char value = data.charAt(i);
                    if (separatorChar == value) {
                        String version = data.substring(i + 1, data.length() - 1);
                        if (StringUtils.isDigits(version) && Long.valueOf(version) > 0) {
                            boolean isBase64Value = Base64.isBase64Value(data.substring(1, i));
                            if (isBase64Value) {
                                return true;
                            }
                        }
                        return false;
                    }
                }
            }
        } else if (separatorChar == PHONE_SEPARATOR_CHAR) {
            for (int i = data.length() - 3; i > 1; i--) {
                char value = data.charAt(i);
                if (separatorChar == value) {
                    // 手机号码前缀
                    int phonePrefixIndex = data.indexOf(separatorChar, 1);
                    if (phonePrefixIndex != i) {
                        String version = data.substring(i + 1, data.length() - 1);
                        if (StringUtils.isDigits(version) && Long.valueOf(version) > 0) {
                            boolean isBase64Value = Base64.isBase64Value(data.substring(phonePrefixIndex + 1, i));
                            if (isBase64Value) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * 加密（所有用户共用秘钥）
     * 
     * @see #encrypt(String, String, String, Long)
     * 
     * @param data
     * @param type
     * @return
     * @throws SecretException
     */
    public String encrypt(String data, String type) throws SecretException {
        return encrypt(data, type, null, null);
    }
    
    /**
     * 用老秘钥加密，只在秘钥升级时使用（所有用户共用秘钥）
     * 
     * @see #encrypt(String, String, String, Long)
     * 
     * @param data
     * @param type
     * @return
     * @throws SecretException
     */
    public String encryptPrevious(String data, String type) throws SecretException {
        return encrypt(data, type, null, -1L);
    }

    /**
     * 加密（每个用户单独分配秘钥）
     * 
     * @see #encrypt(String, String, String, Long)
     * @return
     */
    public String encrypt(String data, String type, String session) throws SecretException {
        return encrypt(data, type, session, null);
    }

    /**
     * 用老秘钥加密，只在秘钥升级时使用（每个用户单独分配秘钥）
     * 
     * @see #encrypt(String, String, String, Long)
     * @return
     */
    public String encryptPrevious(String data, String type, String session) throws SecretException {
        return encrypt(data, type, session, -1L);
    }

    /**
     * 加密之后格式。
     * 手机号码格式：$手机号码前3位明文$base64(encrypt(phone后8位置))$111$
     * nick格式：~base64(encrypt(nick))~111~
     * 
     * @param data
     *            明文数据
     * @param type
     *            加密字段类型(例如：nick\phone)
     * @param session
     *            用户身份,用户级加密必填
     * @param version
     *            秘钥历史版本
     * @return
     */
    private String encrypt(String data, String type, String session, Long version) throws SecretException {
        if (StringUtils.isEmpty(data)) {
            return data;
        }
        try {
            SecretContext secretContext = secretCore.getSecret(session, version);
            if (secretContext == null) {
                throw new SecretException("secretKey is null");
            }
            if (secretContext.getSecret() == null) {
                return data;
            }

            if (NICK.equals(type)) {
                return NICK_SEPARATOR + TaobaoUtils.aesEncrypt(data, secretContext.getSecret()) + NICK_SEPARATOR
                        + secretContext.getSecretVersion() + NICK_SEPARATOR;
            } else if (PHONE.equals(type)) {
                if (data.length() < 11) {
                    throw new SecretException("phoneNumber error");
                }
                String prefixNumber = data.substring(0, data.length() - 8);
                // 取后8位置
                String last8Number = data.substring(data.length() - 8);

                return PHONE_SEPARATOR + prefixNumber + PHONE_SEPARATOR
                        + TaobaoUtils.aesEncrypt(last8Number, secretContext.getSecret()) + PHONE_SEPARATOR
                        + secretContext.getSecretVersion() + PHONE_SEPARATOR;
            } else if (NORMAL.equals(type)) {
                return NORMAL_SEPARATOR + TaobaoUtils.aesEncrypt(data, secretContext.getSecret()) + NORMAL_SEPARATOR
                        + secretContext.getSecretVersion() + NORMAL_SEPARATOR;
            } else {
                throw new SecretException("type error");
            }
        } catch (ApiException e) {
            throw new SecretException("get secret error", e);
        }
    }

    /**
     * 批量加密（所有用户共用秘钥）
     * 
     * @see #encrypt(List, String, String)
     * @param dataList
     * @param type
     * @return
     * @throws SecretException
     */
    public Map<String, String> encrypt(List<String> dataList, String type) throws SecretException {
        return encrypt(dataList, type, null);
    }

    /**
     * 批量加密（每个用户单独分配秘钥）
     * 
     * @see #encrypt(String, String, String, Long)
     * @param dataList
     * @param type
     * @param session
     * @return key=明文数据，value=密文数据
     * @throws SecretException
     */
    public Map<String, String> encrypt(List<String> dataList, String type, String session) throws SecretException {
        if (dataList == null || dataList.isEmpty()) {
            throw new SecretException("dataList can`t be empty");
        }
        Map<String, String> resultMap = new HashMap<String, String>();
        for (String data : dataList) {
            String encryptValue = encrypt(data, type, session, null);
            resultMap.put(data, encryptValue);
        }
        return resultMap;
    }
}
