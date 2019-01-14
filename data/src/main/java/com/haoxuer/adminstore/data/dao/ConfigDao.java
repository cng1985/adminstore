package com.haoxuer.adminstore.data.dao;


import com.haoxuer.adminstore.data.entity.Config;
import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;

/**
* Created by imake on 2018年12月10日13:32:48.
*/
public interface ConfigDao extends BaseDao<Config,Long>{

	Config config();


	Config findById(Long id);

	 Config save(Config bean);

	 Config updateByUpdater(Updater<Config> updater);

	 Config deleteById(Long id);
}