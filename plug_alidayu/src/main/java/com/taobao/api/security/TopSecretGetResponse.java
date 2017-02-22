package com.taobao.api.security;

import com.taobao.api.TaobaoResponse;
import com.taobao.api.internal.mapping.ApiField;

/**
 * 
 * @author changchun
 * @since 2016年3月3日 下午2:04:30
 */
public class TopSecretGetResponse extends TaobaoResponse {

    private static final long serialVersionUID = 5321836199587199672L;

    /**
     * 秘钥值
     */
    @ApiField("secret")
    private String secret;

    /**
     * 秘钥版本号
     */
    @ApiField("secret_version")
    private Long secretVersion;

    /**
     * 下次更新秘钥间隔，单位（秒）
     */
    @ApiField("interval")
    private Long interval;

    /**
     * 最长有效期，容灾使用，单位（秒）
     */
    @ApiField("max_interval")
    private Long maxInterval;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getSecretVersion() {
        return secretVersion;
    }

    public void setSecretVersion(Long secretVersion) {
        this.secretVersion = secretVersion;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public Long getMaxInterval() {
        return maxInterval;
    }

    public void setMaxInterval(Long maxInterval) {
        this.maxInterval = maxInterval;
    }

}
