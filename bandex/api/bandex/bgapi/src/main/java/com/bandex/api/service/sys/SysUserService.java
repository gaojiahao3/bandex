package com.bandex.api.service.sys;

import com.bandex.api.dto.*;
import com.bandex.api.model.SysResourcePo;
import com.bandex.api.model.SysUser;

import java.util.List;

/**
 * 用户相关的API
 * 
 * @author Daniel
 */
public interface SysUserService {

	ApiResponse<SysUser> getUserInfo(ApiRequest apiRequest);

    ApiResponse<UserDto> sysUserLogin(ApiRequest apiRequest);

    ApiResponse<UserDto>  isLogin(ApiRequest apiRequest);

    /**
     * 系统用户修改密码
     * @param apiRequest
     * @return
     */
    ApiResponse<String> updateUserPassword(ApiRequest apiRequest);

    /**
     * 查询系统用户列表
     * @param apiRequest
     * @return
     */
    ApiResponse<List<SysUser>> getSysUserList(ApiRequest apiRequest);

    /**
     * 新增系统用户
     * @param apiRequest
     * @return
     */
    ApiResponse<SysUser> insertSysUser(ApiRequest apiRequest);

    /**
     * 修改系统用户
     * @param apiRequest
     * @return
     */
    ApiResponse<SysUser> updateSysUser(ApiRequest apiRequest);

    /**
     * 查询菜单
     * @param apiRequest
     * @return
     */
    ApiResponse<List<SysResourcePo>> getMenuList(ApiRequest apiRequest);

    /**
     * 根据角色查询用户列表
     * @param apiRequest
     * @return
     */
    ApiResponse<List<SysUser>> selectSysUserListByRoleId(ApiRequest apiRequest);

    /**
     * 根据ID修改系统用户状态
     * @param apiRequest
     * @return
     */
    ApiResponse<SysUser> updateSysUserStateById(ApiRequest apiRequest);

}
