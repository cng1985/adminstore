package com.haoxuer.adminstore.ad.controller.rest;

import com.haoxuer.adminstore.ad.api.apis.AdPositionApi;
import com.haoxuer.adminstore.ad.api.domain.list.AdPositionList;
import com.haoxuer.adminstore.ad.api.domain.page.AdPositionPage;
import com.haoxuer.adminstore.ad.api.domain.request.*;
import com.haoxuer.adminstore.ad.api.domain.response.AdPositionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.rest.BaseRestController;

@RequestMapping("/rest/adposition")
@RestController
public class AdPositionRestController extends BaseRestController {


    @RequestMapping("create")
    public AdPositionResponse create(AdPositionDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public AdPositionResponse update(AdPositionDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public AdPositionResponse delete(AdPositionDataRequest request) {
        init(request);
        return api.delete(request);
    }

    @RequestMapping("view")
    public AdPositionResponse view(AdPositionDataRequest request) {
        init(request);
        return api.view(request);
    }

    @RequestMapping("list")
    public AdPositionList list(AdPositionSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public AdPositionPage search(AdPositionSearchRequest request) {
        init(request);
        return api.search(request);
    }



    @Autowired
    private AdPositionApi api;

}
