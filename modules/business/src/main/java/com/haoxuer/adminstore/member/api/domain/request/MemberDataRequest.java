package com.haoxuer.adminstore.member.api.domain.request;


import com.haoxuer.discover.user.api.domain.request.BaseRequest;
import lombok.Data;
import com.haoxuer.discover.data.enums.State;
import java.util.Date;

/**
*
* Created by imake on 2021年02月27日21:00:48.
*/

@Data
public class MemberDataRequest extends BaseRequest {

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

     private String job;


}