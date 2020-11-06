package com.haoxuer.adminstore.article.api.domain.request;

import com.haoxuer.discover.user.api.domain.request.BasePageRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年11月04日20:16:48.
*/

@Data
public class ArticleCatalogSearchRequest extends BasePageRequest {


    private String sortField;


    private String sortMethod;
}