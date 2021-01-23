package com.haoxuer.adminstore.shop.rest.convert;

import com.haoxuer.adminstore.shop.api.domain.response.ShopResponse;
import com.haoxuer.adminstore.shop.data.entity.Shop;
import com.haoxuer.discover.data.rest.core.Conver;
import com.haoxuer.discover.data.utils.BeanDataUtils;

public class ShopResponseConvert implements Conver<ShopResponse, Shop> {
    @Override
    public ShopResponse conver(Shop source) {
        ShopResponse result = new ShopResponse();
        BeanDataUtils.copyProperties(source,result);


         result.setStoreStateName(source.getStoreState()+"");

        return result;
    }
}
