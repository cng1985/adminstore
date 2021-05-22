package com.nbsaas.adminstore.ad.data.dao.impl;

import com.nbsaas.adminstore.ad.data.entity.Ad;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.nbsaas.adminstore.ad.data.dao.AdDao;

/**
* Created by imake on 2020年11月06日23:28:28.
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