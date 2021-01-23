package com.haoxuer.adminstore.shop.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.adminstore.shop.data.dao.ShopDao;
import com.haoxuer.adminstore.shop.data.entity.Shop;
import com.haoxuer.adminstore.shop.data.service.ShopService;

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
* Created by imake on 2021年01月23日16:17:59.
*/


@Scope("prototype")
@Service
@Transactional
public class ShopServiceImpl implements ShopService {

	private ShopDao dao;


	@Override
	@Transactional(readOnly = true)
	public Shop findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Shop save(Shop bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Shop update(Shop bean) {
		Updater<Shop> updater = new Updater<Shop>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Shop deleteById(Long id) {
		Shop bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Shop[] deleteByIds(Long[] ids) {
		Shop[] beans = new Shop[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ShopDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Shop> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Shop> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Shop> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}