package com.quhaodian.adminstore.rest.api;

import com.quhaodian.discover.rest.base.RequestTokenPageObject;
import com.quhaodian.adminstore.rest.domain.page.MemberPage;

/**
 * 用户api
 */
public interface MemberApi {

    /**
     * 获取系统的用户
     *
     * @param request
     * @return
     */
    MemberPage page(RequestTokenPageObject request);
}
