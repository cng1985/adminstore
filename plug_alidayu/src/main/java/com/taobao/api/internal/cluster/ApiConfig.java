package com.taobao.api.internal.cluster;

import java.util.List;

public class ApiConfig {

	private String user;
	private ApiModle modle;
	private List<ApiRule> rules;

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<ApiRule> getRules() {
		return this.rules;
	}

	public void setRules(List<ApiRule> rules) {
		this.rules = rules;
	}

	public ApiModle getModle() {
		return modle;
	}

	public void setModle(ApiModle modle) {
		this.modle = modle;
	}

}
