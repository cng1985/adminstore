package com.haoxuer.adminstore.member.controller.tenant;

import com.haoxuer.adminstore.member.api.apis.MemberApi;
import com.haoxuer.adminstore.member.api.domain.list.MemberList;
import com.haoxuer.adminstore.member.api.domain.page.MemberPage;
import com.haoxuer.adminstore.member.api.domain.request.*;
import com.haoxuer.adminstore.member.api.domain.response.MemberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.tenant.BaseTenantRestController;
import org.apache.shiro.authz.annotation.RequiresUser;

@RequestMapping("/tenantRest/member")
@RestController
public class MemberTenantRestController extends BaseTenantRestController {


    @RequiresUser
    @RequestMapping("create")
    public MemberResponse create(MemberDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequiresUser
    @RequestMapping("update")
    public MemberResponse update(MemberDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequiresUser
    @RequestMapping("delete")
    public MemberResponse delete(MemberDataRequest request) {
        init(request);
        return api.delete(request);
    }

    @RequiresUser
    @RequestMapping("view")
    public MemberResponse view(MemberDataRequest request) {
       init(request);
       return api.view(request);
   }

    @RequiresUser
    @RequestMapping("list")
    public MemberList list(MemberSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequiresUser
    @RequestMapping("search")
    public MemberPage search(MemberSearchRequest request) {
        init(request);
        return api.search(request);
    }

    @Autowired
    private MemberApi api;

}
