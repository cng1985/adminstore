package com.quhaodian.adminstore.data.entity;

import com.quhaodian.area.data.entity.Area;
import com.quhaodian.data.annotations.ColType;
import com.quhaodian.data.annotations.FormAnnotation;
import com.quhaodian.data.annotations.FormFieldAnnotation;
import com.quhaodian.user.data.entity.AbstractUser;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 网站用户
 */

@FormAnnotation(title = "用户", add = "添加用户", list = "用户", update = "更新用户")
@Entity
@Table(name = "user_info")
public class Member extends AbstractUser {
  
  @FormFieldAnnotation(title = "个人介绍", sortNum = "2", grid = true, col = ColType.col_2)
  private String note;
  
  private String edge;
  
  @FormFieldAnnotation(title = "性别", sortNum = "2", grid = true, col = ColType.col_1)
  @Column(length = 5)
  private String sex;
  
  
  /**
   * 个人介绍
   */
  private String introduce;
  
  @Column(length = 20)
  private String job;
  
  @Column(length = 30)
  private String companyName;
  
  
  private String email;
  
  
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
  
  public String getJob() {
    return job;
  }
  
  public void setJob(String job) {
    this.job = job;
  }
  
  public String getCompanyName() {
    return companyName;
  }
  
  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
}
