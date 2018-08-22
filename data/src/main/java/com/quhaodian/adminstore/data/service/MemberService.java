package com.quhaodian.adminstore.data.service;

import com.quhaodian.adminstore.data.entity.Member;
import com.quhaodian.adminstore.data.request.MemberUpdateRequest;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import com.quhaodian.discover.rest.base.ResponseObject;
import com.quhaodian.user.data.entity.UserAccount;
import com.quhaodian.user.data.vo.UserAccountVo;
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