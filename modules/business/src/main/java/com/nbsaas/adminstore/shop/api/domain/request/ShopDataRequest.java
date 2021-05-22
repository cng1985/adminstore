package com.nbsaas.adminstore.shop.api.domain.request;


import com.haoxuer.discover.user.api.domain.request.BaseRequest;
import lombok.Data;
import com.haoxuer.discover.data.enums.StoreState;
import java.util.Date;

/**
*
* Created by imake on 2021年01月23日16:17:59.
*/

@Data
public class ShopDataRequest extends BaseRequest {

    private Long id;

     private StoreState storeState;

     private String name;


}