package com.haoxuer.adminstore.structure.api.apis;


import com.haoxuer.adminstore.structure.api.domain.list.OrganizationList;
import com.haoxuer.adminstore.structure.api.domain.page.OrganizationPage;
import com.haoxuer.adminstore.structure.api.domain.request.*;
import com.haoxuer.adminstore.structure.api.domain.response.OrganizationResponse;

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