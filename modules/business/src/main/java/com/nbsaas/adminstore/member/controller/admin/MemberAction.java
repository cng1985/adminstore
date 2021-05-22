package com.nbsaas.adminstore.member.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.springframework.context.annotation.Scope;
import com.haoxuer.discover.controller.BaseAction;
/**
*
* Created by imake on 2021年05月22日10:15:23.
*/

@Scope("prototype")
@Controller
public class MemberAction extends BaseAction{


	@RequiresPermissions("member")
	@RequestMapping("/admin/member/view_list")
	public String list() {
		return getView("member/list");
	}

}