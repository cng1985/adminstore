package com.taobao.api.security;

/**
 * 
 * @author changchun
 * @since 2016年3月4日 下午4:48:31
 */
public class SecretData {

    private String prefixValue;// 前缀明文数据
    private String originalBase64Value;// 原始base64加密之后的密文数据
    private Long secretVersion;// 秘钥版本

    public String getPrefixValue() {
        return prefixValue;
    }

    public void setPrefixValue(String prefixValue) {
        this.prefixValue = prefixValue;
    }

    public String getOriginalBase64Value() {
        return originalBase64Value;
    }

    public void setOriginalBase64Value(String originalBase64Value) {
        this.originalBase64Value = originalBase64Value;
    }

    public Long getSecretVersion() {
        return secretVersion;
    }

    public void setSecretVersion(Long secretVersion) {
        this.secretVersion = secretVersion;
    }

}