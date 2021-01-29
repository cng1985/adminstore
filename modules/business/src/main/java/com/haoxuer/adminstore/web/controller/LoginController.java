/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
 */

package com.haoxuer.adminstore.web.controller;

import com.haoxuer.discover.rest.base.ResponseObject;
import com.haoxuer.discover.user.data.entity.UserInfo;
import com.haoxuer.discover.user.data.entity.UserLoginLog;
import com.haoxuer.discover.user.data.enums.BindType;
import com.haoxuer.discover.user.data.enums.LoginState;
import com.haoxuer.discover.user.data.request.UserRegisterRequest;
import com.haoxuer.discover.user.data.response.UserBasicResponse;
import com.haoxuer.discover.user.data.service.UserAccountService;
import com.haoxuer.discover.user.data.service.UserInfoService;
import com.haoxuer.discover.user.data.service.UserLoginLogService;
import com.haoxuer.discover.user.shiro.utils.UserUtil;
import com.haoxuer.discover.web.controller.front.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录页
 *
 * @author langhsu
 */
@Controller
public class LoginController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    UserLoginLogService loginLogService;
    @Autowired
    UserInfoService userInfoService;

    @Autowired
    UserAccountService userAccountService;

    @PostMapping(value = "/loginHandle")
    public String loginHandle(String username, String password,Model model) {
        //attributes.addFlashAttribute("msg", "密码错误");

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            return redirect("/loginok.htm");
        } catch (Exception e) {
           e.printStackTrace();
            model.addAttribute("msg", "密码错误");

        }
        return getView("login");
    }
    @ResponseBody
    @RequestMapping(value = "/loginAjax")
    public ResponseObject loginAjax(String username, String password, String tenant) {
        ResponseObject result=new ResponseObject();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(501);
            result.setMsg("密码错误");
        }
        return result;
    }

    @PostMapping(value = "/login")
    public String loginWork(RedirectAttributes attributes) {
        attributes.addFlashAttribute("msg", "密码错误");
        return "redirect:login.htm";
    }

    @RequestMapping(value = "/loginok", method = RequestMethod.GET)
    public String loginok(HttpServletRequest request) {
        UserInfo user = UserUtil.getCurrentUser();
        if (user != null) {
            UserLoginLog bean = new UserLoginLog();
            try {
                bean.setIp(getIpAddr(request));
            } catch (Exception e) {
                log.info("登陆失败", e);
            }
            bean.setUser(user);
            bean.setState(LoginState.success);
            loginLogService.save(bean);
        }
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/admin/index.htm";
        } else {
            return getView("login");
        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(String name, String username, String password,
                           Model model, RedirectAttributes attributes) {

        UserRegisterRequest request = new UserRegisterRequest();
        request.setBindType(BindType.account);
        request.setNo(username);
        request.setPassword(password);
        UserBasicResponse userx = userInfoService.register(request);
        if (userx.getCode() == 0) {
            attributes.addAttribute("msg", "注册成功");
            return "redirect:/login.htm";
        } else {
            model.addAttribute("msg", userx.getMsg());
            return getView("register");
        }

    }

    /**
     * 跳转登录页
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return getView("register");
    }

    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping("/signout")
    public String signout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/login.htm";
    }

    /**
     * 跳转登录页
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String view() {
        return getView(Views.LOGIN);
    }


}
