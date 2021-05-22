package com.nbsaas.adminstore.common.controller.tenant;

import com.nbsaas.adminstore.common.api.apis.StoreConfigApi;
import com.nbsaas.adminstore.common.api.domain.list.StoreConfigList;
import com.nbsaas.adminstore.common.api.domain.page.StoreConfigPage;

import com.nbsaas.adminstore.common.api.domain.response.StoreConfigResponse;
import com.nbsaas.adminstore.common.api.domain.request.StoreConfigDataRequest;
import com.nbsaas.adminstore.common.api.domain.request.StoreConfigSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.tenant.BaseTenantRestController;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RequestMapping("/tenantRest/storeconfig")
@RestController
public class StoreConfigTenantRestController extends BaseTenantRestController {


	@RequiresPermissions("storeconfig")
    @RequiresUser
    @RequestMapping("create")
    public StoreConfigResponse create(StoreConfigDataRequest request) {
        init(request);
        return api.create(request);
    }

	@RequiresPermissions("storeconfig")
    @RequiresUser
    @RequestMapping("update")
    public StoreConfigResponse update(StoreConfigDataRequest request) {
        init(request);
        return api.update(request);
    }

	@RequiresPermissions("storeconfig")
    @RequiresUser
    @RequestMapping("delete")
    public StoreConfigResponse delete(StoreConfigDataRequest request) {
        init(request);
        StoreConfigResponse result = new StoreConfigResponse();
        try {
           result = api.delete(request);
        } catch (Exception e) {
           result.setCode(501);
           result.setMsg("删除失败!");
        }
        return result;
    }

	@RequiresPermissions("storeconfig")
    @RequiresUser
    @RequestMapping("view")
    public StoreConfigResponse view(StoreConfigDataRequest request) {
       init(request);
       return api.view(request);
   }

	@RequiresPermissions("storeconfig")
    @RequiresUser
    @RequestMapping("list")
    public StoreConfigList list(StoreConfigSearchRequest request) {
        init(request);
        return api.list(request);
    }

	@RequiresPermissions("storeconfig")
    @RequiresUser
    @RequestMapping("search")
    public StoreConfigPage search(StoreConfigSearchRequest request) {
        init(request);
        return api.search(request);
    }

    @Autowired
    private StoreConfigApi api;

}
