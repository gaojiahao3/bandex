package com.bandex.api.service.sys;

import com.bandex.api.annotations.FunctionCode;
import com.bandex.api.constants.Constant;
import com.bandex.api.dao.SysResourceMapper;
import com.bandex.api.dao.SysUserMapper;
import com.bandex.api.dto.ApiRequest;
import com.bandex.api.dto.ApiResponse;
import com.bandex.api.dto.Pagination;
import com.bandex.api.dto.UserDto;
import com.bandex.api.enums.MemcachedKeyEnum;
import com.bandex.api.enums.RestResultEnum;
import com.bandex.api.model.SysResourcePo;
import com.bandex.api.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sh.zj100.common.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FunctionCode(value = "sysUser", descript = "用户相关的API")
@Service
public class SysUserServiceImpl implements SysUserService {

    @Value("${cookie.domain}")
    protected String cookieDomain;

	@Autowired
	private SysUserMapper sysUserMapper;

    @Autowired
    private SysResourceMapper sysResourceMapper;


    @FunctionCode(value = "sysUser.userinfo", descript = "系统用户信息")
	@Override
	public ApiResponse<SysUser> getUserInfo(ApiRequest apiRequest) {
		Object obj = apiRequest.get("userId");
		if (StringUtils.isEmpty(obj)) {
			return new ApiResponse<SysUser>(RestResultEnum.MissParameterException);
		}
		ApiResponse<SysUser> apiResponse = null;
		try {
			SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(obj.toString()));
            sysUser.setPassword(null);
			if (sysUser != null) {
                apiResponse = new ApiResponse<SysUser>(RestResultEnum.SUCCESS, 1, sysUser);
			}

		} catch (Exception e) {
			apiResponse = new ApiResponse<SysUser>(RestResultEnum.INVOKE_ERROR);
		}
		return apiResponse;
	}
    @FunctionCode(value = "sysUser.login", descript = "系统用户登录")
    @Override
    public ApiResponse<UserDto> sysUserLogin(ApiRequest apiRequest) {
        Object name = apiRequest.get("username");
        Object password = apiRequest.get("password");
        //Object sysUserTypeObj = apiRequest.get("sysUserType");
        if (StringUtils.isEmpty(name)||StringUtils.isEmpty(password)) {
            return new ApiResponse<UserDto>(RestResultEnum.MissParameterException);
        }
        ApiResponse<UserDto> apiResponse = null;
        try {
            //Integer sysUserType=Integer.parseInt(sysUserTypeObj.toString());
            HashMap<String, String> paramMap = new HashMap<String, String>();
            paramMap.put("userName", name.toString());
            paramMap.put("password", Md5Util.encodeString(password.toString()));
            SysUser user = sysUserMapper.selectUserByLogin(paramMap);
            user.setPassword(null);
            UserDto userDto=new UserDto();
            ObjectUtil.copyProperties(userDto,user);
            if (user != null) {
//                Integer userType=user.getSysUserType();
//                if(userType!=4&&userType!=sysUserType){
//                    return new ApiResponse<UserDto>(RestResultEnum.NoPermissionException);
//                }
                // 将用户对象放入memcached
                String cookieUserId = RandomIDUtil.getNewUUID();
                userDto.setCookieUserId(cookieUserId);
                String memKey = MemcachedKeyEnum.USER_SESSION.name() + "-" + cookieUserId;
                MemcachedUtil.getInstance().set(memKey, userDto);
                String memKeyJson = MemcachedKeyEnum.USER_SESSION_JSON.name() + "-" + cookieUserId;
                System.out.println("memKeyJson==="+memKeyJson);
                MemcachedUtil.getInstance().set(memKeyJson, JsonUtil.object2Fastjson(userDto));
                apiResponse = new ApiResponse<UserDto>(RestResultEnum.SUCCESS, 1, userDto);
            }else{
                apiResponse = new ApiResponse<UserDto>(RestResultEnum.FAIL);
            }

        } catch (Exception e) {
            e.printStackTrace();
            apiResponse = new ApiResponse<UserDto>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    @FunctionCode(value ="sysUser.isLogin", descript = "系统用户是否已经登录")
    @Override
    public ApiResponse<UserDto> isLogin(ApiRequest apiRequest) {
        Object cookieUserIdObj = apiRequest.get("cookieUserId");
        if (StringUtils.isEmpty(cookieUserIdObj)) {
            return new ApiResponse<UserDto>(RestResultEnum.MissParameterException);
        }
        ApiResponse<UserDto> apiResponse = null;
        try {
            UserDto userDto = null;
            if (cookieUserIdObj != null) {
                userDto = getUserDtoFromMemcached(cookieUserIdObj.toString());
                apiResponse = new ApiResponse<UserDto>(RestResultEnum.SUCCESS, 1, userDto);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse<UserDto>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     *
     * 获得Memcached中的用户
     *
     * @param cookieUserId
     * @return
     * @author Lynch
     */
    public static UserDto getUserDtoFromMemcached(String cookieUserId) {
        UserDto userDto = null;
        if (cookieUserId != null) {
            String memKeySessionJson = MemcachedKeyEnum.USER_SESSION_JSON.name() + "-" + cookieUserId;
            String json = (String) MemcachedUtil.getInstance().get(memKeySessionJson);
            userDto = JsonUtil.fastjson2Object(json, UserDto.class);
        }
        return userDto;
    }

    @FunctionCode(value = "sysUser.updateUserPassword", descript = "系统用户修改密码")
    @Override
    public ApiResponse<String> updateUserPassword(ApiRequest apiRequest) {
        Object userNameObj = apiRequest.get("userName");
        Object oldPasswordObj = apiRequest.get("oldPassword");
        Object newPasswordObj = apiRequest.get("newPassword");
        if (StringUtils.isEmpty(userNameObj)||StringUtils.isEmpty(oldPasswordObj)||StringUtils.isEmpty(newPasswordObj)) {
            return new ApiResponse<String>(RestResultEnum.MissParameterException);
        }
        ApiResponse<String> apiResponse = null;
        try {
            HashMap<String, String> paramMap = new HashMap<String, String>();
            paramMap.put("userName", userNameObj.toString());
            paramMap.put("password", Md5Util.encodeString(oldPasswordObj.toString()));
            SysUser user = sysUserMapper.selectUserByLogin(paramMap);
            if(user!=null){
                paramMap.clear();
                paramMap.put("userName", userNameObj.toString());
                paramMap.put("oldPassword", Md5Util.encodeString(oldPasswordObj.toString()));
                paramMap.put("newPassword", Md5Util.encodeString(newPasswordObj.toString()));
                int flag = sysUserMapper.updateUserPassword(paramMap);
                if(flag>0){
                    apiResponse = new ApiResponse<String>(RestResultEnum.SUCCESS, 1, "修改成功");
                }else{
                    apiResponse = new ApiResponse<String>(RestResultEnum.FAIL, 0,"修改失败");
                }
            }else{
                apiResponse = new ApiResponse<String>(RestResultEnum.FAIL, 0,"用户名或密码错误!");
            }

        } catch (Exception e) {
            apiResponse = new ApiResponse<String>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }

    /**
     * 查询系统用户列表
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysUser.getSysUserList", descript = "查询系统用户列表")
    @Override
    public ApiResponse<List<SysUser>> getSysUserList(ApiRequest apiRequest) {
        Object sysUserTypeObj = apiRequest.get("sysUserType");
        Object realNameObj = apiRequest.get("realName");
        Object sysUserTelObj = apiRequest.get("sysUserTel");
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
        ApiResponse<List<SysUser>> apiResponse = null;
        try {
            HashMap<String,Object> hashMap =new HashMap<String,Object>();
            Pagination<SysUser> poPagination = new Pagination<SysUser>(pageNo, pageSize);
            hashMap.put("startIndex", (pageNo-1)*pageSize);
            hashMap.put("endIndex", pageSize);
            if (!StringUtils.isEmpty(sysUserTypeObj)) {
                hashMap.put("sysUserType", sysUserTypeObj);
            }
            if (!StringUtils.isEmpty(realNameObj)) {
                hashMap.put("realName", realNameObj);
            }
            if (!StringUtils.isEmpty(sysUserTelObj)) {
                hashMap.put("sysUserTel", sysUserTelObj);
            }
            Long count = this.sysUserMapper.selectSysUserCount(hashMap);
            List<SysUser> logisticAreaList = this.sysUserMapper.selectSysUserList(hashMap);
            poPagination.setNumFound(count);
            poPagination.setData(logisticAreaList);
            apiResponse = new ApiResponse<List<SysUser>>(RestResultEnum.SUCCESS, (poPagination == null ? 0 : (int) poPagination.getNumFound()), poPagination.getData());
        } catch (Exception e) {
            e.printStackTrace();
            apiResponse = new ApiResponse<List<SysUser>>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     * 新增系统用户
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysUser.insertSysUser", descript = "新增系统用户")
    @Override
    public ApiResponse<SysUser> insertSysUser(ApiRequest apiRequest) {
        Object sysUserNameObj = apiRequest.get("sysUserName");
        Object passwordObj = apiRequest.get("password");
        Object sysUserSexObj = apiRequest.get("sysUserSex");
        Object sysUserTelObj = apiRequest.get("sysUserTel");
        Object realNameObj = apiRequest.get("realName");
        Object emailObj = apiRequest.get("email");
        if (StringUtils.isEmpty(sysUserNameObj)||StringUtils.isEmpty(passwordObj)||StringUtils.isEmpty(sysUserSexObj)||StringUtils.isEmpty(sysUserTelObj)
                ||StringUtils.isEmpty(realNameObj)||StringUtils.isEmpty(emailObj)) {
            return new ApiResponse<SysUser>(RestResultEnum.MissParameterException);
        }
        SysUser sysUser= new SysUser();
        String password=Md5Util.encodeString(passwordObj.toString());
        sysUser.setPassword(password);
        sysUser.setSysUserName(sysUserNameObj.toString());
        sysUser.setSysUserSex(Integer.parseInt(sysUserSexObj.toString()));
        sysUser.setSysUserTel(sysUserTelObj.toString());
        sysUser.setRealName(realNameObj.toString());
        sysUser.setEmail(emailObj.toString());
        ApiResponse<SysUser> apiResponse = null;
        try {
            int result = this.sysUserMapper.insertSelective(sysUser);
            if(result>0){
                sysUser.setPassword(null);
                apiResponse = new ApiResponse<SysUser>(RestResultEnum.SUCCESS,1,sysUser);
            }else{
                apiResponse = new ApiResponse<SysUser>(RestResultEnum.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            apiResponse = new ApiResponse<SysUser>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     * 修改系统用户信息
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysUser.updateSysUser", descript = "修改系统用户信息")
    @Override
    public ApiResponse<SysUser> updateSysUser(ApiRequest apiRequest) {
        Object idObj = apiRequest.get("id");
        Object sysUserNameObj = apiRequest.get("sysUserName");
        Object sysUserSexObj = apiRequest.get("sysUserSex");
        Object sysUserTelObj = apiRequest.get("sysUserTel");
        Object realNameObj = apiRequest.get("realName");
        Object emailObj = apiRequest.get("email");
        Object stateObj = apiRequest.get("state");
        if (StringUtils.isEmpty(idObj)) {
            return new ApiResponse<SysUser>(RestResultEnum.MissParameterException);
        }
        SysUser sysUser= new SysUser();
        sysUser.setId(Long.valueOf(idObj.toString()));
        if(!StringUtils.isEmpty(sysUserNameObj)){
            sysUser.setSysUserName(sysUserNameObj.toString());
        }
        if(!StringUtils.isEmpty(sysUserSexObj)){
            sysUser.setSysUserSex(Integer.parseInt(sysUserSexObj.toString()));
        }
        if(!StringUtils.isEmpty(sysUserTelObj)){
            sysUser.setSysUserTel(sysUserTelObj.toString());
        }
        if(!StringUtils.isEmpty(realNameObj)){
            sysUser.setRealName(realNameObj.toString());
        }
        if(!StringUtils.isEmpty(emailObj)){
            sysUser.setEmail(emailObj.toString());
        }
        if(!StringUtils.isEmpty(stateObj)){
            sysUser.setSysUserState(Integer.valueOf(stateObj.toString()));
        }

        ApiResponse<SysUser> apiResponse = null;
        try {
            int result = this.sysUserMapper.updateByPrimaryKeySelective(sysUser);
            if(result>0){
                apiResponse = new ApiResponse<SysUser>(RestResultEnum.SUCCESS,1,sysUser);
            }else{
                apiResponse = new ApiResponse<SysUser>(RestResultEnum.FAIL);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse<SysUser>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    @FunctionCode(value = "sysUser.getMenuList", descript = "查询菜单")
    @Override
    public ApiResponse<List<SysResourcePo>> getMenuList(ApiRequest apiRequest) {
        Object obj = apiRequest.get("userId");
        if (StringUtils.isEmpty(obj)) {
            return new ApiResponse<List<SysResourcePo>>(RestResultEnum.MissParameterException);
        }
        ApiResponse<List<SysResourcePo>> apiResponse = null;
        try {
            HashMap<String,Object> map =new HashMap<String, Object>();
            map.put("resourceType",1);//资源类型(1菜单,2按钮)
            map.put("sysUserId",obj);
            List<SysResourcePo> resources=sysResourceMapper.getUserResources(map);
            List<SysResourcePo> twoResources=new ArrayList<SysResourcePo>();
            for(SysResourcePo sysResourcePo:resources){
                Long pId=sysResourcePo.getResourceId();
                List<SysResourcePo> sResources=new ArrayList<SysResourcePo>();
                for(SysResourcePo sysResource:resources){
                    if(sysResource.getParentId()!=null&&pId.longValue()==sysResource.getParentId().longValue()&&pId.longValue()!=sysResource.getResourceId().longValue()){
                        sResources.add(sysResource);
                        twoResources.add(sysResource);
                    }
                }
                if(sResources!=null&&sResources.size()>0){
                    sysResourcePo.setSysResourceList(sResources);
                }
            }
            for(SysResourcePo sysResourcePo:twoResources){
                resources.remove(sysResourcePo);
            }
            if (resources != null&&resources.size()>0) {
                apiResponse = new ApiResponse<List<SysResourcePo>>(RestResultEnum.SUCCESS, 1, resources);
            }else{
                apiResponse = new ApiResponse<List<SysResourcePo>>(RestResultEnum.SUCCESS, 0, resources);
            }

        } catch (Exception e) {
            apiResponse = new ApiResponse<List<SysResourcePo>>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }

    @FunctionCode(value = "sysUser.selectSysUserListByRoleId", descript = "根据角色查询用户列表")
    @Override
    public ApiResponse<List<SysUser>> selectSysUserListByRoleId(ApiRequest apiRequest) {
        Object obj = apiRequest.get("roleId");
        if (StringUtils.isEmpty(obj)) {
            return new ApiResponse<List<SysUser>>(RestResultEnum.MissParameterException);
        }
        ApiResponse<List<SysUser>> apiResponse = null;
        try {
            HashMap<String,Object> map =new HashMap<String, Object>();
            map.put("roleId",obj.toString());
            List<SysUser> sysUsers=this.sysUserMapper.selectSysUserListByRoleId(map);
            if (sysUsers != null&&sysUsers.size()>0) {
                apiResponse = new ApiResponse<List<SysUser>>(RestResultEnum.SUCCESS, 1, sysUsers);
            }else{
                apiResponse = new ApiResponse<List<SysUser>>(RestResultEnum.SUCCESS, 0, sysUsers);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse<List<SysUser>>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
    /**
     * 根据ID修改系统用户状态
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "sysUser.updateSysUserStateById", descript = "根据ID修改系统用户状态")
    @Override
    public ApiResponse<SysUser> updateSysUserStateById(ApiRequest apiRequest) {
        Object userIdObj = apiRequest.get("userId");
        Object userStateObj = apiRequest.get("userState");
        if (StringUtils.isEmpty(userIdObj)||StringUtils.isEmpty(userStateObj)) {
            return new ApiResponse<SysUser>(RestResultEnum.MissParameterException);
        }
        ApiResponse<SysUser> apiResponse = null;
        try {
            //SysUserState:用户状态（0：正常，1：冻结，2：删除）
            SysUser sysUser=new SysUser();
            sysUser.setId(Long.valueOf(userIdObj.toString()));
            sysUser.setSysUserState(Integer.parseInt(userStateObj.toString()));
            int result =  this.sysUserMapper.updateByPrimaryKeySelective(sysUser);
            if(result>0){
                apiResponse = new ApiResponse<SysUser>(RestResultEnum.SUCCESS,1,sysUser);
            }else{
                apiResponse = new ApiResponse<SysUser>(RestResultEnum.SUCCESS,0,null);
            }

        } catch (Exception e) {
            apiResponse = new ApiResponse<SysUser>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }
}
