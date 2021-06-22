package com.nbsaas.adminstore.member.data.entity;


import com.nbsaas.codemake.annotation.FormAnnotation;
import com.haoxuer.discover.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@FormAnnotation(title = "错误日志")
@Entity
@Table(name = "bs_exception_log")
public class ExceptionLog extends AbstractEntity {
  
  @Column(length = 50)
  private String name;
  
  @Column(length = 65536)
  private String note;
  
  private String url;
  
  private String params;
  
}
