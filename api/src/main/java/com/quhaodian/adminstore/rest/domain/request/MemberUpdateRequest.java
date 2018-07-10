package com.quhaodian.adminstore.rest.domain.request;

import com.quhaodian.discover.rest.base.RequestUserTokenObject;

public class MemberUpdateRequest extends RequestUserTokenObject {
  
  private String name;
  
  private String sex;
  
  private String avatar;
  
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
}
