package com.taobao.api.request;

import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.HttpdnsGetResponse;

/**
 * TOP API: taobao.httpdns.get request
 * 
 * @author top auto create
 * @since 1.0, 2016.03.24
 */
public class HttpdnsGetRequest extends BaseTaobaoRequest<HttpdnsGetResponse> {
	
	

	public String getApiMethodName() {
		return "taobao.httpdns.get";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<HttpdnsGetResponse> getResponseClass() {
		return HttpdnsGetResponse.class;
	}

	public void check() throws ApiRuleException {
	}
	

}