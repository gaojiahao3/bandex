package com.bandex.api.dao;

import com.bandex.api.model.SysResource;
import com.bandex.api.model.SysResourcePo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SysResourceMapper {
    int deleteByPrimaryKey(Long resourceId);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(Long resourceId);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);

    List<SysResource> selectSysResourceByParentId(HashMap<String, Object> paramMap);
    List<SysResource> selectSysResourceByRoleId(HashMap<String, Object> paramMap);

    List<SysResource> selectSysResourceList(HashMap<String, Object> paramMap);
    Long selectSysResourceCount(HashMap<String, Object> paramMap);
    List<SysResourcePo> getUserResources(HashMap<String,Object> map);

    SysResource selectByByResourcePath(String resourcePath);

    List<SysResourcePo> getResources(HashMap<String, Object> map);
}