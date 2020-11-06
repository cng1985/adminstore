package com.haoxuer.adminstore.structure.api.domain.request;


import com.haoxuer.discover.user.api.domain.request.BaseRequest;
import lombok.Data;

/**
*
* Created by imake on 2020年07月27日08:50:47.
*/

@Data
public class OrganizationDataRequest extends BaseRequest {

    private Integer id;

     private Integer sortNum;

     private String name;

     private Integer parent;


}