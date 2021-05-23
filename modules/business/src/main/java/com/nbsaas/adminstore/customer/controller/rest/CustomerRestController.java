package com.nbsaas.adminstore.customer.controller.rest;

import com.nbsaas.adminstore.customer.api.apis.CustomerApi;
import com.nbsaas.adminstore.customer.api.domain.list.CustomerList;
import com.nbsaas.adminstore.customer.api.domain.page.CustomerPage;
import com.nbsaas.adminstore.customer.api.domain.request.*;
import com.nbsaas.adminstore.customer.api.domain.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.rest.BaseRestController;

@RequestMapping("/rest/customer")
@RestController
public class CustomerRestController extends BaseRestController {


    @RequestMapping("create")
    public CustomerResponse create(CustomerDataRequest request) {
        init(request);
        request.setCreator(request.getUser());
        return api.create(request);
    }

    @RequestMapping("update")
    public CustomerResponse update(CustomerDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public CustomerResponse delete(CustomerDataRequest request) {
        init(request);
        CustomerResponse result = new CustomerResponse();
        try {
           result = api.delete(request);
        } catch (Exception e) {
           result.setCode(501);
           result.setMsg("删除失败!");
        }
        return result;
    }

    @RequestMapping("view")
    public CustomerResponse view(CustomerDataRequest request) {
        init(request);
        return api.view(request);
    }

    @RequestMapping("list")
    public CustomerList list(CustomerSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public CustomerPage search(CustomerSearchRequest request) {
        init(request);
        return api.search(request);
    }



    @Autowired
    private CustomerApi api;

}
