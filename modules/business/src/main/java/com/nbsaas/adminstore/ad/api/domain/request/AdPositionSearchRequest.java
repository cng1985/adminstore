package com.nbsaas.adminstore.ad.api.domain.request;

import com.haoxuer.discover.user.api.domain.request.BasePageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;
import java.util.Date;


/**
*
* Created by imake on 2021年05月10日16:20:02.
*/

@Data
public class AdPositionSearchRequest extends BasePageRequest {

    //标识
     @Search(name = "key",operator = Filter.Operator.like)
     private String key;

    //广告位
     @Search(name = "name",operator = Filter.Operator.like)
     private String name;




    private String sortField;


    private String sortMethod;
}