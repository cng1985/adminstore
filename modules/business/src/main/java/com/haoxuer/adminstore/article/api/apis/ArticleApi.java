package com.haoxuer.adminstore.article.api.apis;


import com.haoxuer.adminstore.article.api.domain.list.ArticleList;
import com.haoxuer.adminstore.article.api.domain.page.ArticlePage;
import com.haoxuer.adminstore.article.api.domain.request.*;
import com.haoxuer.adminstore.article.api.domain.response.ArticleResponse;

public interface ArticleApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    ArticleResponse create(ArticleDataRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    ArticleResponse update(ArticleDataRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    ArticleResponse delete(ArticleDataRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     ArticleResponse view(ArticleDataRequest request);


    /**
     * 集合功能
     * @param request
     * @return
     */
    ArticleList list(ArticleSearchRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    ArticlePage search(ArticleSearchRequest request);

}