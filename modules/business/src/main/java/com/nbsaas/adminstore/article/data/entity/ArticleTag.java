package com.nbsaas.adminstore.article.data.entity;

import com.haoxuer.discover.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 文章标签
 * 
 * @author 年高
 *
 */
@Data
@Entity
@Table(name = "article_tag")
public class ArticleTag extends AbstractEntity {


	private String name;

	private Integer size;
}
