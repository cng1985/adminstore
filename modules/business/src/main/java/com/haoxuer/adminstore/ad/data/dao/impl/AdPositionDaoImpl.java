package com.haoxuer.adminstore.ad.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.adminstore.ad.data.dao.AdPositionDao;
import com.haoxuer.adminstore.ad.data.entity.AdPosition;

/**
* Created by imake on 2020年11月06日23:22:43.
*/
@Repository

public class AdPositionDaoImpl extends CriteriaDaoImpl<AdPosition, Long> implements AdPositionDao {

	@Override
	public AdPosition findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public AdPosition save(AdPosition bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public AdPosition deleteById(Long id) {
		AdPosition entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<AdPosition> getEntityClass() {
		return AdPosition.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}