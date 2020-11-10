package com.haoxuer.adminstore.web.controller;

import com.haoxuer.discover.qrcode.view.QRView;
import com.haoxuer.discover.web.controller.front.BaseController;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Scope("prototype")
@Controller
public class QrCodeController extends BaseController {
  
  public static final int SIZE = 100;

  @RequestMapping("/qrcode/{path}")
  public ModelAndView view(Model model, @PathVariable("path") String path){
    model.addAttribute("width",500);
    model.addAttribute("height",500);
    model.addAttribute("code",path);

    ModelAndView result=new ModelAndView();
    result.setView(new QRView());
    return result;
  }
}
