package com.bandex.api.service.sys;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bandex.api.annotations.FunctionCode;
import com.bandex.api.dao.SysResourceMapper;
import com.bandex.api.dao.SysRoleResourceRefMapper;
import com.bandex.api.dto.ApiRequest;
import com.bandex.api.dto.ApiResponse;
import com.bandex.api.dto.Pagination;
import com.bandex.api.enums.RestResultEnum;
import com.bandex.api.model.SysResource;
import com.bandex.api.model.SysRoleResourceRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 2015/8/7.
 */
@FunctionCode(value = "sysResource", descript = "资源相关接口")
@Service
public class SysResourceServiceImpl  implements SysResourceService{
    @Autowired
    private SysResourceMapper sysResourceMapper;

    @Autowired
    private SysRoleResourceRefMapper sysRoleResourceRefMapper;
    /**
     *根据ID查询资源详情
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysResource.querySysResourceById", descript = "根据ID查询资源详情")
    @Override
    public ApiResponse<SysResource> querySysResourceById(ApiRequest apiRequest) {
        Object idObj = apiRequest.get("resourceId");
        if (StringUtils.isEmpty(idObj)) {
            return new ApiResponse<SysResource>(RestResultEnum.MissParameterException);
        }
        ApiResponse<SysResource> apiResponse = null;
        try {
            SysResource sysResource = this.sysResourceMapper.selectByPrimaryKey(Long.valueOf(idObj.toString()));
            if (sysResource != null) {
                apiResponse = new ApiResponse<SysResource>(RestResultEnum.SUCCESS, 1, sysResource);
            }else{
                apiResponse = new ApiResponse<SysResource>(RestResultEnum.SUCCESS, 0, null);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse<SysResource>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     * 新增资源信息
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysResource.insertSysResource", descript = "新增资源信息")
    @Override
    public ApiResponse<SysResource> insertSysResource(ApiRequest apiRequest) {
        Object resourceCodeObj = apiRequest.get("resourceCode");
        Object parentIdObj = apiRequest.get("parentId");
        Object resourceNameObj = apiRequest.get("resourceName");
        Object resourceTypeObj = apiRequest.get("resourceType");
        Object resourcePathObj = apiRequest.get("resourcePath");
        Object mappingPathObj = apiRequest.get("mappingPath");
        Object orderNumObj = apiRequest.get("orderNum");
        Object iconClassObj = apiRequest.get("iconClass");
        Object platformCodeObj = apiRequest.get("platformCode");
        Object descriptionObj = apiRequest.get("description");
        Object createByObj = apiRequest.get("createBy");
        if (StringUtils.isEmpty(resourceCodeObj)||StringUtils.isEmpty(parentIdObj)||StringUtils.isEmpty(resourceNameObj)||StringUtils.isEmpty(resourceTypeObj)
                ||StringUtils.isEmpty(resourcePathObj)||StringUtils.isEmpty(mappingPathObj)||StringUtils.isEmpty(orderNumObj)
                ||StringUtils.isEmpty(platformCodeObj)) {
            return new ApiResponse<SysResource>(RestResultEnum.MissParameterException);
        }
        SysResource sysResource= new SysResource();
        sysResource.setResourceCode(resourceCodeObj.toString());
        sysResource.setParentId(Long.valueOf(parentIdObj.toString()));
        sysResource.setResourceName(resourceNameObj.toString());
        sysResource.setResourceType(Integer.valueOf(resourceTypeObj.toString()));
        sysResource.setResourcePath(resourcePathObj.toString());
        sysResource.setMappingPath(mappingPathObj.toString());
        sysResource.setOrderNum(Integer.valueOf(orderNumObj.toString()));

        sysResource.setPlatformCode(platformCodeObj.toString());
        if(!StringUtils.isEmpty(iconClassObj)){
            sysResource.setIconClass(iconClassObj.toString());
        }
        if(!StringUtils.isEmpty(descriptionObj)){
            sysResource.setDescription(descriptionObj.toString());
        }
        if(!StringUtils.isEmpty(createByObj)){
            sysResource.setCreateId(Long.parseLong(createByObj.toString()));
            sysResource.setModifyId(Long.parseLong(createByObj.toString()));
        }
        sysResource.setCreateTime(new Date());
        sysResource.setModifyTime(new Date());
        sysResource.setDeleteFlag(0);
        ApiResponse<SysResource> apiResponse = null;
        try {
            int result =  this.sysResourceMapper.insertSelective(sysResource);
            if(result>0){
                apiResponse = new ApiResponse<SysResource>(RestResultEnum.SUCCESS,1,sysResource);
            }else{
                apiResponse = new ApiResponse<SysResource>(RestResultEnum.FAIL,0,null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            apiResponse = new ApiResponse<SysResource>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     * 修改资源信息
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysResource.updateSysResource", descript = "修改资源信息")
    @Override
    public ApiResponse<SysResource> updateSysResource(ApiRequest apiRequest) {
        Object resourceIdObj = apiRequest.get("resourceId");
        Object resourceCodeObj = apiRequest.get("resourceCode");
        Object parentIdObj = apiRequest.get("parentId");
        Object resourceNameObj = apiRequest.get("resourceName");
        Object resourceTypeObj = apiRequest.get("resourceType");
        Object resourcePathObj = apiRequest.get("resourcePath");
        Object mappingPathObj = apiRequest.get("mappingPath");
        Object orderNumObj = apiRequest.get("orderNum");
        Object iconClassObj = apiRequest.get("iconClass");
        Object platformCodeObj = apiRequest.get("platformCode");
        Object descriptionObj = apiRequest.get("description");
        Object updateByObj = apiRequest.get("updateBy");
        if (StringUtils.isEmpty(resourceIdObj)&&StringUtils.isEmpty(updateByObj)) {
            return new ApiResponse<SysResource>(RestResultEnum.MissParameterException);
        }
        SysResource sysResource= new SysResource();
        sysResource.setResourceId(Long.valueOf(resourceIdObj.toString()));
        if(!StringUtils.isEmpty(resourceCodeObj)){
            sysResource.setResourceCode(resourceCodeObj.toString());
        }
        if(!StringUtils.isEmpty(parentIdObj)){
            sysResource.setParentId(Long.valueOf(parentIdObj.toString()));
        }
        if(!StringUtils.isEmpty(resourceNameObj)){
            sysResource.setResourceName(resourceNameObj.toString());
        }
        if(!StringUtils.isEmpty(resourceTypeObj)){
            sysResource.setResourceType(Integer.valueOf(resourceTypeObj.toString()));
        }
        if(!StringUtils.isEmpty(resourcePathObj)){
            sysResource.setResourcePath(resourcePathObj.toString());
        }
        if(!StringUtils.isEmpty(mappingPathObj)){
            sysResource.setMappingPath(mappingPathObj.toString());
        }
        if(!StringUtils.isEmpty(orderNumObj)){
            sysResource.setOrderNum(Integer.valueOf(orderNumObj.toString()));
        }
        if(!StringUtils.isEmpty(iconClassObj)){
            sysResource.setIconClass(iconClassObj.toString());
        }
        if(!StringUtils.isEmpty(platformCodeObj)){
            sysResource.setPlatformCode(platformCodeObj.toString());
        }
        if(!StringUtils.isEmpty(descriptionObj)){
            sysResource.setDescription(descriptionObj.toString());
        }
        if(!StringUtils.isEmpty(updateByObj)){
            sysResource.setModifyId(Long.parseLong(updateByObj.toString()));
        }
        sysResource.setModifyTime(new Date());
        ApiResponse<SysResource> apiResponse = null;
        try {
            int result =  this.sysResourceMapper.updateByPrimaryKeySelective(sysResource);
            if(result>0){
                apiResponse = new ApiResponse<SysResource>(RestResultEnum.SUCCESS,1,sysResource);
            }else{
                apiResponse = new ApiResponse<SysResource>(RestResultEnum.FAIL,0,null);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse<SysResource>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     * 查询资源信息列表
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysResource.querySysResourceList", descript = "查询资源信息列表")
    @Override
    public ApiResponse<List<SysResource>> querySysResourceList(ApiRequest apiRequest) {
        Object resourceCodeObj = apiRequest.get("resourceCode");
        Object parentIdObj = apiRequest.get("parentId");
        Object resourceTypeObj = apiRequest.get("resourceType");
        Object pageNoObj = apiRequest.get("pageNo");
        Object pageSizeObj = apiRequest.get("pageSize");
        Long pageNo = 1L;
        Long pageSize = 10L;
        if(!StringUtils.isEmpty(pageNoObj)){
            pageNo = Long.parseLong(pageNoObj.toString());
        }
        if(!StringUtils.isEmpty(pageSizeObj)){
            pageSize = Long.parseLong(pageSizeObj.toString());
        }
        HashMap<String,Object> hashMap = new HashMap<String, Object>();
        Pagination<SysResource> poPagination = new Pagination<SysResource>(pageNo, pageSize);
        hashMap.put("startIndex", (pageNo-1)*pageSize);
        hashMap.put("endIndex", pageSize);
        if(!StringUtils.isEmpty(resourceCodeObj)){
            hashMap.put("resourceCode", resourceCodeObj.toString());
        }
        if(!StringUtils.isEmpty(parentIdObj)){
            hashMap.put("parentId", parentIdObj.toString());
        }
        if(!StringUtils.isEmpty(resourceTypeObj)){
            hashMap.put("resourceType", resourceTypeObj.toString());
        }
        Long count = this.sysResourceMapper.selectSysResourceCount(hashMap);
        System.out.println("******************" + count);
        List<SysResource>  sysResources  = this.sysResourceMapper.selectSysResourceList(hashMap);
        poPagination.setNumFound(count);
        poPagination.setData(sysResources);
        return new ApiResponse<List<SysResource>>(RestResultEnum.SUCCESS, (poPagination == null ? 0 : (int) poPagination.getNumFound()), poPagination.getData());
    }
    /**
     * 根据ID删除资源信息
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysResource.deleteSysResourceById", descript = "根据ID删除资源信息")
    @Override
    public ApiResponse<SysResource> deleteSysResourceById(ApiRequest apiRequest) {
        Object resourceIdObj = apiRequest.get("resourceId");
        if (StringUtils.isEmpty(resourceIdObj)) {
            return new ApiResponse<SysResource>(RestResultEnum.MissParameterException);
        }
        ApiResponse<SysResource> apiResponse = null;
        try {
            int result =  this.sysResourceMapper.deleteByPrimaryKey(Long.valueOf(resourceIdObj.toString()));
            if(result>0){
                apiResponse = new ApiResponse<SysResource>(RestResultEnum.SUCCESS,1,null);
            }else {
                apiResponse = new ApiResponse<SysResource>(RestResultEnum.SUCCESS,0,null);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse<SysResource>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     * 绑定系统角色的资源
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysResource.insertSysRoleResourceRef", descript = "绑定系统角色的资源")
    @Override
    public ApiResponse<SysRoleResourceRef> insertSysRoleResourceRef(ApiRequest apiRequest) {
        Object roleResourceStrObj = apiRequest.get("roleResourceStr");
        if (StringUtils.isEmpty(roleResourceStrObj)) {
            return new ApiResponse<SysRoleResourceRef>(RestResultEnum.MissParameterException);
        }
        ApiResponse<SysRoleResourceRef> apiResponse = null;
        try {
            JSONObject roleResouceObj = JSON.parseObject(roleResourceStrObj.toString());
            String roleId=roleResouceObj.getString("roleId");
            JSONArray roleResouceList = roleResouceObj.getJSONArray("record");
            for (int i = 0; i < roleResouceList.size(); i++) {
                JSONObject resouceIdObj = JSON.parseObject(roleResouceList.get(i).toString());
                String resouceId = resouceIdObj.getString("resourceId");
                SysRoleResourceRef sysRoleResourceRef = new SysRoleResourceRef();
                sysRoleResourceRef.setResourceId(Long.valueOf(resouceId));
                sysRoleResourceRef.setRoleId(Long.valueOf(roleId));
                int result = this.sysRoleResourceRefMapper.insertSelective(sysRoleResourceRef);
            }
            apiResponse = new ApiResponse<SysRoleResourceRef>(RestResultEnum.SUCCESS);
        } catch (Exception e) {
            apiResponse = new ApiResponse<SysRoleResourceRef>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     * 修改角色资源信息
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysResource.updateSysRoleResourceRef", descript = "修改角色资源信息")
    @Override
    public ApiResponse<SysRoleResourceRef> updateSysRoleResourceRef(ApiRequest apiRequest) {
        Object idObj = apiRequest.get("id");
        Object resourceIdObj = apiRequest.get("resourceId");
        //Object roleIdObj = apiRequest.get("roleId");
        if (StringUtils.isEmpty(idObj)||StringUtils.isEmpty(resourceIdObj)) {
            return new ApiResponse<SysRoleResourceRef>(RestResultEnum.MissParameterException);
        }
        SysRoleResourceRef sysRoleResourceRef= new SysRoleResourceRef();
        sysRoleResourceRef.setId(Long.valueOf(idObj.toString()));
        sysRoleResourceRef.setResourceId(Long.valueOf(resourceIdObj.toString()));
//        if(!StringUtils.isEmpty(roleIdObj)){
//            sysRoleResourceRef.setRoleId(Long.valueOf(roleIdObj.toString()));
//        }
        ApiResponse<SysRoleResourceRef> apiResponse = null;
        try {
            int result =  this.sysRoleResourceRefMapper.updateByPrimaryKeySelective(sysRoleResourceRef);
            if(result>0){
                apiResponse = new ApiResponse<SysRoleResourceRef>(RestResultEnum.SUCCESS,1,sysRoleResourceRef);
            }else{
                apiResponse = new ApiResponse<SysRoleResourceRef>(RestResultEnum.FAIL,0,null);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse<SysRoleResourceRef>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     * 查询角色资源信息列表
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysResource.querySysRoleResourceRefList", descript = "查询角色资源信息列表")
    @Override
    public ApiResponse<List<SysRoleResourceRef>> querySysRoleResourceRefList(ApiRequest apiRequest) {
        Object resourceIdObj = apiRequest.get("resourceId");
        Object roleIdObj = apiRequest.get("roleId");
        Object pageNoObj = apiRequest.get("pageNo");
        Object pageSizeObj = apiRequest.get("pageSize");
        Long pageNo = 1L;
        Long pageSize = 10L;
        if(!StringUtils.isEmpty(pageNoObj)){
            pageNo = Long.parseLong(pageNoObj.toString());
        }
        if(!StringUtils.isEmpty(pageSizeObj)){
            pageSize = Long.parseLong(pageSizeObj.toString());
        }
        HashMap<String,Object> hashMap = new HashMap<String, Object>();
        Pagination<SysRoleResourceRef> poPagination = new Pagination<SysRoleResourceRef>(pageNo, pageSize);
        hashMap.put("startIndex", (pageNo-1)*pageSize);
        hashMap.put("endIndex", pageSize);
        if(!StringUtils.isEmpty(resourceIdObj)){
            hashMap.put("resourceId", resourceIdObj.toString());
        }
        if(!StringUtils.isEmpty(roleIdObj)){
            hashMap.put("roleId", roleIdObj.toString());
        }
        Long count = this.sysRoleResourceRefMapper.selectSysRoleResourceRefCount(hashMap);
        System.out.println("******************"+count);
        List<SysRoleResourceRef>  sysRoleResourceRefs  = this.sysRoleResourceRefMapper.selectSysRoleResourceRefList(hashMap);
        poPagination.setNumFound(count);
        poPagination.setData(sysRoleResourceRefs);
        return new ApiResponse<List<SysRoleResourceRef>>(RestResultEnum.SUCCESS, (poPagination == null ? 0 : (int) poPagination.getNumFound()), poPagination.getData());
    }
    /**
     * 取消绑定角色的菜单
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysResource.deleteSysRoleResourceRefById", descript = "取消绑定角色的菜单")
    @Override
    public ApiResponse<SysRoleResourceRef> deleteSysRoleResourceRefById(ApiRequest apiRequest) {
        Object idObj = apiRequest.get("id");
        if (StringUtils.isEmpty(idObj)) {
            return new ApiResponse<SysRoleResourceRef>(RestResultEnum.MissParameterException);
        }
        ApiResponse<SysRoleResourceRef> apiResponse = null;
        try {
            int result =  this.sysResourceMapper.deleteByPrimaryKey(Long.valueOf(idObj.toString()));
            apiResponse = new ApiResponse<SysRoleResourceRef>(RestResultEnum.SUCCESS);
        } catch (Exception e) {
            apiResponse = new ApiResponse<SysRoleResourceRef>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }

    /**
     * 取消绑定角色的菜单(批量)
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysResource.deleteSysRoleResouce", descript = "取消绑定角色的菜单(批量)")
    @Override
    public ApiResponse<SysRoleResourceRef> deleteSysRoleResouce(ApiRequest apiRequest) {
        Object roleResourceStrObj = apiRequest.get("roleResourceStr");
        if (StringUtils.isEmpty(roleResourceStrObj)) {
            return new ApiResponse<SysRoleResourceRef>(RestResultEnum.MissParameterException);
        }
        ApiResponse<SysRoleResourceRef> apiResponse = null;
        try {
            JSONObject roleResourceObj = JSON.parseObject(roleResourceStrObj.toString());
            String roleId=roleResourceObj.getString("roleId");
            JSONArray roleResourceList = roleResourceObj.getJSONArray("record");
            for (int i = 0; i < roleResourceList.size(); i++) {
                JSONObject resourceIdObj=JSON.parseObject(roleResourceList.get(i).toString());
                String resourceId=resourceIdObj.getString("resourceId");
                HashMap<String,Object> hashMap = new HashMap<String, Object>();
                hashMap.put("resourceId", resourceId);
                hashMap.put("roleId", roleId);
                int result =  this.sysRoleResourceRefMapper.deleteSysRoleResource(hashMap);
            }
            apiResponse = new ApiResponse<SysRoleResourceRef>(RestResultEnum.SUCCESS);
        } catch (Exception e) {
            apiResponse = new ApiResponse<SysRoleResourceRef>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     * 根据parentId查询资源信息
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysResource.selectSysResourceByParentId", descript = "根据parentId查询资源信息")
    @Override
    public ApiResponse<List<SysResource>> selectSysResourceByParentId(ApiRequest apiRequest) {
        Object parentIdObj = apiRequest.get("parentId");
        if (StringUtils.isEmpty(parentIdObj)) {
            return new ApiResponse<List<SysResource>>(RestResultEnum.MissParameterException);
        }
        ApiResponse<List<SysResource>> apiResponse = null;
        try {
            HashMap<String,Object> hashMap = new HashMap<String, Object>();
            hashMap.put("parentId",parentIdObj.toString());
            List<SysResource>  sysResources = this.sysResourceMapper.selectSysResourceByParentId(hashMap);
            if (sysResources != null) {
                apiResponse = new ApiResponse<List<SysResource>>(RestResultEnum.SUCCESS, 1, sysResources);
            }else{
                apiResponse = new ApiResponse<List<SysResource>>(RestResultEnum.SUCCESS, 0, null);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse<List<SysResource>>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }

    /**
     * 根据roleId查询资源列表
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysResource.selectSysResourceByRoleId", descript = "根据roleId查询资源列表")
    @Override
    public ApiResponse<List<SysResource>> selectSysResourceByRoleId(ApiRequest apiRequest) {
        Object roleIdObj = apiRequest.get("roleId");
        if (StringUtils.isEmpty(roleIdObj)) {
            return new ApiResponse<List<SysResource>>(RestResultEnum.MissParameterException);
        }
        ApiResponse<List<SysResource>> apiResponse = null;
        try {
            HashMap<String,Object> hashMap = new HashMap<String, Object>();
            hashMap.put("roleId",roleIdObj.toString());
            List<SysResource>  sysResources = this.sysResourceMapper.selectSysResourceByRoleId(hashMap);
            if (sysResources != null) {
                apiResponse = new ApiResponse<List<SysResource>>(RestResultEnum.SUCCESS, 1, sysResources);
            }else{
                apiResponse = new ApiResponse<List<SysResource>>(RestResultEnum.SUCCESS, 0, null);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse<List<SysResource>>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     *根据资源路径查询资源列表
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysResource.querySysResourceByResourcePath", descript = "根据资源路径查询资源列表")
    @Override
    public ApiResponse<SysResource> querySysResourceByResourcePath(ApiRequest apiRequest) {
        Object resourcePathObj = apiRequest.get("resourcePath");
        if (StringUtils.isEmpty(resourcePathObj)) {
            return new ApiResponse<SysResource>(RestResultEnum.MissParameterException);
        }
        ApiResponse<SysResource> apiResponse = null;
        try {
            SysResource sysResource = this.sysResourceMapper.selectByByResourcePath(resourcePathObj.toString());
            if (sysResource != null) {
                apiResponse = new ApiResponse<SysResource>(RestResultEnum.SUCCESS, 1, sysResource);
            }else{
                apiResponse = new ApiResponse<SysResource>(RestResultEnum.SUCCESS, 0, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            apiResponse = new ApiResponse<SysResource>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
}
