package com.haoxuer.adminstore.shop.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.adminstore.shop.api.apis.ShopApi;
import com.haoxuer.adminstore.shop.api.domain.page.ShopPage;
import com.haoxuer.adminstore.shop.api.domain.request.*;import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.annotation.Scope;
import com.haoxuer.discover.web.base.BaseAction;
/**
*
* Created by imake on 2021年01月23日16:17:59.
*/


@Scope("prototype")
@Controller
public class ShopAction extends BaseAction{

	public static final String MODEL = "model";

	public static final String REDIRECT_LIST_HTML = "redirect:/admin/shop/view_list.htm";

	private static final Logger log = LoggerFactory.getLogger(ShopAction.class);

	@Autowired
	private ShopApi api;

	@RequiresPermissions("shop")
	@RequestMapping("/admin/shop/view_list")
	public String list(ShopSearchRequest request,ModelMap model) {

        ShopPage page = api.search(request);
        model.addAttribute("list", page.getList());
		model.addAttribute("page", page);
		model.addAttribute("so", request);
		return getView("shop/list");
	}

	@RequiresPermissions("shop")
	@RequestMapping("/admin/shop/view_add")
	public String add(ModelMap model) {
		return getView("shop/add");
	}

	@RequiresPermissions("shop")
	@RequestMapping("/admin/shop/view_edit")
	public String edit(Pageable pageable,ShopDataRequest request,  ModelMap model) {
        model.addAttribute(MODEL, api.view(request));
		model.addAttribute("page", pageable);
		return getView("shop/edit");
	}

	@RequiresPermissions("shop")
	@RequestMapping("/admin/shop/view_view")
	public String view(ShopDataRequest request,ModelMap model) {
         model.addAttribute(MODEL, api.view(request));
		return getView("shop/view");
	}

	@RequiresPermissions("shop")
	@RequestMapping("/admin/shop/model_save")
	public String save(ShopDataRequest request,ModelMap model) {
	
	    String view=REDIRECT_LIST_HTML;
		try {
			 api.create(request);
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view=getView("shop/add");
		}
		return view;
	}

	@RequiresPermissions("shop")
	@RequestMapping("/admin/shop/model_update")
	public String update(Pageable pageable, ShopDataRequest request,  RedirectAttributes redirectAttributes, ModelMap model) {
		
		String view=REDIRECT_LIST_HTML;
		try {
			api.update(request);
			initRedirectData(pageable, redirectAttributes);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,request);
		    model.addAttribute("page", pageable);
			view=getView("shop/edit");
		}
		return view;
	}
	@RequiresPermissions("shop")
	@RequestMapping("/admin/shop/model_delete")
	public String delete(Pageable pageable, ShopDataRequest request, RedirectAttributes redirectAttributes) {

		String view=REDIRECT_LIST_HTML;

		try {
			initRedirectData(pageable, redirectAttributes);
			 api.delete(request);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}

		return view;
	}

	private void initRedirectData(Pageable pageable, RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
	}
}