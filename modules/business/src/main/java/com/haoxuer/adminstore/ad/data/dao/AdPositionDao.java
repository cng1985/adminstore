package com.haoxuer.adminstore.ad.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.adminstore.ad.data.entity.AdPosition;

/**
* Created by imake on 2020年11月06日23:22:43.
*/
public interface AdPositionDao extends BaseDao<AdPosition,Long>{

	 AdPosition findById(Long id);

	 AdPosition save(AdPosition bean);

	 AdPosition updateByUpdater(Updater<AdPosition> updater);

	 AdPosition deleteById(Long id);
}