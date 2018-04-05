package com.quhaodian.adminstore.rest.domain.request;

import com.quhaodian.discover.rest.base.RequestUserTokenPageObject;

public class PageRequest extends RequestUserTokenPageObject {

    private Long app;

    public Long getApp() {
        return app;
    }

    public void setApp(Long app) {
        this.app = app;
    }
}
