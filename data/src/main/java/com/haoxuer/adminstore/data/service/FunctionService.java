package com.haoxuer.adminstore.data.service;

import com.haoxuer.adminstore.data.entity.Function;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2019年03月13日17:03:12.
*/
public interface FunctionService {

	Function findById(Long id);

	Function save(Function bean);

	Function update(Function bean);

	Function deleteById(Long id);
	
	Function[] deleteByIds(Long[] ids);
	
	Page<Function> page(Pageable pageable);
	
	Page<Function> page(Pageable pageable, Object search);


	List<Function> list(int first, Integer size, List<Filter> filters, List<Order> orders);

  Function findByKey(String key);
}