package com.quhaodian.adminstore.rest.api;

import com.quhaodian.adminstore.rest.domain.page.MemberPage;
import com.quhaodian.adminstore.rest.domain.request.MemberUpdateRequest;
import com.quhaodian.discover.rest.base.RequestTokenPageObject;
import com.quhaodian.discover.rest.base.ResponseObject;
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
  
  /**
   * 更新用户信息
   * @param request
   * @return
   */
  ResponseObject update(MemberUpdateRequest request);
  
}
