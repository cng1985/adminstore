package com.quhaodian.adminstore.data.dao;


import com.quhaodian.adminstore.data.entity.Member;
import com.haoxuer.discover.data.core.CriteriaDao;
import com.haoxuer.discover.data.core.Updater;

public interface MemberDao extends CriteriaDao<Member, Long> {
  
  public Member findById(Long id);
  
  public Member save(Member bean);
  
  public Member updateByUpdater(Updater<Member> updater);
  
  public Member deleteById(Long id);
}