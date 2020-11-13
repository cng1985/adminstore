package com.haoxuer.adminstore.article.api.domain.simple;


import java.io.Serializable;
import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
*
* Created by BigWorld on 2020年11月04日20:16:48.
*/

@Data
public class ArticleCatalogSimple implements Serializable {

    private Integer id;

     private String code;
     private Integer levelInfo;
     private Long size;
     private Integer sortNum;
     private String ids;
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date lastDate;
     private String name;
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date addDate;


}