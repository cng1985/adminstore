package com.quhaodian.adminstore.controller.admin;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Scope("prototype")
@Controller
public class TemplateAction {
  
  @RequestMapping("/admin/{view}")
  public String page(@PathVariable(value = "view") String view){
    return "admin/page/"+view;
  }
  
}
