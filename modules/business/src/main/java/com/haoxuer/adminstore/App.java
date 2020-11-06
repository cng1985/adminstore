package com.haoxuer.adminstore;

import com.haoxuer.adminstore.ad.data.entity.Ad;
import com.haoxuer.adminstore.ad.data.entity.AdPosition;
import com.haoxuer.adminstore.article.data.entity.Article;
import com.haoxuer.adminstore.member.controller.admin.Controllers;
import com.haoxuer.imake.ChainMake;
import com.haoxuer.imake.template.hibernate.TemplateHibernateDir;
import com.haoxuer.imake.templates.elementui.ElementUIDir;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println(Controllers.class.getResource("/").getPath());
        ChainMake make = new ChainMake(ElementUIDir.class, TemplateHibernateDir.class);
        File view = new File("E:\\codes\\maven\\adminstore\\web\\src\\main\\webapp\\WEB-INF\\ftl\\tenant\\default");
        make.setView(view);

        List<Class<?>> cs = new ArrayList<Class<?>>();
        cs.add(AdPosition.class);

        make.setMenus("1,51,52");
        make.setDao(true);
        make.setService(true);
        make.setView(true);
        make.setAction(true);
        make.setRest(true);
        make.setApi(true);
        make.setSo(false);
        make.makes(cs);
    }


}
