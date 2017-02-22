package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: alibaba.aliqin.fc.flow.query response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class AlibabaAliqinFcFlowQueryResponse extends TaobaoResponse {

	private static final long serialVersionUID = 1354393687226838226L;

	/** 
	 * 无
	 */
	@ApiField("value")
	private Result value;


	public void setValue(Result value) {
		this.value = value;
	}
	public Result getValue( ) {
		return this.value;
	}
	
	/**
	 * 无
	 *
	 * @author top auto create
	 * @since 1.0, null
	 */
	public static class Result extends TaobaoObject {
		private static final long serialVersionUID = 4844644531981143627L;
		/**
		 * 错误码
		 */
		@ApiField("code")
		private String code;
		/**
		 * "id":"唯一流水号",     "time":"提交时间",     "phone":"号码",     "error":"false",     "reason":"原因",     "status":"充值状态",     "flow":"流量",     "operator":"中国移动"
		 */
		@ApiField("model")
		private String model;
		/**
		 * 原因
		 */
		@ApiField("msg")
		private String msg;
		/**
		 * 状态
		 */
		@ApiField("success")
		private Boolean success;
	
		public String getCode() {
			return this.code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getModel() {
			return this.model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public String getMsg() {
			return this.msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public Boolean getSuccess() {
			return this.success;
		}
		public void setSuccess(Boolean success) {
			this.success = success;
		}
	}
	


}
