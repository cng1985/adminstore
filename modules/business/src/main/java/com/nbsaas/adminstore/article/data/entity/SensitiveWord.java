package com.nbsaas.adminstore.article.data.entity;

import com.haoxuer.discover.config.data.entity.User;
import com.haoxuer.discover.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * 敏感词
 * 
 * @author 年高
 *
 */
@Data
@Entity
@Table(name = "article_sensitive_word")
public class SensitiveWord extends AbstractEntity {

	/**
	 * 敏感词
	 */
	private String word;

	/**
	 * 替换词
	 */
	@Column(name="replace_word")
	private String replace;

	/**
	 * 分类
	 */
	private Integer catalog;

	/**
	 * 用户
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	/**
	 * 相关类容一共有多少个敏感词
	 */
	@Column(name="word_size")
	private Integer size;

	
	
	/**
	 * 敏感词分类
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private SensitiveCategory category;


}
