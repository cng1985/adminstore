package com.nbsaas.adminstore.oa.data.dao.impl;

import com.nbsaas.adminstore.oa.data.dao.WorkLoggerDao;
import com.nbsaas.adminstore.oa.data.entity.WorkLogger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;

/**
* Created by imake on 2021年05月22日09:52:36.
*/
@Repository

public class WorkLoggerDaoImpl extends CriteriaDaoImpl<WorkLogger, Long> implements WorkLoggerDao {

	@Override
	public WorkLogger findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public WorkLogger save(WorkLogger bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public WorkLogger deleteById(Long id) {
		WorkLogger entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<WorkLogger> getEntityClass() {
		return WorkLogger.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}