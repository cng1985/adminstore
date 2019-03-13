package com.haoxuer.adminstore.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.adminstore.data.dao.FunctionDao;
import com.haoxuer.adminstore.data.entity.Function;
import com.haoxuer.adminstore.data.service.FunctionService;

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
* Created by imake on 2019年03月13日17:03:12.
*/


@Scope("prototype")
@Service
@Transactional
public class FunctionServiceImpl implements FunctionService {

	private FunctionDao dao;


	@Override
	@Transactional(readOnly = true)
	public Function findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Function save(Function bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Function update(Function bean) {
		Updater<Function> updater = new Updater<Function>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Function deleteById(Long id) {
		Function bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Function[] deleteByIds(Long[] ids) {
		Function[] beans = new Function[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(FunctionDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Function> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Function> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Function> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

	@Override
	public Function findByKey(String key) {
		return dao.one(Filter.eq("key",key));
	}
}