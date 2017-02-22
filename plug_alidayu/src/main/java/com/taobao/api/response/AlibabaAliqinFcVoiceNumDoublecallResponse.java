package com.taobao.api.response;

import com.taobao.api.domain.BizResult;
import com.taobao.api.internal.mapping.ApiField;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: alibaba.aliqin.fc.voice.num.doublecall response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class AlibabaAliqinFcVoiceNumDoublecallResponse extends TaobaoResponse {

	private static final long serialVersionUID = 5137928283343241921L;

	/** 
	 * 接口返回参数
	 */
	@ApiField("result")
	private BizResult result;


	public void setResult(BizResult result) {
		this.result = result;
	}
	public BizResult getResult( ) {
		return this.result;
	}
	


}
