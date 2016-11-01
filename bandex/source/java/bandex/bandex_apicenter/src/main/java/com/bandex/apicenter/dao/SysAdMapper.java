package com.bandex.apicenter.dao;

import com.bandex.apicenter.model.SysAd;

public interface SysAdMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysAd record);

    int insertSelective(SysAd record);

    SysAd selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysAd record);

    int updateByPrimaryKey(SysAd record);
}