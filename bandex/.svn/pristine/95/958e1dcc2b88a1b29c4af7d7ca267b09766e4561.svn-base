package com.bandex.api.dto;

import com.bandex.api.enums.RestResultEnum;

import java.io.Serializable;

public class ApiResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1390658031289975172L;

	private RestResultEnum returnEnum;
	private Integer total;
	private T record;

	public ApiResponse(RestResultEnum _returnEnum) {
		this.returnEnum = _returnEnum;
	}

	public ApiResponse(RestResultEnum _returnEnum, Integer _total, T _record) {
		this.returnEnum = _returnEnum;
		this.total = _total;
		this.record = _record;
	}

	public RestResultEnum getReturnEnum() {
		return returnEnum;
	}

	public void setReturnEnum(RestResultEnum returnEnum) {
		this.returnEnum = returnEnum;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public T getRecord() {
		return record;
	}

	public void setRecord(T record) {
		this.record = record;
	}

}
