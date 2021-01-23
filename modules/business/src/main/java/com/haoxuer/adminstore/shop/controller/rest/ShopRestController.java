package com.haoxuer.adminstore.shop.controller.rest;

import com.haoxuer.adminstore.shop.api.apis.ShopApi;
import com.haoxuer.adminstore.shop.api.domain.list.ShopList;
import com.haoxuer.adminstore.shop.api.domain.page.ShopPage;
import com.haoxuer.adminstore.shop.api.domain.request.*;
import com.haoxuer.adminstore.shop.api.domain.response.ShopResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.rest.BaseRestController;

@RequestMapping("/rest/shop")
@RestController
public class ShopRestController extends BaseRestController {


    @RequestMapping("create")
    public ShopResponse create(ShopDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public ShopResponse update(ShopDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public ShopResponse delete(ShopDataRequest request) {
        init(request);
        return api.delete(request);
    }

    @RequestMapping("view")
    public ShopResponse view(ShopDataRequest request) {
        init(request);
        return api.view(request);
    }

    @RequestMapping("list")
    public ShopList list(ShopSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public ShopPage search(ShopSearchRequest request) {
        init(request);
        return api.search(request);
    }



    @Autowired
    private ShopApi api;

}
