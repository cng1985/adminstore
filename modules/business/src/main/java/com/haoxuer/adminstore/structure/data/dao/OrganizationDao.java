package com.haoxuer.adminstore.structure.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.haoxuer.adminstore.structure.data.entity.Organization;

/**
* Created by imake on 2021年04月12日20:37:02.
*/
public interface OrganizationDao extends BaseDao<Organization,Integer>{

	 Organization findById(Integer id);

	 Organization save(Organization bean);

	 Organization updateByUpdater(Updater<Organization> updater);

	 Organization deleteById(Integer id);
}