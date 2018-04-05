package com.quhaodian.adminstore.data.entity;

import com.quhaodian.area.data.entity.Area;
import com.quhaodian.data.annotations.ColType;
import com.quhaodian.data.annotations.FormAnnotation;
import com.quhaodian.data.annotations.FormFieldAnnotation;
import com.quhaodian.user.data.entity.AbstractUser;

import javax.persistence.*;

/**
 * 网站用户
 */

@FormAnnotation(title = "用户",add = "添加用户",list = "用户",update = "更新用户")
@Entity
@Table(name = "user_info")
public class Member extends AbstractUser {

    @FormFieldAnnotation(title = "个人介绍",sortNum = "2",grid =true,col = ColType.col_2)
    private String note;

    private String edge;

    @FormFieldAnnotation(title = "性别",sortNum = "2",grid =true,col = ColType.col_1)
    @Column(length = 5)
    private String sex;


    /**
     * 个人介绍
     */
    private String introduce;



    /**
     * 户籍
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Area household;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEdge() {
        return edge;
    }

    public void setEdge(String edge) {
        this.edge = edge;
    }

    public static Member fromId(Long id) {
        Member result = new Member();
        result.setId(id);
        return result;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Area getHousehold() {
        return household;
    }

    public void setHousehold(Area household) {
        this.household = household;
    }


}
