package com.haoxuer.adminstore.ad.controller.tenant;

import com.haoxuer.adminstore.ad.api.apis.AdPositionApi;
import com.haoxuer.adminstore.ad.api.domain.list.AdPositionList;
import com.haoxuer.adminstore.ad.api.domain.page.AdPositionPage;
import com.haoxuer.adminstore.ad.api.domain.request.*;
import com.haoxuer.adminstore.ad.api.domain.response.AdPositionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.tenant.BaseTenantRestController;
import org.apache.shiro.authz.annotation.RequiresUser;

@RequestMapping("/tenantRest/adposition")
@RestController
public class AdPositionTenantRestController extends BaseTenantRestController {


    @RequiresUser
    @RequestMapping("create")
    public AdPositionResponse create(AdPositionDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequiresUser
    @RequestMapping("update")
    public AdPositionResponse update(AdPositionDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequiresUser
    @RequestMapping("delete")
    public AdPositionResponse delete(AdPositionDataRequest request) {
        init(request);
        return api.delete(request);
    }

    @RequiresUser
    @RequestMapping("view")
    public AdPositionResponse view(AdPositionDataRequest request) {
       init(request);
       return api.view(request);
   }

    @RequiresUser
    @RequestMapping("list")
    public AdPositionList list(AdPositionSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequiresUser
    @RequestMapping("search")
    public AdPositionPage search(AdPositionSearchRequest request) {
        init(request);
        return api.search(request);
    }

    @Autowired
    private AdPositionApi api;

}
