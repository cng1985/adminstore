package com.nbsaas.adminstore.article.rest.conver;

import com.nbsaas.adminstore.article.api.domain.simple.ArticleCatalogSimple;
import com.nbsaas.adminstore.article.data.entity.ArticleCatalog;
import com.haoxuer.discover.data.rest.core.Conver;


public class ArticleCatalogSimpleConver implements Conver<ArticleCatalogSimple, ArticleCatalog> {
    @Override
    public ArticleCatalogSimple conver(ArticleCatalog source) {
        ArticleCatalogSimple result = new ArticleCatalogSimple();
        result.setId(source.getId());
         result.setCode(source.getCode());
         result.setLevelInfo(source.getLevelInfo());
         result.setSize(source.getSize());
         result.setSortNum(source.getSortNum());
         result.setIds(source.getIds());
         result.setLastDate(source.getLastDate());
         result.setName(source.getName());
         result.setAddDate(source.getAddDate());


        return result;
    }
}
