package com.haoxuer.adminstore.shop.api.domain.simple;


import java.io.Serializable;
import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.haoxuer.discover.data.enums.StoreState;

/**
*
* Created by BigWorld on 2021年01月23日16:17:59.
*/
@Data
public class ShopSimple implements Serializable {

    private Long id;

     private StoreState storeState;
     private String name;
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date addDate;

     private String storeStateName;

}
