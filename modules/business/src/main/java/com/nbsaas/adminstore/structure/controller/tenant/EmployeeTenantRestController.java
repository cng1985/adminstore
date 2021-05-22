package com.nbsaas.adminstore.structure.controller.tenant;

import com.nbsaas.adminstore.structure.api.apis.EmployeeApi;
import com.nbsaas.adminstore.structure.api.domain.list.EmployeeList;
import com.nbsaas.adminstore.structure.api.domain.page.EmployeePage;

import com.nbsaas.adminstore.structure.api.domain.response.EmployeeResponse;
import com.nbsaas.adminstore.structure.api.domain.request.EmployeeDataRequest;
import com.nbsaas.adminstore.structure.api.domain.request.EmployeeSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.tenant.BaseTenantRestController;
import org.apache.shiro.authz.annotation.RequiresUser;

@RequestMapping("/tenantRest/employee")
@RestController
public class EmployeeTenantRestController extends BaseTenantRestController {


    @RequiresUser
    @RequestMapping("create")
    public EmployeeResponse create(EmployeeDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequiresUser
    @RequestMapping("update")
    public EmployeeResponse update(@RequestBody EmployeeDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequiresUser
    @RequestMapping("delete")
    public EmployeeResponse delete(EmployeeDataRequest request) {
        init(request);
        return api.delete(request);
    }

    @RequiresUser
    @RequestMapping("view")
    public EmployeeResponse view(EmployeeDataRequest request) {
        init(request);
        return api.view(request);
    }

    @RequiresUser
    @RequestMapping("list")
    public EmployeeList list(EmployeeSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequiresUser
    @RequestMapping("search")
    public EmployeePage search(EmployeeSearchRequest request) {
        init(request);
        return api.search(request);
    }

    @Autowired
    private EmployeeApi api;

}
