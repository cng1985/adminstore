package com.quhaodian.adminstore.data.entity;


import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@FormAnnotation(title = "错误日志", add = "添加错误日志", list = "错误日志列表", update = "更新错误日志")
@Entity
@Table(name = "bs_exception_log")
public class ExceptionLog extends AbstractEntity {
  
  @Column(length = 50)
  private String name;
  
  @Column(length = 65536)
  private String note;
  
  private String url;
  
  private String params;
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getNote() {
    return note;
  }
  
  public void setNote(String note) {
    this.note = note;
  }
  
  public String getUrl() {
    return url;
  }
  
  public void setUrl(String url) {
    this.url = url;
  }
  
  public String getParams() {
    return params;
  }
  
  public void setParams(String params) {
    this.params = params;
  }
}
