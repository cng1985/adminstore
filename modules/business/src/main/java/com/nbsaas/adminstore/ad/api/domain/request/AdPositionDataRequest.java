package com.nbsaas.adminstore.ad.api.domain.request;


import com.haoxuer.discover.user.api.domain.request.BaseRequest;
import lombok.Data;
import java.util.Date;

/**
*
* Created by imake on 2021年05月10日16:20:02.
*/

@Data
public class AdPositionDataRequest extends BaseRequest {

    private Long id;

     private String note;

     private String template;

     private Integer sortNum;

     private Date lastDate;

     private String name;

     private Integer width;

     private Date addDate;

     private Integer height;

     private String key;


}