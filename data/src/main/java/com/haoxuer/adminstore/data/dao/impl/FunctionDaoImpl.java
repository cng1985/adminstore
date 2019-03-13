package com.haoxuer.adminstore.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.adminstore.data.dao.FunctionDao;
import com.haoxuer.adminstore.data.entity.Function;

/**
* Created by imake on 2019年03月13日17:03:12.
*/
@Repository

public class FunctionDaoImpl extends CriteriaDaoImpl<Function, Long> implements FunctionDao {

	@Override
	public Function findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Function save(Function bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Function deleteById(Long id) {
		Function entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Function> getEntityClass() {
		return Function.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}