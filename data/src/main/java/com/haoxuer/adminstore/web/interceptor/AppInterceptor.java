package com.haoxuer.adminstore.web.interceptor;

import com.haoxuer.adminstore.exception.NoDataException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AppInterceptor extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    String app = request.getParameter("app");
    if (app == null) {
      throw new NoDataException();
    } else {

    }

    return true;
  }
}
