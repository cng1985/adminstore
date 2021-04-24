package com.haoxuer.adminstore.common.rest.resource;

import com.haoxuer.adminstore.common.api.apis.StoreConfigApi;
import com.haoxuer.adminstore.common.api.domain.list.StoreConfigList;
import com.haoxuer.adminstore.common.api.domain.page.StoreConfigPage;
import com.haoxuer.adminstore.common.api.domain.request.*;
import com.haoxuer.adminstore.common.api.domain.response.StoreConfigResponse;
import com.haoxuer.adminstore.common.data.dao.StoreConfigDao;
import com.haoxuer.adminstore.common.data.entity.StoreConfig;
import com.haoxuer.adminstore.common.rest.convert.StoreConfigResponseConvert;
import com.haoxuer.adminstore.common.rest.convert.StoreConfigSimpleConvert;
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
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class StoreConfigResource implements StoreConfigApi {

    @Autowired
    private StoreConfigDao dataDao;


    @Override
    public StoreConfigResponse create(StoreConfigDataRequest request) {
        StoreConfigResponse result = new StoreConfigResponse();

        StoreConfig bean = new StoreConfig();
        handleData(request, bean);
        dataDao.save(bean);
        result = new StoreConfigResponseConvert().conver(bean);
        return result;
    }

    @Override
    public StoreConfigResponse update(StoreConfigDataRequest request) {
        StoreConfigResponse result = new StoreConfigResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        StoreConfig bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new StoreConfigResponseConvert().conver(bean);
        return result;
    }

    private void handleData(StoreConfigDataRequest request, StoreConfig bean) {
        BeanDataUtils.copyProperties(request,bean);

    }

    @Override
    public StoreConfigResponse delete(StoreConfigDataRequest request) {
        StoreConfigResponse result = new StoreConfigResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getId());
        return result;
    }

    @Override
    public StoreConfigResponse view(StoreConfigDataRequest request) {
        StoreConfigResponse result=new StoreConfigResponse();
        StoreConfig bean = dataDao.findById( request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new StoreConfigResponseConvert().conver(bean);
        return result;
    }
    @Override
    public StoreConfigList list(StoreConfigSearchRequest request) {
        StoreConfigList result = new StoreConfigList();

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
        List<StoreConfig> organizations = dataDao.list(0, request.getSize(), filters, orders);
        StoreConfigSimpleConvert convert=new StoreConfigSimpleConvert();
        ConverResourceUtils.converList(result, organizations,convert);
        return result;
    }

    @Override
    public StoreConfigPage search(StoreConfigSearchRequest request) {
        StoreConfigPage result=new StoreConfigPage();
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
        Page<StoreConfig> page=dataDao.page(pageable);
        StoreConfigSimpleConvert convert=new StoreConfigSimpleConvert();
        ConverResourceUtils.converPage(result,page,convert);
        return result;
    }
}
