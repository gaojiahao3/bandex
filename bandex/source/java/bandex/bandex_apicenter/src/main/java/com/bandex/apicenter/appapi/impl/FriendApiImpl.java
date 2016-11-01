package com.bandex.apicenter.appapi.impl;

import com.bandex.apicenter.appapi.FriendApi;
import com.bandex.apicenter.dao.UserFriendMapper;
import com.bandex.apicenter.dao.UserInfoMapper;
import com.bandex.apicenter.model.UserFriend;
import com.bandex.apicenter.model.UserInfo;
import com.bandex.apicenter.service.impl.BaseServiceImpl;
import com.bandex.base.annotations.ApiMethod;
import com.bandex.base.annotations.ApiParam;
import com.bandex.base.annotations.ApiService;
import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;
import com.bandex.base.enums.ApiMsgEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Thinkpad on 2016/10/29.
 */
@Service
@ApiService(descript = "用户好友API")
public class FriendApiImpl extends BaseServiceImpl implements FriendApi {

    @Autowired
    private UserFriendMapper userFriendMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @ApiMethod(needLogin = true,descript = "获取好友列表", value = "friend-list", apiParams = {@ApiParam(name = "user_token",descript = "当前用户token(*)"),@ApiParam(name = "searchKey",descript = "好友搜索关键字(*)")   })
    @Override
    public ApiResponse myFriendList(ApiRequest apiReq) {
        Long userId = apiReq.getCurrentUserId();
        String searchKey=apiReq.getString("searchKey");
        List<Long> friendUserIdList=userFriendMapper.queryFriendUserIdByUserId(userId);
        if (CollectionUtils.isEmpty(friendUserIdList)){
            return new ApiResponse(ApiMsgEnum.SUCCESS);
        }
        List<UserInfo> userInfos=userInfoMapper.queryUserInfoByUserIdList(friendUserIdList,searchKey,getPageIndex(apiReq),getAppPageSize(apiReq));
        if (CollectionUtils.isEmpty(userInfos)){
            return new ApiResponse(ApiMsgEnum.SUCCESS);
        }
        List<Map> userInfoList = new ArrayList<>();
        for (UserInfo userInfo : userInfos){
            Map user =  new HashMap();
            user.put("userId",userInfo.getUserId());
            user.put("nickName",userInfo.getNickName());
            user.put("userIcon",this.getUserIcon(this.getCdnUrl(null,userInfo.getUserIcon(),null)));
            userInfoList.add(user);
        }
        return new ApiResponse(ApiMsgEnum.SUCCESS,1,userInfoList);
    }

    @ApiMethod(needLogin = true,descript = "删除好友", value = "friend-delete", apiParams = {@ApiParam(name = "user_token",descript = "当前用户token(*)"),@ApiParam(name = "friendUserId",descript = "删除的好友id(*)")   })
    @Override
    public ApiResponse deleteFriend(ApiRequest apiReq) {
        Long userId = apiReq.getCurrentUserId();
        Long friendUserId=apiReq.getLong("friendUserId");
        int deteleedNum = userFriendMapper.deleteUserFriend(userId,friendUserId);
        return new ApiResponse(ApiMsgEnum.SUCCESS);
    }
}
