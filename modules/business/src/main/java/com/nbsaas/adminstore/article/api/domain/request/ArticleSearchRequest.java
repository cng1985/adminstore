package com.nbsaas.adminstore.article.api.domain.request;

import com.haoxuer.discover.user.api.domain.request.BasePageRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年11月04日20:17:53.
*/

@Data
public class ArticleSearchRequest extends BasePageRequest {


    private String sortField;


    private String sortMethod;
}