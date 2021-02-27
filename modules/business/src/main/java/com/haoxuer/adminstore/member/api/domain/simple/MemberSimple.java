package com.haoxuer.adminstore.member.api.domain.simple;


import java.io.Serializable;
import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.haoxuer.discover.data.enums.State;

/**
*
* Created by BigWorld on 2021年02月27日21:00:48.
*/
@Data
public class MemberSimple implements Serializable {

    private Long id;

     private String no;
     private String note;
     private String sex;
     private String phone;
     private String introduce;
     private Integer catalog;
     private String name;
     private String avatar;
     private State state;
     private Integer loginSize;
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
     private Date addDate;
     private String job;

     private String stateName;

}
