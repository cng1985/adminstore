package com.tongna.adminstore.rest.domain.base;

public class AbstractPageVo<T> extends AbstractListVo<T> {



	/**
	 * 第几页
	 */
	private int page;

	/**
	 * 分页大小
	 */
	private int size;

	/**
	 * 总量
	 */
	private int total;

	/**
	 * 总共有多少页
	 */
	private int totalPage;


	public int getPage() {
		return page;
	}

	public int getSize() {
		return size;
	}

	public int getTotal() {
		return total;
	}

	public int getTotalPage() {
		return totalPage;
	}


	public void setPage(int page) {
		this.page = page;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return "PageVo [page=" + page + ", size=" + size + ", total=" + total + ", totalPage=" + totalPage
				+ ", toString()=" + super.toString() + "]";
	}

}
