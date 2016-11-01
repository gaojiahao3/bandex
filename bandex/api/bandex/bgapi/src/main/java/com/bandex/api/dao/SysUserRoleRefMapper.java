package com.bandex.api.dao;

import com.bandex.api.model.SysUserRoleRef;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public interface SysUserRoleRefMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserRoleRef record);

    int insertSelective(SysUserRoleRef record);

    SysUserRoleRef selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRoleRef record);

    int updateByPrimaryKey(SysUserRoleRef record);
}