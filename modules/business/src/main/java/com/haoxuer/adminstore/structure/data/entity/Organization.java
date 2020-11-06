package com.haoxuer.adminstore.structure.data.entity;

import com.haoxuer.discover.data.entity.CatalogEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 组织架构（企业和部门）
 *
 * @author ada
 */
@Data
@Entity
@Table(name = "bs_org_data")
public class Organization extends CatalogEntity {

    public static Organization fromId(Integer id) {
        Organization result = new Organization();
        result.setId(id);
        return result;
    }

    /**
     * 父节点
     */
    @ManyToOne
    private Organization parent;

    /**
     * 数量
     */
    private Long num;

    /**
     * 3为部门 1为公司 2为集团
     */
    private Integer catalog;


    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Organization> children;

    @Override
    public Integer getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }

}
