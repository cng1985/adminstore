package com.haoxuer.adminstore.structure.rest.resource;

import com.haoxuer.adminstore.structure.api.apis.EmployeeApi;
import com.haoxuer.adminstore.structure.api.domain.list.EmployeeList;
import com.haoxuer.adminstore.structure.api.domain.page.EmployeePage;
import com.haoxuer.adminstore.structure.api.domain.request.*;
import com.haoxuer.adminstore.structure.api.domain.response.EmployeeResponse;
import com.haoxuer.adminstore.structure.data.dao.EmployeeDao;
import com.haoxuer.adminstore.structure.data.dao.OrganizationDao;
import com.haoxuer.adminstore.structure.data.entity.Employee;
import com.haoxuer.adminstore.structure.rest.convert.EmployeeResponseConver;
import com.haoxuer.adminstore.structure.rest.convert.EmployeeSimpleConver;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import com.haoxuer.discover.user.data.dao.UserInfoDao;
import com.haoxuer.discover.user.data.dao.UserRoleDao;
import com.haoxuer.discover.user.data.entity.UserRole;
import com.haoxuer.discover.user.data.enums.BindType;
import com.haoxuer.discover.user.data.enums.SecurityType;
import com.haoxuer.discover.user.data.request.ResetPasswordRequest;
import com.haoxuer.discover.user.data.request.UserRegisterRequest;
import com.haoxuer.discover.user.data.response.UserBasicResponse;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.haoxuer.discover.user.rest.conver.PageableConver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Transactional
@Component
public class EmployeeResource implements EmployeeApi {

    @Autowired
    private EmployeeDao dataDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private OrganizationDao organizationDao;

    @Autowired
    private UserRoleDao roleDao;

    @Override
    public EmployeeResponse create(EmployeeDataRequest request) {
        EmployeeResponse result = new EmployeeResponse();
        if (request.getNo() == null) {
            result.setCode(501);
            result.setMsg("账号不能为空");
            return result;
        }
        if (request.getPassword() == null) {
            result.setCode(502);
            result.setMsg("密码不能为空");
            return result;
        }
        UserRegisterRequest registerRequest = new UserRegisterRequest();
        registerRequest.setNo(request.getNo());
        registerRequest.setPassword(request.getPassword());
        registerRequest.setBindType(BindType.account);
        UserBasicResponse response = userInfoDao.register(registerRequest);
        if (response.getCode() != 0) {
            result.setCode(503);
            result.setMsg(response.getMsg());
            return result;
        }
        Employee bean = dataDao.findById(response.getId());
        bean.setNo(request.getNo());
        handleData(request, bean);
        result = new EmployeeResponseConver().conver(bean);

        return result;
    }

    @Override
    public EmployeeResponse update(EmployeeDataRequest request) {
        EmployeeResponse result = new EmployeeResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Employee bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        if (StringUtil.isNotBlank(request.getNewPassword())) {
            ResetPasswordRequest restRequest = new ResetPasswordRequest();
            restRequest.setId(bean.getId());
            restRequest.setSecurityType(SecurityType.account);
            restRequest.setPassword(request.getNewPassword());
            userInfoDao.resetPassword(restRequest);
        }
        handleData(request, bean);
        result = new EmployeeResponseConver().conver(bean);
        return result;
    }

    private void handleData(EmployeeDataRequest request, Employee bean) {
        bean.setJob(request.getJob());
        bean.setAvatar(request.getAvatar());
        bean.setEmail(request.getEmail());
        bean.setPhone(request.getPhone());
        bean.setName(request.getName());
        bean.setDataType(request.getDataType());
        if (request.getOrg() != null) {
            bean.setOrg(organizationDao.findById(request.getOrg()));
        }
        if (request.getSelectRoles() != null&&request.getSelectRoles().size()>0) {
            if (bean.getRoles() == null) {
                bean.setRoles(new HashSet<>());
            }
            bean.getRoles().clear();
            for (Long selectRole : request.getSelectRoles()) {
                UserRole role = roleDao.findById(selectRole);
                if (role != null) {
                    bean.getRoles().add(role);
                }
            }
        }
    }

    @Override
    public EmployeeResponse delete(EmployeeDataRequest request) {
        EmployeeResponse result = new EmployeeResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getId());
        return result;
    }

    @Override
    public EmployeeResponse view(EmployeeDataRequest request) {
        EmployeeResponse result = new EmployeeResponse();
        Employee bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result = new EmployeeResponseConver().conver(bean);
        return result;
    }

    @Override
    public EmployeeList list(EmployeeSearchRequest request) {
        EmployeeList result = new EmployeeList();

        List<Filter> filters = new ArrayList<>();
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        if ("ascending".equals(request.getSortMethod())) {
            orders.add(Order.asc("" + request.getSortField()));
        } else if ("descending".equals(request.getSortMethod())) {
            orders.add(Order.desc("" + request.getSortField()));
        } else {
            orders.add(Order.desc("id"));
        }
        List<Employee> organizations = dataDao.list(0, request.getSize(), filters, orders);
        ConverResourceUtils.converList(result, organizations, new EmployeeSimpleConver());
        return result;
    }

    @Override
    public EmployeePage search(EmployeeSearchRequest request) {
        EmployeePage result = new EmployeePage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        if ("ascending".equals(request.getSortMethod())) {
            pageable.getOrders().add(Order.asc("" + request.getSortField()));
        } else if ("descending".equals(request.getSortMethod())) {
            pageable.getOrders().add(Order.desc("" + request.getSortField()));
        } else {
            pageable.getOrders().add(Order.desc("id"));
        }
        Page<Employee> page = dataDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new EmployeeSimpleConver());
        return result;
    }
}
