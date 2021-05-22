package com.nbsaas.adminstore.ad.api.domain.request;

import com.haoxuer.discover.user.api.domain.request.BasePageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;
import java.util.Date;


/**
*
* Created by imake on 2021年05月10日16:52:39.
*/

@Data
public class AdSearchRequest extends BasePageRequest {

    //广告位
     @Search(name = "adPosition.id",operator = Filter.Operator.eq)
     private Long adPosition;

    //广告名称
     @Search(name = "title",operator = Filter.Operator.like)
     private String title;




    private String sortField;


    private String sortMethod;
}