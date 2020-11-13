package com.haoxuer.adminstore.member.data.entity;

import com.haoxuer.discover.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "bs_config")
public class Config extends AbstractEntity {
  
  @Column(length = 20)
  private String name;
  
  @Column(length = 18)
  private String phone;


}
