package com.taobao.api;

/**
 * 淘宝客户端。
 * 
 * @author carver.gu
 * @since 1.0, Sep 12, 2009
 */
public interface TaobaoClient {

	/**
	 * 执行公开API请求。
	 * 
	 * @param <T> 具体的API响应类
	 * @param request 具体的API请求类
	 * @return 具体的API响应
	 */
	public <T extends TaobaoResponse> T execute(TaobaoRequest<T> request) throws ApiException;

	/**
	 * 执行隐私API请求。
	 * 
	 * @param <T> 具体的API响应类
	 * @param request 具体的API请求类
	 * @param session 用户授权码
	 * @return 具体的API响应
	 */
	public <T extends TaobaoResponse> T execute(TaobaoRequest<T> request, String session) throws ApiException;

}
