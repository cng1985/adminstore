package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.top.secret.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TopSecretGetResponse extends TaobaoResponse {

	private static final long serialVersionUID = 3785854439236386567L;

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


	public void setInterval(Long interval) {
		this.interval = interval;
	}
	public Long getInterval( ) {
		return this.interval;
	}

	public void setMaxInterval(Long maxInterval) {
		this.maxInterval = maxInterval;
	}
	public Long getMaxInterval( ) {
		return this.maxInterval;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getSecret( ) {
		return this.secret;
	}

	public void setSecretVersion(Long secretVersion) {
		this.secretVersion = secretVersion;
	}
	public Long getSecretVersion( ) {
		return this.secretVersion;
	}
	


}
