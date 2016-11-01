package com.bandex.backend.dto;

import java.io.Serializable;

public class CarTypeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4584085827028450987L;
	/**
	 * 车型ID
	 */
	private Integer id;
	/**
	 * 车型名称
	 */
	private String name;
	/**
	 * 长宽
	 */
	private String widthLength;
	/**
	 * 载重
	 */
	private String maxWeight;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 创建时间
	 */
	private String createDatetime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWidthLength() {
		return widthLength;
	}

	public void setWidthLength(String widthLength) {
		this.widthLength = widthLength;
	}

	public String getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(String maxWeight) {
		this.maxWeight = maxWeight;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}

}
