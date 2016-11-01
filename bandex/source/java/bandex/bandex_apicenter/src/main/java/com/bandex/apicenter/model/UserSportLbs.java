package com.bandex.apicenter.model;

import java.util.Date;

public class UserSportLbs {
    private Long id;

    private Long eventId;

    private Long userSportId;

    private Long userId;

    private String xIndex;

    private String yIndex;

    private Date eventTime;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getUserSportId() {
        return userSportId;
    }

    public void setUserSportId(Long userSportId) {
        this.userSportId = userSportId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}