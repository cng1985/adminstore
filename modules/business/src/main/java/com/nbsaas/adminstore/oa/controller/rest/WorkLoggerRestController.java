package com.nbsaas.adminstore.oa.controller.rest;

import com.nbsaas.adminstore.oa.api.apis.WorkLoggerApi;
import com.nbsaas.adminstore.oa.api.domain.list.WorkLoggerList;
import com.nbsaas.adminstore.oa.api.domain.page.WorkLoggerPage;
import com.nbsaas.adminstore.oa.api.domain.response.WorkLoggerResponse;
import com.nbsaas.adminstore.oa.api.domain.request.WorkLoggerDataRequest;
import com.nbsaas.adminstore.oa.api.domain.request.WorkLoggerSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.rest.BaseRestController;

@RequestMapping("/rest/worklogger")
@RestController
public class WorkLoggerRestController extends BaseRestController {


    @RequestMapping("create")
    public WorkLoggerResponse create(WorkLoggerDataRequest request) {
        init(request);
        request.setCreator(request.getUser());
        return api.create(request);
    }

    @RequestMapping("update")
    public WorkLoggerResponse update(WorkLoggerDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public WorkLoggerResponse delete(WorkLoggerDataRequest request) {
        init(request);
        WorkLoggerResponse result = new WorkLoggerResponse();
        try {
           result = api.delete(request);
        } catch (Exception e) {
           result.setCode(501);
           result.setMsg("删除失败!");
        }
        return result;
    }

    @RequestMapping("view")
    public WorkLoggerResponse view(WorkLoggerDataRequest request) {
        init(request);
        return api.view(request);
    }

    @RequestMapping("list")
    public WorkLoggerList list(WorkLoggerSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public WorkLoggerPage search(WorkLoggerSearchRequest request) {
        init(request);
        return api.search(request);
    }



    @Autowired
    private WorkLoggerApi api;

}
