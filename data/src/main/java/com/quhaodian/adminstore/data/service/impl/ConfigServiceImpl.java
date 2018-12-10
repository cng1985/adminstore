package com.quhaodian.adminstore.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.quhaodian.adminstore.data.dao.ConfigDao;
import com.quhaodian.adminstore.data.entity.Config;
import com.quhaodian.adminstore.data.service.ConfigService;

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
* Created by imake on 2018年12月10日13:32:48.
*/


@Scope("prototype")
@Service
@Transactional
public class ConfigServiceImpl implements ConfigService {

	private ConfigDao dao;


	@Override
	@Transactional(readOnly = true)
	public Config findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Config save(Config bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Config update(Config bean) {
		Updater<Config> updater = new Updater<Config>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Config deleteById(Long id) {
		Config bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Config[] deleteByIds(Long[] ids) {
		Config[] beans = new Config[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ConfigDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Config> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Config> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Config> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}