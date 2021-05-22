package com.nbsaas.adminstore.structure.controller.rest;

import com.nbsaas.adminstore.structure.api.apis.OrganizationApi;
import com.nbsaas.adminstore.structure.api.domain.list.OrganizationList;
import com.nbsaas.adminstore.structure.api.domain.page.OrganizationPage;
import com.nbsaas.adminstore.structure.api.domain.response.OrganizationResponse;
import com.nbsaas.adminstore.structure.api.domain.request.OrganizationDataRequest;
import com.nbsaas.adminstore.structure.api.domain.request.OrganizationSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.rest.BaseRestController;

@RequestMapping("/rest/organization")
@RestController
public class OrganizationRestController extends BaseRestController {


    @RequestMapping("create")
    public OrganizationResponse create(OrganizationDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public OrganizationResponse update(OrganizationDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public OrganizationResponse delete(OrganizationDataRequest request) {
        init(request);
        OrganizationResponse result = new OrganizationResponse();
        try {
           result = api.delete(request);
        } catch (Exception e) {
           result.setCode(501);
           result.setMsg("删除失败!");
        }
        return result;
    }

    @RequestMapping("view")
    public OrganizationResponse view(OrganizationDataRequest request) {
        init(request);
        return api.view(request);
    }

    @RequestMapping("list")
    public OrganizationList list(OrganizationSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public OrganizationPage search(OrganizationSearchRequest request) {
        init(request);
        return api.search(request);
    }



    @Autowired
    private OrganizationApi api;

}
