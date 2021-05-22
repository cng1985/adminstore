package com.nbsaas.adminstore.member.data.dao;


import com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.discover.data.core.BaseDao;
import com.nbsaas.adminstore.member.data.entity.ExceptionLog;

/**
* Created by imake on 2018年09月25日16:37:36.
*/
public interface ExceptionLogDao extends BaseDao<ExceptionLog,Long>{

	 ExceptionLog findById(Long id);

	 ExceptionLog save(ExceptionLog bean);

	 ExceptionLog updateByUpdater(Updater<ExceptionLog> updater);

	 ExceptionLog deleteById(Long id);
}