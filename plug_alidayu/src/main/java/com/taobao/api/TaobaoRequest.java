package com.taobao.api;

import java.util.Map;

/**
 * TOP请求接口。
 * 
 * @author carver.gu
 * @since 1.0, Sep 12, 2009
 */
public interface TaobaoRequest<T extends TaobaoResponse> {

	/**
	 * 获取TOP的API名称。
	 * 
	 * @return API名称
	 */
	public String getApiMethodName();

	/**
	 * 获取所有的Key-Value形式的文本请求参数集合。其中：
	 * <ul>
	 * <li>Key: 请求参数名</li>
	 * <li>Value: 请求参数值</li>
	 * </ul>
	 * 
	 * @return 文本请求参数集合
	 */
	public Map<String, String> getTextParams();

	/**
	 * 获取请求时间戳（为空则用系统当前时间）
	 */
	public Long getTimestamp();

	/**
	 * 获取被调用的目标AppKey
	 */
	public String getTargetAppKey();

	/**
	 * 获取具体响应实现类的定义。
	 */
	public Class<T> getResponseClass();

	/**
	 * 获取自定义HTTP请求头参数。
	 */
	public Map<String, String> getHeaderMap();

	/**
	 * 客户端参数检查，减少服务端无效调用。
	 */
	public void check() throws ApiRuleException;

	/**
	 * 获取API请求的用户授权码，仅用于批量API调用请求。
	 * 
	 * @return 用户授权码
	 */
	public String getBatchApiSession();

	/**
	 * 设置API请求的用户授权码，仅用于批量API调用请求。
	 * 
	 * @param session 用户授权码
	 */
	public void setBatchApiSession(String session);

	/**
	 * 获取API在批量调用中的顺序，仅用于批量API调用请求。
	 * 
	 * @return 顺序值
	 */
	public int getBatchApiOrder();

	/**
	 * 设置API在批量调用中的顺序，仅用于批量API调用请求。
	 * 
	 * @param order 顺序值
	 */
	public void setBatchApiOrder(int order);

}
