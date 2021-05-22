package com.nbsaas.adminstore.structure.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.springframework.context.annotation.Scope;
import com.haoxuer.discover.controller.BaseAction;
/**
*
* Created by imake on 2021年05月22日10:30:18.
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