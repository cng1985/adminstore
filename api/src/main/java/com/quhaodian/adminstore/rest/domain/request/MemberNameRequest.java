package com.quhaodian.adminstore.rest.domain.request;

import com.haoxuer.discover.rest.base.RequestTokenPageObject;
import com.haoxuer.discover.rest.base.RequestUserTokenObject;

public class MemberNameRequest extends RequestTokenPageObject {
  
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
