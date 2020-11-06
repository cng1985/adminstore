package com.haoxuer.adminstore.ad.api.domain.request;


import com.haoxuer.discover.user.api.domain.request.BaseRequest;
import lombok.Data;
import com.haoxuer.adminstore.ad.data.enums.AdType;
import java.util.Date;

/**
*
* Created by imake on 2020年11月06日23:14:57.
*/

@Data
public class AdDataRequest extends BaseRequest {

    private Long id;

     private String path;

     private Date beginDate;

     private String note;

     private String title;

     private Date endDate;

     private Integer sortNum;

     private Integer catalog;

     private Long bussId;

     private AdType type;

     private String url;


}