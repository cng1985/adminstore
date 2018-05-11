package com.quhaodian.adminstore.rest.api;

import com.quhaodian.adminstore.rest.domain.list.AdList;
import com.quhaodian.adminstore.rest.domain.request.AdListRequest;
import com.quhaodian.jsonrpc.annotation.RestFul;


@RestFul(value = "adApi", api = AdApi.class)
public interface AdApi {
  /**
   * 获取广告.
   *
   * @param request 请求对象
   * @return
   */
  AdList list(AdListRequest request);
}
