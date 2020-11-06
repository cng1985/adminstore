package com.haoxuer.adminstore.article.api.domain.request;


import com.haoxuer.discover.user.api.domain.request.BaseRequest;
import lombok.Data;
import java.util.Date;

/**
*
* Created by imake on 2020年11月04日20:16:48.
*/

@Data
public class ArticleCatalogDataRequest extends BaseRequest {

    private Integer id;

     private String code;

     private Integer levelInfo;

     private Long size;

     private Integer sortNum;

     private String ids;

     private Integer lft;

     private Date lastDate;

     private String name;

     private Date addDate;

     private Integer rgt;


}