package com.tongna.adminstore.rest.api;

import com.tongna.adminstore.rest.domain.list.AdList;
import com.tongna.adminstore.rest.domain.request.AdListRequest;

public interface AdApi {
    /**
     * 获取商会广告
     *
     * @param request
     * @return
     */
    AdList list(AdListRequest request);
}
