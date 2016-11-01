package com.bandex.apicenter.model;

import java.util.Date;

public class UserSportRef {
    private Long id;

    private Long userId;

    private Long eventId;

    private Long sportId;

    private String sportName;

    private String sportCode;

    private Integer sportType;

    private Integer sportCategory;

    private Integer sportState;

    private Date sprotStartTime;

    private Date sprotEndTime;

    private Double sprotHour;

    private Double sportDistance;

    private Date createTime;

    private Date modifyTime;

    private Integer deleteFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getSportCode() {
        return sportCode;
    }

    public void setSportCode(String sportCode) {
        this.sportCode = sportCode;
    }

    public Integer getSportType() {
        return sportType;
    }

    public void setSportType(Integer sportType) {
        this.sportType = sportType;
    }

    public Integer getSportCategory() {
        return sportCategory;
    }

    public void setSportCategory(Integer sportCategory) {
        this.sportCategory = sportCategory;
    }

    public Integer getSportState() {
        return sportState;
    }

    public void setSportState(Integer sportState) {
        this.sportState = sportState;
    }

    public Date getSprotStartTime() {
        return sprotStartTime;
    }

    public void setSprotStartTime(Date sprotStartTime) {
        this.sprotStartTime = sprotStartTime;
    }

    public Date getSprotEndTime() {
        return sprotEndTime;
    }

    public void setSprotEndTime(Date sprotEndTime) {
        this.sprotEndTime = sprotEndTime;
    }

    public Double getSprotHour() {
        return sprotHour;
    }

    public void setSprotHour(Double sprotHour) {
        this.sprotHour = sprotHour;
    }

    public Double getSportDistance() {
        return sportDistance;
    }

    public void setSportDistance(Double sportDistance) {
        this.sportDistance = sportDistance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}