package com.nbsaas.adminstore.article.controller.tenant;

import com.nbsaas.adminstore.article.api.apis.ArticleCatalogApi;
import com.nbsaas.adminstore.article.api.domain.list.ArticleCatalogList;
import com.nbsaas.adminstore.article.api.domain.page.ArticleCatalogPage;
import com.nbsaas.adminstore.article.api.domain.request.ArticleCatalogDataRequest;
import com.nbsaas.adminstore.article.api.domain.request.ArticleCatalogSearchRequest;
import com.nbsaas.adminstore.article.api.domain.response.ArticleCatalogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haoxuer.discover.user.controller.tenant.BaseTenantRestController;
import org.apache.shiro.authz.annotation.RequiresUser;

@RequestMapping("/tenantRest/articlecatalog")
@RestController
public class ArticleCatalogTenantRestController extends BaseTenantRestController {


    @RequiresUser
    @RequestMapping("create")
    public ArticleCatalogResponse create(ArticleCatalogDataRequest request) {
        init(request);
        return api.create(request);
    }

    @RequiresUser
    @RequestMapping("update")
    public ArticleCatalogResponse update(ArticleCatalogDataRequest request) {
        init(request);
        return api.update(request);
    }

    @RequiresUser
    @RequestMapping("delete")
    public ArticleCatalogResponse delete(ArticleCatalogDataRequest request) {
        init(request);
        return api.delete(request);
    }

    @RequiresUser
    @RequestMapping("view")
    public ArticleCatalogResponse view(ArticleCatalogDataRequest request) {
       init(request);
       return api.view(request);
   }

    @RequiresUser
    @RequestMapping("list")
    public ArticleCatalogList list(ArticleCatalogSearchRequest request) {
        init(request);
        return api.list(request);
    }

    @RequiresUser
    @RequestMapping("search")
    public ArticleCatalogPage search(ArticleCatalogSearchRequest request) {
        init(request);
        return api.search(request);
    }

    @Autowired
    private ArticleCatalogApi api;

}
