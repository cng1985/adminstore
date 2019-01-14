package com.haoxuer.adminstore.data.service.impl;

import com.haoxuer.adminstore.data.dao.MemberDao;
import com.haoxuer.adminstore.data.entity.Member;
import com.haoxuer.adminstore.data.request.MemberUpdateRequest;
import com.haoxuer.adminstore.data.service.MemberService;
import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import com.haoxuer.discover.rest.base.ResponseObject;
import com.haoxuer.discover.user.data.dao.UserAccountDao;
import com.haoxuer.discover.user.data.entity.UserAccount;
import com.haoxuer.discover.user.data.vo.UserAccountVo;

import java.util.List;
import jodd.util.StringUtil;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Scope("prototype")
@Service
@Transactional
public class MemberServiceImpl implements MemberService,InitializingBean,DisposableBean {
  
  private MemberDao dao;
  
  @Autowired
  private UserAccountDao accountDao;
  
  
  @Override
  @Transactional(readOnly = true)
  public Member findById(Long id) {
    return dao.findById(id);
  }
  
  
  @Override
  @Transactional
  public Member save(Member bean) {
    dao.save(bean);
    return bean;
  }
  
  @Override
  public ResponseObject update(MemberUpdateRequest request) {
    ResponseObject result = new ResponseObject();
    Member member = dao.findById(request.getId());
    if (member == null) {
      result.setMsg("该用户不存在!");
      result.setCode(-101);
      return result;
    }
    if (StringUtil.isNotEmpty(request.getAvatar())) {
      member.setAvatar(request.getAvatar());
    }
    if (StringUtil.isNotEmpty(request.getSex())) {
      member.setSex(request.getSex());
    }
    if (StringUtil.isNotEmpty(request.getName())) {
      member.setName(request.getName());
    }
    if (StringUtil.isNotEmpty(request.getPhone())) {
      member.setPhone(request.getPhone());
    }
    if (StringUtil.isNotEmpty(request.getJob())) {
      member.setJob(request.getJob());
    }
    if (StringUtil.isNotEmpty(request.getCompanyName())) {
      member.setCompanyName(request.getCompanyName());
    }
    if (StringUtil.isNotEmpty(request.getIntroduce())) {
      member.setIntroduce(request.getIntroduce());
    }
    if (StringUtil.isNotEmpty(request.getEmail())) {
      member.setEmail(request.getEmail());
    }
    return result;
  }
  
  @Override
  public UserAccountVo reg(UserAccount account, Member member) {
    Member temp = null;
    UserAccountVo vo = accountDao.reg(account);
    if (vo.getCode() == 0) {
      temp = dao.findById(vo.getUser());
      if (temp != null) {
        temp.setName(member.getName());
      }
    }
    return vo;
  }
  
  @Override
  @Transactional
  public Member update(Member bean) {
    Updater<Member> updater = new Updater<Member>(bean);
    updater.exclude("attributes");
    updater.exclude("roles");
    return dao.updateByUpdater(updater);
  }
  
  @Override
  @Transactional
  public Member deleteById(Long id) {
    Member bean = dao.findById(id);
    dao.deleteById(id);
    return bean;
  }
  
  @Override
  @Transactional
  public Member[] deleteByIds(Long[] ids) {
    Member[] beans = new Member[ids.length];
    for (int i = 0, len = ids.length; i < len; i++) {
      beans[i] = deleteById(ids[i]);
    }
    return beans;
  }
  
  
  @Autowired
  public void setDao(MemberDao dao) {
    this.dao = dao;
  }
  
  @Override
  @Transactional(readOnly = true)
  public Page<Member> findPage(Pageable pageable) {
    return dao.findPage(pageable);
  }
  
  @Override
  public Page<Member> page(Pageable pageable) {
    return dao.page(pageable);
  }
  
  @Override
  @Transactional(readOnly = true)
  public long count(Filter... filters) {
    return dao.count(filters);
  }
  
  @Override
  @Transactional(readOnly = true)
  public List<Member> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {
    return dao.findList(first, count, filters, orders);
  }
  
  @Override
  public Page<Member> page(Pageable pageable, Object search) {
    List<Filter> filters = FilterUtils.getFilters(search);
    if (filters != null) {
      pageable.getFilters().addAll(filters);
    }
    return dao.page(pageable);
  }
  
  
  @Override
  public void afterPropertiesSet() throws Exception {
  }
  @Override
  public void destroy() throws Exception {
  }
}