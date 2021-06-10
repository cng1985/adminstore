package com.nbsaas.adminstore.structure.data.entity;


import com.haoxuer.discover.data.entity.AbstractEntity;
import com.haoxuer.discover.user.data.entity.BaseUser;
import com.haoxuer.discover.user.data.entity.UserRole;
import com.haoxuer.discover.user.data.enums.DataScope;
import com.nbsaas.adminstore.structure.enums.PermissionType;
import com.nbsaas.codemake.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@FormAnnotation(title = "员工管理", model = "员工", menu = "1,27,55")
@Entity
@DiscriminatorValue("100")
public class Employee extends BaseUser {

    @SearchItem(label = "姓名",name = "name",key = "name")
    @FormField(title = "姓名", sortNum = "1", grid = true, col = 12)
    private String name;

    @SearchItem(label = "电话",name = "phone",key = "phone")
    @FormField(title = "电话", sortNum = "2", grid = true, col = 12)
    private String phone;

    @FormField(title = "账号", sortNum = "3", grid = true, col = 12)
    private String no;

    @Column(length = 20)
    @FormField(title = "email", sortNum = "3", grid = true, col = 12)
    private String email;

    @Column(length = 20)
    @FormField(title = "职位", sortNum = "3", grid = true, col = 12)
    private String job;

    @FiledName
    @FiledConvert
    @JoinColumn(name = "structure_id")
    @FormField(title = "主要部门", sortNum = "4", grid = true, type = InputType.select,option = "org")
    @ManyToOne(fetch = FetchType.LAZY)
    private Organization org;

    @FormField(title = "权限类型", sortNum = "5", grid = true, col = 12)
    private PermissionType permissionType;


    @FormField(title = "数据范围", sortNum = "2", grid = true, col = 22)
    private DataScope dataScope;

    private String avatar;

    private Integer dataType;

    @FormField(title = "辅助部门", sortNum = "4", grid = true, col = 12)
    @JoinTable(name = "bs_org_user_department",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "department_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Organization> departments;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_links",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id")})
    private Set<UserRole> roles = new HashSet<UserRole>();

}
