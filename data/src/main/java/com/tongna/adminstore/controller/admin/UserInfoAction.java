package com.tongna.adminstore.controller.admin;

import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.user.entity.UserInfo;
import com.ada.user.service.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "admin")
public class UserInfoAction {

	@Autowired
	UserInfoService userInfoService;

	Logger logger = LoggerFactory.getLogger("log");
	int aid = 0;

	@RequiresPermissions("account:list")
	@RequestMapping(value = "userinfo/view_list")
	public String list(Pageable pageable, HttpServletRequest request, ModelMap model) {
		if (pageable == null) {
			pageable = new Pageable();
		}
		if (pageable.getOrders() == null || pageable.getOrders().size() == 0) {
			pageable.getOrders().add(Order.desc("id"));
		}
		if (pageable.getSearchProperty() == null) {
			pageable.setSearchProperty("username");
		}
		Page<UserInfo> pagination = userInfoService.findPage(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		return "admin/userinfo/list";
	}

	@RequiresPermissions("account:add")
	@RequestMapping(value = "userinfo/view_add", method = RequestMethod.GET)
	public String add(UserInfo bean, ModelMap model) {

		// model.addAttribute("contractDetail",contractDetailService.findContractDetail(bean.getId()));

		return "admin/userinfo/add";
	}

	@RequiresPermissions("account:add")
	@RequestMapping(value = "userinfo/model_save", method = RequestMethod.POST)
	public String save(UserInfo bean, HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		userInfoService.save(bean);
		// ContractDetail contractDetail = new ContractDetail();
		// contractDetail.setContract(bean);
		// contractDetailService.save(contractDetail);
		return "redirect:/admin/userinfo/view_list.htm";
	}

	@RequiresPermissions("account:update")
	@RequestMapping(value = "userinfo/view_edit", method = RequestMethod.GET)
	public String edit(Long id, Integer pageNumber, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		// model.addAttribute("contractDetail",
		// userRoleService.findContractDetail(id));
		model.addAttribute("model", userInfoService.findById(id));
		model.addAttribute("pageNumber", pageNumber);
		return "admin/userinfo/edit";
	}

	@RequiresPermissions("account:update")
	@RequestMapping(value = "userinfo/model_update", method = RequestMethod.POST)
	public String update(Pageable pageable, UserInfo bean, HttpServletRequest request, ModelMap model) {
		// ContractDetail contractDetail = new ContractDetail();
		// contractDetail.setContract(bean);
		// contractDetailService.save(contractDetail);
		bean = userInfoService.update(bean);
		return list(pageable, request, model);
	}

	@RequiresPermissions("account:view")
	@RequestMapping(value = "userinfo/view_detail", method = RequestMethod.GET)
	public String detail(Long id, Integer pageNumber, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		// model.addAttribute("contractDetail",
		// contractDetailService.findContractDetail(id));
		model.addAttribute("model", userInfoService.findById(id));
		model.addAttribute("pageNumber", pageNumber);
		return "admin/userinfo/detail";
	}

	@RequiresPermissions("account:delete")
	@RequestMapping(value = "userinfo/model_delete")
	public String delete(Pageable pageable, Long id, HttpServletRequest request, ModelMap model) {

		try {
			userInfoService.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的内容!");
		}
		return list(pageable, request, model);
	}

	@RequiresPermissions("account:delete")
	@RequestMapping(value = "userinfo/model_deletes")
	public String deletes(Pageable pageable, Long[] ids, HttpServletRequest request, ModelMap model) {

		userInfoService.deleteByIds(ids);

		return "redirect:/admin/userinfo/view_list.htm?pageNumber=" + pageable.getPageNumber();
	}

}
