package com.bandex.api.dao;

import com.bandex.api.model.CommonArea;

public interface CommonAreaMapper {
    int deleteByPrimaryKey(Long areaId);

    int insert(CommonArea record);

    int insertSelective(CommonArea record);

    CommonArea selectByPrimaryKey(Long areaId);

    int updateByPrimaryKeySelective(CommonArea record);

    int updateByPrimaryKey(CommonArea record);
}