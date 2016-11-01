package com.bandex.apicenter.dao;

import com.bandex.apicenter.model.UserFriend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserFriendMapper {
    int insert(UserFriend record);

    int insertSelective(UserFriend record);

    List<Long> queryFriendUserIdByUserId(Long userId);

    int deleteUserFriend(@Param("userId") Long userId,@Param("friendId") Long friendUserId);

    List<UserFriend> queryFriendUserIdByUserIdFriendId(@Param("userId")Long userId, @Param("friendId")Long friendId);
}