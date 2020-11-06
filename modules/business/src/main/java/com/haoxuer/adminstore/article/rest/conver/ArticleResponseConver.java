package com.haoxuer.adminstore.article.rest.conver;

import com.haoxuer.adminstore.article.api.domain.response.ArticleResponse;
import com.haoxuer.adminstore.article.data.entity.Article;
import com.haoxuer.discover.data.rest.core.Conver;
import com.haoxuer.discover.data.utils.BeanDataUtils;

public class ArticleResponseConver implements Conver<ArticleResponse, Article> {
    @Override
    public ArticleResponse conver(Article source) {
        ArticleResponse result = new ArticleResponse();
        BeanDataUtils.copyProperties(source,result);


         result.setStoreStateName(source.getStoreState()+"");

        return result;
    }
}
