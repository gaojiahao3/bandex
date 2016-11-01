package com.bandex.apicenter.dao;

import com.bandex.apicenter.model.CommonAchievement;

public interface CommonAchievementMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommonAchievement record);

    int insertSelective(CommonAchievement record);

    CommonAchievement selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommonAchievement record);

    int updateByPrimaryKey(CommonAchievement record);
}