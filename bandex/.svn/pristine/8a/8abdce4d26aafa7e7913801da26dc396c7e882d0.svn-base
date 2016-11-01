package com.bandex.apicenter.dao;

import com.bandex.apicenter.model.UserGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserGroupMapper {
    int deleteByPrimaryKey(Long groupId);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    UserGroup selectByPrimaryKey(Long groupId);

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKey(UserGroup record);

    List<UserGroup> selectUserGroupByUserId(Long userId);

    List<UserGroup> selectUserGroupByGroupIdList(@Param("groupIdList") List<Long> groupIdList);
}