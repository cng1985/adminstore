package com.haoxuer.adminstore.controller.rest;


import com.haoxuer.adminstore.rest.api.MemberApi;
import com.haoxuer.adminstore.rest.domain.page.MemberPage;
import com.haoxuer.adminstore.rest.domain.request.MemberNameRequest;
import com.haoxuer.adminstore.rest.domain.request.MemberUpdateRequest;
import com.haoxuer.discover.rest.base.RequestTokenPageObject;
import com.haoxuer.discover.rest.base.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Scope("prototype")
@RequestMapping("/rest")
@RestController
public class MemberRestController {
  
  @RequestMapping("/member/page")
  public MemberPage page(RequestTokenPageObject request) {
    return api.page(request);
  }
  
  @RequestMapping("/member/update")
  public ResponseObject update(MemberUpdateRequest request) {
    return api.update(request);
  }

  @RequestMapping("/member/name")
  public MemberPage name(MemberNameRequest request) {
    return api.name(request);
  }

  @RequestMapping("/member/demo")
  public ResponseObject demo() {
    return api.demo();
  }

  @Autowired
  private MemberApi api;
  
}
