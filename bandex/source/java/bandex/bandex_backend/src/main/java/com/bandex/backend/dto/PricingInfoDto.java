package com.bandex.backend.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PricingInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1338993739602654005L;
	/**
	 * 价格设置ID
	 */
	private Integer id;
	/**
	 * 地区ID
	 */
	private Integer regionId;
	/**
	 * 地区名称
	 */
	private String regionName;
	/**
	 * 车型ID
	 */
	private Integer carTypeId;
	/**
	 * 车型名称
	 */
	private String carTypeName;
	/**
	 * 起始价格
	 */
	private BigDecimal initPrice;
	/**
	 * 里程单价
	 */
	private BigDecimal unitPrice;
	/**
	 * 起始里程
	 */
	private BigDecimal initKm;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 创建时间
	 */
	private String createDatetime;

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getInitKm() {
		return initKm;
	}

	public void setInitKm(BigDecimal initKm) {
		this.initKm = initKm;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Integer getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(Integer carTypeId) {
		this.carTypeId = carTypeId;
	}

	public String getCarTypeName() {
		return carTypeName;
	}

	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}

	public BigDecimal getInitPrice() {
		return initPrice;
	}

	public void setInitPrice(BigDecimal initPrice) {
		this.initPrice = initPrice;
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
