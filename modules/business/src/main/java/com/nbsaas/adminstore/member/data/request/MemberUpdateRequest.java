package com.nbsaas.adminstore.member.data.request;

import java.io.Serializable;

public class MemberUpdateRequest implements Serializable {
  
  private Long id;
  
  private String name;
  
  private String sex;
  
  private String avatar;
  
  private String phone;
  
  private String email;
  
  private String job;
  
  private String companyName;
  
  private String introduce;
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getSex() {
    return sex;
  }
  
  public void setSex(String sex) {
    this.sex = sex;
  }
  
  public String getAvatar() {
    return avatar;
  }
  
  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
  
  public String getPhone() {
    return phone;
  }
  
  public void setPhone(String phone) {
    this.phone = phone;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
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
  
  public String getIntroduce() {
    return introduce;
  }
  
  public void setIntroduce(String introduce) {
    this.introduce = introduce;
  }
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
}
