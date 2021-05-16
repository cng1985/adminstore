package com.haoxuer.adminstore.member.data.entity;

import com.haoxuer.discover.data.entity.AbstractEntity;
import com.haoxuer.discover.data.enums.State;
import com.haoxuer.discover.user.data.entity.AbstractUser;
import com.haoxuer.discover.user.data.entity.UserLabel;
import com.nbsaas.codemake.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 网站用户
 */

@SearchBean(items = {
        @SearchItem(label = "姓名", name = "name"),
        @SearchItem(label = "手机号", name = "phone")
})
@ComposeView
@Data
@FormAnnotation(title = "用户管理", model = "用户", menu = "1,20,21")
@Entity
@Table(name = "user_info")
public class Member extends AbstractEntity {



    @FormField(title = "头像", sortNum = "2", col = 22,type = InputType.image)
    private String avatar;
    private Integer catalog;


    private Integer loginSize = 0;

    @FormField(title = "姓名", sortNum = "2", grid = true, col = 22)
    @Column( length = 20)
    private String name;

    @FormField(title = "手机号", sortNum = "2", grid = true, col = 22)
    @Column(length = 15 )
    private String phone;

    @Enumerated
    private State state;



    @FormField(title = "个人介绍", sortNum = "2", grid = true, col = 22)
    private String note;


    @FormField(title = "性别", sortNum = "2", grid = true, col = 22, type = InputType.dictionary)
    @Column(length = 5)
    private String sex;

    /**
     * 个人介绍
     */
    @FormField(title = "个人介绍", sortNum = "2", grid = true, col = 22)
    private String introduce;

    @FormField(title = "职业", sortNum = "2", grid = true, col = 22)
    @Column(length = 20)
    private String job;

    @FormField(title = "账号", sortNum = "2", grid = true, col = 22)
    private String no;


    @ManyToMany(fetch = FetchType.LAZY )
    @JoinTable(name = "user_label_links",joinColumns = {@JoinColumn(name = "user_id")})
    private Set<UserLabel> labels = new HashSet();

}
