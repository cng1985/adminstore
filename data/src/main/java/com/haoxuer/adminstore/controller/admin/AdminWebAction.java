package com.haoxuer.adminstore.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "admin")
public class AdminWebAction {
  
  @RequestMapping(value = "loginwork", method = RequestMethod.POST)
  public String loginwork() {
    return "admin/home";
  }
  
  
  @RequestMapping(value = "index", method = RequestMethod.GET)
  public String index() {
    return "admin/home";
  }
}
