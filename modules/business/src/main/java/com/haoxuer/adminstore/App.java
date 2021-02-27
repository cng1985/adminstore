package com.haoxuer.adminstore;

import com.haoxuer.adminstore.ad.data.entity.Ad;
import com.haoxuer.adminstore.ad.data.entity.AdPosition;
import com.haoxuer.adminstore.article.data.entity.Article;
import com.haoxuer.adminstore.member.controller.admin.Controllers;
import com.haoxuer.adminstore.member.data.entity.Member;
import com.haoxuer.adminstore.shop.data.entity.Shop;
import com.haoxuer.imake.ChainMake;
import com.haoxuer.imake.template.hibernate.TemplateHibernateDir;
import com.haoxuer.imake.templates.elementRouter.ElementRouterDir;
import com.haoxuer.imake.templates.elementui.ElementUIDir;
import com.haoxuer.imake.templates.elementuiForm.ElementUIFormDir;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        viewMake().makes(Member.class);
    }

    private static ChainMake getChainMake() {
        ChainMake make = new ChainMake(ElementUIFormDir.class, TemplateHibernateDir.class);
        File view = new File("E:\\codes\\maven\\adminstore\\web\\src\\main\\webapp\\WEB-INF\\ftl\\tenant\\default");
        make.setView(view);
        make.setDao(true);
        make.setService(false);
        make.setView(true);
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
