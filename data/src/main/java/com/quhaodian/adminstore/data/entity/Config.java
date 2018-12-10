package com.quhaodian.adminstore.data.entity;

import com.haoxuer.discover.data.entity.AbstractEntity;
import com.haoxuer.discover.trade.data.entity.TradeAccount;

import javax.persistence.*;

@Entity
@Table(name = "bs_config")
public class Config extends AbstractEntity {
  
  @Column(length = 20)
  private String name;
  
  @Column(length = 18)
  private String phone;

  @ManyToOne(fetch = FetchType.LAZY)
  private TradeAccount account;
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getPhone() {
    return phone;
  }
  
  public void setPhone(String phone) {
    this.phone = phone;
  }

  public TradeAccount getAccount() {
    return account;
  }

  public void setAccount(TradeAccount account) {
    this.account = account;
  }
}
