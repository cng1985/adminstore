package com.haoxuer.adminstore.structure.rest.resource;

import com.haoxuer.adminstore.structure.api.apis.OrganizationApi;
import com.haoxuer.adminstore.structure.api.domain.list.OrganizationList;
import com.haoxuer.adminstore.structure.api.domain.page.OrganizationPage;
import com.haoxuer.adminstore.structure.api.domain.request.OrganizationDataRequest;
import com.haoxuer.adminstore.structure.api.domain.request.OrganizationSearchRequest;
import com.haoxuer.adminstore.structure.api.domain.response.OrganizationResponse;
import com.haoxuer.adminstore.structure.data.dao.OrganizationDao;
import com.haoxuer.adminstore.structure.data.entity.Organization;
import com.haoxuer.adminstore.structure.rest.conver.OrganizationResponseConver;
import com.haoxuer.adminstore.structure.rest.conver.OrganizationSimpleAllConver;
import com.haoxuer.adminstore.structure.rest.conver.OrganizationSimpleConver;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import com.haoxuer.discover.user.rest.conver.PageableConver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class OrganizationResource implements OrganizationApi {

    @Autowired
    private OrganizationDao dataDao;

    @Override
    public OrganizationResponse create(OrganizationDataRequest request) {
        OrganizationResponse result = new OrganizationResponse();

        Organization bean = new Organization();
        handleData(request, bean);
        if (request.getParent() != null) {
            bean.setParent(dataDao.findById(request.getParent()));
        }
        dataDao.save(bean);
        result = new OrganizationResponseConver().conver(bean);
        return result;
    }

    @Override
    public OrganizationResponse update(OrganizationDataRequest request) {
        OrganizationResponse result = new OrganizationResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Organization bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new OrganizationResponseConver().conver(bean);
        return result;
    }

    private void handleData(OrganizationDataRequest request, Organization bean) {
        bean.setSortNum(request.getSortNum());
        bean.setName(request.getName());
    }

    @Override
    public OrganizationResponse delete(OrganizationDataRequest request) {
        OrganizationResponse result = new OrganizationResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getId());
        return result;
    }

    @Override
    public OrganizationResponse view(OrganizationDataRequest request) {
        OrganizationResponse result = new OrganizationResponse();
        Organization bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result = new OrganizationResponseConver().conver(bean);
        return result;
    }

    @Override
    public OrganizationList list(OrganizationSearchRequest request) {
        OrganizationList result = new OrganizationList();
        request.setLevel(1);
        List<Filter> filters = new ArrayList<>();
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        if ("ascending".equals(request.getSortMethod())) {
            orders.add(Order.asc("" + request.getSortField()));
        } else if ("descending".equals(request.getSortMethod())) {
            orders.add(Order.desc("" + request.getSortField()));
        } else {
            orders.add(Order.desc("sortNum"));
        }
        List<Organization> organizations = dataDao.list(0, request.getSize(), filters, orders);
        ConverResourceUtils.converList(result, organizations, new OrganizationSimpleAllConver());
        return result;
    }

    @Override
    public OrganizationPage search(OrganizationSearchRequest request) {
        OrganizationPage result = new OrganizationPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        if ("ascending".equals(request.getSortMethod())) {
            pageable.getOrders().add(Order.asc("" + request.getSortField()));
        } else if ("descending".equals(request.getSortMethod())) {
            pageable.getOrders().add(Order.desc("" + request.getSortField()));
        } else {
            pageable.getOrders().add(Order.desc("id"));
        }
        Page<Organization> page = dataDao.page(pageable);
        ConverResourceUtils.converPage(result, page, new OrganizationSimpleConver());
        return result;
    }
}
