package com.quhaodian.adminstore.data.service;

import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.user.data.entity.UserAccount;
import com.haoxuer.discover.user.data.vo.UserAccountVo;
import com.quhaodian.adminstore.data.entity.Member;
import com.quhaodian.adminstore.data.request.MemberUpdateRequest;
import com.haoxuer.discover.rest.base.ResponseObject;
import java.util.List;


public interface MemberService {
  
  Member findById(Long id);
  
  Member save(Member bean);
  
  /**
   * 更新个人信息
   *
   * @param request
   * @return
   */
  ResponseObject update(MemberUpdateRequest request);
  
  
  UserAccountVo reg(UserAccount account, Member member);
  
  
  Member update(Member bean);
  
  Member deleteById(Long id);
  
  Member[] deleteByIds(Long[] ids);
  
  Page<Member> findPage(Pageable pageable);
  
  Page<Member> page(Pageable pageable);
  
  Page<Member> page(Pageable pageable, Object search);
  
  long count(Filter... filters);
  
  
  List<Member> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
  
}