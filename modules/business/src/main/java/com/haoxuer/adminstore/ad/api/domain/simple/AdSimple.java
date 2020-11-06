package com.haoxuer.adminstore.ad.api.domain.simple;


import java.io.Serializable;
import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.haoxuer.adminstore.ad.data.enums.AdType;

/**
*
* Created by BigWorld on 2020年11月06日23:28:28.
*/

@Data
public class AdSimple implements Serializable {

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
     private String adPositionName;

     private String typeName;

}