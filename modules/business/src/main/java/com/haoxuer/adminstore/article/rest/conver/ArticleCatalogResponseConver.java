package com.haoxuer.adminstore.article.rest.conver;

import com.haoxuer.adminstore.article.api.domain.response.ArticleCatalogResponse;
import com.haoxuer.adminstore.article.data.entity.ArticleCatalog;
import com.haoxuer.discover.data.rest.core.Conver;
import com.haoxuer.discover.data.utils.BeanDataUtils;

public class ArticleCatalogResponseConver implements Conver<ArticleCatalogResponse, ArticleCatalog> {
    @Override
    public ArticleCatalogResponse conver(ArticleCatalog source) {
        ArticleCatalogResponse result = new ArticleCatalogResponse();
        BeanDataUtils.copyProperties(source,result);



        return result;
    }
}
