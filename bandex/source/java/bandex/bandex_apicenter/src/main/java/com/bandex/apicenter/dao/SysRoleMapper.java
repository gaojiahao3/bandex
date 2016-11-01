package com.bandex.apicenter.dao;

import java.util.List;
import java.util.Map;

import com.bandex.apicenter.model.SysRole;

public interface SysRoleMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(Map<String, Object> params);

	SysRole selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(Map<String, Object> params);

	List<SysRole> selectList(Map<String, Object> params);

	int selectCount(Map<String, Object> params);
}