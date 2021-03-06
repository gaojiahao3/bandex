package com.bandex.apicenter.dao;

import com.bandex.apicenter.model.UserAchievement;

import java.util.List;

public interface UserAchievementMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAchievement record);

    int insertSelective(UserAchievement record);

    UserAchievement selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAchievement record);

    int updateByPrimaryKey(UserAchievement record);

    List<UserAchievement> selectByUserId(Long userId);
}