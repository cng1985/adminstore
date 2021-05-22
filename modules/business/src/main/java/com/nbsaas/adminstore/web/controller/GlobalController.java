package com.nbsaas.adminstore.web.controller;


import com.nbsaas.adminstore.exception.NoDataException;
import com.nbsaas.adminstore.exception.NoUserTokenException;
import com.nbsaas.adminstore.exception.UnAuthorizationException;
import com.nbsaas.adminstore.member.data.entity.ExceptionLog;
import com.nbsaas.adminstore.member.data.service.ExceptionLogService;
import com.haoxuer.discover.rest.base.ResponseObject;
import com.haoxuer.discover.user.utils.UserUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Set;


@ControllerAdvice
public class GlobalController   {


  @Autowired
  private ExceptionLogService logService;


  @ExceptionHandler(ServletException.class)
  public ModelAndView expx(HttpServletRequest request, Exception ex) {
    return handleException(request, ex);
  }
  @ExceptionHandler(DataIntegrityViolationException.class)
  public ModelAndView dataIntegrityViolationException(HttpServletRequest request, Exception ex) {
    return handleException(request, ex);
  }
  @ExceptionHandler(IllegalArgumentException.class)
  public ModelAndView illegalArgument(HttpServletRequest request, Exception ex) {
    return handleException(request, ex);
  }

  @ExceptionHandler(NullPointerException.class)
  public ModelAndView nullEx(HttpServletRequest request, Exception ex) {
    return handleException(request, ex);

  }

  @ResponseBody
  @ExceptionHandler(NoDataException.class)
  public ResponseObject exp(HttpServletRequest request, Exception ex) {
    ResponseObject result = new ResponseObject();
    result.setMsg("app的id不存在!");
    result.setCode(-1);
    savaLog(ex, request);
    return result;
  }

  @ResponseBody
  @ExceptionHandler(NoUserTokenException.class)
  public ResponseObject noUserToken(HttpServletRequest request, Exception ex) {
    ResponseObject result = new ResponseObject();
    result.setMsg("用户token不存在!");
    result.setCode(-2);
    savaLog(ex, request);
    return result;
  }


  @ResponseBody
  @ExceptionHandler(UnAuthorizationException.class)
  public ResponseObject unAuthorization(HttpServletRequest request, Exception ex) {
    ResponseObject result = new ResponseObject();
    result.setMsg("用户token失效!");
    result.setCode(-3);
    savaLog(ex, request);
    return result;
  }

  @ResponseBody
  @ExceptionHandler(UserUtils.TokenInvalidException.class)
  public ResponseObject tokenInvalidException(HttpServletRequest request, Exception ex) {
    ResponseObject result = new ResponseObject();
    result.setMsg("用户token异常!");
    result.setCode(-4);
    savaLog(ex, request);
    return result;
  }

  public static boolean isAjaxRequest(HttpServletRequest request) {
    String requestedWith = request.getHeader("x-requested-with");
      return requestedWith != null && requestedWith.equalsIgnoreCase("XMLHttpRequest");
  }

  @ExceptionHandler(AuthorizationException.class)
  public ModelAndView unauthenticatedException(HttpServletRequest request, Exception ex) {
    return handleException(request, ex);

  }

  private ModelAndView handleException(HttpServletRequest request, Exception ex) {
    savaLog(ex, request);
    if (isAjaxRequest(request)) {
      ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
      mav.addObject("code", -5);
      mav.addObject("msg", "没有登陆");
      return mav;
    } else {
      RedirectView redirectView=new RedirectView("/index.htm",true);
      ModelAndView mav = new ModelAndView(redirectView);
      return mav;
    }
  }

  private void savaLog(Exception ex, HttpServletRequest request) {
    ExceptionLog bean = new ExceptionLog();
    bean.setName(ex.getClass().getSimpleName());
    bean.setNote(getExceptionAllInfo(ex));
    bean.setUrl(request.getRequestURL().toString());
    StringBuffer buffer = new StringBuffer();
    Map map = request.getParameterMap();
    Set set = map.keySet();
    if (set != null) {
      for (Object o : set) {
        buffer.append(o + "=");
        buffer.append(request.getParameter(o + "") + "\n");
      }
    }
    bean.setParams(buffer.toString());
    logService.save(bean);
  }

  public static String getExceptionAllInfo(Exception ex) {
    ByteArrayOutputStream out = null;
    PrintStream pout = null;
    String ret = "";
    try {
      out = new ByteArrayOutputStream();
      pout = new PrintStream(out);
      ex.printStackTrace(pout);
      ret = out.toString();
      out.close();
    } catch (Exception e) {
      return ex.getMessage();
    } finally {
      if (pout != null) {
        pout.close();
      }
    }
    return ret;
  }
  public GlobalController() {
    //super("callback");
  }
}
