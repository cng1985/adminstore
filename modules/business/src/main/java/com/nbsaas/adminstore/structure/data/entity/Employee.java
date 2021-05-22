package com.nbsaas.adminstore.structure.data.entity;



import com.haoxuer.discover.user.data.enums.DataScope;
import com.nbsaas.adminstore.structure.enums.PermissionType;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.data.entity.AbstractEntity;
import com.haoxuer.discover.user.data.entity.UserRole;
import com.haoxuer.imake.annotation.SearchItem;
import com.nbsaas.codemake.annotation.FormField;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@FormAnnotation(title = "员工", add = "员工", list = "员工", update = "员工")
@Entity
@Table(name = "user_info")
public class Employee extends AbstractEntity {

    @SearchItem(label = "姓名",name = "name",key = "name")
    @FormFieldAnnotation(title = "姓名", sortNum = "1", grid = true, col = ColType.col_2)
    private String name;

    @SearchItem(label = "电话",name = "phone",key = "phone")
    @FormFieldAnnotation(title = "电话", sortNum = "2", grid = true, col = ColType.col_2)
    private String phone;

    @FormFieldAnnotation(title = "账号", sortNum = "3", grid = true, col = ColType.col_2)
    private String no;

    @Column(length = 20)
    @FormFieldAnnotation(title = "email", sortNum = "3", grid = true, col = ColType.col_2)
    private String email;

    @Column(length = 20)
    @FormFieldAnnotation(title = "职位", sortNum = "3", grid = true, col = ColType.col_2)
    private String job;


    @JoinColumn(name = "structure_id")
    @FormFieldAnnotation(title = "主要部门", sortNum = "4", grid = true, col = ColType.col_2)
    @ManyToOne(fetch = FetchType.LAZY)
    private Organization org;

    @FormFieldAnnotation(title = "权限类型", sortNum = "5", grid = true, col = ColType.col_2)
    private PermissionType permissionType;


    @FormField(title = "数据范围", sortNum = "2", grid = true, col = 22)
    private DataScope dataScope;

    private String avatar;

    private Integer dataType;

    @FormFieldAnnotation(title = "辅助部门", sortNum = "4", grid = true, col = ColType.col_2)
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
