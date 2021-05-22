package com.nbsaas.adminstore.structure.data.entity;

import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.entity.CatalogEntity;
import com.nbsaas.codemake.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 组织架构（企业和部门）
 *
 * @author ada
 */
@CatalogClass
@FormAnnotation(title = "组织架构管理",model = "组织架构",menu = "1,27,54")
@Data
@Entity
@Table(name = "sys_structure")
public class Organization extends CatalogEntity {

    public static Organization fromId(Integer id) {
        Organization result = new Organization();
        result.setId(id);
        return result;
    }

    /**
     * 父节点
     */
    @FiledConvert(classType = "Integer")
    @FiledName
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

    @FormField(title = "备注", sortNum = "2", grid = true, col = 22)
    private String note;


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
