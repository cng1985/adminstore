package com.nbsaas.adminstore.article.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.nbsaas.adminstore.article.data.entity.Article;

/**
* Created by imake on 2020年11月04日20:17:53.
*/
public interface ArticleDao extends BaseDao<Article,Long>{

	 Article findById(Long id);

	 Article save(Article bean);

	 Article updateByUpdater(Updater<Article> updater);

	 Article deleteById(Long id);
}