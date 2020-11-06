package com.haoxuer.adminstore.structure.rest.conver;

import com.haoxuer.adminstore.structure.api.domain.response.OrganizationResponse;
import com.haoxuer.adminstore.structure.data.entity.Organization;
import com.haoxuer.discover.data.rest.core.Conver;

public class OrganizationResponseConver implements Conver<OrganizationResponse, Organization> {
    @Override
    public OrganizationResponse conver(Organization source) {
        OrganizationResponse result = new OrganizationResponse();
        result.setId(source.getId());
        result.setLevelInfo(source.getLevelInfo());
        result.setLft(source.getLft());
        result.setNum(source.getNum());
        result.setCatalog(source.getCatalog());
        result.setName(source.getName());
        result.setIds(source.getIds());
        result.setSortNum(source.getSortNum());
        result.setRgt(source.getRgt());
        return result;
    }
}
