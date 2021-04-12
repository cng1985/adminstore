package com.haoxuer.adminstore.structure.rest.convert;

import com.haoxuer.adminstore.structure.api.domain.simple.OrganizationSimple;
import com.haoxuer.adminstore.structure.data.entity.Organization;
import com.haoxuer.discover.data.rest.core.Conver;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import lombok.Data;


@Data
public class OrganizationSimpleConvert implements Conver<OrganizationSimple, Organization> {

    private int fetch;

    @Override
    public OrganizationSimple conver(Organization source) {
        OrganizationSimple result = new OrganizationSimple();

         result.setLabel(source.getName());
         result.setValue(""+source.getId());
         if (fetch!=0&&source.getChildren()!=null&&source.getChildren().size()>0){
             result.setChildren(ConverResourceUtils.converList(source.getChildren(),this));
         }
            result.setId(source.getId());
            if(source.getParent()!=null){
               result.setParent(source.getParent().getId());
            }
             result.setNote(source.getNote());
             result.setCode(source.getCode());
             result.setLevelInfo(source.getLevelInfo());
             if(source.getParent()!=null){
                result.setParentName(source.getParent().getName());
             }
             result.setNum(source.getNum());
             result.setSortNum(source.getSortNum());
             result.setIds(source.getIds());
             result.setCatalog(source.getCatalog());
             result.setLastDate(source.getLastDate());
             result.setName(source.getName());
             result.setAddDate(source.getAddDate());

        return result;
    }
}
