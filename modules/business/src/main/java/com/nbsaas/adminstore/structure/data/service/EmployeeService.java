package com.nbsaas.adminstore.structure.data.service;

import com.nbsaas.adminstore.structure.data.entity.Employee;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;

import java.util.List;

/**
* Created by imake on 2020年07月27日09:16:50.
*/
public interface EmployeeService {

	Employee findById(Long id);

	Employee save(Employee bean);

	Employee update(Employee bean);

	Employee deleteById(Long id);
	
	Employee[] deleteByIds(Long[] ids);
	
	Page<Employee> page(Pageable pageable);
	
	Page<Employee> page(Pageable pageable, Object search);


	List<Employee> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}