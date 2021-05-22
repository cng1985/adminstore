package com.nbsaas.adminstore.member.data.so;

import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import java.io.Serializable;

/**
 * Created by imake on 2017年08月29日17:08:12.
 */
public class MemberSo implements Serializable {

  @Search(name = "name", operator = Filter.Operator.like)
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
