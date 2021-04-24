package com.haoxuer.adminstore.common.controller.admin;

import com.haoxuer.discover.web.base.BaseAction;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/tenant/system")
@Scope("prototype")
@Controller
public class TenantSystemAction extends BaseAction {


    @RequiresPermissions("system_index")
    @RequestMapping("/index")
    public String index(ModelMap model) {
        return getView("system/index");
    }

    @RequiresPermissions("system_profile")
    @RequestMapping("/profile")
    public String add(ModelMap model) {
        return getView("system/profile");
    }
}
