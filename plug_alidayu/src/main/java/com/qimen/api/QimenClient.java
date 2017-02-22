package com.qimen.api;

import com.taobao.api.ApiException;

/**
 * 奇门客户端。
 * 
 * @author fengsheng
 * @since Jan 27, 2016
 */
public interface QimenClient {

	/**
	 * 执行公开API请求。
	 * 
	 * @param <T> 具体的API响应类
	 * @param request 具体的API请求类
	 * @return 具体的API响应
	 */
	public <T extends QimenResponse> T execute(QimenRequest<T> request) throws ApiException;

	/**
	 * 执行隐私API请求。
	 * 
	 * @param <T> 具体的API响应类
	 * @param request 具体的API请求类
	 * @param session 用户授权码
	 * @return 具体的API响应
	 */
	public <T extends QimenResponse> T execute(QimenRequest<T> request, String session) throws ApiException;

}
