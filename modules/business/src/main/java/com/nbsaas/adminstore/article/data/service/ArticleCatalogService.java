package com.nbsaas.adminstore.article.data.service;

import com.nbsaas.adminstore.article.data.entity.ArticleCatalog;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年11月04日20:16:48.
*/
public interface ArticleCatalogService {

	ArticleCatalog findById(Integer id);

	ArticleCatalog save(ArticleCatalog bean);

	ArticleCatalog update(ArticleCatalog bean);

	ArticleCatalog deleteById(Integer id);
	
	ArticleCatalog[] deleteByIds(Integer[] ids);
	
	Page<ArticleCatalog> page(Pageable pageable);
	
	Page<ArticleCatalog> page(Pageable pageable, Object search);

	List<ArticleCatalog> findByTops(Integer pid);


    List<ArticleCatalog> child(Integer id,Integer max);

	List<ArticleCatalog> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}