package com.nbsaas.adminstore.member.api.domain.request;

import com.haoxuer.discover.user.api.domain.request.BasePageRequest;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;
import java.util.Date;

/**
*
* Created by imake on 2021年05月22日10:14:20.
*/

@Data
public class MemberSearchRequest extends BasePageRequest {

    //姓名
     @Search(name = "name",operator = Filter.Operator.like)
     private String name;

    //手机号
     @Search(name = "phone",operator = Filter.Operator.like)
     private String phone;




    private String sortField;


    private String sortMethod;
}