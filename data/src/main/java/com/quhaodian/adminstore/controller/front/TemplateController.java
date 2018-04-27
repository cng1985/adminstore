package com.quhaodian.adminstore.controller.front;

import com.quhaodian.web.controller.front.BaseController;
import org.springframework.web.bind.annotation.GetMapping;

public class TemplateController extends BaseController {
  
  
  @GetMapping(value = "/index")
  public String index(){
   return getView("login");
  }
}
