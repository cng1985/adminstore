package com.haoxuer.adminstore.common.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.adminstore.common.data.entity.StoreConfig;

/**
* Created by imake on 2021年04月24日18:10:25.
*/
public interface StoreConfigDao extends BaseDao<StoreConfig,Long>{

	 StoreConfig findById(Long id);

	 StoreConfig save(StoreConfig bean);

	 StoreConfig updateByUpdater(Updater<StoreConfig> updater);

	 StoreConfig deleteById(Long id);
}