package com.haoxuer.adminstore.web.controller;

import com.haoxuer.discover.web.controller.front.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SiteController extends BaseController {

    /**
     * 跳转登录页
     *
     * @return
     */
    @GetMapping(value = "/index")
    public String index() {
        return getView("login");
    }


}
