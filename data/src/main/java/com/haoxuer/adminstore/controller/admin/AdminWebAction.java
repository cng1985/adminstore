package com.haoxuer.adminstore.controller.admin;

import com.haoxuer.adminstore.data.entity.Config;
import com.haoxuer.adminstore.data.entity.Member;
import com.haoxuer.adminstore.data.service.ConfigService;
import com.haoxuer.adminstore.data.service.MemberService;
import com.haoxuer.discover.rest.base.ResponseObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "admin")
public class AdminWebAction {

  @Autowired
  private ConfigService configService;

  @Autowired
  private MemberService memberService;

  @RequestMapping(value = "loginwork", method = RequestMethod.POST)
  public String loginwork() {
    return "redirect:/admin/index.htm";
  }
  
  
  @RequestMapping(value = "index", method = RequestMethod.GET)
  public String index(Model model) {
    model.addAttribute("members",memberService.count());
    return "admin/home";
  }


  @RequiresPermissions("system_config")
  @RequestMapping(value = "config", method = RequestMethod.GET)
  public String config(Model model) {
    model.addAttribute("model",configService.config());
    return "admin/system/config";
  }

  @ResponseBody
  @RequiresPermissions("system_config")
  @RequestMapping(value = "update_config", method = RequestMethod.POST)
  public ResponseObject updateConfig(@RequestBody Config config) {
    ResponseObject result=new ResponseObject();
    configService.update(config);
    return result;
  }
}
