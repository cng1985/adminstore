package com.tongna.adminstore.rest.domain.base;

import java.io.Serializable;

/**
 * 
 * 返回对象基础类 包括code和msg内容<br/>
 * code默认为0<br/>
 * msg默认为success<br/>
 * 
 * @author ada
 *
 */
public class AbstractVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 状态码
	 */
	private int code = 0;

	/**
	 * 状态信息 默认为 success
	 */
	private String msg = "成功";

	/**
	 * 返回状态码
	 * 
	 * @return 状态码
	 */
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * 返回状态信息
	 * 
	 * @return 状态信息
	 */
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "BaseVo [code=" + code + ", msg=" + msg + "]";
	}

}
