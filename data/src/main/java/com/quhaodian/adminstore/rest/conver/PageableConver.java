package com.quhaodian.adminstore.rest.conver;

import com.quhaodian.data.page.Pageable;
import com.quhaodian.data.rest.core.Conver;
import com.quhaodian.discover.rest.base.RequestTokenPageObject;

public class PageableConver implements Conver<Pageable, RequestTokenPageObject> {
    @Override
    public Pageable conver(RequestTokenPageObject source) {
        Pageable result = new Pageable();
        result.setSize(source.getSize());
        result.setNo(source.getNo());
        return result;
    }
}
