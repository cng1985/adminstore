package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.KfcSearchResult;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.kfc.keyword.search response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class KfcKeywordSearchResponse extends TaobaoResponse {

	private static final long serialVersionUID = 3611819672913962331L;

	/** 
	 * KFC 关键词过滤匹配结果
	 */
	@ApiField("kfc_search_result")
	private KfcSearchResult kfcSearchResult;


	public void setKfcSearchResult(KfcSearchResult kfcSearchResult) {
		this.kfcSearchResult = kfcSearchResult;
	}
	public KfcSearchResult getKfcSearchResult( ) {
		return this.kfcSearchResult;
	}
	


}
