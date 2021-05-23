package com.nbsaas.adminstore.customer.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
*
* Created by imake on 2021年05月23日15:15:47.
*/

@Data
public class CustomerResponse extends ResponseObject {

    private Long id;

     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date beginDate;

     private Integer score;

     private String note;

     private String introducer;

     private Long creator;

     private String phone;

     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date lastDate;

     private String name;

     private String creatorName;

     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date addDate;


}