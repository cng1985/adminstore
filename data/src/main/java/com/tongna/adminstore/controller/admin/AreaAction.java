package com.tongna.adminstore.controller.admin;


import com.ada.data.page.Filter;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import  com.ada.area.entity.Area;
import com.ada.area.service.AreaService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AreaAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(AreaAction.class);

	@Autowired
	private AreaService manager;

	@RequiresPermissions("area")
	@RequestMapping("/admin/area/view_list")
	public String list(Pageable pageable, @RequestParam(value="pid",defaultValue = "1") Integer pid, HttpServletRequest request, ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
				pageable.getOrders().add(Order.asc("code"));
			}
			pageable.getFilters().add(Filter.eq("parent.id", pid));
		}
		Page<Area> pagination = manager.page(pageable);
		model.addAttribute("tops", manager.findByTops(pid));
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("pid", pid);
		return "/admin/area/list";
	}

	@RequiresPermissions("area")
	@RequestMapping("/admin/area/view_add")
	public String add(ModelMap model) {
		return "/admin/area/add";
	}

	@RequiresPermissions("area")
	@RequestMapping("/admin/area/view_edit")
	public String edit(Pageable pageable,Integer id, HttpServletRequest request, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/area/edit";
	}

	@RequiresPermissions("area")
	@RequestMapping("/admin/area/view_view")
	public String view(Integer id,HttpServletRequest request, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/area/view";
	}

	@RequiresPermissions("area")
	@RequestMapping("/admin/area/model_save")
	public String save(Pageable pageable,Area bean, HttpServletRequest request, ModelMap model) {
	
	    String view="redirect:/admin/area/view_list.htm?pid=" + bean.getParentId() + "&pageNumber=" + pageable.getPageNumber();
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/admin/area/add";
		}
		return view;
	}

	@RequiresPermissions("area")
	@RequestMapping("/admin/area/model_update")
	public String update(Pageable pageable, Area bean,HttpServletRequest request, ModelMap model) {
		
		String view="redirect:/admin/area/view_list.htm?pid=" + bean.getParentId() + "&pageNumber=" + pageable.getPageNumber();
		try {
			manager.update(bean);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view="/admin/area/edit";
		}
		return view;
	}
	@RequiresPermissions("area")
	@RequestMapping("/admin/area/model_delete")
	public String delete(Pageable pageable, Integer id, HttpServletRequest request, ModelMap model) {
			 
		try {
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
					 
		return list(pageable,1, request, model);
	}

	@RequiresPermissions("area")
	@RequestMapping("/admin/area/model_deletes")
	public String deletes(Pageable pageable, Integer[] ids, HttpServletRequest request, ModelMap model) {
			 
	  try{
			manager.deleteByIds(ids);
		} catch (DataIntegrityViolationException e) {
			log.error("批量删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
		return list(pageable,1, request, model);
	}

}