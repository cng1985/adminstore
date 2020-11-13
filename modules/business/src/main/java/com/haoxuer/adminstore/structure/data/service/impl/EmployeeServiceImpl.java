package com.haoxuer.adminstore.structure.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.adminstore.structure.data.dao.EmployeeDao;
import com.haoxuer.adminstore.structure.data.entity.Employee;
import com.haoxuer.adminstore.structure.data.service.EmployeeService;

import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

import com.haoxuer.discover.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2020年07月27日09:16:50.
*/


@Scope("prototype")
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao dao;


	@Override
	@Transactional(readOnly = true)
	public Employee findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Employee save(Employee bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Employee update(Employee bean) {
		Updater<Employee> updater = new Updater<Employee>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Employee deleteById(Long id) {
		Employee bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Employee[] deleteByIds(Long[] ids) {
		Employee[] beans = new Employee[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Employee> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Employee> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Employee> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}