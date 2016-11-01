package com.bandex.api.dto;

import java.io.Serializable;

public class ApiFinalResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3747150192343646103L;

	private String functioncode;
	private String version;
	private Boolean isSuccess;
	private String code;
	private String msg;
	private Integer total;
	private T record;

	public String getFunctioncode() {
		return functioncode;
	}

	public void setFunctioncode(String functioncode) {
		this.functioncode = functioncode;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	// public T getModelMap() {
	// return modelMap;
	// }
	//
	// public void setModelMap(T modelMap) {
	// this.modelMap = modelMap;
	// }

}
