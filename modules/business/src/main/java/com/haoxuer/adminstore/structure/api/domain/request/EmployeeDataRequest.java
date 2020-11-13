package com.haoxuer.adminstore.structure.api.domain.request;


import com.haoxuer.discover.user.api.domain.request.BaseRequest;
import lombok.Data;

import java.util.List;

/**
 * Created by imake on 2020年07月27日09:16:50.
 */

@Data
public class EmployeeDataRequest extends BaseRequest {

    private Long id;

    private String job;

    private String avatar;

    private String email;

    private String phone;

    private String name;

    private String no;

    private Integer dataType;

    private Integer org;

    private String password;

    private String newPassword;

    private List<Long> selectRoles;


}