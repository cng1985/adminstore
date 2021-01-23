package com.haoxuer.adminstore.shop.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.adminstore.shop.data.entity.Shop;

/**
* Created by imake on 2021年01月23日16:17:59.
*/
public interface ShopDao extends BaseDao<Shop,Long>{

	 Shop findById(Long id);

	 Shop save(Shop bean);

	 Shop updateByUpdater(Updater<Shop> updater);

	 Shop deleteById(Long id);
}