package com.tongna.adminstore.controller.admin;


import com.ada.admin.service.MenuService;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.user.entity.UserRole;
import com.ada.user.service.UserRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserRoleAction {
	private static final Logger log = LoggerFactory.getLogger(UserRoleAction.class);
	@Autowired
	MenuService menuService;

	@RequiresPermissions("role:list")
	@RequestMapping("/admin/userrole/view_list")
	public String list(Pageable pageable, HttpServletRequest request, ModelMap model) {
	
		if (pageable==null) {
			pageable=new Pageable();
		}
		if (pageable.getOrders()==null||pageable.getOrders().size()==0) {
			pageable.getOrders().add(Order.desc("id"));
		}
	   if(pageable.getSearchProperty()==null||pageable.getSearchProperty().length()<2) {
			pageable.setSearchProperty("name");
			pageable.setSearchValue("");
		}
		Page<UserRole> pagination = manager.findPage(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		return "/admin/userrole/list";
	}

	@RequiresPermissions("role:add")
	@RequestMapping("/admin/userrole/view_add")
	public String add(ModelMap model) {
		model.addAttribute("menus", menuService.findChild(1));
		return "/admin/userrole/add";
	}

	@RequiresPermissions("role:update")
	@RequestMapping("/admin/userrole/view_edit")
	public String edit(Pageable pageable, Long id, HttpServletRequest request, ModelMap model) {
		model.addAttribute("menus", menuService.findChild(1));
		model.addAttribute("model", manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/userrole/edit";
	}

	@RequiresPermissions("role:view")
	@RequestMapping("/admin/userrole/view_view")
	public String view(Long id,HttpServletRequest request, ModelMap model) {
		model.addAttribute("model", manager.findById(id));
		return "/admin/userrole/view";
	}

	@RequiresPermissions("role:add")
	@RequestMapping("/admin/userrole/model_save")
	public String save(UserRole bean, HttpServletRequest request, ModelMap model) {
	
	    String view="redirect:view_list.htm";
		try {
			bean = manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("erro", e.getMessage());
			view="/admin/userrole/add";
		}
		return view;
	}

	@RequiresPermissions("role:update")
	@RequestMapping("/admin/userrole/model_update")
	public String update(Pageable pageable, UserRole bean, HttpServletRequest request, ModelMap model) {
		
		String view="redirect:/admin/userrole/view_list.htm?pageNumber="+pageable.getPageNumber();
		try {
		bean = manager.update(bean);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("erro", e.getMessage());
			model.addAttribute("model",bean);
		    model.addAttribute("page", pageable);
			view="/admin/userrole/edit";
		}
		return view;
	}

	@RequiresPermissions("role:delete")
	@RequestMapping("/admin/userrole/model_delete")
	public String delete(Pageable pageable, Long id, HttpServletRequest request, ModelMap model) {
			 
		try {
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
					 
		return list(pageable, request, model);
	}

	@RequiresPermissions("role:delete")
	@RequestMapping("/admin/userrole/model_deletes")
	public String deletes(Pageable pageable, Long[] ids, HttpServletRequest request, ModelMap model) {
			 
	  try{
			manager.deleteByIds(ids);
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
		return list(pageable, request, model);
	}
	@Autowired
	private UserRoleService manager;
}