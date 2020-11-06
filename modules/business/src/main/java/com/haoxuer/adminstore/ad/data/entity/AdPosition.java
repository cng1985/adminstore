/*
 * 
 * 
 * 
 */
package com.haoxuer.adminstore.ad.data.entity;

import com.haoxuer.discover.data.entity.CatalogEntity;
import com.haoxuer.discover.data.entity.SortEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity - 广告位
 * 
 * 
 * 
 */
@Data
@Entity
@Table(name = "bs_basic_ad_position")
public class AdPosition extends SortEntity {

	public AdPosition(){
		width=1;
		height=1;
		template="";
	}
	/** 名称 */
	@Column(nullable = false)
	private String name;

	/** 宽度 */
	@Column(nullable = false)
	private Integer width;

	/** 高度 */
	@Column(nullable = false)
	private Integer height;

	/** 描述 */
	private String description;

	/** 模板 */
	@Lob
	@Column(nullable = false)
	private String template;

	@ManyToOne(fetch = FetchType.LAZY)
	private AdPosition parent;


	/** 广告 */
	@OneToMany(mappedBy = "adPosition", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@OrderBy("adPosition asc")
	private Set<Ad> ads = new HashSet<Ad>();


}