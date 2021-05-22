package com.nbsaas.adminstore.member.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.nbsaas.adminstore.member.data.entity.Member;

/**
* Created by imake on 2021年05月22日10:14:20.
*/
public interface MemberDao extends BaseDao<Member,Long>{

	 Member findById(Long id);

	 Member save(Member bean);

	 Member updateByUpdater(Updater<Member> updater);

	 Member deleteById(Long id);
}