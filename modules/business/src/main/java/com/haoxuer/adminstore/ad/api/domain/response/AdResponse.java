package com.haoxuer.adminstore.ad.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.haoxuer.adminstore.ad.data.enums.AdType;

/**
*
* Created by imake on 2021年05月10日16:52:39.
*/

@Data
public class AdResponse extends ResponseObject {

    private Long id;

     private String note;

     private String title;

     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date endDate;

     private Integer catalog;

     private Long bussId;

     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date addDate;

     private AdType type;

     private String url;

     private String path;

     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date beginDate;

     private Integer sortNum;

     private Long adPosition;

     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date lastDate;

     private String adPositionName;


     private String typeName;
}