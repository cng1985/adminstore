package com.tongna.adminstore.controller.admin;



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
import  com.tongna.adminstore.data.entity.Member;
import com.tongna.adminstore.data.service.MemberService;

@Controller
public class MemberAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(MemberAction.class);

	@Autowired
	private MemberService manager;

	@RequiresPermissions("member")
	@RequestMapping("/admin/member/view_list")
	public String list(Pageable pageable, HttpServletRequest request, ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
			}
			if(pageable.getSearchProperty()==null||pageable.getSearchProperty().length()<2) {
			pageable.setSearchProperty("name");
			pageable.setSearchValue("");
			}
		}
		Page<Member> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		return "/admin/member/list";
	}

	@RequiresPermissions("member")
	@RequestMapping("/admin/member/view_add")
	public String add(ModelMap model) {
		return "/admin/member/add";
	}

	@RequiresPermissions("member")
	@RequestMapping("/admin/member/view_edit")
	public String edit(Pageable pageable,Long id, HttpServletRequest request, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/member/edit";
	}

	@RequiresPermissions("member")
	@RequestMapping("/admin/member/view_view")
	public String view(Long id,HttpServletRequest request, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/member/view";
	}

	@RequiresPermissions("member")
	@RequestMapping("/admin/member/model_save")
	public String save(Member bean, HttpServletRequest request, ModelMap model) {
	
	    String view="redirect:view_list.htm";
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/admin/member/add";
		}
		return view;
	}

	@RequiresPermissions("member")
	@RequestMapping("/admin/member/model_update")
	public String update(Pageable pageable, Member bean,HttpServletRequest request, ModelMap model) {
		
		String view="redirect:/admin/member/view_list.htm?pageNumber="+pageable.getPageNumber();
		try {
			manager.update(bean);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view="/admin/member/edit";
		}
		return view;
	}
	@RequiresPermissions("member")
	@RequestMapping("/admin/member/model_delete")
	public String delete(Pageable pageable, Long id, HttpServletRequest request, ModelMap model) {
			 
		try {
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
					 
		return list(pageable, request, model);
	}

	@RequiresPermissions("member")
	@RequestMapping("/admin/member/model_deletes")
	public String deletes(Pageable pageable, Long[] ids, HttpServletRequest request, ModelMap model) {
			 
	  try{
			manager.deleteByIds(ids);
		} catch (DataIntegrityViolationException e) {
			log.error("批量删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
		return list(pageable, request, model);
	}

}