package com.quhaodian.adminstore.rest.domain.simple;

import java.io.Serializable;

public class MemberSimple implements Serializable {


    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
