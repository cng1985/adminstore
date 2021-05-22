package com.nbsaas.adminstore.oa.api.domain.request;


import com.haoxuer.discover.user.api.domain.request.BaseRequest;
import lombok.Data;
import java.util.Date;

/**
*
* Created by imake on 2021年05月22日09:52:36.
*/

@Data
public class WorkLoggerDataRequest extends BaseRequest {

    private Long id;

     private String note;

     private String title;

     private Long creator;

     private Date recordDate;

     private Date lastDate;

     private Date addDate;


}