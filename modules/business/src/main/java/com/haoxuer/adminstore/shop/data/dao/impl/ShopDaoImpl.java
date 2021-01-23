package com.haoxuer.adminstore.shop.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.adminstore.shop.data.dao.ShopDao;
import com.haoxuer.adminstore.shop.data.entity.Shop;
import com.haoxuer.discover.data.enums.StoreState;

/**
* Created by imake on 2021年01月23日16:17:59.
*/
@Repository

public class ShopDaoImpl extends CriteriaDaoImpl<Shop, Long> implements ShopDao {

	@Override
	public Shop findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Shop save(Shop bean) {

		bean.setStoreState(StoreState.normal);

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Shop deleteById(Long id) {
		Shop entity = super.get(id);
		if (entity != null) {
			entity.setStoreState(StoreState.recycle);
		}
		return entity;
	}
	
	@Override
	protected Class<Shop> getEntityClass() {
		return Shop.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}