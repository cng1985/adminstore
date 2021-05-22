package com.nbsaas.adminstore.structure.controller.rest;

import com.nbsaas.adminstore.structure.api.apis.EmployeeApi;
import com.nbsaas.adminstore.structure.api.domain.list.EmployeeList;
import com.nbsaas.adminstore.structure.api.domain.page.EmployeePage;

import com.nbsaas.adminstore.structure.api.domain.response.EmployeeResponse;
import com.nbsaas.adminstore.structure.api.domain.request.EmployeeDataRequest;
import com.nbsaas.adminstore.structure.api.domain.request.EmployeeSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.rest.BaseRestController;

@RequestMapping("/rest/employee")
@RestController
public class EmployeeRestController extends BaseRestController {


    @RequestMapping("create")
    public EmployeeResponse create(EmployeeDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public EmployeeResponse update(EmployeeDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public EmployeeResponse delete(EmployeeDataRequest request) {
        init(request);
        return api.delete(request);
    }

    @RequestMapping("view")
    public EmployeeResponse view(EmployeeDataRequest request) {
        init(request);
        return api.view(request);
    }

    @RequestMapping("list")
    public EmployeeList list(EmployeeSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public EmployeePage search(EmployeeSearchRequest request) {
        init(request);
        return api.search(request);
    }



    @Autowired
    private EmployeeApi api;

}
