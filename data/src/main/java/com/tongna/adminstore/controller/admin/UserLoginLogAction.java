package com.tongna.adminstore.controller.admin;


import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.user.entity.UserLoginLog;
import com.ada.user.service.UserLoginLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserLoginLogAction {
	private static final Logger log = LoggerFactory.getLogger(UserLoginLogAction.class);

	@RequestMapping("/admin/userloginlog/view_list")
	public String list(Pageable pageable, HttpServletRequest request, ModelMap model) {
	
		if (pageable==null) {
			pageable=new Pageable();
		}
		if (pageable.getOrders()==null||pageable.getOrders().size()==0) {
			pageable.getOrders().add(Order.desc("id"));
		}
		Page<UserLoginLog> pagination = manager.findPage(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		return "/admin/userloginlog/list";
	}

	@RequestMapping("/admin/userloginlog/view_add")
	public String add(ModelMap model) {
		return "/admin/userloginlog/add";
	}

	@RequestMapping("/admin/userloginlog/view_edit")
	public String edit(Pageable pageable, Long id, Integer pageNo, HttpServletRequest request, ModelMap model) {
		model.addAttribute("model", manager.findById(id));
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("page", pageable);
		return "/admin/userloginlog/edit";
	}

	@RequestMapping("/admin/userloginlog/view_view")
	public String view(Long id,HttpServletRequest request, ModelMap model) {
		model.addAttribute("model", manager.findById(id));
		return "/admin/userloginlog/view";
	}

	@RequestMapping("/admin/userloginlog/model_save")
	public String save(UserLoginLog bean, HttpServletRequest request, ModelMap model) {
	
	    String view="redirect:view_list.htm";
		try {
			bean = manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("erro", e.getMessage());
			view="/admin/userloginlog/add";
		}
		return view;
	}

	@RequestMapping("/admin/userloginlog/model_update")
	public String update(Pageable pageable, UserLoginLog bean, HttpServletRequest request, ModelMap model) {
		
		String view="redirect:/admin/userloginlog/view_list.htm?pageNumber="+pageable.getPageNumber();
		try {
		bean = manager.update(bean);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("erro", e.getMessage());
			model.addAttribute("model",bean);
		    model.addAttribute("page", pageable);
			view="/admin/userloginlog/edit";
		}
		return view;
	}

	@RequestMapping("/admin/userloginlog/model_delete")
	public String delete(Pageable pageable, Long id, HttpServletRequest request, ModelMap model) {
			 
		try {
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
					 
		return list(pageable, request, model);
	}
	@RequestMapping("/admin/userloginlog/model_deletes")
	public String deletes(Pageable pageable, Long[] ids, HttpServletRequest request, ModelMap model) {
			 
	  try{
			manager.deleteByIds(ids);
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
		return list(pageable, request, model);
	}
	@Autowired
	private UserLoginLogService manager;
}