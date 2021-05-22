package com.nbsaas.adminstore.article.controller.tenant;

import com.nbsaas.adminstore.article.api.apis.ArticleApi;
import com.nbsaas.adminstore.article.api.domain.list.ArticleList;
import com.nbsaas.adminstore.article.api.domain.page.ArticlePage;

import com.nbsaas.adminstore.article.api.domain.request.ArticleDataRequest;
import com.nbsaas.adminstore.article.api.domain.request.ArticleSearchRequest;
import com.nbsaas.adminstore.article.api.domain.response.ArticleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.tenant.BaseTenantRestController;
import org.apache.shiro.authz.annotation.RequiresUser;

@RequestMapping("/tenantRest/article")
@RestController
public class ArticleTenantRestController extends BaseTenantRestController {


    @RequiresUser
    @RequestMapping("create")
    public ArticleResponse create(ArticleDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequiresUser
    @RequestMapping("update")
    public ArticleResponse update(ArticleDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequiresUser
    @RequestMapping("delete")
    public ArticleResponse delete(ArticleDataRequest request) {
        init(request);
        return api.delete(request);
    }

    @RequiresUser
    @RequestMapping("view")
    public ArticleResponse view(ArticleDataRequest request) {
       init(request);
       return api.view(request);
   }

    @RequiresUser
    @RequestMapping("list")
    public ArticleList list(ArticleSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequiresUser
    @RequestMapping("search")
    public ArticlePage search(ArticleSearchRequest request) {
        init(request);
        return api.search(request);
    }

    @Autowired
    private ArticleApi api;

}
