package com.nbsaas.adminstore.structure.api.domain.simple;


import java.io.Serializable;
import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;

/**
*
* Created by BigWorld on 2021年04月12日20:57:24.
*/

@Data
public class OrganizationSimple implements Serializable {
    private Integer id;
    private String value;
    private String label;
    private List<OrganizationSimple> children;

     private Integer parent;
     private String note;
     private String code;
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
