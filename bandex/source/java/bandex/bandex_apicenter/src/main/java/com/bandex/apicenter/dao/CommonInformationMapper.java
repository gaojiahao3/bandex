package com.bandex.apicenter.dao;

import com.bandex.apicenter.model.CommonInformation;

public interface CommonInformationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommonInformation record);

    int insertSelective(CommonInformation record);

    CommonInformation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommonInformation record);

    int updateByPrimaryKey(CommonInformation record);
}