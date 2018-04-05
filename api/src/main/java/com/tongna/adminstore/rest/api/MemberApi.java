package com.tongna.adminstore.rest.api;

import com.quhaodian.discover.rest.base.RequestTokenPageObject;
import com.tongna.adminstore.rest.domain.page.MemberPage;

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
