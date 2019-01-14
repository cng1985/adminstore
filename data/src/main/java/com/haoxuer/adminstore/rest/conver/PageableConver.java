package com.haoxuer.adminstore.rest.conver;

import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.rest.core.Conver;
import com.haoxuer.discover.rest.base.RequestTokenPageObject;

public class PageableConver implements Conver<Pageable, RequestTokenPageObject> {
  @Override
  public Pageable conver(RequestTokenPageObject source) {
    Pageable result = new Pageable();
    result.setPageSize(source.getSize());
    result.setPageNo(source.getNo());
    return result;
  }
}
