package com.haoxuer.adminstore.ad.api.domain.request;


import com.haoxuer.discover.user.api.domain.request.BaseRequest;
import lombok.Data;
import com.haoxuer.adminstore.ad.data.enums.AdType;
import java.util.Date;

/**
*
* Created by imake on 2021年05月10日16:52:39.
*/

@Data
public class AdDataRequest extends BaseRequest {

    private Long id;

     private String note;

     private String title;

     private Date endDate;

     private Integer catalog;

     private Long bussId;

     private Date addDate;

     private AdType type;

     private String url;

     private String path;

     private Date beginDate;

     private Integer sortNum;

     private Long adPosition;

     private Date lastDate;


}