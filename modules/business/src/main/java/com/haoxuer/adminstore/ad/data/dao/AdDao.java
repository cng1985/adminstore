package com.haoxuer.adminstore.ad.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.adminstore.ad.data.entity.Ad;

/**
* Created by imake on 2020年11月06日23:28:28.
*/
public interface AdDao extends BaseDao<Ad,Long>{

	 Ad findById(Long id);

	 Ad save(Ad bean);

	 Ad updateByUpdater(Updater<Ad> updater);

	 Ad deleteById(Long id);
}