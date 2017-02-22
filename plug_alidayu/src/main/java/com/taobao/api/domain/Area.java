package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;


/**
 * 地址区域结构
 *
 * @author top auto create
 * @since 1.0, null
 */
public class Area extends TaobaoObject {

	private static final long serialVersionUID = 3514194831289177825L;

	/**
	 * 标准行政区域代码.参考:http://www.stats.gov.cn/tjbz/xzqhdm/t20120105_402777427.htm
	 */
	@ApiField("id")
	private Long id;

	/**
	 * 地域名称.如北京市,杭州市,西湖区,每一个area_id 都代表了一个具体的地区.
	 */
	@ApiField("name")
	private String name;

	/**
	 * 父节点区域标识.如北京市的area_id是110100,朝阳区是北京市的一个区,所以朝阳区的parent_id就是北京市的area_id.
	 */
	@ApiField("parent_id")
	private Long parentId;

	/**
	 * 区域类型.area区域 1:country/国家;2:province/省/自治区/直辖市;3:city/地区(省下面的地级市);4:district/县/市(县级市)/区;abroad:海外. 比如北京市的area_type = 2,朝阳区是北京市的一个区,所以朝阳区的area_type = 4.
	 */
	@ApiField("type")
	private Long type;

	/**
	 * 具体一个地区的邮编
	 */
	@ApiField("zip")
	private String zip;


	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return this.parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getType() {
		return this.type;
	}
	public void setType(Long type) {
		this.type = type;
	}

	public String getZip() {
		return this.zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

}
