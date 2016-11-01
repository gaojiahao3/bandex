package com.bandex.apicenter.dto;

import com.bandex.apicenter.model.FriendApply;

import java.util.Date;

/**
 * Created by fanshuai on 16/10/30.
 */
public class FriendApplyDto {
    private Long id;

    private Long userId;
    private String userNickName;
    private String userIcon;

    private Long friendId;
    private String friendNickName;
    private String friendIcon;

    private Integer applyState;

    private Long createTime;

    private boolean isICreate = false;


    public static FriendApplyDto tranferToDto(FriendApply entity,String userNickName,String userIcon,String friendNickName,String friendIcon){
        FriendApplyDto dto = new FriendApplyDto();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setFriendId(entity.getFriendId());
        dto.setApplyState(entity.getApplyState());
        dto.setCreateTime(entity.getCreateTime().getTime());
        dto.setUserNickName(userNickName);
        dto.setUserIcon(userIcon);
        dto.setFriendNickName(friendNickName);
        dto.setFriendIcon(friendIcon);
        return dto;
    }

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

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public String getFriendNickName() {
        return friendNickName;
    }

    public void setFriendNickName(String friendNickName) {
        this.friendNickName = friendNickName;
    }

    public String getFriendIcon() {
        return friendIcon;
    }

    public void setFriendIcon(String friendIcon) {
        this.friendIcon = friendIcon;
    }

    public Integer getApplyState() {
        return applyState;
    }

    public void setApplyState(Integer applyState) {
        this.applyState = applyState;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public boolean isICreate() {
        return isICreate;
    }

    public void setICreate(boolean isICreate) {
        this.isICreate = isICreate;
    }
}
