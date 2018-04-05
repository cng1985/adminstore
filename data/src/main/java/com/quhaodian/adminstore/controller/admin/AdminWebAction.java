package com.quhaodian.adminstore.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "admin")
public class AdminWebAction {

	@RequestMapping(value = "loginwork", method = RequestMethod.POST)
	public String loginwork() {
		return "admin/home";
	}
	

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "admin/home";
	}
}
