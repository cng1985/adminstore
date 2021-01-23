package com.haoxuer.adminstore.shop.api.domain.request;

import com.haoxuer.discover.user.api.domain.request.BasePageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;
import java.util.Date;

import com.haoxuer.discover.data.enums.StoreState;

/**
*
* Created by imake on 2021年01月23日16:17:59.
*/

@Data
public class ShopSearchRequest extends BasePageRequest {


    @Search(name = "storeState",operator = Filter.Operator.eq)
    private StoreState storeState;


    private String sortField;


    private String sortMethod;
}