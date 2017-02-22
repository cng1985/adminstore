package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Area;
import com.taobao.api.internal.mapping.ApiListField;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.areas.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class AreasGetResponse extends TaobaoResponse {

	private static final long serialVersionUID = 4142128173671778733L;

	/** 
	 * 地址区域信息列表.返回的Area包含的具体信息为入参fields请求的字段信息.
	 */
	@ApiListField("areas")
	@ApiField("area")
	private List<Area> areas;


	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}
	public List<Area> getAreas( ) {
		return this.areas;
	}
	


}
