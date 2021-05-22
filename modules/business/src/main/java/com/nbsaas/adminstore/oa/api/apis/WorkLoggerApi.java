package com.nbsaas.adminstore.oa.api.apis;


import com.nbsaas.adminstore.oa.api.domain.list.WorkLoggerList;
import com.nbsaas.adminstore.oa.api.domain.page.WorkLoggerPage;
import com.nbsaas.adminstore.oa.api.domain.response.WorkLoggerResponse;
import com.nbsaas.adminstore.oa.api.domain.request.WorkLoggerDataRequest;
import com.nbsaas.adminstore.oa.api.domain.request.WorkLoggerSearchRequest;

public interface WorkLoggerApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    WorkLoggerResponse create(WorkLoggerDataRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    WorkLoggerResponse update(WorkLoggerDataRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    WorkLoggerResponse delete(WorkLoggerDataRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     WorkLoggerResponse view(WorkLoggerDataRequest request);


    /**
     * 集合功能
     * @param request
     * @return
     */
    WorkLoggerList list(WorkLoggerSearchRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    WorkLoggerPage search(WorkLoggerSearchRequest request);

}