package com.bandex.api.dao;

import com.bandex.api.model.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}