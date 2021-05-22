package com.nbsaas.adminstore.oa.rest.resource;

import com.nbsaas.adminstore.oa.api.apis.WorkLoggerApi;
import com.nbsaas.adminstore.oa.api.domain.list.WorkLoggerList;
import com.nbsaas.adminstore.oa.api.domain.page.WorkLoggerPage;
import com.nbsaas.adminstore.oa.api.domain.response.WorkLoggerResponse;
import com.nbsaas.adminstore.oa.data.dao.WorkLoggerDao;
import com.nbsaas.adminstore.oa.data.entity.WorkLogger;
import com.nbsaas.adminstore.oa.rest.convert.WorkLoggerResponseConvert;
import com.nbsaas.adminstore.oa.rest.convert.WorkLoggerSimpleConvert;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import com.nbsaas.adminstore.oa.api.domain.request.WorkLoggerDataRequest;
import com.nbsaas.adminstore.oa.api.domain.request.WorkLoggerSearchRequest;
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
public class WorkLoggerResource implements WorkLoggerApi {

    @Autowired
    private WorkLoggerDao dataDao;

    @Autowired
    private UserInfoDao creatorDao;

    @Override
    public WorkLoggerResponse create(WorkLoggerDataRequest request) {
        WorkLoggerResponse result = new WorkLoggerResponse();

        WorkLogger bean = new WorkLogger();
        handleData(request, bean);
        dataDao.save(bean);
        result = new WorkLoggerResponseConvert().conver(bean);
        return result;
    }

    @Override
    public WorkLoggerResponse update(WorkLoggerDataRequest request) {
        WorkLoggerResponse result = new WorkLoggerResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        WorkLogger bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new WorkLoggerResponseConvert().conver(bean);
        return result;
    }

    private void handleData(WorkLoggerDataRequest request, WorkLogger bean) {
        BeanDataUtils.copyProperties(request,bean);
            if(request.getCreator()!=null){
               bean.setCreator(creatorDao.findById(request.getCreator()));
            }

    }

    @Override
    public WorkLoggerResponse delete(WorkLoggerDataRequest request) {
        WorkLoggerResponse result = new WorkLoggerResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getId());
        return result;
    }

    @Override
    public WorkLoggerResponse view(WorkLoggerDataRequest request) {
        WorkLoggerResponse result=new WorkLoggerResponse();
        WorkLogger bean = dataDao.findById( request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new WorkLoggerResponseConvert().conver(bean);
        return result;
    }
    @Override
    public WorkLoggerList list(WorkLoggerSearchRequest request) {
        WorkLoggerList result = new WorkLoggerList();

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
        List<WorkLogger> organizations = dataDao.list(0, request.getSize(), filters, orders);
        WorkLoggerSimpleConvert convert=new WorkLoggerSimpleConvert();
        ConverResourceUtils.converList(result, organizations,convert);
        return result;
    }

    @Override
    public WorkLoggerPage search(WorkLoggerSearchRequest request) {
        WorkLoggerPage result=new WorkLoggerPage();
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
        Page<WorkLogger> page=dataDao.page(pageable);
        WorkLoggerSimpleConvert convert=new WorkLoggerSimpleConvert();
        ConverResourceUtils.converPage(result,page,convert);
        return result;
    }
}
