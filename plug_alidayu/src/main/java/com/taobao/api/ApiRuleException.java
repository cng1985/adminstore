package com.taobao.api;

/**
 * API前置检查异常。
 * 
 * @author fengsheng
 * @since 1.0, May 23, 2012
 */
public class ApiRuleException extends ApiException {

	private static final long serialVersionUID = -7787145910600194272L;

	public ApiRuleException(String errCode, String errMsg) {
		super(errCode, errMsg);
	}

}
