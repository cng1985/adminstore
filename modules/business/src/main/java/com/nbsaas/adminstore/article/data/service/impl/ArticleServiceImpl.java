package com.nbsaas.adminstore.article.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.nbsaas.adminstore.article.data.dao.ArticleDao;
import com.nbsaas.adminstore.article.data.entity.Article;
import com.nbsaas.adminstore.article.data.service.ArticleService;

import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

import com.haoxuer.discover.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2020年11月04日20:17:53.
*/


@Scope("prototype")
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	private ArticleDao dao;


	@Override
	@Transactional(readOnly = true)
	public Article findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Article save(Article bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Article update(Article bean) {
		Updater<Article> updater = new Updater<Article>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Article deleteById(Long id) {
		Article bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Article[] deleteByIds(Long[] ids) {
		Article[] beans = new Article[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ArticleDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Article> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Article> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Article> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}