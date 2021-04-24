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
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RequestMapping("/tenantRest/member")
@RestController
public class MemberTenantRestController extends BaseTenantRestController {


	@RequiresPermissions("member")
    @RequiresUser
    @RequestMapping("create")
    public MemberResponse create(MemberDataRequest request) {
        init(request);
        return api.create(request);
    }

	@RequiresPermissions("member")
    @RequiresUser
    @RequestMapping("update")
    public MemberResponse update(MemberDataRequest request) {
        init(request);
        return api.update(request);
    }

	@RequiresPermissions("member")
    @RequiresUser
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

	@RequiresPermissions("member")
    @RequiresUser
    @RequestMapping("view")
    public MemberResponse view(MemberDataRequest request) {
       init(request);
       return api.view(request);
   }

	@RequiresPermissions("member")
    @RequiresUser
    @RequestMapping("list")
    public MemberList list(MemberSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequestMapping("current")
    public MemberResponse current(MemberDataRequest request) {
        init(request);
        request.setId(request.getCreateUser());
        return api.view(request);
    }
    @RequiresPermissions("member")
    @RequiresUser
    @RequestMapping("model_update_basic")
    public MemberResponse model_update_basic(MemberDataRequest request) {
        init(request);
        request.setId(request.getCreateUser());
        return api.update(request);
    }


	@RequiresPermissions("member")
    @RequiresUser
    @RequestMapping("search")
    public MemberPage search(MemberSearchRequest request) {
        init(request);
        return api.search(request);
    }

    @Autowired
    private MemberApi api;

}
