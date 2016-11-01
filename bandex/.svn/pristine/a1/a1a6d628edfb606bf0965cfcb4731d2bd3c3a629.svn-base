package com.bandex.api.service.sys;

import com.bandex.api.dto.ApiRequest;
import com.bandex.api.dto.ApiResponse;
import com.bandex.api.model.SysResource;
import com.bandex.api.model.SysRoleResourceRef;

import java.util.List;

/**
 * Created by user on 2015/8/7.
 */
public interface SysResourceService {
    ApiResponse<SysResource> querySysResourceById(ApiRequest apiRequest);

    ApiResponse<SysResource> insertSysResource(ApiRequest apiRequest);

    ApiResponse<SysResource> updateSysResource(ApiRequest apiRequest);

    ApiResponse<List<SysResource>> querySysResourceList(ApiRequest apiRequest);

    ApiResponse<SysResource> deleteSysResourceById(ApiRequest apiRequest);

    ApiResponse<List<SysResource>> selectSysResourceByParentId(ApiRequest apiRequest);

    ApiResponse<List<SysResource>> selectSysResourceByRoleId(ApiRequest apiRequest);

    ApiResponse<SysRoleResourceRef> insertSysRoleResourceRef(ApiRequest apiRequest);

    ApiResponse<SysRoleResourceRef> updateSysRoleResourceRef(ApiRequest apiRequest);

    ApiResponse<List<SysRoleResourceRef>> querySysRoleResourceRefList(ApiRequest apiRequest);

    ApiResponse<SysRoleResourceRef> deleteSysRoleResourceRefById(ApiRequest apiRequest);

    ApiResponse<SysRoleResourceRef> deleteSysRoleResouce(ApiRequest apiRequest);

    ApiResponse<SysResource> querySysResourceByResourcePath(ApiRequest apiRequest);
}
