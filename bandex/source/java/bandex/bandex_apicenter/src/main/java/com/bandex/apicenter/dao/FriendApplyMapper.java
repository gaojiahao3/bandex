package com.bandex.apicenter.dao;

import com.bandex.apicenter.model.FriendApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendApplyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FriendApply record);

    int insertSelective(FriendApply record);

    FriendApply selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FriendApply record);

    int updateByPrimaryKey(FriendApply record);

    List<FriendApply> queryByUserId(@Param("userId")Long userId,@Param("pageIndex") int pageIndex,@Param("pageSize") int appPageSize);

    List<FriendApply> queryNotAcceptApplyByUserIdAndFriendId(@Param("userId")Long userId,@Param("friendId") Long friendId);
}