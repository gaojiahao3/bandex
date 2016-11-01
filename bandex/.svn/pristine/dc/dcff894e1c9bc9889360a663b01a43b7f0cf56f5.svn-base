package com.bandex.apicenter.appapi.impl;

import com.bandex.apicenter.appapi.UserGroupApi;
import com.bandex.apicenter.dao.UserGroupMapper;
import com.bandex.apicenter.dao.UserGroupRefMapper;
import com.bandex.apicenter.dao.UserInfoMapper;
import com.bandex.apicenter.model.UserGroup;
import com.bandex.apicenter.model.UserGroupRef;
import com.bandex.apicenter.model.UserInfo;
import com.bandex.apicenter.service.impl.BaseServiceImpl;
import com.bandex.base.annotations.ApiMethod;
import com.bandex.base.annotations.ApiParam;
import com.bandex.base.annotations.ApiService;
import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;
import com.bandex.base.enums.ApiMsgEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fanshuai on 16/10/31.
 */
@Service
@ApiService(descript = "用户群组API")
public class UserGroupApiImpl extends BaseServiceImpl implements UserGroupApi {
    @Autowired
    private UserGroupMapper userGroupMapper;

    @Autowired
    private UserGroupRefMapper userGroupRefMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @ApiMethod(needLogin = true,descript = "创建分组", value = "userGroup-create", apiParams = {@ApiParam(name = "user_token",descript = "当前用户token(*)") ,
            @ApiParam(name = "groupName",descript = "组名(*)"),
            @ApiParam(name = "groupPic",descript = "图标(*)"),
            @ApiParam(name = "groupDesc",descript = "描述(*)")})
    @Override
    public ApiResponse createFriendGroup(ApiRequest apiReq) {
        Long userId=apiReq.getCurrentUserId();
        String name = apiReq.getString("groupName");
        String pic = apiReq.getString("groupPic");
        String des = apiReq.getString("groupDesc");
        UserGroup userGroup = new UserGroup();
        userGroupMapper.insert(userGroup);
        userGroup.setUserId(userId);
        userGroup.setGroupName(name);
        userGroup.setGroupPic(pic);
        userGroup.setGroupDes(des);
        return new ApiResponse(ApiMsgEnum.SUCCESS);
    }
    @ApiMethod(needLogin = true,descript = "分组列表", value = "userGroup-list", apiParams = {@ApiParam(name = "user_token",descript = "当前用户token(*)")   })
    @Override
    public ApiResponse friendGroupList(ApiRequest apiReq) {
        Long userId = apiReq.getCurrentUserId();
        List<UserGroup> myGroups = userGroupMapper.selectUserGroupByUserId(userId);
        List<Long> groupIdList = userGroupRefMapper.selectUserGroupIdByUserId(userId);
        List<UserGroup> applyedGroups = userGroupMapper.selectUserGroupByGroupIdList(groupIdList);
        Map retMap = new HashMap();
        retMap.put("myGroups",myGroups);
        retMap.put("applyedGroups",applyedGroups);
        return new ApiResponse(ApiMsgEnum.SUCCESS,1,retMap);

    }

    @ApiMethod(needLogin = true,descript = "分组邀请好友", value = "userGroup-invite", apiParams = {@ApiParam(name = "user_token",descript = "当前用户token(*)"),
            @ApiParam(name = "groupId",descript = "分组id(*)"),
            @ApiParam(name = "userIdList",descript = "邀请的好友id列表逗号间隔(*)")})
    @Override
    public ApiResponse friendGroupInviteUsers(ApiRequest apiReq) {
        Long userId=apiReq.getCurrentUserId();
        Long groupId=apiReq.getLong("groupId");
        UserGroup userGroup=userGroupMapper.selectByPrimaryKey(groupId);
        if (userGroup==null||userGroup.getUserId()!=userId){
            new ApiResponse<>(ApiMsgEnum.FAIL);
        }
        List<Long> userIdList = apiReq.getLongList("userIdList");
        List<UserInfo> userInfos = userInfoMapper.queryUserIdList(userIdList);
        for (UserInfo userInfo:userInfos){
            UserGroupRef ref = new UserGroupRef();
            ref.setGroupId(groupId);
            ref.setUserId(userInfo.getUserId());
            ref.setUserIcon(userInfo.getUserIcon());
            ref.setNickName(userInfo.getNickName());
            userGroupRefMapper.insert(ref);
        }
        return null;
    }

    @ApiMethod(needLogin = true,descript = "接受分组邀请", value = "userGroup-invite-accept", apiParams = {@ApiParam(name = "user_token",descript = "当前用户token(*)") ,
            @ApiParam(name = "groupId",descript = "分组id(*)")})
    @Override
    public ApiResponse friendGroupAcceptInvite(ApiRequest apiReq) {
        Long userId=apiReq.getCurrentUserId();
        Long groupId=apiReq.getLong("groupId");
        int updateCount = userGroupRefMapper.updateIsAgree(userId,groupId,1);
        if (updateCount>0){
            return new ApiResponse(ApiMsgEnum.SUCCESS);
        }
        return new ApiResponse(ApiMsgEnum.FAIL);
    }
    @ApiMethod(needLogin = true,descript = "拒绝分组邀请", value = "userGroup-invite-reject", apiParams = {@ApiParam(name = "user_token",descript = "当前用户token(*)"),
            @ApiParam(name = "groupId",descript = "分组id(*)")})
    @Override
    public ApiResponse friendGroupRejectInvite(ApiRequest apiReq) {
        Long userId=apiReq.getCurrentUserId();
        Long groupId=apiReq.getLong("groupId");
        int updateCount = userGroupRefMapper.updateIsAgree(userId,groupId,2);
        if (updateCount>0){
            return new ApiResponse(ApiMsgEnum.SUCCESS);
        }
        return new ApiResponse(ApiMsgEnum.FAIL);
    }
}
