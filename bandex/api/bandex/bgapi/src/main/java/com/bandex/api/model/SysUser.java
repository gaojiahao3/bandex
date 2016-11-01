package com.bandex.api.model;

import java.util.Date;

public class SysUser {
    private Long id;

    private String sysUserName;

    private String password;

    private Integer sysUserSex;

    private String sysUserTel;

    private String realName;

    private String email;

    private Integer sysUserState;

    private Integer sysUserType;

    private Date createTime;

    private Long createId;

    private Date modifyTime;

    private Long modifyId;

    private Integer deleteFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysUserName() {
        return sysUserName;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSysUserSex() {
        return sysUserSex;
    }

    public void setSysUserSex(Integer sysUserSex) {
        this.sysUserSex = sysUserSex;
    }

    public String getSysUserTel() {
        return sysUserTel;
    }

    public void setSysUserTel(String sysUserTel) {
        this.sysUserTel = sysUserTel;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSysUserState() {
        return sysUserState;
    }

    public void setSysUserState(Integer sysUserState) {
        this.sysUserState = sysUserState;
    }

    public Integer getSysUserType() {
        return sysUserType;
    }

    public void setSysUserType(Integer sysUserType) {
        this.sysUserType = sysUserType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getModifyId() {
        return modifyId;
    }

    public void setModifyId(Long modifyId) {
        this.modifyId = modifyId;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}