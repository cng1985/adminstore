package com.nbsaas.adminstore.article.controller.rest;

import com.nbsaas.adminstore.article.api.apis.ArticleApi;
import com.nbsaas.adminstore.article.api.domain.list.ArticleList;
import com.nbsaas.adminstore.article.api.domain.page.ArticlePage;

import com.nbsaas.adminstore.article.api.domain.request.ArticleDataRequest;
import com.nbsaas.adminstore.article.api.domain.request.ArticleSearchRequest;
import com.nbsaas.adminstore.article.api.domain.response.ArticleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.rest.BaseRestController;

@RequestMapping("/rest/article")
@RestController
public class ArticleRestController extends BaseRestController {


    @RequestMapping("create")
    public ArticleResponse create(ArticleDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public ArticleResponse update(ArticleDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public ArticleResponse delete(ArticleDataRequest request) {
        init(request);
        return api.delete(request);
    }

    @RequestMapping("view")
    public ArticleResponse view(ArticleDataRequest request) {
        init(request);
        return api.view(request);
    }

    @RequestMapping("list")
    public ArticleList list(ArticleSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public ArticlePage search(ArticleSearchRequest request) {
        init(request);
        return api.search(request);
    }



    @Autowired
    private ArticleApi api;

}
