package com.nbsaas.adminstore.customer.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.springframework.context.annotation.Scope;
import com.haoxuer.discover.controller.BaseAction;
/**
*
* Created by imake on 2021年05月23日15:15:46.
*/

@Scope("prototype")
@Controller
public class CustomerAction extends BaseAction{


	@RequiresPermissions("customer")
	@RequestMapping("/admin/customer/view_list")
	public String list() {
		return getView("customer/list");
	}

}