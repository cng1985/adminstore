package com.taobao.api;

import java.util.ArrayList;
import java.util.List;

/**
 * 批量API响应类。
 * 
 * @author fengsheng
 * @since Jan 6, 2016
 */
public class TaobaoBatchResponse extends TaobaoResponse {

	private static final long serialVersionUID = -3566443848146265580L;

	private List<TaobaoResponse> responseList;

	public TaobaoBatchResponse() {
	}

	public TaobaoBatchResponse(String errorCode, String msg) {
		setErrorCode(errorCode);
		setMsg(msg);
	}

	/**
	 * 当批量API请求成功后，或获取所有API的响应结果。
	 */
	public List<TaobaoResponse> getResponseList() {
		return this.responseList;
	}

	public void setResponseList(List<TaobaoResponse> responseList) {
		this.responseList = responseList;
	}

	/**
	 * 根据指定的API请求获取相应的API响应结果。
	 */
	@SuppressWarnings("unchecked")
	public <T extends TaobaoResponse> T getResponse(TaobaoRequest<T> request) {
		if (responseList == null || responseList.isEmpty()) {
			return null;
		}
		return (T) responseList.get(request.getBatchApiOrder());
	}

	public void addResponse(TaobaoResponse response) {
		if (this.responseList == null) {
			this.responseList = new ArrayList<TaobaoResponse>();
		}
		this.responseList.add(response);
	}

}
