package com.haoxuer.adminstore.article.controller.rest;

import com.haoxuer.adminstore.article.api.apis.ArticleCatalogApi;
import com.haoxuer.adminstore.article.api.domain.list.ArticleCatalogList;
import com.haoxuer.adminstore.article.api.domain.page.ArticleCatalogPage;
import com.haoxuer.adminstore.article.api.domain.request.*;
import com.haoxuer.adminstore.article.api.domain.response.ArticleCatalogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.rest.BaseRestController;

@RequestMapping("/rest/articlecatalog")
@RestController
public class ArticleCatalogRestController extends BaseRestController {


    @RequestMapping("create")
    public ArticleCatalogResponse create(ArticleCatalogDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequestMapping("update")
    public ArticleCatalogResponse update(ArticleCatalogDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequestMapping("delete")
    public ArticleCatalogResponse delete(ArticleCatalogDataRequest request) {
        init(request);
        return api.delete(request);
    }

    @RequestMapping("view")
    public ArticleCatalogResponse view(ArticleCatalogDataRequest request) {
        init(request);
        return api.view(request);
    }

    @RequestMapping("list")
    public ArticleCatalogList list(ArticleCatalogSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequestMapping("search")
    public ArticleCatalogPage search(ArticleCatalogSearchRequest request) {
        init(request);
        return api.search(request);
    }



    @Autowired
    private ArticleCatalogApi api;

}
