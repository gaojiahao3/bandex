package com.bandex.apicenter.model;

import java.util.Date;

public class UserIntegrationDetail {
    private Long id;

    private Long userId;

    private Integer integralNum;

    private Integer integralType;

    private Integer integralFrom;

    private Long fromId;

    private String remark;

    private Integer integralBefore;

    private Integer integralAfter;

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

    public Integer getIntegralNum() {
        return integralNum;
    }

    public void setIntegralNum(Integer integralNum) {
        this.integralNum = integralNum;
    }

    public Integer getIntegralType() {
        return integralType;
    }

    public void setIntegralType(Integer integralType) {
        this.integralType = integralType;
    }

    public Integer getIntegralFrom() {
        return integralFrom;
    }

    public void setIntegralFrom(Integer integralFrom) {
        this.integralFrom = integralFrom;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIntegralBefore() {
        return integralBefore;
    }

    public void setIntegralBefore(Integer integralBefore) {
        this.integralBefore = integralBefore;
    }

    public Integer getIntegralAfter() {
        return integralAfter;
    }

    public void setIntegralAfter(Integer integralAfter) {
        this.integralAfter = integralAfter;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}