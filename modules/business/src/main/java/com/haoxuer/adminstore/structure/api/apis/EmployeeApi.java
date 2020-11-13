package com.haoxuer.adminstore.structure.api.apis;


import com.haoxuer.adminstore.structure.api.domain.list.EmployeeList;
import com.haoxuer.adminstore.structure.api.domain.page.EmployeePage;
import com.haoxuer.adminstore.structure.api.domain.request.*;
import com.haoxuer.adminstore.structure.api.domain.response.EmployeeResponse;

public interface EmployeeApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    EmployeeResponse create(EmployeeDataRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    EmployeeResponse update(EmployeeDataRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    EmployeeResponse delete(EmployeeDataRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     EmployeeResponse view(EmployeeDataRequest request);


    /**
     * 集合功能
     * @param request
     * @return
     */
    EmployeeList list(EmployeeSearchRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    EmployeePage search(EmployeeSearchRequest request);

}