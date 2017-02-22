package com.tongna.adminstore.rest.domain.base;

/**
 * 令牌返回对象
 *
 * Created by ada on 2016/12/13.
 */
public class TokenVo extends  AbstractVo {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
