package com.bandex.apicenter.model;

import java.util.Date;

public class UserAchievement {
    private Long id;

    private Long userId;

    private Long achieveId;

    private Date createTime;

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

    public Long getAchieveId() {
        return achieveId;
    }

    public void setAchieveId(Long achieveId) {
        this.achieveId = achieveId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}