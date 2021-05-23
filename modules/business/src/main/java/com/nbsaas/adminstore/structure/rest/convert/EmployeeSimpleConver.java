package com.nbsaas.adminstore.structure.rest.convert;

import com.nbsaas.adminstore.structure.api.domain.simple.EmployeeSimple;
import com.nbsaas.adminstore.structure.data.entity.Employee;
import com.haoxuer.discover.data.rest.core.Conver;

public class EmployeeSimpleConver implements Conver<EmployeeSimple, Employee> {
    @Override
    public EmployeeSimple conver(Employee source) {
        EmployeeSimple result = new EmployeeSimple();
        result.setId(source.getId());
        result.setJob(source.getJob());
        result.setPhone(source.getPhone());
        result.setAvatar(source.getAvatar());
        result.setDataType(source.getDataType());
        result.setName(source.getName());
        result.setEmail(source.getEmail());
        result.setNo(source.getNo());
        if (source.getOrg() != null) {
            result.setOrg(source.getOrg().getId());
            result.setOrgName(source.getOrg().getName());
        }
        result.setDataScope(source.getDataScope());
        if (source.getDataScope()!=null){
            result.setDataScopeName(source.getDataScope()+"");
        }else{
            result.setDataScopeName("");
        }
        return result;
    }
}
