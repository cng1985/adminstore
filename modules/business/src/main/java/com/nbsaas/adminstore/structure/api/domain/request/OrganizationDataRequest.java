package com.nbsaas.adminstore.structure.api.domain.request;


import com.haoxuer.discover.user.api.domain.request.BaseRequest;
import lombok.Data;
import java.util.Date;

/**
*
* Created by imake on 2021年04月12日20:57:24.
*/

@Data
public class OrganizationDataRequest extends BaseRequest {

    private Integer id;

     private Integer parent;

     private String note;

     private String code;

     private Long num;

     private Integer catalog;

     private Date addDate;

     private Integer levelInfo;

     private Integer sortNum;

     private String ids;

     private Integer lft;

     private Date lastDate;

     private String name;

     private Integer rgt;


}