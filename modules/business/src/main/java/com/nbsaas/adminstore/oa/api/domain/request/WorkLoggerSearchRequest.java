package com.nbsaas.adminstore.oa.api.domain.request;

import com.haoxuer.discover.user.api.domain.request.BasePageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;
import java.util.Date;

/**
*
* Created by imake on 2021年05月22日09:52:36.
*/

@Data
public class WorkLoggerSearchRequest extends BasePageRequest {

    //标题
     @Search(name = "title",operator = Filter.Operator.like)
     private String title;




    private String sortField;


    private String sortMethod;
}