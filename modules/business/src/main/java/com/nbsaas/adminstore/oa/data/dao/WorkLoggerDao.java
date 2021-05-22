package com.nbsaas.adminstore.oa.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.nbsaas.adminstore.oa.data.entity.WorkLogger;

/**
* Created by imake on 2021年05月22日09:52:36.
*/
public interface WorkLoggerDao extends BaseDao<WorkLogger,Long>{

	 WorkLogger findById(Long id);

	 WorkLogger save(WorkLogger bean);

	 WorkLogger updateByUpdater(Updater<WorkLogger> updater);

	 WorkLogger deleteById(Long id);
}