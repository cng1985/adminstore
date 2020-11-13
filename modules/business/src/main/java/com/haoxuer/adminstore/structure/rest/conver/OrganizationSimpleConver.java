package com.haoxuer.adminstore.structure.rest.conver;

import com.haoxuer.adminstore.structure.api.domain.simple.OrganizationSimple;
import com.haoxuer.adminstore.structure.data.entity.Organization;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrganizationSimpleConver implements Conver<OrganizationSimple, Organization> {
    @Override
    public OrganizationSimple conver(Organization source) {
        OrganizationSimple result = new OrganizationSimple();
        result.setId(source.getId());
        result.setSortNum(source.getSortNum());
        result.setCode(source.getCode());
        result.setNum(source.getNum());
        result.setName(source.getName());

        return result;
    }
}
