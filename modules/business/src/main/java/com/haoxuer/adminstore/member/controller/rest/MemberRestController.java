package com.haoxuer.adminstore.member.controller.rest;

import com.haoxuer.adminstore.member.api.apis.MemberApi;
import com.haoxuer.adminstore.member.api.domain.list.MemberList;
import com.haoxuer.adminstore.member.api.domain.page.MemberPage;
import com.haoxuer.adminstore.member.api.domain.request.*;
import com.haoxuer.adminstore.member.api.domain.response.MemberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.rest.BaseRestController;

@RequestMapping("/rest/member")
@RestController
public class MemberRestController extends BaseRestController {


    @RequestMapping("create")
    public MemberResponse create(MemberDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public MemberResponse update(MemberDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public MemberResponse delete(MemberDataRequest request) {
        init(request);
        MemberResponse result = new MemberResponse();
        try {
           result = api.delete(request);
        } catch (Exception e) {
           result.setCode(501);
           result.setMsg("删除失败!");
        }
        return result;
    }

    @RequestMapping("view")
    public MemberResponse view(MemberDataRequest request) {
        init(request);
        return api.view(request);
    }

    @RequestMapping("list")
    public MemberList list(MemberSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public MemberPage search(MemberSearchRequest request) {
        init(request);
        return api.search(request);
    }



    @Autowired
    private MemberApi api;

}
