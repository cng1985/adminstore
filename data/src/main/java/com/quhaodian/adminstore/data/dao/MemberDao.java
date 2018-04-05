package com.quhaodian.adminstore.data.dao;


import com.quhaodian.adminstore.data.entity.Member;
import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;

public interface MemberDao extends CriteriaDao<Member,Long>{

	public Member findById(Long id);

	public Member save(Member bean);

	public Member updateByUpdater(Updater<Member> updater);

	public Member deleteById(Long id);
}