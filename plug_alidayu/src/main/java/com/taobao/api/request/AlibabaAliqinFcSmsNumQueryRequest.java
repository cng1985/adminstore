package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.AlibabaAliqinFcSmsNumQueryResponse;

/**
 * TOP API: alibaba.aliqin.fc.sms.num.query request
 * 
 * @author top auto create
 * @since 1.0, 2016.03.01
 */
public class AlibabaAliqinFcSmsNumQueryRequest extends BaseTaobaoRequest<AlibabaAliqinFcSmsNumQueryResponse> {
	
	

	/** 
	* 短信发送流水
	 */
	private String bizId;

	/** 
	* 分页参数,页码
	 */
	private Long currentPage;

	/** 
	* 分页参数，每页数量。最大值50
	 */
	private Long pageSize;

	/** 
	* 短信发送日期，支持近30天记录查询，格式yyyyMMdd
	 */
	private String queryDate;

	/** 
	* 短信接收号码
	 */
	private String recNum;

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getBizId() {
		return this.bizId;
	}

	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}

	public Long getCurrentPage() {
		return this.currentPage;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getPageSize() {
		return this.pageSize;
	}

	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}

	public String getQueryDate() {
		return this.queryDate;
	}

	public void setRecNum(String recNum) {
		this.recNum = recNum;
	}

	public String getRecNum() {
		return this.recNum;
	}

	public String getApiMethodName() {
		return "alibaba.aliqin.fc.sms.num.query";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("biz_id", this.bizId);
		txtParams.put("current_page", this.currentPage);
		txtParams.put("page_size", this.pageSize);
		txtParams.put("query_date", this.queryDate);
		txtParams.put("rec_num", this.recNum);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<AlibabaAliqinFcSmsNumQueryResponse> getResponseClass() {
		return AlibabaAliqinFcSmsNumQueryResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(currentPage, "currentPage");
		RequestCheckUtils.checkNotEmpty(pageSize, "pageSize");
		RequestCheckUtils.checkNotEmpty(queryDate, "queryDate");
		RequestCheckUtils.checkNotEmpty(recNum, "recNum");
	}
	

}