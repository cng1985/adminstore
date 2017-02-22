package com.taobao.api.request;

import com.taobao.api.internal.util.json.JSONValidatingReader;
import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * TOP API: alibaba.aliqin.fc.sms.num.send request
 * 
 * @author top auto create
 * @since 1.0, 2016.05.24
 */
public class AlibabaAliqinFcSmsNumSendRequest extends BaseTaobaoRequest<AlibabaAliqinFcSmsNumSendResponse> {
	
	

	/** 
	* 公共回传参数，在“消息返回”中会透传回该参数；举例：用户可以传入自己下级的会员ID，在消息返回时，该会员ID会包含在内，用户可以根据该会员ID识别是哪位会员使用了你的应用
	 */
	private String extend;

	/** 
	* 短信接收号码。支持单个或多个手机号码，传入号码为11位手机号码，不能加0或+86。群发短信需传入多个号码，以英文逗号分隔，一次调用最多传入200个号码。示例：18600000000,13911111111,13322222222
	 */
	private String recNum;

	/** 
	* 短信签名，传入的短信签名必须是在阿里大鱼“管理中心-短信签名管理”中的可用签名。如“阿里大鱼”已在短信签名管理中通过审核，则可传入”阿里大鱼“（传参时去掉引号）作为短信签名。短信效果示例：【阿里大鱼】欢迎使用阿里大鱼服务。
	 */
	private String smsFreeSignName;

	/** 
	* 短信模板变量，传参规则{"key":"value"}，key的名字须和申请模板中的变量名一致，多个变量之间以逗号隔开。示例：针对模板“验证码${code}，您正在进行${product}身份验证，打死不要告诉别人哦！”，传参时需传入{"code":"1234","product":"alidayu"}
	 */
	private String smsParam;

	/** 
	* 短信模板ID，传入的模板必须是在阿里大鱼“管理中心-短信模板管理”中的可用模板。示例：SMS_585014
	 */
	private String smsTemplateCode;

	/** 
	* 短信类型，传入值请填写normal
	 */
	private String smsType;

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public String getExtend() {
		return this.extend;
	}

	public void setRecNum(String recNum) {
		this.recNum = recNum;
	}

	public String getRecNum() {
		return this.recNum;
	}

	public void setSmsFreeSignName(String smsFreeSignName) {
		this.smsFreeSignName = smsFreeSignName;
	}

	public String getSmsFreeSignName() {
		return this.smsFreeSignName;
	}

	public void setSmsParam(String smsParam) {
		this.smsParam = smsParam;
	}
	public void setSmsParamString(String smsParam) {
		this.smsParam = smsParam;
	}

	public String getSmsParam() {
		return this.smsParam;
	}

	public void setSmsTemplateCode(String smsTemplateCode) {
		this.smsTemplateCode = smsTemplateCode;
	}

	public String getSmsTemplateCode() {
		return this.smsTemplateCode;
	}

	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}

	public String getSmsType() {
		return this.smsType;
	}

	public String getApiMethodName() {
		return "alibaba.aliqin.fc.sms.num.send";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("extend", this.extend);
		txtParams.put("rec_num", this.recNum);
		txtParams.put("sms_free_sign_name", this.smsFreeSignName);
		txtParams.put("sms_param", this.smsParam);
		txtParams.put("sms_template_code", this.smsTemplateCode);
		txtParams.put("sms_type", this.smsType);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<AlibabaAliqinFcSmsNumSendResponse> getResponseClass() {
		return AlibabaAliqinFcSmsNumSendResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(recNum, "recNum");
		RequestCheckUtils.checkNotEmpty(smsFreeSignName, "smsFreeSignName");
		RequestCheckUtils.checkNotEmpty(smsTemplateCode, "smsTemplateCode");
		RequestCheckUtils.checkNotEmpty(smsType, "smsType");
	}
	

}