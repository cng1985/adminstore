package com.nbsaas.adminstore.oa.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.springframework.context.annotation.Scope;
import com.haoxuer.discover.controller.BaseAction;
/**
*
* Created by imake on 2021年05月22日09:52:36.
*/

@Scope("prototype")
@Controller
public class WorkLoggerAction extends BaseAction{


	@RequiresPermissions("worklogger")
	@RequestMapping("/admin/worklogger/view_list")
	public String list() {
		return getView("worklogger/list");
	}

}