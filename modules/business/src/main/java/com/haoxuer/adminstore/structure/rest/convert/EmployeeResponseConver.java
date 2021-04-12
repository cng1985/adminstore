package com.haoxuer.adminstore.structure.rest.convert;

import com.haoxuer.adminstore.structure.api.domain.response.EmployeeResponse;
import com.haoxuer.adminstore.structure.data.entity.Employee;
import com.haoxuer.discover.data.rest.core.Conver;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeResponseConver implements Conver<EmployeeResponse, Employee> {
    @Override
    public EmployeeResponse conver(Employee source) {
        EmployeeResponse result = new EmployeeResponse();
        result.setId(source.getId());
        result.setEmail(source.getEmail());
        result.setNo(source.getNo());
        result.setAvatar(source.getAvatar());
        result.setPhone(source.getPhone());
        result.setDataType(source.getDataType());
        result.setJob(source.getJob());
        result.setName(source.getName());
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
