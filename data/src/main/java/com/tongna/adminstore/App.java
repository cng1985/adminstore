package com.tongna.adminstore;

import com.ada.area.entity.Area;
import com.ada.imake.ChainMake;
import com.ada.imake.template.hibernate.TemplateHibernateDir;
import com.ada.imake.templates.ace.TemplateAceDir;
import com.ada.imake.templates.adminlte.TemplateAdminLTE;
import com.ada.user.entity.UserAccount;
import com.tongna.adminstore.data.entity.Member;

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
        // TODO Auto-generated method stub
        //String fieldir = TemplateDir.class.getResource(".").toString();
        //System.out.println(fieldir);

        ChainMake make=	new ChainMake(TemplateAdminLTE.class,TemplateHibernateDir.class);
        make.setAction("com.tongna.adminstore.controller.admin");
        File view=new File("E:\\mvnspace\\adminstore\\web\\src\\main\\webapp\\WEB-INF\\ftl\\admin");
        make.setView(view);

        List<Class<?>> cs=new ArrayList<Class<?>>();
        cs.add(UserAccount.class);

        make.setDao(false);
        make.setService(false);
        make.setView(true);
        make.setAction(true);
        make.makes(cs);
        System.out.println("ok");

    }

    /**
     * @param make
     */
    private static void x(ChainMake make) {
        List<Class<?>> others=new ArrayList<Class<?>>();

        make.setDao(false);
        make.setService(false);
        //make.makes(others);
    }

}
