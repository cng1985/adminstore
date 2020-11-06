package com.haoxuer.adminstore.member.controller.front;


import com.haoxuer.discover.web.controller.front.BaseController;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Scope("prototype")
@Controller
public class TemplatePageController extends BaseController {
  
  @RequestMapping("/pages/{view}")
  public String page(@PathVariable(value = "view") String view) {
    if (StringUtils.isEmpty(view)) {
      view = "index";
    }
    return getView("pages/" + view);
  }
}
