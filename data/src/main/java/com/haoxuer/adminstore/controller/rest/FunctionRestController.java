package com.haoxuer.adminstore.controller.rest;


import bsh.EvalError;
import bsh.Interpreter;
import com.haoxuer.adminstore.data.entity.Function;
import com.haoxuer.adminstore.data.service.FunctionService;
import com.haoxuer.discover.rest.base.ResponseObject;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Scope("prototype")
@RequestMapping("/function")
@RestController
public class FunctionRestController implements ApplicationContextAware {

  private ApplicationContext context;

  @Autowired
  private FunctionService functionService;

  @RequestMapping("{key}")
  public ResponseObject page(@PathVariable("key") String key, HttpServletRequest request) {
    ResponseObject result = new ResponseObject();
   Function function= functionService.findByKey(key);
   if (function==null){
     result.setCode(501);
     result.setMsg("无效key");
     return result;
   }
   if (StringUtils.isEmpty(function.getScript())){
     result.setCode(502);
     result.setMsg("无效脚本");
     return result;
   }

    Interpreter interpreter = new Interpreter();  // Construct an interpreter

    try {
      interpreter.set("request", request);
      interpreter.set("context", context);

      StringBuffer buffer = new StringBuffer();
      buffer.append(function.getScript());
      interpreter.eval(buffer.toString());

      Object object = interpreter.get("result");
      if (object != null) {
        if (object instanceof ResponseObject) {
          result = (ResponseObject) object;
        }
      }
    } catch (EvalError evalError) {
      evalError.printStackTrace();
    }

    return result;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context=applicationContext;

  }
}
