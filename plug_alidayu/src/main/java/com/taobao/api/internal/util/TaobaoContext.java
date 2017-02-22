package com.taobao.api.internal.util;

import java.util.HashMap;
import java.util.Map;

/**
 * TAOBAO容器上下文。
 * 
 * @author carver.gu
 * @since 1.0, Oct 15, 2009
 */
public class TaobaoContext {

	public static final String APPKEY = "top_appkey";
	public static final String SESSION = "top_session";
	public static final String SIGNATURE = "top_sign";
	public static final String PARAMETERS = "top_parameters";
	public static final String USER_ID = "visitor_id";
	public static final String USER_NICK = "visitor_nick";

	private Map<String, String> parameters = new HashMap<String, String>();
	private String callbackUrl;

	/**
	 * 获取应用编号。
	 * 
	 * @return 应用编号
	 */
	public String getAppKey() {
		return getParameter(APPKEY);
	}

	/**
	 * 获取授权码。
	 * 
	 * @return 授权码
	 */
	public String getSessionKey() {
		return getParameter(SESSION);
	}

	/**
	 * 获取回调签名。
	 * 
	 * @return 回调签名
	 */
	public String getSignature() {
		return getParameter(SIGNATURE);
	}

	/**
	 * 获取淘宝用户编号。
	 * 
	 * @return 淘宝用户编号
	 */
	public Long getUserId() {
		String userId = getParameter(USER_ID);
		if (StringUtils.isEmpty(userId)) {
			return null;
		} else {
			return Long.valueOf(userId);
		}
	}

	/**
	 * 获取淘宝用户昵称。
	 * 
	 * @return 淘宝用户昵称
	 */
	public String getUserNick() {
		return getParameter(USER_NICK);
	}

	/**
	 * 获取指定参数的值。
	 * 
	 * @param key 参数名
	 * @return 参数值
	 */
	public String getParameter(String key) {
		return this.parameters.get(key);
	}

	/**
	 * 批量添加参数。
	 * 
	 * @param parameters 参数映射
	 */
	public void addParameters(Map<String, String> parameters) {
		if (parameters != null && !parameters.isEmpty()) {
			this.parameters.putAll(parameters);
		}
	}

	/**
	 * 添加一个参数。
	 * 
	 * @param key 参数名
	 * @param value 参数值
	 */
	public void addParameter(String key, String value) {
		this.parameters.put(key, value);
	}

	/**
	 * 获取TOP回调过来的URL参数。
	 */
	public String getCallbackUrl() {
		return this.callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

}
