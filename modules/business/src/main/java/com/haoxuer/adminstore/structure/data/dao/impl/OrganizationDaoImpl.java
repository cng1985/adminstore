package com.haoxuer.adminstore.structure.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.adminstore.structure.data.dao.OrganizationDao;
import com.haoxuer.adminstore.structure.data.entity.Organization;
import com.haoxuer.discover.data.core.CatalogDaoImpl;

/**
* Created by imake on 2021年04月12日20:37:02.
*/
@Repository

public class OrganizationDaoImpl extends CatalogDaoImpl<Organization, Integer> implements OrganizationDao {

	@Override
	public Organization findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Organization save(Organization bean) {

		add(bean);
		
		
		return bean;
	}

    @Override
	public Organization deleteById(Integer id) {
		Organization entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Organization> getEntityClass() {
		return Organization.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}