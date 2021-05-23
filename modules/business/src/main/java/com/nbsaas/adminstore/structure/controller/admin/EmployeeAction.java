package com.nbsaas.adminstore.structure.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.springframework.context.annotation.Scope;
import com.haoxuer.discover.controller.BaseAction;
/**
*
* Created by imake on 2021年05月23日11:08:13.
*/

@Scope("prototype")
@Controller
public class EmployeeAction extends BaseAction{


	@RequiresPermissions("employee")
	@RequestMapping("/admin/employee/view_list")
	public String list() {
		return getView("employee/list");
	}

}