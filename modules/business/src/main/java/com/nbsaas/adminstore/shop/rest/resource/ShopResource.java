package com.nbsaas.adminstore.shop.rest.resource;

import com.nbsaas.adminstore.shop.api.apis.ShopApi;
import com.nbsaas.adminstore.shop.api.domain.list.ShopList;
import com.nbsaas.adminstore.shop.api.domain.page.ShopPage;
import com.nbsaas.adminstore.shop.api.domain.request.ShopDataRequest;
import com.nbsaas.adminstore.shop.api.domain.request.ShopSearchRequest;
import com.nbsaas.adminstore.shop.api.domain.response.ShopResponse;
import com.nbsaas.adminstore.shop.data.dao.ShopDao;
import com.nbsaas.adminstore.shop.data.entity.Shop;
import com.nbsaas.adminstore.shop.rest.convert.ShopResponseConvert;
import com.nbsaas.adminstore.shop.rest.convert.ShopSimpleConvert;
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
public class ShopResource implements ShopApi {

    @Autowired
    private ShopDao dataDao;


    @Override
    public ShopResponse create(ShopDataRequest request) {
        ShopResponse result = new ShopResponse();

        Shop bean = new Shop();
        handleData(request, bean);
        dataDao.save(bean);
        result = new ShopResponseConvert().conver(bean);
        return result;
    }

    @Override
    public ShopResponse update(ShopDataRequest request) {
        ShopResponse result = new ShopResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Shop bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new ShopResponseConvert().conver(bean);
        return result;
    }

    private void handleData(ShopDataRequest request, Shop bean) {
        BeanDataUtils.copyProperties(request,bean);

    }

    @Override
    public ShopResponse delete(ShopDataRequest request) {
        ShopResponse result = new ShopResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getId());
        return result;
    }

    @Override
    public ShopResponse view(ShopDataRequest request) {
        ShopResponse result=new ShopResponse();
        Shop bean = dataDao.findById( request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new ShopResponseConvert().conver(bean);
        return result;
    }
    @Override
    public ShopList list(ShopSearchRequest request) {
        ShopList result = new ShopList();

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
        List<Shop> organizations = dataDao.list(0, request.getSize(), filters, orders);
        ShopSimpleConvert convert=new ShopSimpleConvert();
        ConverResourceUtils.converList(result, organizations,convert);
        return result;
    }

    @Override
    public ShopPage search(ShopSearchRequest request) {
        ShopPage result=new ShopPage();
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
        Page<Shop> page=dataDao.page(pageable);
        ShopSimpleConvert convert=new ShopSimpleConvert();
        ConverResourceUtils.converPage(result,page,convert);
        return result;
    }
}
