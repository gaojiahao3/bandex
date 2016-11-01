package com.bandex.apicenter.dao;

import java.util.List;
import java.util.Map;

import com.bandex.apicenter.model.SysUserRole;

public interface SysUserRoleMapper {

	int deleteByUserId(Integer userId);

	int insert(Map<String, Object> params);

	List<SysUserRole> selectList(Map<String, Object> params);

	int selectCount(Map<String, Object> params);

}