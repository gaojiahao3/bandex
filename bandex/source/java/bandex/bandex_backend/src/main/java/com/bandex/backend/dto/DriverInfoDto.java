package com.bandex.backend.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DriverInfoDto implements Serializable {

	private static final long serialVersionUID = 3730857972695893094L;

	private Integer id;

	private String username;

	private String code;

	private Integer countryId;

	private String countryName;

	private Integer regionId;

	private String regionName;

	private Integer agentId;

	private String nationality;

	private String realname;

	private String sex;

	private String phone;

	private String avatar;

	private Integer carTypeId;

	private String carTypeName;

	private BigDecimal settlementRate;

	private BigDecimal carLength;

	private BigDecimal carMaxWeight;

	private String idcard;

	private String idcardImage;

	private String driverlicense;

	private String driverlicenseImage;

	private String drivinglicenseImage;

	private String carImage;

	private String status;

	private Integer createBy;

	private Date createDatetime;

	private Integer updateBy;

	private Date updateDatetime;

	private Date trainingApplyDatetime;

	private Date trainingPassDatetime;

	private String rejectReason;

	private String workStatus;

	private String pushToken;

	public String getCarTypeName() {
		return carTypeName;
	}

	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(Integer carTypeId) {
		this.carTypeId = carTypeId;
	}

	public BigDecimal getSettlementRate() {
		return settlementRate;
	}

	public void setSettlementRate(BigDecimal settlementRate) {
		this.settlementRate = settlementRate;
	}

	public BigDecimal getCarLength() {
		return carLength;
	}

	public void setCarLength(BigDecimal carLength) {
		this.carLength = carLength;
	}

	public BigDecimal getCarMaxWeight() {
		return carMaxWeight;
	}

	public void setCarMaxWeight(BigDecimal carMaxWeight) {
		this.carMaxWeight = carMaxWeight;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getIdcardImage() {
		return idcardImage;
	}

	public void setIdcardImage(String idcardImage) {
		this.idcardImage = idcardImage;
	}

	public String getDriverlicense() {
		return driverlicense;
	}

	public void setDriverlicense(String driverlicense) {
		this.driverlicense = driverlicense;
	}

	public String getDriverlicenseImage() {
		return driverlicenseImage;
	}

	public void setDriverlicenseImage(String driverlicenseImage) {
		this.driverlicenseImage = driverlicenseImage;
	}

	public String getDrivinglicenseImage() {
		return drivinglicenseImage;
	}

	public void setDrivinglicenseImage(String drivinglicenseImage) {
		this.drivinglicenseImage = drivinglicenseImage;
	}

	public String getCarImage() {
		return carImage;
	}

	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public Date getTrainingApplyDatetime() {
		return trainingApplyDatetime;
	}

	public void setTrainingApplyDatetime(Date trainingApplyDatetime) {
		this.trainingApplyDatetime = trainingApplyDatetime;
	}

	public Date getTrainingPassDatetime() {
		return trainingPassDatetime;
	}

	public void setTrainingPassDatetime(Date trainingPassDatetime) {
		this.trainingPassDatetime = trainingPassDatetime;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public String getPushToken() {
		return pushToken;
	}

	public void setPushToken(String pushToken) {
		this.pushToken = pushToken;
	}
}