package com.quhaodian.adminstore.rest.api;

import com.quhaodian.adminstore.rest.domain.page.MemberPage;
import com.quhaodian.discover.rest.base.RequestTokenPageObject;
import com.quhaodian.jsonrpc.annotation.RestFul;

/**
 * 用户api
 */
@RestFul(value = "memberApi", api = MemberApi.class)
public interface MemberApi {
  
  /**
   * 获取系统的用户
   *
   * @param request
   * @return
   */
  MemberPage page(RequestTokenPageObject request);
}
