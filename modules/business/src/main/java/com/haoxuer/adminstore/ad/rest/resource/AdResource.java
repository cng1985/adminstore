package com.haoxuer.adminstore.ad.rest.resource;

import com.haoxuer.adminstore.ad.api.apis.AdApi;
import com.haoxuer.adminstore.ad.api.domain.list.AdList;
import com.haoxuer.adminstore.ad.api.domain.page.AdPage;
import com.haoxuer.adminstore.ad.api.domain.request.*;
import com.haoxuer.adminstore.ad.api.domain.response.AdResponse;
import com.haoxuer.adminstore.ad.data.dao.AdDao;
import com.haoxuer.adminstore.ad.data.entity.Ad;
import com.haoxuer.adminstore.ad.rest.conver.AdResponseConver;
import com.haoxuer.adminstore.ad.rest.conver.AdSimpleConver;
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
import com.haoxuer.adminstore.ad.data.dao.AdPositionDao;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class AdResource implements AdApi {

    @Autowired
    private AdDao dataDao;

    @Autowired
    private AdPositionDao adPositionDao;

    @Override
    public AdResponse create(AdDataRequest request) {
        AdResponse result = new AdResponse();

        Ad bean = new Ad();
        handleData(request, bean);
        dataDao.save(bean);
        result = new AdResponseConver().conver(bean);
        return result;
    }

    @Override
    public AdResponse update(AdDataRequest request) {
        AdResponse result = new AdResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Ad bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new AdResponseConver().conver(bean);
        return result;
    }

    private void handleData(AdDataRequest request, Ad bean) {
        BeanDataUtils.copyProperties(request,bean);
            if(request.getAdPosition()!=null){
               bean.setAdPosition(adPositionDao.findById(request.getAdPosition()));
            }

    }

    @Override
    public AdResponse delete(AdDataRequest request) {
        AdResponse result = new AdResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getId());
        return result;
    }

    @Override
    public AdResponse view(AdDataRequest request) {
        AdResponse result=new AdResponse();
        Ad bean = dataDao.findById( request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new AdResponseConver().conver(bean);
        return result;
    }
    @Override
    public AdList list(AdSearchRequest request) {
        AdList result = new AdList();

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
        List<Ad> organizations = dataDao.list(0, request.getSize(), filters, orders);
        ConverResourceUtils.converList(result, organizations, new AdSimpleConver());
        return result;
    }

    @Override
    public AdPage search(AdSearchRequest request) {
        AdPage result=new AdPage();
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
        Page<Ad> page=dataDao.page(pageable);
        ConverResourceUtils.converPage(result,page,new AdSimpleConver());
        return result;
    }
}
