package com.haoxuer.adminstore.member.controller.tenant;

import com.haoxuer.adminstore.member.api.apis.MemberApi;
import com.haoxuer.adminstore.member.api.domain.list.MemberList;
import com.haoxuer.adminstore.member.api.domain.page.MemberPage;
import com.haoxuer.adminstore.member.api.domain.request.*;
import com.haoxuer.adminstore.member.api.domain.response.MemberResponse;
import com.haoxuer.discover.user.api.apis.UserInfoApi;
import com.haoxuer.discover.user.api.domain.page.UserInfoPage;
import com.haoxuer.discover.user.api.domain.request.UserChangePasswordRequest;
import com.haoxuer.discover.user.data.entity.UserInfo;
import com.haoxuer.discover.user.shiro.utils.UserUtil;
import com.haoxuer.discover.user.utils.UserUtils;
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

    @RequiresUser
    @RequestMapping("updateCurrent")
    public MemberResponse updateCurrent(MemberDataRequest request) {
        init(request);
        UserInfo user = UserUtil.getCurrentUser();
        if (user != null) {
            request.setId(user.getId());
        }
        return api.update(request);
    }

    @RequiresUser
    @RequestMapping("updatePassword")
    public UserInfoPage updatePassword(UserChangePasswordRequest request) {

        UserInfo user = UserUtil.getCurrentUser();
        if (user != null) {
            request.setId(user.getId());
        }
        return infoApi.changePassword(request);
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

    @RequiresUser
    @RequestMapping("viewCurrent")
    public MemberResponse viewCurrent(MemberDataRequest request) {
        init(request);
        UserInfo user = UserUtil.getCurrentUser();
        if (user != null) {
            request.setId(user.getId());
        }
        return api.view(request);
    }

    @RequiresPermissions("member")
    @RequiresUser
    @RequestMapping("list")
    public MemberList list(MemberSearchRequest request) {
        init(request);
        return api.list(request);
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

    @Autowired
    private UserInfoApi infoApi;

}
