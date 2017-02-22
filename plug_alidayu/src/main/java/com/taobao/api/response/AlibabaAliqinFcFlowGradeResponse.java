package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: alibaba.aliqin.fc.flow.grade response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class AlibabaAliqinFcFlowGradeResponse extends TaobaoResponse {

	private static final long serialVersionUID = 5898977392454523515L;

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
		private static final long serialVersionUID = 7375127472493414772L;
		/**
		 * 错误码
		 */
		@ApiField("code")
		private String code;
		/**
		 * 档位
		 */
		@ApiField("model")
		private String model;
		/**
		 * 错误原因
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
