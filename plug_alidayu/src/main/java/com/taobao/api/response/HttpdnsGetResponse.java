package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.httpdns.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class HttpdnsGetResponse extends TaobaoResponse {

	private static final long serialVersionUID = 3639286997573216982L;

	/** 
	 * HTTP DNS配置信息
	 */
	@ApiField("result")
	private String result;


	public void setResult(String result) {
		this.result = result;
	}
	public String getResult( ) {
		return this.result;
	}
	


}
