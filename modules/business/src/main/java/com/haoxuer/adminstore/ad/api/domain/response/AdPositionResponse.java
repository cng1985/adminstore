package com.haoxuer.adminstore.ad.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
*
* Created by imake on 2020年11月06日23:15:57.
*/

@Data
public class AdPositionResponse extends ResponseObject {

    private Long id;

     private String template;

     private long serialVersionUID;

     private Integer sortNum;

     private String name;

     private Integer width;

     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date addDate;

     private Integer height;

     private String description;


}