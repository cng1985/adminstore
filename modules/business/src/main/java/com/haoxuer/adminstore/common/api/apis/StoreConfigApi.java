package com.haoxuer.adminstore.common.api.apis;


import com.haoxuer.adminstore.common.api.domain.list.StoreConfigList;
import com.haoxuer.adminstore.common.api.domain.page.StoreConfigPage;
import com.haoxuer.adminstore.common.api.domain.request.*;
import com.haoxuer.adminstore.common.api.domain.response.StoreConfigResponse;

public interface StoreConfigApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    StoreConfigResponse create(StoreConfigDataRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    StoreConfigResponse update(StoreConfigDataRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    StoreConfigResponse delete(StoreConfigDataRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     StoreConfigResponse view(StoreConfigDataRequest request);


    /**
     * 集合功能
     * @param request
     * @return
     */
    StoreConfigList list(StoreConfigSearchRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    StoreConfigPage search(StoreConfigSearchRequest request);

}