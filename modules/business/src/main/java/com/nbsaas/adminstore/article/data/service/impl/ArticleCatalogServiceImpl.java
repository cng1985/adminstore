package com.nbsaas.adminstore.article.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.nbsaas.adminstore.article.data.dao.ArticleCatalogDao;
import com.nbsaas.adminstore.article.data.entity.ArticleCatalog;
import com.nbsaas.adminstore.article.data.service.ArticleCatalogService;

import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import com.haoxuer.discover.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2020年11月04日20:16:48.
*/


@Scope("prototype")
@Service
@Transactional
public class ArticleCatalogServiceImpl implements ArticleCatalogService {

	private ArticleCatalogDao dao;


	@Override
	@Transactional(readOnly = true)
	public ArticleCatalog findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<ArticleCatalog> findByTops(Integer pid) {
		LinkedList<ArticleCatalog> result = new LinkedList<ArticleCatalog>();
		ArticleCatalog catalog = dao.findById(pid);
	    if(catalog != null){
			while ( catalog != null && catalog.getParent() != null ) {
				result.addFirst(catalog);
				catalog = dao.findById(catalog.getParentId());
			}
			result.addFirst(catalog);
	    }
		return result;
	}


    @Override
    public List<ArticleCatalog> child(Integer id,Integer max) {
        List<Order> orders=new ArrayList<Order>();
        orders.add(Order.asc("code"));
        List<Filter> list=new ArrayList<Filter>();
        list.add(Filter.eq("parent.id",id));
        return dao.list(0,max,list,orders);
	}

	@Override
    @Transactional
	public ArticleCatalog save(ArticleCatalog bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public ArticleCatalog update(ArticleCatalog bean) {
		Updater<ArticleCatalog> updater = new Updater<ArticleCatalog>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public ArticleCatalog deleteById(Integer id) {
		ArticleCatalog bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public ArticleCatalog[] deleteByIds(Integer[] ids) {
		ArticleCatalog[] beans = new ArticleCatalog[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ArticleCatalogDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<ArticleCatalog> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<ArticleCatalog> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<ArticleCatalog> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}