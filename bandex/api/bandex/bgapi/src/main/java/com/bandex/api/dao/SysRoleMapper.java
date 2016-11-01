package com.bandex.api.dao;

import com.bandex.api.model.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface SysRoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> selectSysRoleBySysUserId(Map<String, Object> paramMap);

    List<SysRole> selectSysRoleList(Map<String, Object> paramMap);
    Long selectSysRoleCount(Map<String, Object> paramMap);
}