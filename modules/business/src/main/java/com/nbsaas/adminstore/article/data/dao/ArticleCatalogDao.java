package com.nbsaas.adminstore.article.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.nbsaas.adminstore.article.data.entity.ArticleCatalog;

/**
* Created by imake on 2020年11月04日20:16:48.
*/
public interface ArticleCatalogDao extends BaseDao<ArticleCatalog,Integer>{

	 ArticleCatalog findById(Integer id);

	 ArticleCatalog save(ArticleCatalog bean);

	 ArticleCatalog updateByUpdater(Updater<ArticleCatalog> updater);

	 ArticleCatalog deleteById(Integer id);
}