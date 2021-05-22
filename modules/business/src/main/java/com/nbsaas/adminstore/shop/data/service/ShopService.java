package com.nbsaas.adminstore.shop.data.service;

import com.nbsaas.adminstore.shop.data.entity.Shop;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2021年01月23日16:17:59.
*/
public interface ShopService {

	Shop findById(Long id);

	Shop save(Shop bean);

	Shop update(Shop bean);

	Shop deleteById(Long id);
	
	Shop[] deleteByIds(Long[] ids);
	
	Page<Shop> page(Pageable pageable);
	
	Page<Shop> page(Pageable pageable, Object search);


	List<Shop> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}