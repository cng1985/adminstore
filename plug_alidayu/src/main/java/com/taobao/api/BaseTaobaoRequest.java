package com.taobao.api;

import java.util.Map;

import com.taobao.api.internal.util.TaobaoHashMap;

/**
 * 基础TOP请求类，存放一些通用的请求参数。注：这个类不能随意增加get/set/is开头类的方法，否则会有可能和API业务级的参数冲突。
 * 
 * @author fengsheng
 * @since Sep 9, 2015
 */
public abstract class BaseTaobaoRequest<T extends TaobaoResponse> implements TaobaoRequest<T> {

	protected Map<String, String> headerMap; // HTTP请求头参数
	protected TaobaoHashMap udfParams; // 自定义表单参数
	protected Long timestamp; // 请求时间戳
	protected String targetAppKey; // 请求目标AppKey
	protected String topMixParams; // 指定哪个入参是混淆参数
	protected String session; // 使用批量API调用时，每个API可以使用不同的授权码，普通API调用忽略此属性
	protected int order; // 标示该API在批量API调用中的顺序

	/**
	 * 添加URL自定义请求参数。
	 */
	public void putOtherTextParam(String key, String value) {
		if (this.udfParams == null) {
			this.udfParams = new TaobaoHashMap();
		}
		this.udfParams.put(key, value);
	}

	public Map<String, String> getHeaderMap() {
		if (this.headerMap == null) {
			this.headerMap = new TaobaoHashMap();
		}
		return this.headerMap;
	}

	public void setHeaderMap(Map<String, String> headerMap) {
		this.headerMap = headerMap;
	}

	/**
	 * 添加头部自定义请求参数。
	 */
	public void putHeaderParam(String key, String value) {
		getHeaderMap().put(key, value);
	}

	public Long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getTargetAppKey() {
		return this.targetAppKey;
	}

	public void setTargetAppKey(String targetAppKey) {
		this.targetAppKey = targetAppKey;
	}

	public String getTopMixParams() {
		return this.topMixParams;
	}

	public void setTopMixParams(String topMixParams) {
		this.topMixParams = topMixParams;
	}

	public String getBatchApiSession() {
		return this.session;
	}

	public void setBatchApiSession(String session) {
		this.session = session;
	}

	public int getBatchApiOrder() {
		return this.order;
	}

	public void setBatchApiOrder(int order) {
		this.order = order;
	}

}
