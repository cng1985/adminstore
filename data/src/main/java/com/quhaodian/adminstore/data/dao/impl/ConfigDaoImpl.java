package com.quhaodian.adminstore.data.dao.impl;

import com.haoxuer.discover.data.core.Finder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.quhaodian.adminstore.data.dao.ConfigDao;
import com.quhaodian.adminstore.data.entity.Config;

/**
 * Created by imake on 2018年12月10日13:32:48.
 */
@Repository

public class ConfigDaoImpl extends CriteriaDaoImpl<Config, Long> implements ConfigDao {

  @Override
  public Config config() {
    Finder finder = Finder.create();
    finder.append("from Config c");
    Config result = findOne(finder);
    if (result == null) {
      result = new Config();
      save(result);
    }
    return result;
  }

  @Override
  public Config findById(Long id) {
    if (id == null) {
      return null;
    }
    return get(id);
  }

  @Override
  public Config save(Config bean) {

    getSession().save(bean);


    return bean;
  }

  @Override
  public Config deleteById(Long id) {
    Config entity = super.get(id);
    if (entity != null) {
      getSession().delete(entity);
    }
    return entity;
  }

  @Override
  protected Class<Config> getEntityClass() {
    return Config.class;
  }

  @Autowired
  public void setSuperSessionFactory(SessionFactory sessionFactory) {
    super.setSessionFactory(sessionFactory);
  }
}