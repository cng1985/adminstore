package com.nbsaas.adminstore.ad.data.enums;



/**
 * 类型
 */
public enum AdType {

	/** 文本 */
	text,

	/** 图片 */
	image,

	/** flash */
	flash,

	/**
	 * 在线图片地址
	 */
	online;


	@Override
	public String toString() {
		if (name().equals("text")){
			return "文本广告";
		}
		else if (name().equals("image")){
			return "图片广告";

		}
		else if (name().equals("flash")){
			return "flash广告";

		}
		else if (name().equals("online")){
			return "在线图片广告";

		}
		return super.toString();
	}
}
