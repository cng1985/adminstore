package com.taobao.api.request;

import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.AlibabaAliqinFcFlowGradeResponse;

/**
 * TOP API: alibaba.aliqin.fc.flow.grade request
 * 
 * @author top auto create
 * @since 1.0, 2016.03.30
 */
public class AlibabaAliqinFcFlowGradeRequest extends BaseTaobaoRequest<AlibabaAliqinFcFlowGradeResponse> {
	
	

	public String getApiMethodName() {
		return "alibaba.aliqin.fc.flow.grade";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<AlibabaAliqinFcFlowGradeResponse> getResponseClass() {
		return AlibabaAliqinFcFlowGradeResponse.class;
	}

	public void check() throws ApiRuleException {
	}
	

}