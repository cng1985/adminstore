package com.haoxuer.adminstore.member.data.dao.impl;

import com.haoxuer.adminstore.member.data.dao.MemberDao;
import com.haoxuer.adminstore.member.data.entity.Member;
import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("prototype")
@Repository
public class MemberDaoImpl extends CriteriaDaoImpl<Member, Long> implements MemberDao {
  
  @Override
  public Member findById(Long id) {
    if (id == null) {
      return null;
    }
    return get(id);
  }
  
  @Override
  public Member save(Member bean) {
    getSession().save(bean);
    
    
    return bean;
  }
  
  @Override
  public Member deleteById(Long id) {
    Member entity = super.get(id);
    if (entity != null) {
      getSession().delete(entity);
    }
    return entity;
  }
  
  @Override
  protected Class<Member> getEntityClass() {
    return Member.class;
  }
  
  @Autowired
  public void setSuperSessionFactory(SessionFactory sessionFactory) {
    super.setSessionFactory(sessionFactory);
  }
}