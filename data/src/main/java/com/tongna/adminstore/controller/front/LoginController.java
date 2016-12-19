/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
 */
package com.tongna.adminstore.controller.front;

import com.ada.shiro.utils.UserUtil;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserLoginLog;
import com.ada.user.service.UserInfoService;
import com.ada.user.service.UserLoginLogService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录页
 *
 * @author langhsu
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    UserLoginLogService loginLogService;
    @Autowired
    UserInfoService userInfoService;

    /**
     * 跳转登录页
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return getView(Views.LOGIN);
    }

    /**
     * 提交登录
     *
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, ModelMap model) {
        String ret = getView(Views.LOGIN);

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return ret;
        }

        AuthenticationToken token = new UsernamePasswordToken(username,
                password);
        if (token == null) {
            model.put("message", "用户名或密码错误");
            return ret;
        }

        try {
            SecurityUtils.getSubject().login(token);

            ret = Views.REDIRECT_HOME;

            // 更新消息数量
            // pushBadgesCount();
        } catch (AuthenticationException e) {
            if (e instanceof UnknownAccountException) {
                model.put("message", "用户不存在");
            } else if (e instanceof LockedAccountException) {
                model.put("message", "用户被禁用");
            } else {
                model.put("message", "用户认证失败");
            }
        }

        return ret;
    }

    @RequestMapping(value = "/loginok", method = RequestMethod.GET)
    public String loginok(HttpServletRequest request) {
        UserInfo user = UserUtil.getCurrentUser();
        if (user != null) {
            UserLoginLog bean = new UserLoginLog();
            try {
                bean.setIp(getIpAddr(request));
            } catch (Exception e) {
                e.printStackTrace();
            }
            bean.setUser(user);
            bean.setState(1);
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
                           HttpServletRequest request, HttpServletResponse response,
                           Model model) {

        UserInfo user = new UserInfo();
        user.setName(name);
        user.setUsername(username);
        user.setPlainPassword(password);
        UserInfo userx = userInfoService.reg(user);
        if (userx != null && userx.getId() > 0) {
            model.addAttribute("msg", "注册成功");
            return "redirect:/login.htm";
        } else {
            model.addAttribute("msg", "注册失败");
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
