/*
 * 
 * 
 * 
 */
package com.haoxuer.adminstore.ad.data.entity;

import com.haoxuer.discover.data.annotations.FormAnnotation;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.data.annotations.InputType;
import com.haoxuer.discover.data.entity.CatalogEntity;
import com.haoxuer.discover.data.entity.SortEntity;
import com.haoxuer.imake.annotation.SearchItem;
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
@FormAnnotation(list = "广告位管理")
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

	@SearchItem(label = "标识",name = "key")
	@FormFieldAnnotation(title = "标识", sortNum = "10", grid = true,required = true)
	@Column(length = 30,name = "data_key")
	private String key;

	@SearchItem(label = "广告位",name = "name")
	@FormFieldAnnotation(title = "广告位",sortNum = "10",grid = true,required = true)
	@Column(nullable = false)
	private String name;

	/** 宽度 */

	@FormFieldAnnotation(title = "宽度",sortNum = "20",grid = true,type = InputType.el_input_number)
	@Column(nullable = false)
	private Integer width;

	/** 高度 */
	@FormFieldAnnotation(title = "高度",sortNum = "30",grid = true,type = InputType.el_input_number)
	@Column(nullable = false)
	private Integer height;

	/** 描述 */
	@FormFieldAnnotation(title = "备注",sortNum = "40",grid = true,type = InputType.textarea)
	private String note;

	/** 模板 */
	@Lob
	@Column(nullable = false)
	private String template;

	/** 广告 */
	@OneToMany(mappedBy = "adPosition", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@OrderBy("adPosition asc")
	private Set<Ad> ads = new HashSet<Ad>();


}