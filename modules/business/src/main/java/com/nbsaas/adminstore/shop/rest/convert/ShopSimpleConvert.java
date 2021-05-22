package com.nbsaas.adminstore.shop.rest.convert;

import com.nbsaas.adminstore.shop.api.domain.simple.ShopSimple;
import com.nbsaas.adminstore.shop.data.entity.Shop;
import com.haoxuer.discover.data.rest.core.Conver;
public class ShopSimpleConvert implements Conver<ShopSimple, Shop> {


    @Override
    public ShopSimple conver(Shop source) {
        ShopSimple result = new ShopSimple();

            result.setId(source.getId());
             result.setStoreState(source.getStoreState());
             result.setName(source.getName());
             result.setAddDate(source.getAddDate());

             result.setStoreStateName(source.getStoreState()+"");
        return result;
    }
}