package com.nbsaas.adminstore.structure.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

import java.util.List;

/**
 * Created by imake on 2020年07月27日09:16:50.
 */

@Data
public class EmployeeResponse extends ResponseObject {

    private Long id;

    private String email;

    private String no;

    private String avatar;

    private String phone;

    private Integer dataType;

    private String job;

    private String name;

    private Integer org;

    private String orgName;

    private List<Long> selectRoles;


}