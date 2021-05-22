package com.nbsaas.adminstore.ad.rest.resource;

import com.nbsaas.adminstore.ad.api.apis.AdPositionApi;
import com.nbsaas.adminstore.ad.api.domain.list.AdPositionList;
import com.nbsaas.adminstore.ad.api.domain.page.AdPositionPage;

import com.nbsaas.adminstore.ad.api.domain.request.AdPositionDataRequest;
import com.nbsaas.adminstore.ad.api.domain.request.AdPositionSearchRequest;
import com.nbsaas.adminstore.ad.api.domain.response.AdPositionResponse;
import com.nbsaas.adminstore.ad.data.dao.AdPositionDao;
import com.nbsaas.adminstore.ad.data.entity.AdPosition;
import com.nbsaas.adminstore.ad.rest.conver.AdPositionResponseConver;
import com.nbsaas.adminstore.ad.rest.conver.AdPositionSimpleConver;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.haoxuer.discover.user.rest.conver.PageableConver;
import com.haoxuer.discover.data.utils.BeanDataUtils;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class AdPositionResource implements AdPositionApi {

    @Autowired
    private AdPositionDao dataDao;


    @Override
    public AdPositionResponse create(AdPositionDataRequest request) {
        AdPositionResponse result = new AdPositionResponse();

        AdPosition bean = new AdPosition();
        handleData(request, bean);
        dataDao.save(bean);
        result = new AdPositionResponseConver().conver(bean);
        return result;
    }

    @Override
    public AdPositionResponse update(AdPositionDataRequest request) {
        AdPositionResponse result = new AdPositionResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        AdPosition bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new AdPositionResponseConver().conver(bean);
        return result;
    }

    private void handleData(AdPositionDataRequest request, AdPosition bean) {
        BeanDataUtils.copyProperties(request,bean);

    }

    @Override
    public AdPositionResponse delete(AdPositionDataRequest request) {
        AdPositionResponse result = new AdPositionResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getId());
        return result;
    }

    @Override
    public AdPositionResponse view(AdPositionDataRequest request) {
        AdPositionResponse result=new AdPositionResponse();
        AdPosition bean = dataDao.findById( request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new AdPositionResponseConver().conver(bean);
        return result;
    }
    @Override
    public AdPositionList list(AdPositionSearchRequest request) {
        AdPositionList result = new AdPositionList();

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
        List<AdPosition> organizations = dataDao.list(0, request.getSize(), filters, orders);
        ConverResourceUtils.converList(result, organizations, new AdPositionSimpleConver());
        return result;
    }

    @Override
    public AdPositionPage search(AdPositionSearchRequest request) {
        AdPositionPage result=new AdPositionPage();
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
        Page<AdPosition> page=dataDao.page(pageable);
        ConverResourceUtils.converPage(result,page,new AdPositionSimpleConver());
        return result;
    }
}
