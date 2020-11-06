package com.haoxuer.adminstore.structure.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.adminstore.structure.data.entity.Organization;

/**
* Created by imake on 2020年07月27日08:50:47.
*/
public interface OrganizationDao extends BaseDao<Organization,Integer>{

	 Organization findById(Integer id);

	 Organization save(Organization bean);

	 Organization updateByUpdater(Updater<Organization> updater);

	 Organization deleteById(Integer id);
}