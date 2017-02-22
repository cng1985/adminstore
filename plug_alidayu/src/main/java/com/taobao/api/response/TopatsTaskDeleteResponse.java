package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.topats.task.delete response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TopatsTaskDeleteResponse extends TaobaoResponse {

	private static final long serialVersionUID = 3895531582462879348L;

	/** 
	 * 表示操作是否成功，是为true，否为false。
	 */
	@ApiField("is_success")
	private Boolean isSuccess;


	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public Boolean getIsSuccess( ) {
		return this.isSuccess;
	}
	


}
