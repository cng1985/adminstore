package com.nbsaas.adminstore.structure.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.nbsaas.adminstore.structure.data.dao.EmployeeDao;
import com.nbsaas.adminstore.structure.data.entity.Employee;

/**
* Created by imake on 2020年07月27日09:16:50.
*/
@Repository

public class EmployeeDaoImpl extends CriteriaDaoImpl<Employee, Long> implements EmployeeDao {

	@Override
	public Employee findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Employee save(Employee bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Employee deleteById(Long id) {
		Employee entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Employee> getEntityClass() {
		return Employee.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}