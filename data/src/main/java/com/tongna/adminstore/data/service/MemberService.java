package com.tongna.adminstore.data.service;

import com.tongna.adminstore.data.entity.Member;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface MemberService {

	public Member findById(Long id);

	public Member save(Member bean);

	public Member update(Member bean);

	public Member deleteById(Long id);
	
	public Member[] deleteByIds(Long[] ids);
	
	public Page<Member> findPage(Pageable pageable);
	
	public Page<Member> page(Pageable pageable);
	
	public Page<Member> page(Pageable pageable, Object search);

	public long count(Filter... filters);


	public List<Member> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}