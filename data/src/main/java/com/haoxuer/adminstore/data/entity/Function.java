package com.haoxuer.adminstore.data.entity;

import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.data.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@FormAnnotation(title = "云函数", add = "云函数", list = "云函数", update = "云函数")
@Entity
@Table(name = "bs_function")
public class Function extends AbstractEntity {

  @FormFieldAnnotation(title = "函数名", sortNum = "1", grid = true, col = ColType.col_2)
  private String name;

  @Column(name = "data_key",unique = true)
  @FormFieldAnnotation(title = "远程key", sortNum = "2", grid = true, col = ColType.col_2)
  private String key;

  @FormFieldAnnotation(title = "函数介绍", sortNum = "3", grid = true, col = ColType.col_6)
  private String note;

  @Column(name = "data_script")
  @FormFieldAnnotation(title = "脚本", sortNum = "4", grid = false, col = ColType.col_6)
  private String script;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getScript() {
    return script;
  }

  public void setScript(String script) {
    this.script = script;
  }
}
