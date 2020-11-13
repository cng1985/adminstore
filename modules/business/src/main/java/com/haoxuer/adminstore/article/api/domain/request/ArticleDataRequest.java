package com.haoxuer.adminstore.article.api.domain.request;


import com.haoxuer.discover.user.api.domain.request.BaseRequest;
import lombok.Data;
import com.haoxuer.discover.data.enums.StoreState;

/**
*
* Created by imake on 2020年11月04日20:17:53.
*/

@Data
public class ArticleDataRequest extends BaseRequest {

    private Long id;

     private String img;

     private String title;

     private Integer comments;

     private StoreState storeState;

     private String contents;

     private Integer ups;

     private String extData;

     private Integer likes;

     private String images;

     private String introduction;

     private Integer views;


}