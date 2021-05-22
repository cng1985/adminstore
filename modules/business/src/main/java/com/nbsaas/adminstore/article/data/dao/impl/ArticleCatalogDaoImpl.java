package com.nbsaas.adminstore.article.data.dao.impl;

import com.nbsaas.adminstore.article.data.dao.ArticleCatalogDao;
import com.nbsaas.adminstore.article.data.entity.ArticleCatalog;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CatalogDaoImpl;

/**
* Created by imake on 2020年11月04日20:16:48.
*/
@Repository

public class ArticleCatalogDaoImpl extends CatalogDaoImpl<ArticleCatalog, Integer> implements ArticleCatalogDao {

	@Override
	public ArticleCatalog findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public ArticleCatalog save(ArticleCatalog bean) {

		add(bean);
		
		
		return bean;
	}

    @Override
	public ArticleCatalog deleteById(Integer id) {
		ArticleCatalog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ArticleCatalog> getEntityClass() {
		return ArticleCatalog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}