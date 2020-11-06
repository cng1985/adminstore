package com.haoxuer.adminstore.ad.data.service;

import com.haoxuer.adminstore.ad.data.entity.AdPosition;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年11月06日23:22:43.
*/
public interface AdPositionService {

	AdPosition findById(Long id);

	AdPosition save(AdPosition bean);

	AdPosition update(AdPosition bean);

	AdPosition deleteById(Long id);
	
	AdPosition[] deleteByIds(Long[] ids);
	
	Page<AdPosition> page(Pageable pageable);
	
	Page<AdPosition> page(Pageable pageable, Object search);


	List<AdPosition> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}