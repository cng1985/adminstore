package com.haoxuer.adminstore.structure.controller.admin;

import com.haoxuer.discover.web.base.BaseAction;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
*
* Created by imake on 2021年04月12日20:37:02.
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