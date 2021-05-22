package com.nbsaas.adminstore.common.data.dao.impl;

import com.nbsaas.adminstore.common.data.dao.StoreConfigDao;
import com.nbsaas.adminstore.common.data.entity.StoreConfig;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;

/**
* Created by imake on 2021年04月24日18:10:25.
*/
@Repository

public class StoreConfigDaoImpl extends CriteriaDaoImpl<StoreConfig, Long> implements StoreConfigDao {

	@Override
	public StoreConfig findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public StoreConfig save(StoreConfig bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public StoreConfig deleteById(Long id) {
		StoreConfig entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<StoreConfig> getEntityClass() {
		return StoreConfig.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}