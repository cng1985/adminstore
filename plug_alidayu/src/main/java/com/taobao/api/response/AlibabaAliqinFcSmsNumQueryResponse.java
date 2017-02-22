package com.taobao.api.response;

import java.util.Date;
import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;
import com.taobao.api.internal.mapping.ApiListField;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: alibaba.aliqin.fc.sms.num.query response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class AlibabaAliqinFcSmsNumQueryResponse extends TaobaoResponse {

	private static final long serialVersionUID = 7333553323948651312L;

	/** 
	 * 当前页码
	 */
	@ApiField("current_page")
	private Long currentPage;

	/** 
	 * 每页数量
	 */
	@ApiField("page_size")
	private Long pageSize;

	/** 
	 * 总量
	 */
	@ApiField("total_count")
	private Long totalCount;

	/** 
	 * 总页数
	 */
	@ApiField("total_page")
	private Long totalPage;

	/** 
	 * 1
	 */
	@ApiListField("values")
	@ApiField("fc_partner_sms_detail_dto")
	private List<FcPartnerSmsDetailDto> values;


	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}
	public Long getCurrentPage( ) {
		return this.currentPage;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
	public Long getPageSize( ) {
		return this.pageSize;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Long getTotalCount( ) {
		return this.totalCount;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public Long getTotalPage( ) {
		return this.totalPage;
	}

	public void setValues(List<FcPartnerSmsDetailDto> values) {
		this.values = values;
	}
	public List<FcPartnerSmsDetailDto> getValues( ) {
		return this.values;
	}
	
	/**
	 * 1
	 *
	 * @author top auto create
	 * @since 1.0, null
	 */
	public static class FcPartnerSmsDetailDto extends TaobaoObject {
		private static final long serialVersionUID = 5642231749767197513L;
		/**
		 * 公共回传参数
		 */
		@ApiField("extend")
		private String extend;
		/**
		 * 短信接收号码
		 */
		@ApiField("rec_num")
		private String recNum;
		/**
		 * 短信错误码
		 */
		@ApiField("result_code")
		private String resultCode;
		/**
		 * 模板编码
		 */
		@ApiField("sms_code")
		private String smsCode;
		/**
		 * 短信发送内容
		 */
		@ApiField("sms_content")
		private String smsContent;
		/**
		 * 短信接收时间
		 */
		@ApiField("sms_receiver_time")
		private Date smsReceiverTime;
		/**
		 * 短信发送时间
		 */
		@ApiField("sms_send_time")
		private Date smsSendTime;
		/**
		 * 发送状态 1：等待回执，2：发送失败，3：发送成功
		 */
		@ApiField("sms_status")
		private Long smsStatus;
	
		public String getExtend() {
			return this.extend;
		}
		public void setExtend(String extend) {
			this.extend = extend;
		}
		public String getRecNum() {
			return this.recNum;
		}
		public void setRecNum(String recNum) {
			this.recNum = recNum;
		}
		public String getResultCode() {
			return this.resultCode;
		}
		public void setResultCode(String resultCode) {
			this.resultCode = resultCode;
		}
		public String getSmsCode() {
			return this.smsCode;
		}
		public void setSmsCode(String smsCode) {
			this.smsCode = smsCode;
		}
		public String getSmsContent() {
			return this.smsContent;
		}
		public void setSmsContent(String smsContent) {
			this.smsContent = smsContent;
		}
		public Date getSmsReceiverTime() {
			return this.smsReceiverTime;
		}
		public void setSmsReceiverTime(Date smsReceiverTime) {
			this.smsReceiverTime = smsReceiverTime;
		}
		public Date getSmsSendTime() {
			return this.smsSendTime;
		}
		public void setSmsSendTime(Date smsSendTime) {
			this.smsSendTime = smsSendTime;
		}
		public Long getSmsStatus() {
			return this.smsStatus;
		}
		public void setSmsStatus(Long smsStatus) {
			this.smsStatus = smsStatus;
		}
	}
	


}
