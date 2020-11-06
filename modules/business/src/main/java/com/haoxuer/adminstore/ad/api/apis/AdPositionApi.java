package com.haoxuer.adminstore.ad.api.apis;


import com.haoxuer.adminstore.ad.api.domain.list.AdPositionList;
import com.haoxuer.adminstore.ad.api.domain.page.AdPositionPage;
import com.haoxuer.adminstore.ad.api.domain.request.*;
import com.haoxuer.adminstore.ad.api.domain.response.AdPositionResponse;

public interface AdPositionApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    AdPositionResponse create(AdPositionDataRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    AdPositionResponse update(AdPositionDataRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    AdPositionResponse delete(AdPositionDataRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     AdPositionResponse view(AdPositionDataRequest request);


    /**
     * 集合功能
     * @param request
     * @return
     */
    AdPositionList list(AdPositionSearchRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    AdPositionPage search(AdPositionSearchRequest request);

}