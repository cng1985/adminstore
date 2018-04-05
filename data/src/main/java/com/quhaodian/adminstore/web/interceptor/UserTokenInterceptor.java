package com.quhaodian.adminstore.web.interceptor;

import com.quhaodian.user.utils.UserUtils;
import com.quhaodian.adminstore.exception.NoUserTokenException;
import com.quhaodian.adminstore.exception.UnAuthorizationException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserTokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getParameter("userToken");
        if (token == null) {
            throw new NoUserTokenException();
        }
        Long app = UserUtils.getApp(token);
        if (app == null) {
            throw new UnAuthorizationException();
        }
        return true;
    }
}
