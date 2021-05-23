package com.nbsaas.adminstore.customer.api.domain.request;


import com.haoxuer.discover.user.api.domain.request.BaseRequest;
import lombok.Data;
import java.util.Date;

/**
*
* Created by imake on 2021年05月23日15:15:47.
*/

@Data
public class CustomerDataRequest extends BaseRequest {

    private Long id;

     private Date beginDate;

     private Integer score;

     private String note;

     private String introducer;

     private Long creator;

     private String phone;

     private Date lastDate;

     private String name;

     private Date addDate;


}