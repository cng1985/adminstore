package com.haoxuer.adminstore.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.adminstore.data.entity.Function;

/**
* Created by imake on 2019年03月13日17:03:12.
*/
public interface FunctionDao extends BaseDao<Function,Long>{

	 Function findById(Long id);

	 Function save(Function bean);

	 Function updateByUpdater(Updater<Function> updater);

	 Function deleteById(Long id);
}