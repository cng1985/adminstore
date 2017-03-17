package com.tongna.adminstore.data.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import  com.tongna.adminstore.data.entity.Member;

public interface MemberDao extends CriteriaDao<Member,Long>{

	public Member findById(Long id);

	public Member save(Member bean);

	public Member updateByUpdater(Updater<Member> updater);

	public Member deleteById(Long id);
}