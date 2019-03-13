package com.haoxuer.adminstore.rest.domain.response;

import com.haoxuer.discover.rest.base.ResponseObject;

public class MemberResponse extends ResponseObject {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
