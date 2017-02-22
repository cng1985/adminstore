package com.tongna.adminstore.rest.domain.base;

import java.util.List;

/**
 * Created by ada on 2016/12/12.
 */
public class AbstractListVo<T> extends  AbstractVo {

    /**
     * 数据集合
     */
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
