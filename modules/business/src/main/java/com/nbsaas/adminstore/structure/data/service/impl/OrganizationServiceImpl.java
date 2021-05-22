package com.nbsaas.adminstore.structure.data.service.impl;

import com.nbsaas.adminstore.structure.data.dao.OrganizationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.nbsaas.adminstore.structure.data.entity.Organization;
import com.nbsaas.adminstore.structure.data.service.OrganizationService;

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
* Created by imake on 2020年07月27日08:50:47.
*/


@Scope("prototype")
@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

	private OrganizationDao dao;


	@Override
	@Transactional(readOnly = true)
	public Organization findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Organization> findByTops(Integer pid) {
		LinkedList<Organization> result = new LinkedList<Organization>();
		Organization catalog = dao.findById(pid);
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
    public List<Organization> child(Integer id,Integer max) {
        List<Order> orders=new ArrayList<Order>();
        orders.add(Order.asc("code"));
        List<Filter> list=new ArrayList<Filter>();
        list.add(Filter.eq("parent.id",id));
        return dao.list(0,max,list,orders);
	}

	@Override
    @Transactional
	public Organization save(Organization bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Organization update(Organization bean) {
		Updater<Organization> updater = new Updater<Organization>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Organization deleteById(Integer id) {
		Organization bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Organization[] deleteByIds(Integer[] ids) {
		Organization[] beans = new Organization[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(OrganizationDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Organization> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Organization> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Organization> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}