package com.bandex.api.dao;

import com.bandex.api.model.SysUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * 系统用户登录
     * @param map
     * @return
     */
    SysUser selectUserByLogin(HashMap<String, String> map);

    /**
     * 系统用户修改密码
     * @param map
     * @return
     */
    int updateUserPassword(HashMap<String, String> map);

    /**
     * 查询系统用户列表
     * @param hashMap
     * @return
     */
    Long selectSysUserCount(HashMap<String,Object> hashMap);
    List<SysUser> selectSysUserList(HashMap<String,Object> hashMap);

    /**
     * 根据角色查询系统用户
     * @param hashMap
     * @return
     */
    List<SysUser> selectSysUserListByRoleId(HashMap<String,Object> hashMap);
}