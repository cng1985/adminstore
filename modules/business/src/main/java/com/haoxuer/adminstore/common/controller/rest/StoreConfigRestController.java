package com.haoxuer.adminstore.common.controller.rest;

import com.haoxuer.adminstore.common.api.apis.StoreConfigApi;
import com.haoxuer.adminstore.common.api.domain.list.StoreConfigList;
import com.haoxuer.adminstore.common.api.domain.page.StoreConfigPage;
import com.haoxuer.adminstore.common.api.domain.request.*;
import com.haoxuer.adminstore.common.api.domain.response.StoreConfigResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.rest.BaseRestController;

@RequestMapping("/rest/storeconfig")
@RestController
public class StoreConfigRestController extends BaseRestController {


    @RequestMapping("create")
    public StoreConfigResponse create(StoreConfigDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public StoreConfigResponse update(StoreConfigDataRequest request) {
        init(request);
        return api.update(request);
    }

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

    @RequestMapping("view")
    public StoreConfigResponse view(StoreConfigDataRequest request) {
        init(request);
        return api.view(request);
    }

    @RequestMapping("list")
    public StoreConfigList list(StoreConfigSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public StoreConfigPage search(StoreConfigSearchRequest request) {
        init(request);
        return api.search(request);
    }



    @Autowired
    private StoreConfigApi api;

}
