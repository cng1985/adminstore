package com.haoxuer.adminstore.article.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.haoxuer.discover.data.enums.StoreState;

/**
*
* Created by imake on 2020年11月04日20:17:53.
*/

@Data
public class ArticleResponse extends ResponseObject {

    private Long id;

     private String img;

     private String title;

     private Integer comments;

     private StoreState storeState;

     private String contents;

     private Integer ups;

     private String extData;

     private Integer likes;

     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date addDate;

     private String images;

     private String introduction;

     private Integer views;


     private String storeStateName;
}