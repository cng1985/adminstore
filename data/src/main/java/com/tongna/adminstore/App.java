package com.tongna.adminstore;

import com.quhaodian.imake.ChainMake;
import com.quhaodian.imake.template.hibernate.TemplateHibernateDir;
import com.quhaodian.imake.templates.adminlte.TemplateAdminLTE;
import com.quhaodian.notice.data.entity.UserNotification;
import com.quhaodian.notice.data.entity.UserNotificationCatalog;
import com.quhaodian.notice.data.entity.UserNotificationMember;
import com.quhaodian.quartz.data.entity.CronTaskRecord;
import com.quhaodian.user.data.entity.UserAccount;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        ChainMake make=	new ChainMake(TemplateAdminLTE.class,TemplateHibernateDir.class);
        make.setAction("com.tongna.adminstore.controller.admin");
        File view=new File("E:\\mvnspace\\adminstore\\web\\src\\main\\webapp\\WEB-INF\\ftl\\admin");
        make.setView(view);

        List<Class<?>> cs=new ArrayList<Class<?>>();
        cs.add(UserNotificationMember.class);

        make.setMenus("1,28,29");
        make.setDao(false);
        make.setService(false);
        make.setView(true);
        make.setAction(false);
        make.makes(cs);
    }


}
