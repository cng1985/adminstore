package com.nbsaas.adminstore.customer.api.domain.request;

import com.haoxuer.discover.user.api.domain.request.BasePageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;
import java.util.Date;

/**
*
* Created by imake on 2021年05月23日15:15:47.
*/

@Data
public class CustomerSearchRequest extends BasePageRequest {

    //客户名称
     @Search(name = "name",operator = Filter.Operator.like)
     private String name;

    //介绍人
     @Search(name = "introducer",operator = Filter.Operator.like)
     private String introducer;




    private String sortField;


    private String sortMethod;
}