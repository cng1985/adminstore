package com.haoxuer.adminstore.structure.rest.conver;

import com.haoxuer.adminstore.structure.api.domain.simple.OrganizationSimple;
import com.haoxuer.adminstore.structure.data.entity.Organization;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrganizationSimpleAllConver implements Conver<OrganizationSimple, Organization> {
    @Override
    public OrganizationSimple conver(Organization source) {
        OrganizationSimple result = new OrganizationSimple();
        result.setId(source.getId());
        result.setName(source.getName());
        if (source.getChildren() != null && source.getChildren().size() > 0) {
            result.setChild(ConverResourceUtils.converCollect(source.getChildren(), new OrganizationSimpleAllConver()));
        }
        return result;
    }
}
