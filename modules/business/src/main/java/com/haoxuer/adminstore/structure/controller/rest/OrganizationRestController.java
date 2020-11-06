package com.haoxuer.adminstore.structure.controller.rest;

import com.haoxuer.adminstore.structure.api.apis.OrganizationApi;
import com.haoxuer.adminstore.structure.api.domain.list.OrganizationList;
import com.haoxuer.adminstore.structure.api.domain.page.OrganizationPage;
import com.haoxuer.adminstore.structure.api.domain.request.*;
import com.haoxuer.adminstore.structure.api.domain.response.OrganizationResponse;
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
        return api.delete(request);
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
