package com.tongna.adminstore;

import java.io.Serializable;

/**
 * 发送验证码
 * 
 * @author ada
 *
 */
public class SendVCode implements Serializable {

	/**
	 * 验证码
	 */
	private String code;

	/**
	 * 产品
	 */
	private String product;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	
	
}
