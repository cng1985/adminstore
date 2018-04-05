package com.tongna.adminstore.web.interceptor;

import com.tongna.adminstore.exception.NoDataException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String app = request.getParameter("app");
        if (app==null){
            throw new NoDataException();
        }else{

        }

        return true;
    }
}
