package com.nbsaas.adminstore.analysis.controller.tenant;

import com.nbsaas.adminstore.analysis.api.UserAnalysisApi;
import com.nbsaas.adminstore.analysis.list.LongList;
import com.nbsaas.adminstore.analysis.request.OrderNumRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tenantRest/user")
@RestController
public class UserAnalysisController  {

    @RequestMapping("num")
    public LongList num(OrderNumRequest request) {
        return api.num(request);
    }

    @RequestMapping("month")
    public LongList month(OrderNumRequest request) {
        return api.month(request);
    }

    @Autowired
    private UserAnalysisApi api;
}
