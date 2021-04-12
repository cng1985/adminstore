package com.haoxuer.adminstore.member.api.domain.request;

import com.haoxuer.discover.user.api.domain.request.BasePageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;
import java.util.Date;

/**
*
* Created by imake on 2021年02月28日16:04:56.
*/

@Data
public class MemberSearchRequest extends BasePageRequest {




    private String sortField;


    private String sortMethod;
}