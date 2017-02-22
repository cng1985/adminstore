package com.tongna.adminstore.controller.admin;

import com.ada.admin.entity.Menu;
import com.ada.admin.service.MenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "admin")
public class MenuAction {

	@Autowired
	MenuService menuService;

	Logger logger = LoggerFactory.getLogger("log");
	int aid = 0;

	@RequiresPermissions("menu:list")
	@RequestMapping(value = "menu/list", method = RequestMethod.GET)
	public String list(@RequestParam(value = "id", required = true, defaultValue = "1") int id,
			HttpServletRequest request, HttpServletResponse response, Model model) {

		model.addAttribute("id", id);
		model.addAttribute("tops", menuService.findTop(id));
		model.addAttribute("list", menuService.findChild(id));

		return "admin/menu/list";
	}

	@RequiresPermissions("menu:list")
	@RequestMapping(value = "menu/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "admin/menu/index";
	}

	@RequiresPermissions("menu:list")
	@RequestMapping(value = "menu/view_add", method = RequestMethod.GET)
	public String view_add(HttpServletRequest request, int pid, HttpServletResponse response, Model model) {
		Menu item = menuService.findById(pid);
		model.addAttribute("item", item);
		return "admin/menu/view_add";
	}

	@RequiresPermissions("menu:list")
	@RequestMapping(value = "menu/model_add", method = RequestMethod.POST)
	public String model_add(Menu menu, HttpServletRequest request, HttpServletResponse response, Model model) {

		menuService.save(menu);
		if (menu.getParentId() != null) {
			return "redirect:/admin/menu/list.htm?id=" + menu.getParentId();

		} else {
			return "redirect:/admin/menu/list.htm";

		}
	}

	@RequiresPermissions("menu:list")
	@RequestMapping(value = "menu/view_update", method = RequestMethod.GET)
	public String view_update(Integer id, HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("model", menuService.findById(id));
		return "admin/menu/view_update";
	}

	@RequiresPermissions("menu:list")
	@RequestMapping(value = "menu/model_update")
	public String model_update(Menu menu, HttpServletRequest request, HttpServletResponse response, Model model) {

		menu = menuService.update(menu);

		Integer id = null;
		if (menu != null) {
			id = menu.getParentId();
		} else {
			id = 1;
		}

		return "redirect:/admin/menu/list.htm?id=" + id;
	}

	@RequiresPermissions("menu:list")
	@RequestMapping(value = "menu/model_delete", method = RequestMethod.GET)
	public String model_delete(int typeid, HttpServletRequest request, HttpServletResponse response, Model model) {
		Menu menu = menuService.findById(typeid);
		Integer id = null;
		if (menu != null) {
			id = menu.getParentId();
		} else {
			id = 1;
		}
		menuService.deleteById(typeid);

		return "redirect:/admin/menu/list.htm?id=" + id;
	}

	private HttpSession getSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			logger.info("会话不存在");
			session = request.getSession(true);
		}
		return session;
	}

}
