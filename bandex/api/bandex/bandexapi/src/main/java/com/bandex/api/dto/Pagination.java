package com.bandex.api.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Pagination<E> implements Serializable {
	private static final long serialVersionUID = -4107386542783484429L;

	/**
	 * 数据列表
	 */
	@SerializedName("rows")
	private List<E> data;

	/**
	 * 用于页面入参：表示当前页码（默认页码从1开始）
	 */
	private long page = 1;

	/**
	 * 用于页面入参：表示每页显示多少条记录（默认10条）
	 */
	@SerializedName("pageSize")
	private long rows =10;

	/**
	 * 表示总共搜索到多少条记录
	 */
	@SerializedName("total")
	private long numFound;

	/**
	 * 表示总共有多少页
	 */
	private long totalPages;

	/**
	 * 用于数据库分页：表示从哪一条记录开始分页
	 */
	private long startIndex = 0;

	/**
	 * 用于数据库分页：表示到哪一条记录结束
	 */
	private long endIndex;

	private String sort;

	public Pagination() {
	}

	/**
	 * 
	 * @param page
	 *            当前页码，默认每页10条
	 * @author daniel
	 */
	public Pagination(long page) {
		this.page = page;
	}

	/**
	 * 
	 * @param page
	 *            当前页码
	 * @param rows
	 *            每页多少条
	 * @author daniel
	 */
	public Pagination(long page, long rows) {
		this.page = page;
		this.rows = rows;
	}

	public long getRows() {
		return rows;
	}

	public void setrows(long rows) {
		this.rows = rows;
	}

	public long getNumFound() {
		return numFound;
	}

	public void setNumFound(long numFound) {
		this.numFound = numFound;
	}

	public long getTotalPages() {
		if (this.numFound < this.rows) {
			this.totalPages = 1;
		} else {
			if (this.numFound % this.rows == 0) {
				this.totalPages = this.numFound / this.rows;
			} else {
				this.totalPages = (this.numFound / this.rows) + 1;
			}
		}
		return totalPages;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public long getPage() {
		// if (this.startIndex % this.rows != 0) {
		// this.startIndex = this.startIndex - 1;
		// }
		// if (this.startIndex < this.rows) {
		// this.curPage = 1;
		// } else {
		// this.curPage = (this.startIndex / this.rows) + 1;
		// }
		return page;
	}

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

	public long getStartIndex() {
		startIndex = (this.getPage() - 1) * this.getRows();
		return startIndex;
	}

	public long getEndIndex() {
		endIndex = this.getPage() * this.getRows();
		return endIndex;
	}

	/**
	 * 放入总记录条数和数据
	 * 
	 * @param count
	 *            总记录条数
	 * @param data
	 *            数据
	 * @author Henry
	 */
	public void putData(Long count, List<E> data) {
		this.setNumFound(count);
		this.setData(data);
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}
