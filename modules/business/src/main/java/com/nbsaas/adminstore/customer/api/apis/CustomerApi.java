package com.nbsaas.adminstore.customer.api.apis;


import com.nbsaas.adminstore.customer.api.domain.list.CustomerList;
import com.nbsaas.adminstore.customer.api.domain.page.CustomerPage;
import com.nbsaas.adminstore.customer.api.domain.request.*;
import com.nbsaas.adminstore.customer.api.domain.response.CustomerResponse;

public interface CustomerApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    CustomerResponse create(CustomerDataRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    CustomerResponse update(CustomerDataRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    CustomerResponse delete(CustomerDataRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     CustomerResponse view(CustomerDataRequest request);


    /**
     * 集合功能
     * @param request
     * @return
     */
    CustomerList list(CustomerSearchRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    CustomerPage search(CustomerSearchRequest request);

}