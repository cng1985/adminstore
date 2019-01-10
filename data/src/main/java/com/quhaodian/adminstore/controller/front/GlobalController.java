package com.quhaodian.adminstore.controller.front;


import com.quhaodian.adminstore.data.entity.ExceptionLog;
import com.quhaodian.adminstore.data.service.ExceptionLogService;
import com.quhaodian.adminstore.exception.NoDataException;
import com.quhaodian.adminstore.exception.NoUserTokenException;
import com.quhaodian.adminstore.exception.UnAuthorizationException;
import com.haoxuer.discover.rest.base.ResponseObject;
import com.haoxuer.discover.user.utils.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Set;


@ControllerAdvice
public class GlobalController  {

  @Autowired
  ExceptionLogService logService;

  @ResponseBody
  @ExceptionHandler(ServletException.class)
  public ResponseObject expx(HttpServletRequest request, Exception ex) {
    ResponseObject result = new ResponseObject();
    result.setMsg("服务器异常!");
    result.setCode(-1);
    savaLog(ex, request);
    return result;
  }

  @ResponseBody
  @ExceptionHandler(CannotAcquireLockException.class)
  public ResponseObject cannotacquirelock(HttpServletRequest request, Exception ex) {
    ResponseObject result = new ResponseObject();
    result.setMsg("事物异常!");
    result.setCode(-1);
    savaLog(ex, request);
    return result;
  }


  @ResponseBody
  @ExceptionHandler(NullPointerException.class)
  public ResponseObject nullEx(HttpServletRequest request, Exception ex) {
    ResponseObject result = new ResponseObject();
    result.setMsg("数据处理异常!");
    result.setCode(-1);
    savaLog(ex, request);
    return result;
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
  
  
  public GlobalController() {

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
      ret = new String(out.toByteArray());
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
}
