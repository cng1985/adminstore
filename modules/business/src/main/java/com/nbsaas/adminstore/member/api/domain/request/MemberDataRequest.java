package com.nbsaas.adminstore.member.api.domain.request;


import com.haoxuer.discover.user.api.domain.request.BaseRequest;
import lombok.Data;
import com.haoxuer.discover.data.enums.State;
import com.haoxuer.discover.user.data.enums.DataScope;
import java.util.Date;

/**
*
* Created by imake on 2021年05月22日10:14:20.
*/

@Data
public class MemberDataRequest extends BaseRequest {

    private Long id;

     private String no;

     private String note;

     private String sex;

     private Integer catalog;

     private String introduce;

     private String avatar;

     private Integer loginSize;

     private Date addDate;

     private DataScope dataScope;

     private String phone;

     private Date lastDate;

     private String name;

     private State state;

     private String job;


}