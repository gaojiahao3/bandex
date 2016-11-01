package com.bandex.backend.dto;

import java.io.Serializable;

public class OrderHubListDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7703831956898196885L;
	/**
	 * 中转站名称
	 */
	private String hubPlace;
	/**
	 * 中转站序号
	 */
	private Integer hubOrder;

	public String getHubPlace() {
		return hubPlace;
	}

	public void setHubPlace(String hubPlace) {
		this.hubPlace = hubPlace;
	}

	public Integer getHubOrder() {
		return hubOrder;
	}

	public void setHubOrder(Integer hubOrder) {
		this.hubOrder = hubOrder;
	}

}
