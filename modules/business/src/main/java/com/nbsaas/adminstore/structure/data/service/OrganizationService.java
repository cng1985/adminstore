package com.nbsaas.adminstore.structure.data.service;

import com.nbsaas.adminstore.structure.data.entity.Organization;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;

import java.util.List;

/**
* Created by imake on 2020年07月27日08:50:47.
*/
public interface OrganizationService {

	Organization findById(Integer id);

	Organization save(Organization bean);

	Organization update(Organization bean);

	Organization deleteById(Integer id);
	
	Organization[] deleteByIds(Integer[] ids);
	
	Page<Organization> page(Pageable pageable);
	
	Page<Organization> page(Pageable pageable, Object search);

	List<Organization> findByTops(Integer pid);


    List<Organization> child(Integer id,Integer max);

	List<Organization> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}