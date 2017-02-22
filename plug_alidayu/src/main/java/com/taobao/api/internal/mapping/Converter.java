package com.taobao.api.internal.mapping;

import com.taobao.api.ApiException;

/**
 * 动态格式转换器。
 * 
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public interface Converter {

	/**
	 * 把字符串转换为响应对象。
	 * 
	 * @param <T> 领域泛型
	 * @param rsp 响应字符串
	 * @param clazz 领域类型
	 * @return 响应对象
	 */
	public <T> T toResponse(String rsp, Class<T> clazz) throws ApiException;

}
