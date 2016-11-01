package com.bandex.apicenter.dao;

import com.bandex.apicenter.model.CommonSportProject;

import java.util.List;

public interface CommonSportProjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommonSportProject record);

    int insertSelective(CommonSportProject record);

    CommonSportProject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommonSportProject record);

    int updateByPrimaryKey(CommonSportProject record);

    List<CommonSportProject> selectAll();
}