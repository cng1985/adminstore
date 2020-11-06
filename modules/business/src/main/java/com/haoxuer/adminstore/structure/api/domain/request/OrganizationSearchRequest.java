package com.haoxuer.adminstore.structure.api.domain.request;

import com.haoxuer.discover.user.api.domain.request.BasePageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;

/**
*
* Created by imake on 2020年07月27日08:50:47.
*/

@Data
public class OrganizationSearchRequest extends BasePageRequest {


    private String sortField;


    private String sortMethod;

    @Search(name = "levelInfo",operator = Filter.Operator.eq)
    private Integer level;
}