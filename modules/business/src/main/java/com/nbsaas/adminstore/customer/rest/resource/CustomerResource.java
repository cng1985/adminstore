package com.nbsaas.adminstore.customer.rest.resource;

import com.nbsaas.adminstore.customer.api.apis.CustomerApi;
import com.nbsaas.adminstore.customer.api.domain.list.CustomerList;
import com.nbsaas.adminstore.customer.api.domain.page.CustomerPage;
import com.nbsaas.adminstore.customer.api.domain.request.*;
import com.nbsaas.adminstore.customer.api.domain.response.CustomerResponse;
import com.nbsaas.adminstore.customer.data.dao.CustomerDao;
import com.nbsaas.adminstore.customer.data.entity.Customer;
import com.nbsaas.adminstore.customer.rest.convert.CustomerResponseConvert;
import com.nbsaas.adminstore.customer.rest.convert.CustomerSimpleConvert;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.haoxuer.discover.user.rest.conver.PageableConver;
import com.haoxuer.discover.data.utils.BeanDataUtils;
import com.haoxuer.discover.user.data.dao.UserInfoDao;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class CustomerResource implements CustomerApi {

    @Autowired
    private CustomerDao dataDao;

    @Autowired
    private UserInfoDao creatorDao;

    @Override
    public CustomerResponse create(CustomerDataRequest request) {
        CustomerResponse result = new CustomerResponse();

        Customer bean = new Customer();
        handleData(request, bean);
        dataDao.save(bean);
        result = new CustomerResponseConvert().conver(bean);
        return result;
    }

    @Override
    public CustomerResponse update(CustomerDataRequest request) {
        CustomerResponse result = new CustomerResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Customer bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new CustomerResponseConvert().conver(bean);
        return result;
    }

    private void handleData(CustomerDataRequest request, Customer bean) {
        BeanDataUtils.copyProperties(request,bean);
            if(request.getCreator()!=null){
               bean.setCreator(creatorDao.findById(request.getCreator()));
            }

    }

    @Override
    public CustomerResponse delete(CustomerDataRequest request) {
        CustomerResponse result = new CustomerResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getId());
        return result;
    }

    @Override
    public CustomerResponse view(CustomerDataRequest request) {
        CustomerResponse result=new CustomerResponse();
        Customer bean = dataDao.findById( request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new CustomerResponseConvert().conver(bean);
        return result;
    }
    @Override
    public CustomerList list(CustomerSearchRequest request) {
        CustomerList result = new CustomerList();

        List<Filter> filters = new ArrayList<>();
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        if ("asc".equals(request.getSortMethod())){
           orders.add(Order.asc(""+request.getSortField()));
        }
        else if ("desc".equals(request.getSortMethod())){
           orders.add(Order.desc(""+request.getSortField()));
        }else{
           orders.add(Order.desc("id"));
        }
        List<Customer> organizations = dataDao.list(0, request.getSize(), filters, orders);
        CustomerSimpleConvert convert=new CustomerSimpleConvert();
        ConverResourceUtils.converList(result, organizations,convert);
        return result;
    }

    @Override
    public CustomerPage search(CustomerSearchRequest request) {
        CustomerPage result=new CustomerPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        if ("asc".equals(request.getSortMethod())){
            pageable.getOrders().add(Order.asc(""+request.getSortField()));
        }
        else if ("desc".equals(request.getSortMethod())){
            pageable.getOrders().add(Order.desc(""+request.getSortField()));
        }else{
            pageable.getOrders().add(Order.desc("id"));
        }
        Page<Customer> page=dataDao.page(pageable);
        CustomerSimpleConvert convert=new CustomerSimpleConvert();
        ConverResourceUtils.converPage(result,page,convert);
        return result;
    }
}
