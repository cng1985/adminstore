package com.nbsaas.adminstore.structure.rest.resource;

import com.haoxuer.discover.user.data.dao.UserBindDao;
import com.haoxuer.discover.user.data.dao.UserSecurityDao;
import com.haoxuer.discover.user.data.entity.UserBind;
import com.haoxuer.discover.user.data.entity.UserInfo;
import com.haoxuer.discover.user.data.entity.UserSecurity;
import com.haoxuer.discover.user.utils.SecurityUtil;
import com.nbsaas.adminstore.structure.api.apis.EmployeeApi;
import com.nbsaas.adminstore.structure.api.domain.list.EmployeeList;
import com.nbsaas.adminstore.structure.api.domain.page.EmployeePage;
import com.nbsaas.adminstore.structure.api.domain.response.EmployeeResponse;
import com.nbsaas.adminstore.structure.data.dao.EmployeeDao;
import com.nbsaas.adminstore.structure.data.dao.OrganizationDao;
import com.nbsaas.adminstore.structure.data.entity.Employee;
import com.nbsaas.adminstore.structure.rest.convert.EmployeeResponseConver;
import com.nbsaas.adminstore.structure.rest.convert.EmployeeSimpleConver;
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
import com.nbsaas.adminstore.structure.api.domain.request.EmployeeDataRequest;
import com.nbsaas.adminstore.structure.api.domain.request.EmployeeSearchRequest;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.haoxuer.discover.user.rest.conver.PageableConver;
import org.springframework.util.StringUtils;

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

    @Autowired
    private UserBindDao bindDao;

    @Autowired
    private UserSecurityDao securityDao;

    @Override
    public EmployeeResponse create(EmployeeDataRequest request) {
        EmployeeResponse result = new EmployeeResponse();
        Employee bean = new Employee();
        handleData(request, bean);
        dataDao.save(bean);

        if (StringUtils.hasText(request.getPhone())){
            UserBind temp = this.bindDao.findByType( request.getPhone(), BindType.phone);
            if (temp==null){
                temp= new UserBind();
                temp.setBindType(BindType.phone);
                temp.setNo(request.getPhone());
                temp.setUser(UserInfo.fromId(bean.getId()));
                temp.setLoginSize(0L);
                this.bindDao.save(temp);
            }
        }
        if (StringUtils.hasText(request.getPassword())){
            UserSecurity security = securityDao.findByUser(bean.getId(), SecurityType.account);
            if (security == null) {
                security=new UserSecurity();
                security.setUser(UserInfo.fromId(bean.getId()));
                security.setSecurityType(SecurityType.account);
                securityDao.save(security);
            }
            SecurityUtil securityUtil = new SecurityUtil();
            security.setPassword(securityUtil.entryptPassword(request.getPassword()));
            security.setSalt(securityUtil.getSalt());
        }

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
        bean.setDataScope(request.getDataScope());
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
