package com.tongna.adminstore;

import java.io.Serializable;

public class SendCode implements Serializable {

	/**
	 * 用户名
	 */
	private String name;

	/**
	 * 邮箱
	 */
	private String ccncmail;

	/**
	 * 密码
	 */
	private String ccncpw;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCcncmail() {
		return ccncmail;
	}

	public void setCcncmail(String ccncmail) {
		this.ccncmail = ccncmail;
	}

	public String getCcncpw() {
		return ccncpw;
	}

	public void setCcncpw(String ccncpw) {
		this.ccncpw = ccncpw;
	}
	
	

}
