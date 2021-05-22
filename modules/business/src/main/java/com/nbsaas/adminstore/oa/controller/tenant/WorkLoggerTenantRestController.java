package com.nbsaas.adminstore.oa.controller.tenant;

import com.nbsaas.adminstore.oa.api.apis.WorkLoggerApi;
import com.nbsaas.adminstore.oa.api.domain.list.WorkLoggerList;
import com.nbsaas.adminstore.oa.api.domain.page.WorkLoggerPage;
import com.nbsaas.adminstore.oa.api.domain.response.WorkLoggerResponse;
import com.nbsaas.adminstore.oa.api.domain.request.WorkLoggerDataRequest;
import com.nbsaas.adminstore.oa.api.domain.request.WorkLoggerSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.tenant.BaseTenantRestController;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.haoxuer.discover.user.handle.PermissionHandle;

@RequestMapping("/tenantRest/worklogger")
@RestController
public class WorkLoggerTenantRestController extends BaseTenantRestController {

    @Autowired
    private PermissionHandle permissionHandle;

	@RequiresPermissions("worklogger")
    @RequiresUser
    @RequestMapping("create")
    public WorkLoggerResponse create(WorkLoggerDataRequest request) {
        init(request);
        request.setCreator(request.getCreateUser());
        return api.create(request);
    }

	@RequiresPermissions("worklogger")
    @RequiresUser
    @RequestMapping("update")
    public WorkLoggerResponse update(WorkLoggerDataRequest request) {
        init(request);
        return api.update(request);
    }

	@RequiresPermissions("worklogger")
    @RequiresUser
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

	@RequiresPermissions("worklogger")
    @RequiresUser
    @RequestMapping("view")
    public WorkLoggerResponse view(WorkLoggerDataRequest request) {
       init(request);
       return api.view(request);
   }

	@RequiresPermissions("worklogger")
    @RequiresUser
    @RequestMapping("list")
    public WorkLoggerList list(WorkLoggerSearchRequest request) {
        init(request);
        permissionHandle.handle(request);
        return api.list(request);
    }

	@RequiresPermissions("worklogger")
    @RequiresUser
    @RequestMapping("search")
    public WorkLoggerPage search(WorkLoggerSearchRequest request) {
        init(request);
        permissionHandle.handle(request);
        return api.search(request);
    }

    @Autowired
    private WorkLoggerApi api;

}
