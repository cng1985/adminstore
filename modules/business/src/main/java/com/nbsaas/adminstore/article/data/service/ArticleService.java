package com.nbsaas.adminstore.article.data.service;

import com.nbsaas.adminstore.article.data.entity.Article;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2020年11月04日20:17:53.
*/
public interface ArticleService {

	Article findById(Long id);

	Article save(Article bean);

	Article update(Article bean);

	Article deleteById(Long id);
	
	Article[] deleteByIds(Long[] ids);
	
	Page<Article> page(Pageable pageable);
	
	Page<Article> page(Pageable pageable, Object search);


	List<Article> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}