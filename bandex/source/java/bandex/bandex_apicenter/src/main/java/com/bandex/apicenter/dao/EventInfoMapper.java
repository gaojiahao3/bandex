package com.bandex.apicenter.dao;

import com.bandex.apicenter.model.EventInfo;

public interface EventInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EventInfo record);

    int insertSelective(EventInfo record);

    EventInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EventInfo record);

    int updateByPrimaryKey(EventInfo record);
}