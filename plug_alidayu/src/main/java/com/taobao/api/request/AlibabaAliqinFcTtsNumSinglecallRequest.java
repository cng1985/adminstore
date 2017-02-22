package com.taobao.api.request;

import com.taobao.api.internal.util.json.JSONValidatingReader;
import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.AlibabaAliqinFcTtsNumSinglecallResponse;

/**
 * TOP API: alibaba.aliqin.fc.tts.num.singlecall request
 * 
 * @author top auto create
 * @since 1.0, 2016.05.24
 */
public class AlibabaAliqinFcTtsNumSinglecallRequest extends BaseTaobaoRequest<AlibabaAliqinFcTtsNumSinglecallResponse> {
	
	

	/** 
	* 被叫号码，支持国内手机号与固话号码,格式如下057188773344,13911112222,4001112222,95500
	 */
	private String calledNum;

	/** 
	* 被叫号显，传入的显示号码必须是阿里大鱼“管理中心-号码管理”中申请或购买的号码
	 */
	private String calledShowNum;

	/** 
	* 公共回传参数，在“消息返回”中会透传回该参数；举例：用户可以传入自己下级的会员ID，在消息返回时，该会员ID会包含在内，用户可以根据该会员ID识别是哪位会员使用了你的应用
	 */
	private String extend;

	/** 
	* TTS模板ID，传入的模板必须是在阿里大鱼“管理中心-语音TTS模板管理”中的可用模板
	 */
	private String ttsCode;

	/** 
	* 文本转语音（TTS）模板变量，传参规则{"key"："value"}，key的名字须和TTS模板中的变量名一致，多个变量之间以逗号隔开，示例：{"name":"xiaoming","code":"1234"}
	 */
	private String ttsParam;

	public void setCalledNum(String calledNum) {
		this.calledNum = calledNum;
	}

	public String getCalledNum() {
		return this.calledNum;
	}

	public void setCalledShowNum(String calledShowNum) {
		this.calledShowNum = calledShowNum;
	}

	public String getCalledShowNum() {
		return this.calledShowNum;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public String getExtend() {
		return this.extend;
	}

	public void setTtsCode(String ttsCode) {
		this.ttsCode = ttsCode;
	}

	public String getTtsCode() {
		return this.ttsCode;
	}

	public void setTtsParam(String ttsParam) {
		this.ttsParam = ttsParam;
	}
	public void setTtsParamString(String ttsParam) {
		this.ttsParam = ttsParam;
	}

	public String getTtsParam() {
		return this.ttsParam;
	}

	public String getApiMethodName() {
		return "alibaba.aliqin.fc.tts.num.singlecall";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("called_num", this.calledNum);
		txtParams.put("called_show_num", this.calledShowNum);
		txtParams.put("extend", this.extend);
		txtParams.put("tts_code", this.ttsCode);
		txtParams.put("tts_param", this.ttsParam);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<AlibabaAliqinFcTtsNumSinglecallResponse> getResponseClass() {
		return AlibabaAliqinFcTtsNumSinglecallResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(calledNum, "calledNum");
		RequestCheckUtils.checkNotEmpty(calledShowNum, "calledShowNum");
		RequestCheckUtils.checkNotEmpty(ttsCode, "ttsCode");
	}
	

}