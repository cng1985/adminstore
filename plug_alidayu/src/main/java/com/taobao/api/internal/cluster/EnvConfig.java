package com.taobao.api.internal.cluster;

import java.util.List;

public class EnvConfig {

	private String domain;
	private String protocol;
	private List<VipRule> vipRules;

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getProtocol() {
		return this.protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public List<VipRule> getVipRules() {
		return this.vipRules;
	}

	public void setVipRules(List<VipRule> vipRules) {
		this.vipRules = vipRules;
	}

}
