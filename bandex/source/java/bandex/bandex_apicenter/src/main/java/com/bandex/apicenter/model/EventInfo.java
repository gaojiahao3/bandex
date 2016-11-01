package com.bandex.apicenter.model;

import java.util.Date;

public class EventInfo {
    private Long id;

    private String eventName;

    private String eventDescription;

    private Date eventStartTime;

    private Date eventEndTime;

    private Integer sportCategory;

    private Integer sportType;

    private Long sportId;

    private String sportName;

    private String startAddress;

    private Long productId;

    private Integer orderId;

    private String xIndex;

    private String yIndex;

    private Integer isPublic;

    private Long userId;

    private Date createTime;

    private Date modifyTime;

    private Integer deleteFlag;

    private Integer eventState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(Date eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public Date getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(Date eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public Integer getSportCategory() {
        return sportCategory;
    }

    public void setSportCategory(Integer sportCategory) {
        this.sportCategory = sportCategory;
    }

    public Integer getSportType() {
        return sportType;
    }

    public void setSportType(Integer sportType) {
        this.sportType = sportType;
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

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getxIndex() {
        return xIndex;
    }

    public void setxIndex(String xIndex) {
        this.xIndex = xIndex;
    }

    public String getyIndex() {
        return yIndex;
    }

    public void setyIndex(String yIndex) {
        this.yIndex = yIndex;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Integer getEventState() {
        return eventState;
    }

    public void setEventState(Integer eventState) {
        this.eventState = eventState;
    }
}