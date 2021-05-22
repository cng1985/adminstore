package com.nbsaas.adminstore.member.controller.admin;

import com.haoxuer.discover.controller.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "admin")
public class AdminWebAction extends BaseAction {

    @RequestMapping(value = "loginwork", method = RequestMethod.POST)
    public String loginwork() {
        return getView("home");
    }


    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return getView("home");
    }
}
