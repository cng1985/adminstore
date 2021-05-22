package com.nbsaas.adminstore.common.api.domain.request;

import com.haoxuer.discover.user.api.domain.request.BasePageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;
import java.util.Date;

/**
*
* Created by imake on 2021年04月24日18:10:25.
*/

@Data
public class StoreConfigSearchRequest extends BasePageRequest {




    private String sortField;


    private String sortMethod;
}