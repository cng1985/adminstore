package com.quhaodian.adminstore.rest.domain.simple;

import java.io.Serializable;

public class AdSimple implements Serializable{

    private Long id;

    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
