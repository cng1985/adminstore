package com.haoxuer.adminstore.article.rest.resource;

import com.haoxuer.adminstore.article.api.apis.ArticleCatalogApi;
import com.haoxuer.adminstore.article.api.domain.list.ArticleCatalogList;
import com.haoxuer.adminstore.article.api.domain.page.ArticleCatalogPage;
import com.haoxuer.adminstore.article.api.domain.request.*;
import com.haoxuer.adminstore.article.api.domain.response.ArticleCatalogResponse;
import com.haoxuer.adminstore.article.data.dao.ArticleCatalogDao;
import com.haoxuer.adminstore.article.data.entity.ArticleCatalog;
import com.haoxuer.adminstore.article.rest.conver.ArticleCatalogResponseConver;
import com.haoxuer.adminstore.article.rest.conver.ArticleCatalogSimpleConver;
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
public class ArticleCatalogResource implements ArticleCatalogApi {

    @Autowired
    private ArticleCatalogDao dataDao;


    @Override
    public ArticleCatalogResponse create(ArticleCatalogDataRequest request) {
        ArticleCatalogResponse result = new ArticleCatalogResponse();

        ArticleCatalog bean = new ArticleCatalog();
        handleData(request, bean);
        dataDao.save(bean);
        result = new ArticleCatalogResponseConver().conver(bean);
        return result;
    }

    @Override
    public ArticleCatalogResponse update(ArticleCatalogDataRequest request) {
        ArticleCatalogResponse result = new ArticleCatalogResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        ArticleCatalog bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new ArticleCatalogResponseConver().conver(bean);
        return result;
    }

    private void handleData(ArticleCatalogDataRequest request, ArticleCatalog bean) {
        BeanDataUtils.copyProperties(request,bean);

    }

    @Override
    public ArticleCatalogResponse delete(ArticleCatalogDataRequest request) {
        ArticleCatalogResponse result = new ArticleCatalogResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getId());
        return result;
    }

    @Override
    public ArticleCatalogResponse view(ArticleCatalogDataRequest request) {
        ArticleCatalogResponse result=new ArticleCatalogResponse();
        ArticleCatalog bean = dataDao.findById( request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new ArticleCatalogResponseConver().conver(bean);
        return result;
    }
    @Override
    public ArticleCatalogList list(ArticleCatalogSearchRequest request) {
        ArticleCatalogList result = new ArticleCatalogList();

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
        List<ArticleCatalog> organizations = dataDao.list(0, request.getSize(), filters, orders);
        ConverResourceUtils.converList(result, organizations, new ArticleCatalogSimpleConver());
        return result;
    }

    @Override
    public ArticleCatalogPage search(ArticleCatalogSearchRequest request) {
        ArticleCatalogPage result=new ArticleCatalogPage();
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
        Page<ArticleCatalog> page=dataDao.page(pageable);
        ConverResourceUtils.converPage(result,page,new ArticleCatalogSimpleConver());
        return result;
    }
}
