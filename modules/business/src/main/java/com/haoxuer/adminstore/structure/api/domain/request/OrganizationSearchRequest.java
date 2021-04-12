package com.haoxuer.adminstore.structure.api.domain.request;

import com.haoxuer.discover.user.api.domain.request.BasePageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;
import java.util.Date;


/**
*
* Created by imake on 2021年04月12日20:57:24.
*/

@Data
public class OrganizationSearchRequest extends BasePageRequest {



    private int fetch;

    @Search(name = "levelInfo",operator = Filter.Operator.eq)
    private Integer level;

    private String sortField;


    private String sortMethod;
}