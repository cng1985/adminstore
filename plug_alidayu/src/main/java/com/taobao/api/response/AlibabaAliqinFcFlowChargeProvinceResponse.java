package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: alibaba.aliqin.fc.flow.charge.province response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class AlibabaAliqinFcFlowChargeProvinceResponse extends TaobaoResponse {

	private static final long serialVersionUID = 4639282987239157872L;

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
		private static final long serialVersionUID = 4321888368814244542L;
		/**
		 * 错误码
		 */
		@ApiField("code")
		private String code;
		/**
		 * 无
		 */
		@ApiField("model")
		private String model;
		/**
		 * 原因
		 */
		@ApiField("msg")
		private String msg;
		/**
		 * 结果
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
