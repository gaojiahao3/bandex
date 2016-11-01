package com.bandex.api.service.sys;

import com.bandex.api.dto.ApiRequest;
import com.bandex.api.dto.ApiResponse;
import com.bandex.api.model.SysRole;
import com.bandex.api.model.SysUserRoleRef;

import java.util.List;

/**
 * Created by user on 2015/8/7.
 */
public interface SysRoleService {
    ApiResponse<SysRole> querySysRoleById(ApiRequest apiRequest);

    ApiResponse<SysRole> insertSysRole(ApiRequest apiRequest);

    ApiResponse<SysRole> updateSysRole(ApiRequest apiRequest);

    ApiResponse<List<SysRole>> querySysRoleList(ApiRequest apiRequest);

    ApiResponse<SysRole> deleteSysRoleById(ApiRequest apiRequest);

    ApiResponse<List<SysRole>> selectSysRoleBySysUserId(ApiRequest apiRequest);

    ApiResponse<SysUserRoleRef> insertSysUserRoleRef(ApiRequest apiRequest);

    ApiResponse<SysUserRoleRef> updateSysUserRoleRef(ApiRequest apiRequest);

    ApiResponse<SysUserRoleRef> deleteSysUserRoleRefById(ApiRequest apiRequest);

}
