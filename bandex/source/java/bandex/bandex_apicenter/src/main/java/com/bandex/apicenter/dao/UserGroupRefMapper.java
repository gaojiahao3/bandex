package com.bandex.apicenter.dao;

import com.bandex.apicenter.model.UserGroupRef;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserGroupRefMapper {
    int insert(UserGroupRef record);

    int insertSelective(UserGroupRef record);

    List<Long> selectUserGroupIdByUserId(Long userId);

    int updateIsAgree(@Param("userId") Long userId,@Param("groupId") Long groupId,@Param("isAgree") int status);
}