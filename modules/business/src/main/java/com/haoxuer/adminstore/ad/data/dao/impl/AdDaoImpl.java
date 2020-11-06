package com.haoxuer.adminstore.ad.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.adminstore.ad.data.dao.AdDao;
import com.haoxuer.adminstore.ad.data.entity.Ad;

/**
* Created by imake on 2020年11月06日23:14:57.
*/
@Repository

public class AdDaoImpl extends CriteriaDaoImpl<Ad, Long> implements AdDao {

	@Override
	public Ad findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Ad save(Ad bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Ad deleteById(Long id) {
		Ad entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Ad> getEntityClass() {
		return Ad.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}