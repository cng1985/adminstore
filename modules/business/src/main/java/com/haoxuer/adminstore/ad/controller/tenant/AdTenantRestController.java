package com.haoxuer.adminstore.ad.controller.tenant;

import com.haoxuer.adminstore.ad.api.apis.AdApi;
import com.haoxuer.adminstore.ad.api.domain.list.AdList;
import com.haoxuer.adminstore.ad.api.domain.page.AdPage;
import com.haoxuer.adminstore.ad.api.domain.request.*;
import com.haoxuer.adminstore.ad.api.domain.response.AdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.tenant.BaseTenantRestController;
import org.apache.shiro.authz.annotation.RequiresUser;

@RequestMapping("/tenantRest/ad")
@RestController
public class AdTenantRestController extends BaseTenantRestController {


    @RequiresUser
    @RequestMapping("create")
    public AdResponse create(AdDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequiresUser
    @RequestMapping("update")
    public AdResponse update(AdDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequiresUser
    @RequestMapping("delete")
    public AdResponse delete(AdDataRequest request) {
        init(request);
        return api.delete(request);
    }

    @RequiresUser
    @RequestMapping("view")
    public AdResponse view(AdDataRequest request) {
       init(request);
       return api.view(request);
   }

    @RequiresUser
    @RequestMapping("list")
    public AdList list(AdSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequiresUser
    @RequestMapping("search")
    public AdPage search(AdSearchRequest request) {
        init(request);
        return api.search(request);
    }

    @Autowired
    private AdApi api;

}
