package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.AlibabaAliqinFcFlowChargeResponse;

/**
 * TOP API: alibaba.aliqin.fc.flow.charge request
 * 
 * @author top auto create
 * @since 1.0, 2016.03.30
 */
public class AlibabaAliqinFcFlowChargeRequest extends BaseTaobaoRequest<AlibabaAliqinFcFlowChargeResponse> {
	
	

	/** 
	* 需要充值的流量
	 */
	private String grade;

	/** 
	* 唯一流水号
	 */
	private String outRechargeId;

	/** 
	* 手机号
	 */
	private String phoneNum;

	/** 
	* 充值原因
	 */
	private String reason;

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setOutRechargeId(String outRechargeId) {
		this.outRechargeId = outRechargeId;
	}

	public String getOutRechargeId() {
		return this.outRechargeId;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReason() {
		return this.reason;
	}

	public String getApiMethodName() {
		return "alibaba.aliqin.fc.flow.charge";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("grade", this.grade);
		txtParams.put("out_recharge_id", this.outRechargeId);
		txtParams.put("phone_num", this.phoneNum);
		txtParams.put("reason", this.reason);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<AlibabaAliqinFcFlowChargeResponse> getResponseClass() {
		return AlibabaAliqinFcFlowChargeResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(grade, "grade");
		RequestCheckUtils.checkNotEmpty(outRechargeId, "outRechargeId");
		RequestCheckUtils.checkNotEmpty(phoneNum, "phoneNum");
	}
	

}