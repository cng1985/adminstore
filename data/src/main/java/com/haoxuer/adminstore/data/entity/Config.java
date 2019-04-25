package com.haoxuer.adminstore.data.entity;

import com.haoxuer.discover.data.entity.AbstractEntity;
import com.haoxuer.discover.trade.data.entity.TradeAccount;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bs_config")
public class Config extends AbstractEntity {
  
  @Column(length = 20)
  private String name;
  
  @Column(length = 18)
  private String phone;

  @ManyToOne(fetch = FetchType.LAZY)
  private TradeAccount account;
  
}
