package com.quhaodian.adminstore.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.quhaodian.adminstore.data.dao.ExceptionLogDao;
import com.quhaodian.adminstore.data.entity.ExceptionLog;

/**
* Created by imake on 2018年09月25日16:37:36.
*/
@Repository

public class ExceptionLogDaoImpl extends CriteriaDaoImpl<ExceptionLog, Long> implements ExceptionLogDao {

	@Override
	public ExceptionLog findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public ExceptionLog save(ExceptionLog bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public ExceptionLog deleteById(Long id) {
		ExceptionLog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ExceptionLog> getEntityClass() {
		return ExceptionLog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}