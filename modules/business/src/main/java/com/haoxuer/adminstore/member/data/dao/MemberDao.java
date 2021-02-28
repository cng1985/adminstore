package com.haoxuer.adminstore.member.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.adminstore.member.data.entity.Member;

/**
* Created by imake on 2021年02月28日16:04:56.
*/
public interface MemberDao extends BaseDao<Member,Long>{

	 Member findById(Long id);

	 Member save(Member bean);

	 Member updateByUpdater(Updater<Member> updater);

	 Member deleteById(Long id);
}