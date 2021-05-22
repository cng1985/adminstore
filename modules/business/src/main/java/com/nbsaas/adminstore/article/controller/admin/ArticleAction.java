package com.nbsaas.adminstore.article.controller.admin;

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
import com.nbsaas.adminstore.article.data.entity.Article;
import com.nbsaas.adminstore.article.data.service.ArticleService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.annotation.Scope;
import com.haoxuer.discover.web.base.BaseAction;
/**
*
* Created by imake on 2020年11月04日20:17:53.
*/


@Scope("prototype")
@Controller
public class ArticleAction extends BaseAction{

	public static final String MODEL = "model";

	public static final String REDIRECT_LIST_HTML = "redirect:/admin/article/view_list.htm";

	private static final Logger log = LoggerFactory.getLogger(ArticleAction.class);

	@Autowired
	private ArticleService manager;

	@RequiresPermissions("article")
	@RequestMapping("/admin/article/view_list")
	public String list(Pageable pageable,ModelMap model) {

		if (pageable==null){
			pageable=new Pageable();
		}
		if (pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
		}
		Page<Article> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		return getView("article/list");
	}

	@RequiresPermissions("article")
	@RequestMapping("/admin/article/view_add")
	public String add(ModelMap model) {
		return getView("article/add");
	}

	@RequiresPermissions("article")
	@RequestMapping("/admin/article/view_edit")
	public String edit(Pageable pageable,Long id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return getView("article/edit");
	}

	@RequiresPermissions("article")
	@RequestMapping("/admin/article/view_view")
	public String view(Long id,ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return getView("article/view");
	}

	@RequiresPermissions("article")
	@RequestMapping("/admin/article/model_save")
	public String save(Article bean,ModelMap model) {
	
	    String view=REDIRECT_LIST_HTML;
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view=getView("article/add");
		}
		return view;
	}

	@RequiresPermissions("article")
	@RequestMapping("/admin/article/model_update")
	public String update(Pageable pageable, Article bean, RedirectAttributes redirectAttributes, ModelMap model) {
		
		String view=REDIRECT_LIST_HTML;
		try {
			manager.update(bean);
			initRedirectData(pageable, redirectAttributes);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view=getView("article/edit");
		}
		return view;
	}
	@RequiresPermissions("article")
	@RequestMapping("/admin/article/model_delete")
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

	@RequiresPermissions("article")
	@RequestMapping("/admin/article/model_deletes")
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