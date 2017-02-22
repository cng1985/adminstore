package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.AlibabaAliqinFcVoiceNumDoublecallResponse;

/**
 * TOP API: alibaba.aliqin.fc.voice.num.doublecall request
 * 
 * @author top auto create
 * @since 1.0, 2016.03.06
 */
public class AlibabaAliqinFcVoiceNumDoublecallRequest extends BaseTaobaoRequest<AlibabaAliqinFcVoiceNumDoublecallResponse> {
	
	

	/** 
	* 被叫号码，支持国内手机号与固话号码,格式如下057188773344,13911112222,4001112222,95500
	 */
	private String calledNum;

	/** 
	* 被叫号码侧的号码显示，传入的显示号码可以是阿里大鱼“管理中心-号码管理”中申请通过的号码。显示号码格式如下057188773344，4001112222，95500。显示号码也可以为主叫号码。
	 */
	private String calledShowNum;

	/** 
	* 主叫号码，支持国内手机号与固话号码,格式如下057188773344,13911112222,4001112222,95500
	 */
	private String callerNum;

	/** 
	* 主叫号码侧的号码显示，传入的显示号码必须是阿里大鱼“管理中心-号码管理”中申请通过的号码。显示号码格式如下057188773344，4001112222，95500
	 */
	private String callerShowNum;

	/** 
	* 公共回传参数，在“消息返回”中会透传回该参数；举例：用户可以传入自己下级的会员ID，在消息返回时，该会员ID会包含在内，用户可以根据该会员ID识别是哪位会员使用了你的应用
	 */
	private String extend;

	/** 
	* 通话超时时长，如接通后到达120秒时，通话会因为超时自动挂断。若无需设置超时时长，可不传。
	 */
	private String sessionTimeOut;

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

	public void setCallerNum(String callerNum) {
		this.callerNum = callerNum;
	}

	public String getCallerNum() {
		return this.callerNum;
	}

	public void setCallerShowNum(String callerShowNum) {
		this.callerShowNum = callerShowNum;
	}

	public String getCallerShowNum() {
		return this.callerShowNum;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public String getExtend() {
		return this.extend;
	}

	public void setSessionTimeOut(String sessionTimeOut) {
		this.sessionTimeOut = sessionTimeOut;
	}

	public String getSessionTimeOut() {
		return this.sessionTimeOut;
	}

	public String getApiMethodName() {
		return "alibaba.aliqin.fc.voice.num.doublecall";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("called_num", this.calledNum);
		txtParams.put("called_show_num", this.calledShowNum);
		txtParams.put("caller_num", this.callerNum);
		txtParams.put("caller_show_num", this.callerShowNum);
		txtParams.put("extend", this.extend);
		txtParams.put("session_time_out", this.sessionTimeOut);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<AlibabaAliqinFcVoiceNumDoublecallResponse> getResponseClass() {
		return AlibabaAliqinFcVoiceNumDoublecallResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(calledNum, "calledNum");
		RequestCheckUtils.checkNotEmpty(calledShowNum, "calledShowNum");
		RequestCheckUtils.checkNotEmpty(callerNum, "callerNum");
		RequestCheckUtils.checkNotEmpty(callerShowNum, "callerShowNum");
	}
	

}