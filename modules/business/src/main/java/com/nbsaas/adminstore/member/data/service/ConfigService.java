package com.nbsaas.adminstore.member.data.service;

import com.nbsaas.adminstore.member.data.entity.Config;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;

import java.util.List;

/**
* Created by imake on 2018年12月10日13:32:48.
*/
public interface ConfigService {

	Config findById(Long id);

	Config save(Config bean);

	Config update(Config bean);

	Config deleteById(Long id);
	
	Config[] deleteByIds(Long[] ids);
	
	Page<Config> page(Pageable pageable);
	
	Page<Config> page(Pageable pageable, Object search);


	List<Config> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}