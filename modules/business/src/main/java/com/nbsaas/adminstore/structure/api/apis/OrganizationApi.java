package com.nbsaas.adminstore.structure.api.apis;


import com.nbsaas.adminstore.structure.api.domain.list.OrganizationList;
import com.nbsaas.adminstore.structure.api.domain.page.OrganizationPage;
import com.nbsaas.adminstore.structure.api.domain.response.OrganizationResponse;
import com.nbsaas.adminstore.structure.api.domain.request.OrganizationDataRequest;
import com.nbsaas.adminstore.structure.api.domain.request.OrganizationSearchRequest;

public interface OrganizationApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    OrganizationResponse create(OrganizationDataRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    OrganizationResponse update(OrganizationDataRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    OrganizationResponse delete(OrganizationDataRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     OrganizationResponse view(OrganizationDataRequest request);


    /**
     * 集合功能
     * @param request
     * @return
     */
    OrganizationList list(OrganizationSearchRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    OrganizationPage search(OrganizationSearchRequest request);

}