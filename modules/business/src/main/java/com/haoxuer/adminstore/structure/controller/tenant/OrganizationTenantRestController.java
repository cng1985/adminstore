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
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RequestMapping("/tenantRest/organization")
@RestController
public class OrganizationTenantRestController extends BaseTenantRestController {


	@RequiresPermissions("organization")
    @RequiresUser
    @RequestMapping("create")
    public OrganizationResponse create(OrganizationDataRequest request) {
        init(request);
        return api.create(request);
    }

	@RequiresPermissions("organization")
    @RequiresUser
    @RequestMapping("update")
    public OrganizationResponse update(OrganizationDataRequest request) {
        init(request);
        return api.update(request);
    }

	@RequiresPermissions("organization")
    @RequiresUser
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

	@RequiresPermissions("organization")
    @RequiresUser
    @RequestMapping("view")
    public OrganizationResponse view(OrganizationDataRequest request) {
       init(request);
       return api.view(request);
   }

	@RequiresPermissions("organization")
    @RequiresUser
    @RequestMapping("list")
    public OrganizationList list(OrganizationSearchRequest request) {
        init(request);
        return api.list(request);
    }

	@RequiresPermissions("organization")
    @RequiresUser
    @RequestMapping("search")
    public OrganizationPage search(OrganizationSearchRequest request) {
        init(request);
        return api.search(request);
    }

    @Autowired
    private OrganizationApi api;

}
