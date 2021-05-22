package com.nbsaas.adminstore.ad.api.apis;


import com.nbsaas.adminstore.ad.api.domain.list.AdList;
import com.nbsaas.adminstore.ad.api.domain.page.AdPage;
import com.nbsaas.adminstore.ad.api.domain.response.AdResponse;
import com.nbsaas.adminstore.ad.api.domain.request.AdDataRequest;
import com.nbsaas.adminstore.ad.api.domain.request.AdSearchRequest;

public interface AdApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    AdResponse create(AdDataRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    AdResponse update(AdDataRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    AdResponse delete(AdDataRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     AdResponse view(AdDataRequest request);


    /**
     * 集合功能
     * @param request
     * @return
     */
    AdList list(AdSearchRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    AdPage search(AdSearchRequest request);

}