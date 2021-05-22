package com.nbsaas.adminstore.ad.data.service;

import com.nbsaas.adminstore.ad.data.entity.Ad;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年11月06日23:28:28.
*/
public interface AdService {

	Ad findById(Long id);

	Ad save(Ad bean);

	Ad update(Ad bean);

	Ad deleteById(Long id);
	
	Ad[] deleteByIds(Long[] ids);
	
	Page<Ad> page(Pageable pageable);
	
	Page<Ad> page(Pageable pageable, Object search);


	List<Ad> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}