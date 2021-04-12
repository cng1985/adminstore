package com.haoxuer.adminstore;

import com.haoxuer.adminstore.structure.data.entity.Organization;
import com.haoxuer.imake.ChainMake;
import com.haoxuer.imake.template.hibernate.TemplateHibernateDir;
import com.haoxuer.imake.template.hibernateSimple.TemplateHibernateSimpleDir;
import com.haoxuer.imake.templates.elementuiForm.ElementUIFormDir;

import java.io.File;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        viewMake().makes(Organization.class);
    }

    private static ChainMake code() {
        ChainMake make = new ChainMake(ElementUIFormDir.class, TemplateHibernateSimpleDir.class);
        File view = new File("E:\\codes\\maven\\adminstore\\web\\src\\main\\webapp\\WEB-INF\\ftl\\tenant\\default");
        make.setView(view);
        make.setDao(true);
        make.setService(false);
        make.setView(false);
        make.setAction(true);
        make.setRest(true);
        make.setApi(true);
        make.setSo(false);
        return make;
    }

    private static ChainMake viewMake() {
        ChainMake make = new ChainMake(ElementUIFormDir.class, TemplateHibernateDir.class);
        File view = new File("E:\\codes\\maven\\adminstore\\web\\src\\main\\webapp\\WEB-INF\\ftl\\tenant\\default");
        make.setView(view);
        make.setDao(false);
        make.setService(false);
        make.setView(true);
        make.setAction(false);
        make.setRest(false);
        make.setApi(false);
        make.setSo(false);
        return make;
    }
}
