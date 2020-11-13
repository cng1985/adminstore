package com.haoxuer.adminstore.article.data.entity;

import com.haoxuer.discover.config.data.entity.User;
import com.haoxuer.discover.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 文章评论
 * 
 * @author 年高
 *
 */
@Data
@Entity
@Table(name = "article_comment")
public class ArticleComment extends AbstractEntity {



	private String contents;


	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Article article;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;



}
