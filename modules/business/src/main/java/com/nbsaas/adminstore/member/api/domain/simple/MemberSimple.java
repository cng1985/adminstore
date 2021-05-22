package com.nbsaas.adminstore.member.api.domain.simple;


import java.io.Serializable;
import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.haoxuer.discover.data.enums.State;
import com.haoxuer.discover.user.data.enums.DataScope;

/**
*
* Created by BigWorld on 2021年05月22日10:14:20.
*/
@Data
public class MemberSimple implements Serializable {

    private Long id;

     private String no;
     private String note;
     private String sex;
     private Integer catalog;
     private String introduce;
     private String avatar;
     private Integer loginSize;
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date addDate;
     private DataScope dataScope;
     private String phone;
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date lastDate;
     private String name;
     private State state;
     private String job;

     private String stateName;
     private String dataScopeName;

}