package com.haoxuer.adminstore.common.api.domain.simple;


import java.io.Serializable;
import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
*
* Created by BigWorld on 2021年04月24日18:10:25.
*/
@Data
public class StoreConfigSimple implements Serializable {

    private Long id;

     private String phone;
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date lastDate;
     private String name;
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date addDate;


}
