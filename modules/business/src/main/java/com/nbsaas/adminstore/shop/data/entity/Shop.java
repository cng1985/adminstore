package com.nbsaas.adminstore.shop.data.entity;

import com.haoxuer.discover.data.entity.AbstractEntity;
import com.haoxuer.discover.data.enums.StoreState;
import com.nbsaas.codemake.annotation.ComposeView;
import com.nbsaas.codemake.annotation.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


@ComposeView
@Data
@FormAnnotation(title = "用户", model = "添加用户",menu = "更新用户")
@Entity
@Table(name = "user_info")
public class Shop extends AbstractEntity {

    private StoreState storeState;

    private String name;
}
