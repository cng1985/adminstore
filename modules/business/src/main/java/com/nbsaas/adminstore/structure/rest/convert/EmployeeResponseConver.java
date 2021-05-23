package com.nbsaas.adminstore.structure.rest.convert;

import com.haoxuer.discover.data.utils.BeanDataUtils;
import com.haoxuer.discover.user.data.enums.DataScope;
import com.nbsaas.adminstore.structure.api.domain.response.EmployeeResponse;
import com.nbsaas.adminstore.structure.data.entity.Employee;
import com.haoxuer.discover.data.rest.core.Conver;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeResponseConver implements Conver<EmployeeResponse, Employee> {
    @Override
    public EmployeeResponse conver(Employee source) {
        EmployeeResponse result = new EmployeeResponse();
        if (source.getDataScope()==null){
            source.setDataScope(DataScope.my);
        }
        BeanDataUtils.copyProperties(source,result);

        if (source.getOrg() != null) {
            result.setOrg(source.getOrg().getId());
            result.setOrgName(source.getOrg().getName());
        }
        if (source.getRoles() != null) {
            List<Long> roles = source.getRoles().stream().map(item -> item.getId()).collect(Collectors.toList());
            result.setSelectRoles(roles);
        }
        return result;
    }
}
