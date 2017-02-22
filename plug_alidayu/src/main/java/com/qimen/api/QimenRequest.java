package com.qimen.api;

import com.taobao.api.internal.util.TaobaoHashMap;

/**
 * 奇门API请求包装类。
 * 
 * @author fengsheng
 * @since Jan 27, 2016
 * @param <T> 奇门API响应类
 */
public abstract class QimenRequest<T extends QimenResponse> {

	protected String customerId; // 客户ID号
	protected Long timestamp; // 请求时间戳
	protected String version = "1.0"; // API版本号
	protected String testType; // 测试类型
	protected String body; // 请求body体
	protected TaobaoHashMap queryParams; // 自定义URL参数

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTestType() {
		return this.testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBody() {
		return this.body;
	}

	public TaobaoHashMap getQueryParams() {
		return this.queryParams;
	}

	public void addQueryParam(String key, String value) {
		if (this.queryParams == null) {
			this.queryParams = new TaobaoHashMap();
		}
		this.queryParams.put(key, value);
	}

	/**
	 * 获取API名称。
	 */
	public abstract String getApiMethodName();

	/**
	 * 获取API响应类实例。
	 */
	public abstract Class<T> getResponseClass();

}
