package com.haoxuer.adminstore.structure.controller.admin;


import com.haoxuer.discover.data.page.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import  com.haoxuer.adminstore.structure.data.entity.Organization;
import com.haoxuer.adminstore.structure.data.service.OrganizationService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import com.haoxuer.discover.web.base.BaseAction;

/**
* Created by imake on 2020年07月27日08:50:47.
*/

@Scope("prototype")
@Controller
public class OrganizationAction  extends BaseAction{

	public static final String MODEL = "model";

	public static final String REDIRECT_LIST_HTML = "redirect:/admin/organization/view_list.htm";

	private static final Logger log = LoggerFactory.getLogger(OrganizationAction.class);

	@Autowired
	private OrganizationService manager;

	@RequiresPermissions("organization")
	@RequestMapping("/admin/organization/view_list")
	public String list() {
		return  getView("organization/list");
	}
}