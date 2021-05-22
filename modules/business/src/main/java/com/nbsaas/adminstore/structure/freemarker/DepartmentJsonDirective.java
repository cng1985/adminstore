package com.nbsaas.adminstore.structure.freemarker;

import com.google.gson.Gson;
import com.nbsaas.adminstore.structure.api.domain.simple.OrganizationSimple;
import com.nbsaas.adminstore.structure.data.entity.Organization;
import com.nbsaas.adminstore.structure.data.service.OrganizationService;
import com.nbsaas.adminstore.structure.rest.convert.OrganizationSimpleConvert;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("departmentJsonDirective")
public class DepartmentJsonDirective implements TemplateDirectiveModel {


    @Autowired
    private OrganizationService service;

    @Override
    public void execute(Environment env, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        List<Filter> filters = new ArrayList<>();

        filters.add(Filter.eq("levelInfo", 1));


        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc("sortNum"));
        List<Organization> list = service.list(0, 100, filters, orders);
        if (list != null && list.size() > 0) {
            OrganizationSimpleConvert convert=new OrganizationSimpleConvert();
            convert.setFetch(1);
            List<OrganizationSimple> vs = ConverResourceUtils.converCollect(list, convert);
            env.getOut().append(new Gson().toJson(vs));
        }else{
            env.getOut().append("[]");

        }
    }
}
