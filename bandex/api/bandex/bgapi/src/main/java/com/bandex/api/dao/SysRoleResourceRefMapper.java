package com.bandex.api.dao;

import com.bandex.api.model.SysRoleResourceRef;

import java.util.HashMap;
import java.util.List;

public interface SysRoleResourceRefMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleResourceRef record);

    int insertSelective(SysRoleResourceRef record);

    SysRoleResourceRef selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleResourceRef record);

    int updateByPrimaryKey(SysRoleResourceRef record);

    List<SysRoleResourceRef> selectSysRoleResourceRefList(HashMap<String, Object> paramMap);
    Long selectSysRoleResourceRefCount(HashMap<String, Object> paramMap);


    int deleteSysRoleResource(HashMap<String, Object> paramMap);
}