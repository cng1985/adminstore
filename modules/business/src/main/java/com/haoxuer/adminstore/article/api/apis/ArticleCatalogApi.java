package com.haoxuer.adminstore.article.api.apis;


import com.haoxuer.adminstore.article.api.domain.list.ArticleCatalogList;
import com.haoxuer.adminstore.article.api.domain.page.ArticleCatalogPage;
import com.haoxuer.adminstore.article.api.domain.request.*;
import com.haoxuer.adminstore.article.api.domain.response.ArticleCatalogResponse;

public interface ArticleCatalogApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    ArticleCatalogResponse create(ArticleCatalogDataRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    ArticleCatalogResponse update(ArticleCatalogDataRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    ArticleCatalogResponse delete(ArticleCatalogDataRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     ArticleCatalogResponse view(ArticleCatalogDataRequest request);


    /**
     * 集合功能
     * @param request
     * @return
     */
    ArticleCatalogList list(ArticleCatalogSearchRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    ArticleCatalogPage search(ArticleCatalogSearchRequest request);

}