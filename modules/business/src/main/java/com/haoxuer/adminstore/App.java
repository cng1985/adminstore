package com.haoxuer.adminstore;

import com.haoxuer.adminstore.ad.data.entity.Ad;
import com.haoxuer.adminstore.ad.data.entity.AdPosition;
import com.nbsaas.codemake.CodeMake;
import com.nbsaas.codemake.template.hibernate.TemplateHibernateDir;
import com.nbsaas.codemake.template.hibernateSimple.TemplateHibernateSimpleDir;
import com.nbsaas.codemake.templates.elementuiForm.ElementUIFormDir;

import java.io.File;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        viewMake().makes(Ad.class);
    }

    private static CodeMake code() {
        CodeMake make = new CodeMake(ElementUIFormDir.class, TemplateHibernateSimpleDir.class);
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

    private static CodeMake viewMake() {
        CodeMake make = new CodeMake(ElementUIFormDir.class, TemplateHibernateDir.class);
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
