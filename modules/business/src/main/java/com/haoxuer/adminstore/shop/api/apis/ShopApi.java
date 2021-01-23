package com.haoxuer.adminstore.shop.api.apis;


import com.haoxuer.adminstore.shop.api.domain.list.ShopList;
import com.haoxuer.adminstore.shop.api.domain.page.ShopPage;
import com.haoxuer.adminstore.shop.api.domain.request.*;
import com.haoxuer.adminstore.shop.api.domain.response.ShopResponse;

public interface ShopApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    ShopResponse create(ShopDataRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    ShopResponse update(ShopDataRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    ShopResponse delete(ShopDataRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     ShopResponse view(ShopDataRequest request);


    /**
     * 集合功能
     * @param request
     * @return
     */
    ShopList list(ShopSearchRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    ShopPage search(ShopSearchRequest request);

}