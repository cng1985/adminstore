package com.nbsaas.adminstore.structure.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.springframework.context.annotation.Scope;
import com.haoxuer.discover.controller.BaseAction;
/**
*
* Created by imake on 2021年05月22日10:28:14.
*/

@Scope("prototype")
@Controller
public class OrganizationAction extends BaseAction{


	@RequiresPermissions("organization")
	@RequestMapping("/admin/organization/view_list")
	public String list() {
		return getView("organization/list");
	}

}