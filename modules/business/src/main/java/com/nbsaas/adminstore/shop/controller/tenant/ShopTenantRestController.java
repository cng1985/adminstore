package com.nbsaas.adminstore.shop.controller.tenant;

import com.nbsaas.adminstore.shop.api.apis.ShopApi;
import com.nbsaas.adminstore.shop.api.domain.list.ShopList;
import com.nbsaas.adminstore.shop.api.domain.page.ShopPage;

import com.nbsaas.adminstore.shop.api.domain.request.ShopDataRequest;
import com.nbsaas.adminstore.shop.api.domain.request.ShopSearchRequest;
import com.nbsaas.adminstore.shop.api.domain.response.ShopResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.tenant.BaseTenantRestController;
import org.apache.shiro.authz.annotation.RequiresUser;

@RequestMapping("/tenantRest/shop")
@RestController
public class ShopTenantRestController extends BaseTenantRestController {


    @RequiresUser
    @RequestMapping("create")
    public ShopResponse create(ShopDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequiresUser
    @RequestMapping("update")
    public ShopResponse update(ShopDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequiresUser
    @RequestMapping("delete")
    public ShopResponse delete(ShopDataRequest request) {
        init(request);
        return api.delete(request);
    }

    @RequiresUser
    @RequestMapping("view")
    public ShopResponse view(ShopDataRequest request) {
       init(request);
       return api.view(request);
   }

    @RequiresUser
    @RequestMapping("list")
    public ShopList list(ShopSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequiresUser
    @RequestMapping("search")
    public ShopPage search(ShopSearchRequest request) {
        init(request);
        return api.search(request);
    }

    @Autowired
    private ShopApi api;

}
