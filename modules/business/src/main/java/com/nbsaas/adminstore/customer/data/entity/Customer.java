package com.nbsaas.adminstore.customer.data.entity;

import com.haoxuer.discover.user.data.entity.UserEntity;
import com.nbsaas.codemake.annotation.*;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@CreateByUser
@ComposeView
@Data
@FormAnnotation(title = "客户", model = "客户", menu = "1,60,61",searchWidth = "100",viewWidth = "120")
@Entity
@Table(name = "bs_customer")
public class Customer extends UserEntity {

    @SearchItem(name = "name",key = "name",label = "客户名称")
    @FormField(title = "客户名称", sortNum = "1", grid = true,required = true)
    @Column(length = 30)
    private String name;

    @FormField(title = "联系电话", sortNum = "1", grid = true)
    @Column(length = 30)
    private String phone;

    /**
     * 开始日期
     */
    @FormField(title = "合作日期", type = InputType.date, sortNum = "4",width = "160",grid = true)
    private Date beginDate;

    @SearchItem(name = "introducer",key = "introducer",label = "介绍人")
    @FormField(title = "介绍人", sortNum = "1", grid = true)
    @Column(length = 30)
    private String introducer;


    @FormField(title = "关系分数", sortNum = "1", grid = true,type = InputType.el_input_number,sort = true)
    private Integer score;


    /**
     * 项目内容
     */
    @FormField(title = "内容", sortNum = "10",type = InputType.richText,col = 23)
    private String note;
}
