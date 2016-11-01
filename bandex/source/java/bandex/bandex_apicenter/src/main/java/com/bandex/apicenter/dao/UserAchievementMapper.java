package com.bandex.apicenter.dao;

import com.bandex.apicenter.model.UserAchievement;

public interface UserAchievementMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAchievement record);

    int insertSelective(UserAchievement record);

    UserAchievement selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAchievement record);

    int updateByPrimaryKey(UserAchievement record);
}