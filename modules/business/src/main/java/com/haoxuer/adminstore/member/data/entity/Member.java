package com.haoxuer.adminstore.member.data.entity;

import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.user.data.entity.AbstractUser;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 网站用户
 */

@Data
@FormAnnotation(title = "用户", add = "添加用户", list = "用户", update = "更新用户")
@Entity
@Table(name = "user_info")
public class Member extends AbstractUser {

    @FormFieldAnnotation(title = "个人介绍", sortNum = "2", grid = true, col = ColType.col_2)
    private String note;


    @FormFieldAnnotation(title = "性别", sortNum = "2", grid = true, col = ColType.col_1)
    @Column(length = 5)
    private String sex;

    /**
     * 个人介绍
     */
    @FormFieldAnnotation(title = "个人介绍", sortNum = "2", grid = true, col = ColType.col_1)
    private String introduce;

    @FormFieldAnnotation(title = "职业", sortNum = "2", grid = true, col = ColType.col_1)
    @Column(length = 20)
    private String job;

    @FormFieldAnnotation(title = "账号", sortNum = "2", grid = true, col = ColType.col_1)
    private String no;


}
