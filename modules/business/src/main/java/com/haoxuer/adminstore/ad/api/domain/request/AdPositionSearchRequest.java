package com.haoxuer.adminstore.ad.api.domain.request;

import com.haoxuer.discover.user.api.domain.request.BasePageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;
import java.util.Date;

/**
*
* Created by imake on 2020年11月06日23:22:43.
*/

@Data
public class AdPositionSearchRequest extends BasePageRequest {

    //广告位
     @Search(name = "name",operator = Filter.Operator.like)
     private String name;

    @Search(name = "adPosition.id",operator = Filter.Operator.eq)
    private Long adPosition;

    private String sortField;


    private String sortMethod;
}