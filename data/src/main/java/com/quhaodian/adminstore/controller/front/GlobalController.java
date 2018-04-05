package com.quhaodian.adminstore.controller.front;


import com.quhaodian.discover.rest.base.ResponseObject;
import com.quhaodian.user.utils.UserUtils;
import com.quhaodian.adminstore.exception.NoDataException;
import com.quhaodian.adminstore.exception.NoUserTokenException;
import com.quhaodian.adminstore.exception.UnAuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GlobalController extends AbstractJsonpResponseBodyAdvice {

    @ResponseBody
    @ExceptionHandler(NoDataException.class)
    public ResponseObject exp(HttpServletRequest request, Exception ex) {
        ResponseObject result = new ResponseObject();
        result.setMsg("app的id不存在!");
        result.setCode(-1);
        return result;
    }

    @ResponseBody
    @ExceptionHandler(NoUserTokenException.class)
    public ResponseObject noUserToken(HttpServletRequest request, Exception ex) {
        ResponseObject result = new ResponseObject();
        result.setMsg("用户token不存在!");
        result.setCode(-2);
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
        return result;
    }


    public GlobalController() {
        super("callback");
    }
}
