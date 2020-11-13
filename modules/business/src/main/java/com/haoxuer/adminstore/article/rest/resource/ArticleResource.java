package com.haoxuer.adminstore.article.rest.resource;

import com.haoxuer.adminstore.article.api.apis.ArticleApi;
import com.haoxuer.adminstore.article.api.domain.list.ArticleList;
import com.haoxuer.adminstore.article.api.domain.page.ArticlePage;
import com.haoxuer.adminstore.article.api.domain.request.*;
import com.haoxuer.adminstore.article.api.domain.response.ArticleResponse;
import com.haoxuer.adminstore.article.data.dao.ArticleDao;
import com.haoxuer.adminstore.article.data.entity.Article;
import com.haoxuer.adminstore.article.rest.conver.ArticleResponseConver;
import com.haoxuer.adminstore.article.rest.conver.ArticleSimpleConver;
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
public class ArticleResource implements ArticleApi {

    @Autowired
    private ArticleDao dataDao;


    @Override
    public ArticleResponse create(ArticleDataRequest request) {
        ArticleResponse result = new ArticleResponse();

        Article bean = new Article();
        handleData(request, bean);
        dataDao.save(bean);
        result = new ArticleResponseConver().conver(bean);
        return result;
    }

    @Override
    public ArticleResponse update(ArticleDataRequest request) {
        ArticleResponse result = new ArticleResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Article bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new ArticleResponseConver().conver(bean);
        return result;
    }

    private void handleData(ArticleDataRequest request, Article bean) {
        BeanDataUtils.copyProperties(request,bean);

    }

    @Override
    public ArticleResponse delete(ArticleDataRequest request) {
        ArticleResponse result = new ArticleResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getId());
        return result;
    }

    @Override
    public ArticleResponse view(ArticleDataRequest request) {
        ArticleResponse result=new ArticleResponse();
        Article bean = dataDao.findById( request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new ArticleResponseConver().conver(bean);
        return result;
    }
    @Override
    public ArticleList list(ArticleSearchRequest request) {
        ArticleList result = new ArticleList();

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
        List<Article> organizations = dataDao.list(0, request.getSize(), filters, orders);
        ConverResourceUtils.converList(result, organizations, new ArticleSimpleConver());
        return result;
    }

    @Override
    public ArticlePage search(ArticleSearchRequest request) {
        ArticlePage result=new ArticlePage();
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
        Page<Article> page=dataDao.page(pageable);
        ConverResourceUtils.converPage(result,page,new ArticleSimpleConver());
        return result;
    }
}
