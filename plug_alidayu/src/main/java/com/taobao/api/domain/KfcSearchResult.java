package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;


/**
 * KFC 关键词过滤匹配结果
 *
 * @author top auto create
 * @since 1.0, null
 */
public class KfcSearchResult extends TaobaoObject {

	private static final long serialVersionUID = 2191769414312568754L;

	/**
	 * 过滤后的文本：
当匹配到B等级的词时，文本中的关键词被替换为*号，content即为关键词替换后的文本；
其他情况，content始终为null
	 */
	@ApiField("content")
	private String content;

	/**
	 * 匹配到的关键词的等级，值为null，或为A、B、C、D。
当匹配不到关键词时，值为null，否则值为A、B、C、D中的一个。
A、B、C、D等级按严重程度从高至低排列。
	 */
	@ApiField("level")
	private String level;

	/**
	 * 是否匹配到关键词,匹配到则为true.
	 */
	@ApiField("matched")
	private Boolean matched;


	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getLevel() {
		return this.level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	public Boolean getMatched() {
		return this.matched;
	}
	public void setMatched(Boolean matched) {
		this.matched = matched;
	}

}
