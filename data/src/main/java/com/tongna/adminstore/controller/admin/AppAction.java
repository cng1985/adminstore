package com.tongna.adminstore.controller.admin;



import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import  com.ada.site.entity.App;
import com.ada.site.service.AppService;

@Controller
public class AppAction {
	private static final Logger log = LoggerFactory.getLogger(AppAction.class);

	@RequiresPermissions("app:list")
	@RequestMapping("/admin/app/view_list")
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
		Page<App> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		return "/admin/app/list";
	}

	@RequiresPermissions("app:add")
	@RequestMapping("/admin/app/view_add")
	public String add(ModelMap model) {
		return "/admin/app/add";
	}

	@RequiresPermissions("app:update")
	@RequestMapping("/admin/app/view_edit")
	public String edit(Pageable pageable,Long id, HttpServletRequest request, ModelMap model) {
		model.addAttribute("model", manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/app/edit";
	}

	@RequiresPermissions("app:view")
	@RequestMapping("/admin/app/view_view")
	public String view(Long id,HttpServletRequest request, ModelMap model) {
		model.addAttribute("model", manager.findById(id));
		return "/admin/app/view";
	}

	@RequiresPermissions("app:add")
	@RequestMapping("/admin/app/model_save")
	public String save(App bean, HttpServletRequest request, ModelMap model) {
	
	    String view="redirect:view_list.htm";
		try {
			bean = manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("erro", e.getMessage());
			view="/admin/app/add";
		}
		return view;
	}

	@RequiresPermissions("app:update")
	@RequestMapping("/admin/app/model_update")
	public String update(Pageable pageable, App bean,HttpServletRequest request, ModelMap model) {
		
		String view="redirect:/admin/app/view_list.htm?pageNumber="+pageable.getPageNumber();
		try {
		bean = manager.update(bean);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("erro", e.getMessage());
			model.addAttribute("model",bean);
		    model.addAttribute("page", pageable);
			view="/admin/app/edit";
		}
		return view;
	}
	@RequiresPermissions("app:delete")
	@RequestMapping("/admin/app/model_delete")
	public String delete(Pageable pageable, Long id, HttpServletRequest request, ModelMap model) {
			 
		try {
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
					 
		return list(pageable, request, model);
	}

	@RequiresPermissions("app:delete")
	@RequestMapping("/admin/app/model_deletes")
	public String deletes(Pageable pageable, Long[] ids, HttpServletRequest request, ModelMap model) {
			 
	  try{
			manager.deleteByIds(ids);
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
		return list(pageable, request, model);
	}
	@Autowired
	private AppService manager;
}