package com.quhaodian.adminstore;

import com.quhaodian.adminstore.controller.admin.Controllers;
import com.quhaodian.imake.ChainMake;
import com.quhaodian.imake.template.hibernate.TemplateHibernateDir;
import com.quhaodian.imake.templates.adminlte.TemplateAdminLTE;
import com.quhaodian.notice.data.entity.UserNotificationMember;
import com.quhaodian.user.data.entity.UserRoleCatalog;

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
    File view = new File("D:\\mvnspace\\adminstore\\web\\src\\main\\webapp\\WEB-INF\\ftl\\admin");
    make.setView(view);

    List<Class<?>> cs = new ArrayList<Class<?>>();
    cs.add(UserRoleCatalog.class);

    make.setMenus("1,2,8");
    make.setDao(false);
    make.setService(false);
    make.setView(true);
    make.setAction(false);
    make.makes(cs);
  }


}
