package com.haoxuer.adminstore.structure.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.adminstore.structure.data.entity.Employee;

/**
* Created by imake on 2020年07月27日09:16:50.
*/
public interface EmployeeDao extends BaseDao<Employee,Long>{

	 Employee findById(Long id);

	 Employee save(Employee bean);

	 Employee updateByUpdater(Updater<Employee> updater);

	 Employee deleteById(Long id);
}