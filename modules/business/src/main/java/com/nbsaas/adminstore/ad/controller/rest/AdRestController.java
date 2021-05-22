package com.nbsaas.adminstore.ad.controller.rest;

import com.nbsaas.adminstore.ad.api.apis.AdApi;
import com.nbsaas.adminstore.ad.api.domain.list.AdList;
import com.nbsaas.adminstore.ad.api.domain.page.AdPage;
import com.nbsaas.adminstore.ad.api.domain.request.AdDataRequest;
import com.nbsaas.adminstore.ad.api.domain.request.AdSearchRequest;
import com.nbsaas.adminstore.ad.api.domain.response.AdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.rest.BaseRestController;

@RequestMapping("/rest/ad")
@RestController
public class AdRestController extends BaseRestController {


    @RequestMapping("create")
    public AdResponse create(AdDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public AdResponse update(AdDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public AdResponse delete(AdDataRequest request) {
        init(request);
        return api.delete(request);
    }

    @RequestMapping("view")
    public AdResponse view(AdDataRequest request) {
        init(request);
        return api.view(request);
    }

    @RequestMapping("list")
    public AdList list(AdSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public AdPage search(AdSearchRequest request) {
        init(request);
        return api.search(request);
    }



    @Autowired
    private AdApi api;

}
