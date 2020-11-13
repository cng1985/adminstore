package com.haoxuer.adminstore.structure.api.domain.simple;


import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * Created by imake on 2020年07月27日08:50:47.
 */

@Data
public class OrganizationSimple implements Serializable {

    private Integer id;

    private Integer sortNum;

    private String code;

    private Long num;


    private String name;

    private List<OrganizationSimple> child;

}