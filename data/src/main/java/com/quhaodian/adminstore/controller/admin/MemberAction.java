package com.quhaodian.adminstore.controller.admin;

import com.haoxuer.discover.data.rest.domain.AbstractVo;
import com.haoxuer.discover.user.data.service.UserAccountService;
import com.haoxuer.discover.user.enums.AccountType;
import com.haoxuer.discover.user.shiro.utils.UserUtil;
import com.quhaodian.adminstore.data.entity.Member;
import com.quhaodian.adminstore.data.request.MemberUpdateRequest;
import com.quhaodian.adminstore.data.service.MemberService;
import com.quhaodian.adminstore.data.so.MemberSo;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import com.haoxuer.discover.rest.base.ResponseObject;
import com.haoxuer.discover.user.data.entity.UserAccount;
import com.haoxuer.discover.user.data.service.UserInfoService;
import com.haoxuer.discover.user.data.service.UserRoleService;
import com.haoxuer.discover.user.data.vo.UserAccountVo;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by imake on 2017年08月29日17:08:12.
 */


@Scope("prototype")
@Controller
public class MemberAction {
  
  public static final String MODEL = "model";
  
  private static final Logger log = LoggerFactory.getLogger(MemberAction.class);
  public static final String REDIRECT_LIST_HTML = "redirect:/admin/member/view_list.htm";
  
  @Autowired
  private MemberService manager;
  
  
  @Autowired
  private UserRoleService roleService;
  
  @Autowired
  private UserInfoService userInfoService;

  @Autowired
  private UserAccountService accountService;
  
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
  }
  
  @RequiresPermissions("member")
  @RequestMapping("/admin/member/view_list")
  public String list(Pageable pageable, MemberSo so, ModelMap model) {
    
    if (pageable == null) {
      pageable = new Pageable();
    }
    if (pageable.getOrders() == null || pageable.getOrders().isEmpty()) {
      pageable.getOrders().add(Order.desc("id"));
    }
    pageable.getFilters().addAll(FilterUtils.getFilters(so));
    Page<Member> pagination = manager.page(pageable);
    model.addAttribute("list", pagination.getContent());
    model.addAttribute("page", pagination);
    model.addAttribute("so", so);
    return "/admin/member/list";
  }
  
  @RequiresPermissions("member")
  @RequestMapping("/admin/member/view_add")
  public String add(ModelMap model) {
    model.addAttribute("roles", roleService.list(0, 1000, null, null));
    return "/admin/member/add";
  }
  
  @RequiresPermissions("member")
  @RequestMapping("/admin/member/view_edit")
  public String edit(Pageable pageable, Long id, ModelMap model) {
    model.addAttribute(MODEL, manager.findById(id));
    model.addAttribute("page", pageable);
    model.addAttribute("roles", roleService.list(0, 1000, null, null));
    
    return "/admin/member/edit";
  }
  
  @RequiresPermissions("member")
  @RequestMapping("/admin/member/view_view")
  public String view(Long id, ModelMap model) {
    model.addAttribute(MODEL, manager.findById(id));
    return "/admin/member/view";
  }
  
  @RequiresPermissions("member")
  @RequestMapping("/admin/member/profile")
  public String profile(Long id, ModelMap model) {
    model.addAttribute(MODEL, manager.findById(id));
    return "/admin/member/profile";
  }

  @ResponseBody
  @RequiresPermissions("member")
  @RequestMapping("/admin/member/model_update_json")
  public ResponseObject updateInfo(@RequestBody MemberUpdateRequest request) {
    return manager.update(request);
  }

  @RequiresPermissions("member_basic")
  @RequestMapping("/admin/member/basic")
  public String basic(ModelMap model) {
    model.addAttribute(MODEL, manager.findById(UserUtil.getCurrentUser().getId()));
    return "/admin/member/basic";
  }
  @ResponseBody
  @RequiresPermissions("member")
  @RequestMapping("/admin/member/model_update_basic")
  public ResponseObject updateBasic(@RequestBody MemberUpdateRequest request) {
    request.setId(UserUtil.getCurrentUser().getId());
    if (StringUtils.hasText(request.getName())){
      UserUtil.getCurrentUser().setName(request.getName());
    }
    return manager.update(request);
  }
  @ResponseBody
  @RequiresPermissions("member")
  @RequestMapping("/admin/member/updatepassword")
  public AbstractVo updatepassword(String oldPassword, String password) {
    return accountService.updatePassword(UserUtil.getCurrentUser().getId(), AccountType.Account, oldPassword, password);
  }


  
  @RequiresPermissions("member")
  @RequestMapping("/admin/member/model_save")
  public String save(UserAccount account, Member bean, Long[] roles, ModelMap model, RedirectAttributes attributes) {
    
    String view = "redirect:view_list.htm";
    try {
      
      UserAccountVo vo = manager.reg(account, bean);
      if (vo != null) {
        attributes.addFlashAttribute("msg", vo.getMsg());
        if (roles != null) {
          for (Long role : roles) {
            userInfoService.addRole(vo.getUser(), role);
          }
        }
      }
      log.info("save object id={}", bean.getId());
    } catch (Exception e) {
      log.error("保存失败", e);
      model.addAttribute("erro", e.getMessage());
      view = "/admin/member/add";
    }
    return view;
  }
  
  @RequiresPermissions("member")
  @RequestMapping("/admin/member/model_update")
  public String update(Pageable pageable, Member bean, Long[] roles, RedirectAttributes redirectAttributes, ModelMap model) {
    
    String view = REDIRECT_LIST_HTML;
    try {
      manager.update(bean);
      if (roles != null) {
        for (Long role : roles) {
          userInfoService.addRole(bean.getId(), role);
        }
      }
      initPageNum(pageable, redirectAttributes);
    } catch (Exception e) {
      log.error("更新失败", e);
      model.addAttribute("erro", e.getMessage());
      model.addAttribute(MODEL, bean);
      model.addAttribute("page", pageable);
      view = "/admin/member/edit";
    }
    return view;
  }
  
  private void initPageNum(Pageable pageable, RedirectAttributes redirectAttributes) {
    redirectAttributes.addAttribute("pageNumber", pageable.getPageNumber());
  }
  
  @RequiresPermissions("member")
  @RequestMapping("/admin/member/model_delete")
  public String delete(Pageable pageable, Long id, RedirectAttributes redirectAttributes) {
    
    String view = REDIRECT_LIST_HTML;
    
    try {
      initPageNum(pageable, redirectAttributes);
      manager.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      log.error("删除失败", e);
      redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
    }
    
    return view;
  }
  
  @RequiresPermissions("member")
  @RequestMapping("/admin/member/model_deletes")
  public String deletes(Pageable pageable, Long[] ids, RedirectAttributes redirectAttributes) {
    
    String view = REDIRECT_LIST_HTML;
    
    try {
      initPageNum(pageable, redirectAttributes);
      manager.deleteByIds(ids);
    } catch (DataIntegrityViolationException e) {
      log.error("批量删除失败", e);
      redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
    }
    return view;
  }
  
}