package com.bandex.api.service.sys;

import com.bandex.api.annotations.FunctionCode;
import com.bandex.api.dao.SysRoleMapper;
import com.bandex.api.dao.SysUserRoleRefMapper;
import com.bandex.api.dto.ApiRequest;
import com.bandex.api.dto.ApiResponse;
import com.bandex.api.dto.Pagination;
import com.bandex.api.enums.RestResultEnum;
import com.bandex.api.model.SysRole;
import com.bandex.api.model.SysUserRoleRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 2015/8/7.
 */
@FunctionCode(value = "sysRole", descript = "角色相关接口")
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleRefMapper sysUserRoleRefMapper;

    /**
     * 根据id查询系统角色详情
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysRole.querySysRoleById", descript = "根据id查询系统角色详情")
    @Override
    public ApiResponse<SysRole> querySysRoleById(ApiRequest apiRequest) {
        Object roleIdObj = apiRequest.get("roleId");
        if (StringUtils.isEmpty(roleIdObj)) {
            return new ApiResponse<SysRole>(RestResultEnum.MissParameterException);
        }
        ApiResponse<SysRole> apiResponse = null;
        try {
            SysRole sysRole = this.sysRoleMapper.selectByPrimaryKey(Long.valueOf(roleIdObj.toString()));
            if (sysRole != null) {
                apiResponse = new ApiResponse<SysRole>(RestResultEnum.SUCCESS, 1, sysRole);
            }else{
                apiResponse = new ApiResponse<SysRole>(RestResultEnum.SUCCESS, 0, null);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse<SysRole>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     * 新增系统角色
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysRole.insertSysRole", descript = "新增系统角色")
    @Override
    public ApiResponse<SysRole> insertSysRole(ApiRequest apiRequest) {
        Object roleNameObj = apiRequest.get("roleName");
        Object descriptionObj = apiRequest.get("description");
        Object roleCodeObj = apiRequest.get("roleCode");
        Object createByObj = apiRequest.get("createBy");
        if (StringUtils.isEmpty(roleNameObj)||StringUtils.isEmpty(descriptionObj)||StringUtils.isEmpty(roleCodeObj)||StringUtils.isEmpty(createByObj)) {
            return new ApiResponse<SysRole>(RestResultEnum.MissParameterException);
        }
        SysRole sysRole= new SysRole();
        sysRole.setRoleCode(roleCodeObj.toString());
        sysRole.setRoleName(roleNameObj.toString());
        sysRole.setDescription(descriptionObj.toString());
        if(!StringUtils.isEmpty(createByObj)){
            sysRole.setCreateId(Long.parseLong(createByObj.toString()));
            sysRole.setModifyId(Long.parseLong(createByObj.toString()));
        }
        sysRole.setCreateTime(new Date());
        sysRole.setModifyTime(new Date());
        sysRole.setDeleteFlag(0);
        ApiResponse<SysRole> apiResponse = null;
        try {
            int result =  this.sysRoleMapper.insertSelective(sysRole);
            if(result>0){
                apiResponse = new ApiResponse<SysRole>(RestResultEnum.SUCCESS,1,sysRole);
            }else{
                apiResponse = new ApiResponse<SysRole>(RestResultEnum.FAIL,0,null);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse<SysRole>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     * 修改系统角色
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysRole.updateSysRole", descript = "修改系统角色")
    @Override
    public ApiResponse<SysRole> updateSysRole(ApiRequest apiRequest) {
        Object roleIdObj = apiRequest.get("roleId");
        Object roleNameObj = apiRequest.get("roleName");
        Object descriptionObj = apiRequest.get("description");
        Object roleCodeObj = apiRequest.get("roleCode");
        Object updateByObj = apiRequest.get("updateBy");
        if (StringUtils.isEmpty(roleIdObj)||StringUtils.isEmpty(updateByObj)) {
            return new ApiResponse<SysRole>(RestResultEnum.MissParameterException);
        }
        SysRole sysRole= new SysRole();
        sysRole.setRoleId(Long.valueOf(roleIdObj.toString()));
        if(!StringUtils.isEmpty(roleNameObj)){
            sysRole.setRoleName(roleNameObj.toString());
        }
        if(!StringUtils.isEmpty(descriptionObj)){
            sysRole.setDescription(descriptionObj.toString());
        }
        if(!StringUtils.isEmpty(roleCodeObj)){
            sysRole.setRoleCode(roleCodeObj.toString());
        }
        if(!StringUtils.isEmpty(updateByObj)){
            sysRole.setModifyId(Long.parseLong(updateByObj.toString()));
            sysRole.setModifyTime(new Date());
        }
        ApiResponse<SysRole> apiResponse = null;
        try {
            int result =  this.sysRoleMapper.updateByPrimaryKeySelective(sysRole);
            if(result>0){
                apiResponse = new ApiResponse<SysRole>(RestResultEnum.SUCCESS,1,sysRole);
            }else{
                apiResponse = new ApiResponse<SysRole>(RestResultEnum.FAIL,0,null);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse<SysRole>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     * 查询系统角色列表
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysRole.querySysRoleList", descript = "查询系统角色列表")
    @Override
    public ApiResponse<List<SysRole>> querySysRoleList(ApiRequest apiRequest) {
        Object roleNameObj = apiRequest.get("roleName");
        Object roleCodeObj = apiRequest.get("roleCode");
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
        Pagination<SysRole> poPagination = new Pagination<SysRole>(pageNo, pageSize);
        hashMap.put("startIndex", (pageNo-1)*pageSize);
        hashMap.put("endIndex", pageSize);
        if(!StringUtils.isEmpty(roleNameObj)){
            hashMap.put("roleName", roleNameObj.toString());
        }
        if(!StringUtils.isEmpty(roleCodeObj)){
            hashMap.put("roleCode", roleCodeObj.toString());
        }
        Long count = this.sysRoleMapper.selectSysRoleCount(hashMap);
        System.out.println("******************"+count);
        List<SysRole>  sysRoles  = this.sysRoleMapper.selectSysRoleList(hashMap);
        poPagination.setNumFound(count);
        poPagination.setData(sysRoles);
        return new ApiResponse<List<SysRole>>(RestResultEnum.SUCCESS, (poPagination == null ? 0 : (int) poPagination.getNumFound()), poPagination.getData());
    }
    /**
     * 根据ID删除系统角色信息
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysRole.deleteSysRoleById", descript = "根据ID删除系统角色信息")
    @Override
    public ApiResponse<SysRole> deleteSysRoleById(ApiRequest apiRequest) {
        Object roleIdObj = apiRequest.get("roleId");
        if (StringUtils.isEmpty(roleIdObj)) {
            return new ApiResponse<SysRole>(RestResultEnum.MissParameterException);
        }
        ApiResponse<SysRole> apiResponse = null;
        try {
            SysRole sysRole=new SysRole();
            sysRole.setRoleId(Long.valueOf(roleIdObj.toString()));
            sysRole.setDeleteFlag(1);
            int result =  this.sysRoleMapper.updateByPrimaryKeySelective(sysRole);
            if(result>0){
                apiResponse = new ApiResponse<SysRole>(RestResultEnum.SUCCESS,1,sysRole);
            }else{
                apiResponse = new ApiResponse<SysRole>(RestResultEnum.SUCCESS,0,null);
            }

        } catch (Exception e) {
            apiResponse = new ApiResponse<SysRole>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     * 新增系统用户的角色
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysRole.insertSysUserRoleRef", descript = "新增系统用户的角色")
    @Override
    public ApiResponse<SysUserRoleRef> insertSysUserRoleRef(ApiRequest apiRequest) {
        Object sysUserIdObj = apiRequest.get("sysUserId");
        Object roleIdObj = apiRequest.get("roleId");
        if (StringUtils.isEmpty(sysUserIdObj)||StringUtils.isEmpty(roleIdObj)) {
            return new ApiResponse<SysUserRoleRef>(RestResultEnum.MissParameterException);
        }
        SysUserRoleRef sysUserRoleRef= new SysUserRoleRef();
        sysUserRoleRef.setSysUserId(Long.valueOf(sysUserIdObj.toString()));
        sysUserRoleRef.setRoleId(Long.valueOf(roleIdObj.toString()));
        ApiResponse<SysUserRoleRef> apiResponse = null;
        try {
            int result =  this.sysUserRoleRefMapper.insertSelective(sysUserRoleRef);
            if(result>0){
                apiResponse = new ApiResponse<SysUserRoleRef>(RestResultEnum.SUCCESS,1,sysUserRoleRef);
            }else{
                apiResponse = new ApiResponse<SysUserRoleRef>(RestResultEnum.FAIL,0,null);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse<SysUserRoleRef>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     * 修改系统用户的角色
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysRole.updateSysUserRoleRef", descript = "修改系统用户的角色")
    @Override
    public ApiResponse<SysUserRoleRef> updateSysUserRoleRef(ApiRequest apiRequest) {
        Object idObj = apiRequest.get("id");
        //Object sysUserIdObj = apiRequest.get("sysUserId");
        Object roleIdObj = apiRequest.get("roleId");
        if (StringUtils.isEmpty(idObj)||StringUtils.isEmpty(roleIdObj)) {
            return new ApiResponse<SysUserRoleRef>(RestResultEnum.MissParameterException);
        }
        SysUserRoleRef sysUserRoleRef= new SysUserRoleRef();
        sysUserRoleRef.setId(Long.valueOf(idObj.toString()));
//        if(!StringUtils.isEmpty(sysUserIdObj)){
//            sysUserRoleRef.setSysUserId(Long.valueOf(sysUserIdObj.toString()));
//        }
        if(!StringUtils.isEmpty(roleIdObj)){
            sysUserRoleRef.setRoleId(Long.valueOf(roleIdObj.toString()));
        }
        ApiResponse<SysUserRoleRef> apiResponse = null;
        try {
            int result =  this.sysUserRoleRefMapper.updateByPrimaryKeySelective(sysUserRoleRef);
            if(result>0){
                apiResponse = new ApiResponse<SysUserRoleRef>(RestResultEnum.SUCCESS,1,sysUserRoleRef);
            }else{
                apiResponse = new ApiResponse<SysUserRoleRef>(RestResultEnum.FAIL,0,null);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse<SysUserRoleRef>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     * 删除系统用户的角色
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysRole.deleteSysUserRoleRefById", descript = "删除系统用户的角色")
    @Override
    public ApiResponse<SysUserRoleRef> deleteSysUserRoleRefById(ApiRequest apiRequest) {
        Object idObj = apiRequest.get("id");
        if (StringUtils.isEmpty(idObj)) {
            return new ApiResponse<SysUserRoleRef>(RestResultEnum.MissParameterException);
        }
        ApiResponse<SysUserRoleRef> apiResponse = null;
        try {
            int result =  this.sysUserRoleRefMapper.deleteByPrimaryKey(Long.valueOf(idObj.toString()));
            if(result>0){
                apiResponse = new ApiResponse<SysUserRoleRef>(RestResultEnum.SUCCESS,1,null);
            }else{
                apiResponse = new ApiResponse<SysUserRoleRef>(RestResultEnum.SUCCESS,0,null);
            }

        } catch (Exception e) {
            apiResponse = new ApiResponse<SysUserRoleRef>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }

    /**
     * 根据用户ID查询角色
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysRole.selectSysRoleBySysUserId", descript = "根据用户ID查询角色")
    @Override
    public ApiResponse<List<SysRole>> selectSysRoleBySysUserId(ApiRequest apiRequest) {
        Object sysUserIdObj = apiRequest.get("sysUserId");
        if (StringUtils.isEmpty(sysUserIdObj)) {
            return new ApiResponse<List<SysRole>>(RestResultEnum.MissParameterException);
        }
        ApiResponse<List<SysRole>> apiResponse = null;
        try {
            HashMap<String,Object> hashMap = new HashMap<String, Object>();
            hashMap.put("sysUserId",sysUserIdObj.toString());
            List<SysRole>  sysRoles = this.sysRoleMapper.selectSysRoleBySysUserId(hashMap);
            if (sysRoles != null) {
                apiResponse = new ApiResponse<List<SysRole>>(RestResultEnum.SUCCESS, 1, sysRoles);
            }else{
                apiResponse = new ApiResponse<List<SysRole>>(RestResultEnum.SUCCESS, 0, null);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse<List<SysRole>>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }


}
