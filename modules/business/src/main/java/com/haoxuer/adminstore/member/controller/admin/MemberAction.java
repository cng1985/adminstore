package com.haoxuer.adminstore.member.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.adminstore.member.api.apis.MemberApi;
import com.haoxuer.adminstore.member.api.domain.page.MemberPage;
import com.haoxuer.adminstore.member.api.domain.request.*;import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.annotation.Scope;
import com.haoxuer.discover.web.base.BaseAction;
/**
*
* Created by imake on 2021年01月23日16:23:08.
*/


@Scope("prototype")
@Controller
public class MemberAction extends BaseAction{

	public static final String MODEL = "model";

	public static final String REDIRECT_LIST_HTML = "redirect:/admin/member/view_list.htm";

	private static final Logger log = LoggerFactory.getLogger(MemberAction.class);

	@Autowired
	private MemberApi api;

	@RequiresPermissions("member")
	@RequestMapping("/admin/member/view_list")
	public String list(MemberSearchRequest request,ModelMap model) {

        MemberPage page = api.search(request);
        model.addAttribute("list", page.getList());
		model.addAttribute("page", page);
		model.addAttribute("so", request);
		return getView("member/list");
	}

	@RequiresPermissions("member")
	@RequestMapping("/admin/member/view_add")
	public String add(ModelMap model) {
		return getView("member/add");
	}

	@RequiresPermissions("member")
	@RequestMapping("/admin/member/view_edit")
	public String edit(Pageable pageable,MemberDataRequest request,  ModelMap model) {
        model.addAttribute(MODEL, api.view(request));
		model.addAttribute("page", pageable);
		return getView("member/edit");
	}

	@RequiresPermissions("member")
	@RequestMapping("/admin/member/view_view")
	public String view(MemberDataRequest request,ModelMap model) {
         model.addAttribute(MODEL, api.view(request));
		return getView("member/view");
	}

	@RequiresPermissions("member")
	@RequestMapping("/admin/member/model_save")
	public String save(MemberDataRequest request,ModelMap model) {
	
	    String view=REDIRECT_LIST_HTML;
		try {
			 api.create(request);
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view=getView("member/add");
		}
		return view;
	}

	@RequiresPermissions("member")
	@RequestMapping("/admin/member/model_update")
	public String update(Pageable pageable, MemberDataRequest request,  RedirectAttributes redirectAttributes, ModelMap model) {
		
		String view=REDIRECT_LIST_HTML;
		try {
			api.update(request);
			initRedirectData(pageable, redirectAttributes);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,request);
		    model.addAttribute("page", pageable);
			view=getView("member/edit");
		}
		return view;
	}
	@RequiresPermissions("member")
	@RequestMapping("/admin/member/model_delete")
	public String delete(Pageable pageable, MemberDataRequest request, RedirectAttributes redirectAttributes) {

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