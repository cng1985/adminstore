package com.tongna.adminstore.rest.domain.base;

import java.io.Serializable;

/**
 * Created by ada on 2016/12/12.
 */
public class TokenDto implements Serializable {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
