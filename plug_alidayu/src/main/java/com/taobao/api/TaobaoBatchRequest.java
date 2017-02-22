package com.taobao.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.taobao.api.internal.util.TaobaoHashMap;

/**
 * 批量API请求包装类。
 * 
 * @author fengsheng
 * @since Jan 6, 2016
 * @param <T> 具体的单个API响应类
 */
public class TaobaoBatchRequest extends BaseTaobaoRequest<TaobaoBatchResponse> {

	private String publicMethod; // 公共方法
	private TaobaoHashMap publicParams; // 公共参数
	private List<TaobaoRequest<? extends TaobaoResponse>> requestList;

	public String getPublicMethod() {
		return publicMethod;
	}

	public void setPublicMethod(String publicMethod) {
		this.publicMethod = publicMethod;
	}

	public TaobaoHashMap getPublicParams() {
		if (this.publicParams == null) {
			this.publicParams = new TaobaoHashMap();
		}
		return this.publicParams;
	}

	public void setPublicParams(TaobaoHashMap publicParams) {
		this.publicParams = publicParams;
	}

	public void addPublicParam(String key, String value) {
		getPublicParams().put(key, value);
	}

	public List<TaobaoRequest<? extends TaobaoResponse>> getRequestList() {
		return this.requestList;
	}

	public void setRequestList(List<TaobaoRequest<? extends TaobaoResponse>> requestList) {
		this.requestList = requestList;
	}

	public TaobaoBatchRequest addRequest(TaobaoRequest<? extends TaobaoResponse> request) {
		if (this.requestList == null) {
			this.requestList = new ArrayList<TaobaoRequest<? extends TaobaoResponse>>();
		}
		this.requestList.add(request);
		return this;
	}

	public void check() throws ApiRuleException {
	}

	public String getApiMethodName() {
		return null;
	}

	public Class<TaobaoBatchResponse> getResponseClass() {
		return TaobaoBatchResponse.class;
	}

	public Map<String, String> getTextParams() {
		return null;
	}

}
