package com.haoxuer.adminstore.structure.rest.convert;

import com.haoxuer.adminstore.structure.api.domain.response.OrganizationResponse;
import com.haoxuer.adminstore.structure.data.entity.Organization;
import com.haoxuer.discover.data.rest.core.Conver;
import com.haoxuer.discover.data.utils.BeanDataUtils;

public class OrganizationResponseConvert implements Conver<OrganizationResponse, Organization> {
    @Override
    public OrganizationResponse conver(Organization source) {
        OrganizationResponse result = new OrganizationResponse();
        BeanDataUtils.copyProperties(source,result);

        if(source.getParent()!=null){
           result.setParent(source.getParent().getId());
        }
         if(source.getParent()!=null){
            result.setParentName(source.getParent().getName());
         }


        return result;
    }
}
