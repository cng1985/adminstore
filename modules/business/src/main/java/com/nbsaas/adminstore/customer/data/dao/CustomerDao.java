package com.nbsaas.adminstore.customer.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import  com.nbsaas.adminstore.customer.data.entity.Customer;

/**
* Created by imake on 2021年05月23日15:15:46.
*/
public interface CustomerDao extends BaseDao<Customer,Long>{

	 Customer findById(Long id);

	 Customer save(Customer bean);

	 Customer updateByUpdater(Updater<Customer> updater);

	 Customer deleteById(Long id);
}