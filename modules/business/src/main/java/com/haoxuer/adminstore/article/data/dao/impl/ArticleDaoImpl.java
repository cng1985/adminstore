package com.haoxuer.adminstore.article.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.adminstore.article.data.dao.ArticleDao;
import com.haoxuer.adminstore.article.data.entity.Article;

/**
* Created by imake on 2020年11月04日20:17:53.
*/
@Repository

public class ArticleDaoImpl extends CriteriaDaoImpl<Article, Long> implements ArticleDao {

	@Override
	public Article findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Article save(Article bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Article deleteById(Long id) {
		Article entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Article> getEntityClass() {
		return Article.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}