package com.haoxuer.adminstore.ad.api.domain.simple;


import java.io.Serializable;
import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
*
* Created by BigWorld on 2021年05月10日16:20:02.
*/
@Data
public class AdPositionSimple implements Serializable {

    private Long id;

     private String note;
     private String template;
     private Integer sortNum;
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date lastDate;
     private String name;
     private Integer width;
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date addDate;
     private Integer height;
     private String key;


}
