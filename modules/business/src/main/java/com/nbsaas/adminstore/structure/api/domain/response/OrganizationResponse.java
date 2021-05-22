package com.nbsaas.adminstore.structure.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
*
* Created by imake on 2021年04月12日20:57:24.
*/

@Data
public class OrganizationResponse extends ResponseObject {

    private Integer id;

     private Integer parent;

     private String note;

     private Integer levelInfo;

     private String parentName;

     private Long num;

     private Integer sortNum;

     private String ids;

     private Integer catalog;

     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date lastDate;

     private String name;

     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date addDate;


}