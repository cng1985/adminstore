package com.taobao.api.request;

import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.AppipGetResponse;

/**
 * TOP API: taobao.appip.get request
 * 
 * @author top auto create
 * @since 1.0, 2014.11.26
 */
public class AppipGetRequest extends BaseTaobaoRequest<AppipGetResponse> {
	
	

	public String getApiMethodName() {
		return "taobao.appip.get";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<AppipGetResponse> getResponseClass() {
		return AppipGetResponse.class;
	}

	public void check() throws ApiRuleException {
	}
	

}