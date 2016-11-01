package com.bandex.apicenter.dao;

import java.util.List;
import java.util.Map;

import com.bandex.apicenter.model.SysMenu;

public interface SysMenuMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(Map<String, Object> params);

	SysMenu selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(Map<String, Object> params);

	List<SysMenu> selectList(Map<String, Object> params);

	int selectCount(Map<String, Object> params);

	List<SysMenu> selectTreeList(Map<String, Object> params);

}