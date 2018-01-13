package com.sf.lottery.entity;

import com.github.pagehelper.Page;

/**
 * 分页信息类
 */
public class PageInfo {
	/** 当前页 */
	private int pageNum;
	/** 每页的数量 */
	private int pageSize;
	/** 总记录数 */
	private long total;
	/** 总页数 */
	private int pages;
	/** 结果集 */
	private Object[] result;

	public <T> PageInfo(Page<T> page) {
		this.pageNum = page.getPageNum();
		this.pageSize = page.getPageSize();
		this.total = page.getTotal();
		this.pages = page.getPages();
		this.result = page.toArray();
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public long getTotal() {
		return total;
	}

	public int getPages() {
		return pages;
	}

	public Object[] getResult() {
		return result;
	}

}
