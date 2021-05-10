/*
 * 
 * 
 * 
 */
package com.haoxuer.adminstore.ad.data.entity;

import com.haoxuer.discover.data.entity.SortEntity;
import com.nbsaas.codemake.annotation.*;
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
@ComposeView
@FormAnnotation(title = "广告位管理",model = "广告位",menu = "1,51,52")
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
	@FormField(title = "标识", sortNum = "10", grid = true,required = true,col = 22)
	@Column(length = 30,name = "data_key")
	private String key;

	@SearchItem(label = "广告位",name = "name")
	@FormField(title = "广告位",sortNum = "10",grid = true,required = true,col = 22)
	@Column(nullable = false)
	private String name;

	/** 宽度 */

	@FormField(title = "宽度",sortNum = "20",grid = true,type = InputType.el_input_number,col = 22)
	@Column(nullable = false)
	private Integer width;

	/** 高度 */
	@FormField(title = "高度",sortNum = "30",grid = true,type = InputType.el_input_number,col = 22)
	@Column(nullable = false)
	private Integer height;

	/** 描述 */
	@FormField(title = "备注",sortNum = "40",grid = true,type = InputType.textarea,width = "1000",col = 22)
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