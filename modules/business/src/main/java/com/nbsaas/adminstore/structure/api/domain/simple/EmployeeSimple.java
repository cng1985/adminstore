package com.nbsaas.adminstore.structure.api.domain.simple;


import lombok.Data;

import java.io.Serializable;

/**
 * Created by imake on 2020年07月27日09:16:50.
 */

@Data
public class EmployeeSimple implements Serializable {

    private Long id;

    private String job;

    private String phone;

    private String avatar;

    private Integer dataType;

    private String name;

    private String email;

    private String no;

    private Integer org;

    private String orgName;

}