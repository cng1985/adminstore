package com.haoxuer.adminstore.common.api.domain.request;


import com.haoxuer.discover.user.api.domain.request.BaseRequest;
import lombok.Data;
import java.util.Date;

/**
*
* Created by imake on 2021年04月24日18:10:25.
*/

@Data
public class StoreConfigDataRequest extends BaseRequest {

    private Long id;

     private String phone;

     private Date lastDate;

     private String name;

     private Date addDate;


}