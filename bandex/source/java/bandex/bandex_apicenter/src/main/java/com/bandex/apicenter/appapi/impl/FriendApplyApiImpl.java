package com.bandex.apicenter.appapi.impl;

import com.bandex.apicenter.appapi.FriendApi;
import com.bandex.apicenter.appapi.FriendApplyApi;
import com.bandex.apicenter.dao.FriendApplyMapper;
import com.bandex.apicenter.dao.UserFriendMapper;
import com.bandex.apicenter.dao.UserInfoMapper;
import com.bandex.apicenter.dto.FriendApplyDto;
import com.bandex.apicenter.model.FriendApply;
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
import java.util.Date;
import java.util.List;

/**
 * Created by fanshuai on 16/10/30.
 */
@Service
@ApiService(descript = "用户邀请相关API")
public class FriendApplyApiImpl extends BaseServiceImpl implements FriendApplyApi {

    @Autowired
    private FriendApplyMapper friendApplyMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserFriendMapper userFriendMapper;

    @ApiMethod(needLogin = true,descript = "好友申请列表", value = "friend-apply-list", apiParams = {@ApiParam(name = "user_token",descript = "当前用户token(*)")  })
    @Override
    public ApiResponse applyList(ApiRequest apiReq) {
        Long userId=apiReq.getCurrentUserId();
        List<FriendApply> friendApplyList=friendApplyMapper.queryByUserId(userId, getPageIndex(apiReq), getAppPageSize(apiReq));
        if (CollectionUtils.isEmpty(friendApplyList)){
            return new ApiResponse(ApiMsgEnum.SUCCESS);
        }
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        //如果是我发出的申请，未接受，提示等待验证
        //如果是我发出的申请，已经授受，提示已添加
        //如果是我发出的申请，已经拒绝，提示被拒绝
        //如果是邀请我，未接受，提示授受按钮
        //如果是邀请我已经接受，提示已添加
        //如果是邀请我已经拒绝，提示我已拒绝
        List<FriendApplyDto> friendApplyDtoList=new ArrayList<>();
        for (FriendApply friendApply:friendApplyList){
            UserInfo friendInfo = null;
            FriendApplyDto dto=null;
            if (friendApply.getUserId()==userId){
                //我申请的
                friendInfo = userInfoMapper.selectByPrimaryKey(friendApply.getFriendId());
                dto=FriendApplyDto.tranferToDto(friendApply,userInfo.getNickName(),this.getCdnUrl(null,userInfo.getUserIcon(),null),friendInfo.getNickName(),this.getCdnUrl(null,friendInfo.getUserIcon(),null));
                dto.setICreate(true);
            }
            if (friendApply.getFriendId()==userId){
                //我被邀请的
                friendInfo = userInfoMapper.selectByPrimaryKey(friendApply.getUserId());
                dto=FriendApplyDto.tranferToDto(friendApply,friendInfo.getNickName(),this.getCdnUrl(null,friendInfo.getUserIcon(),null),userInfo.getNickName(),this.getCdnUrl(null,userInfo.getUserIcon(),null));
                dto.setICreate(false);
            }
            friendApplyDtoList.add(dto);
        }
        return new ApiResponse(ApiMsgEnum.SUCCESS,1,friendApplyDtoList);
    }

    @ApiMethod(needLogin = true,descript = "好友申请的详细内容", value = "friend-apply-detail", apiParams = {@ApiParam(name = "user_token",descript = "当前用户token(*)"),@ApiParam(name = "applyId",descript = "好友申请的id(*)")   })
    @Override
    public ApiResponse applyDetail(ApiRequest apiReq) {
        return null;
    }

    @ApiMethod(needLogin = true,descript = "提交添加好友申请", value = "friend-apply-new", apiParams = {@ApiParam(name = "user_token",descript = "当前用户token(*)"),@ApiParam(name = "friendId",descript = "好友用户Id(*)")   })
    @Override
    public ApiResponse applyToFriend(ApiRequest apiReq) {
        Long userId=apiReq.getCurrentUserId();
        Long friendId=apiReq.getLong("friendId");
        UserInfo friendUserInfo=userInfoMapper.selectByPrimaryKey(friendId);
        if (friendUserInfo==null){
            return new ApiResponse(ApiMsgEnum.UserDosentExist);
        }
        List<UserFriend> userFriends=userFriendMapper.queryFriendUserIdByUserIdFriendId(userId, friendId);
        if (!CollectionUtils.isEmpty(userFriends)){
            return new ApiResponse(ApiMsgEnum.SUCCESS);
        }
        List<FriendApply> friendApplyList=friendApplyMapper.queryNotAcceptApplyByUserIdAndFriendId(userId, friendId);
        if (CollectionUtils.isEmpty(friendApplyList)){
            FriendApply friendApply = new FriendApply();
            friendApply.setUserId(userId);
            friendApply.setFriendId(friendId);
            friendApply.setModifyTime(new Date());
            friendApplyMapper.insert(friendApply);
        }
        return new ApiResponse(ApiMsgEnum.SUCCESS);
    }

    @ApiMethod(needLogin = true,descript = "拒绝好友申请", value = "friend-apply-reject", apiParams = {@ApiParam(name = "user_token",descript = "当前用户token(*)"),@ApiParam(name = "applyId",descript = "好友用户Id(*)")   })
    @Override
    public ApiResponse rejectForApply(ApiRequest apiReq) {
        Long userId=apiReq.getCurrentUserId();
        Long applyId=apiReq.getLong("applyId");
        FriendApply friendApply = friendApplyMapper.selectByPrimaryKey(applyId);
        if (friendApply==null ){
            return new ApiResponse(ApiMsgEnum.FAIL);
        }
        friendApply.setApplyState(2);
        friendApplyMapper.updateByPrimaryKeySelective(friendApply);
        return  new ApiResponse(ApiMsgEnum.SUCCESS);
    }

    @ApiMethod(needLogin = true,descript = "同意好友申请", value = "friend-apply-accept", apiParams = {@ApiParam(name = "user_token",descript = "当前用户token(*)"),@ApiParam(name = "applyId",descript = "好友用户Id(*)")   })
    @Override
    public ApiResponse acceptForApply(ApiRequest apiReq) {
        Long userId=apiReq.getCurrentUserId();
        Long applyId=apiReq.getLong("applyId");
        FriendApply friendApply = friendApplyMapper.selectByPrimaryKey(applyId);
        if (friendApply==null ){
            return new ApiResponse(ApiMsgEnum.FAIL);
        }
        friendApply.setApplyState(1);
        friendApplyMapper.updateByPrimaryKeySelective(friendApply);
        return  new ApiResponse(ApiMsgEnum.SUCCESS);
    }
}
