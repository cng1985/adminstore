package com.taobao.api.security;

/**
 * 
 * @author changchun
 * @since 2016年3月4日 下午4:48:52
 */
public class SecretContext {
    private byte[] secret;
    private Long secretVersion;
    private long invalidTime;// 过期时间，单位（毫秒）
    private long maxInvalidTime;// 最长有效期，单位（毫秒）

    public byte[] getSecret() {
        return secret;
    }

    public void setSecret(byte[] secret) {
        this.secret = secret;
    }

    public Long getSecretVersion() {
        return secretVersion;
    }

    public void setSecretVersion(Long secretVersion) {
        this.secretVersion = secretVersion;
    }

    public long getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(long invalidTime) {
        this.invalidTime = invalidTime;
    }

    /**
     * 判断是否过期
     * 
     * @return
     */
    public boolean isValid() {
        return invalidTime > System.currentTimeMillis();
    }

    /**
     * 容灾，调用api获取秘钥可能会失败，在失败情况下最长有效期
     * 
     * @return
     */
    public boolean isMaxValid() {
        return maxInvalidTime > System.currentTimeMillis();
    }

    public void setMaxInvalidTime(long maxInvalidTime) {
        this.maxInvalidTime = maxInvalidTime;
    }

}
