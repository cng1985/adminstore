package com.haoxuer.adminstore;

import com.haoxuer.discover.config.data.entity.Dictionary;
import com.haoxuer.imake.ChainMake;
import com.haoxuer.imake.template.hibernate.TemplateHibernateDir;
import com.haoxuer.imake.templates.adminlte.TemplateAdminLTE;
import com.haoxuer.adminstore.controller.admin.Controllers;
import com.haoxuer.adminstore.data.entity.Config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {

    System.out.println(Controllers.class.getResource("/").getPath());
    ChainMake make = new ChainMake(TemplateAdminLTE.class, TemplateHibernateDir.class);
    make.setAction(Controllers.class.getPackage().getName());
    File view = new File("E:\\mvnspace\\adminstore\\web\\src\\main\\webapp\\WEB-INF\\ftl\\admin");
    make.setView(view);

    List<Class<?>> cs = new ArrayList<Class<?>>();
    cs.add(Dictionary.class);

    make.setMenus("1,2,47");
    make.setDao(false);
    make.setService(false);
    make.setView(true);
    make.setAction(false);
    make.makes(cs);
  }


}
