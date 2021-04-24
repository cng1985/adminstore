package com.haoxuer.adminstore.common.data.entity;

import com.haoxuer.discover.data.entity.AbstractEntity;
import com.nbsaas.codemake.annotation.ComposeView;
import com.nbsaas.codemake.annotation.FormAnnotation;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@ComposeView
@FormAnnotation(title = "配置管理", model= "配置", menu = "1,20,21")
@Data
@Entity
@Table(name = "bs_config")
public class StoreConfig extends AbstractEntity {
  
  @Column(length = 20)
  private String name;
  
  @Column(length = 18)
  private String phone;


}
