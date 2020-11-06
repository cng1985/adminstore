package com.haoxuer.adminstore.article.data.entity;

import com.haoxuer.discover.data.entity.CatalogEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 文章分类
 * 
 * @author 年高
 *
 */
@Data
@Entity
@Table(name = "article_catalog")
public class ArticleCatalog extends CatalogEntity {

	/**
	 * 父节点
	 */
	@JoinColumn(name = "pid")
	@ManyToOne
	private ArticleCatalog parent;

	/**
	 * 数量
	 */
	private Long size;

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private List<ArticleCatalog> children;

	@Override
	public Integer getParentId() {
		if (parent != null) {
			return parent.getId();
		}
		return null;
	}


}
