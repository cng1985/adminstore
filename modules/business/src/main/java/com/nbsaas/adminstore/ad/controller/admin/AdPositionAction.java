package com.nbsaas.adminstore.ad.controller.admin;

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
import com.nbsaas.adminstore.ad.data.entity.AdPosition;
import com.nbsaas.adminstore.ad.data.service.AdPositionService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.annotation.Scope;
import com.haoxuer.discover.controller.BaseAction;
/**
*
* Created by imake on 2020年11月06日23:22:43.
*/


@Scope("prototype")
@Controller
public class AdPositionAction extends BaseAction{

	public static final String MODEL = "model";

	public static final String REDIRECT_LIST_HTML = "redirect:/admin/adposition/view_list.htm";

	private static final Logger log = LoggerFactory.getLogger(AdPositionAction.class);

	@Autowired
	private AdPositionService manager;

	@RequiresPermissions("adposition")
	@RequestMapping("/admin/adposition/view_list")
	public String list(Pageable pageable,ModelMap model) {

		if (pageable==null){
			pageable=new Pageable();
		}
		if (pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
		}
		Page<AdPosition> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		return getView("adposition/list");
	}

	@RequiresPermissions("adposition")
	@RequestMapping("/admin/adposition/view_add")
	public String add(ModelMap model) {
		return getView("adposition/add");
	}

	@RequiresPermissions("adposition")
	@RequestMapping("/admin/adposition/view_edit")
	public String edit(Pageable pageable,Long id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return getView("adposition/edit");
	}

	@RequiresPermissions("adposition")
	@RequestMapping("/admin/adposition/view_view")
	public String view(Long id,ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return getView("adposition/view");
	}

	@RequiresPermissions("adposition")
	@RequestMapping("/admin/adposition/model_save")
	public String save(AdPosition bean,ModelMap model) {
	
	    String view=REDIRECT_LIST_HTML;
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view=getView("adposition/add");
		}
		return view;
	}

	@RequiresPermissions("adposition")
	@RequestMapping("/admin/adposition/model_update")
	public String update(Pageable pageable, AdPosition bean, RedirectAttributes redirectAttributes, ModelMap model) {
		
		String view=REDIRECT_LIST_HTML;
		try {
			manager.update(bean);
			initRedirectData(pageable, redirectAttributes);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view=getView("adposition/edit");
		}
		return view;
	}
	@RequiresPermissions("adposition")
	@RequestMapping("/admin/adposition/model_delete")
	public String delete(Pageable pageable, Long id, RedirectAttributes redirectAttributes) {

		String view=REDIRECT_LIST_HTML;

		try {
			initRedirectData(pageable, redirectAttributes);
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}

		return view;
	}

	@RequiresPermissions("adposition")
	@RequestMapping("/admin/adposition/model_deletes")
	public String deletes(Pageable pageable, Long[] ids,RedirectAttributes redirectAttributes) {

		String view=REDIRECT_LIST_HTML;

		try{
				initRedirectData(pageable, redirectAttributes);
				manager.deleteByIds(ids);
			} catch (DataIntegrityViolationException e) {
				log.error("批量删除失败",e);
				redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
			}
		return view;
	}
	private void initRedirectData(Pageable pageable, RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
	}
}