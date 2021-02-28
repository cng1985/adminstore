package com.haoxuer.adminstore.member.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.springframework.context.annotation.Scope;
import com.haoxuer.discover.web.base.BaseAction;
/**
*
* Created by imake on 2021年02月28日16:04:56.
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