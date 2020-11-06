package com.haoxuer.adminstore.structure.controller.tenant;

import com.haoxuer.adminstore.structure.api.apis.OrganizationApi;
import com.haoxuer.adminstore.structure.api.domain.list.OrganizationList;
import com.haoxuer.adminstore.structure.api.domain.page.OrganizationPage;
import com.haoxuer.adminstore.structure.api.domain.request.*;
import com.haoxuer.adminstore.structure.api.domain.response.OrganizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.tenant.BaseTenantRestController;
import org.apache.shiro.authz.annotation.RequiresUser;

@RequestMapping("/tenantRest/organization")
@RestController
public class OrganizationTenantRestController extends BaseTenantRestController {


    @RequiresUser
    @RequestMapping("create")
    public OrganizationResponse create(OrganizationDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequiresUser
    @RequestMapping("update")
    public OrganizationResponse update(OrganizationDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequiresUser
    @RequestMapping("delete")
    public OrganizationResponse delete(OrganizationDataRequest request) {
        init(request);
        return api.delete(request);
    }

    @RequiresUser
    @RequestMapping("view")
    public OrganizationResponse view(OrganizationDataRequest request) {
       init(request);
       return api.view(request);
   }

    @RequiresUser
    @RequestMapping("list")
    public OrganizationList list(OrganizationSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequiresUser
    @RequestMapping("search")
    public OrganizationPage search(OrganizationSearchRequest request) {
        init(request);
        return api.search(request);
    }

    @Autowired
    private OrganizationApi api;

}
