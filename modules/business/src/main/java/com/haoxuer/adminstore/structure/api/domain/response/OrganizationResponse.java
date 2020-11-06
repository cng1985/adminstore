package com.haoxuer.adminstore.structure.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

/**
*
* Created by imake on 2020年07月27日08:50:47.
*/

@Data
public class OrganizationResponse extends ResponseObject {

    private Integer id;

     private Integer levelInfo;

     private Integer lft;

     private Long num;

     private Integer catalog;

     private String name;


     private String ids;

     private Integer sortNum;

     private Integer rgt;

}