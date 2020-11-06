package com.haoxuer.adminstore.ad.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.adminstore.ad.data.dao.AdPositionDao;
import com.haoxuer.adminstore.ad.data.entity.AdPosition;
import com.haoxuer.adminstore.ad.data.service.AdPositionService;

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
* Created by imake on 2020年11月06日23:22:43.
*/


@Scope("prototype")
@Service
@Transactional
public class AdPositionServiceImpl implements AdPositionService {

	private AdPositionDao dao;


	@Override
	@Transactional(readOnly = true)
	public AdPosition findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public AdPosition save(AdPosition bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public AdPosition update(AdPosition bean) {
		Updater<AdPosition> updater = new Updater<AdPosition>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public AdPosition deleteById(Long id) {
		AdPosition bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public AdPosition[] deleteByIds(Long[] ids) {
		AdPosition[] beans = new AdPosition[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(AdPositionDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<AdPosition> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<AdPosition> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<AdPosition> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}