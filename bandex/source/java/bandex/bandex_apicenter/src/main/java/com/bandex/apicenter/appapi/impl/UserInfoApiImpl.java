package com.bandex.apicenter.appapi.impl;

import com.bandex.apicenter.appapi.UserInfoApi;
import com.bandex.apicenter.dao.CommonSportProjectMapper;
import com.bandex.apicenter.dao.UserInfoMapper;
import com.bandex.apicenter.dto.UserInfoDto;
import com.bandex.apicenter.model.CommonSportProject;
import com.bandex.apicenter.model.UserInfo;
import com.bandex.apicenter.service.impl.BaseServiceImpl;
import com.bandex.apicenter.util.FileUtils;
import com.bandex.base.annotations.ApiMethod;
import com.bandex.base.annotations.ApiParam;
import com.bandex.base.annotations.ApiService;
import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;
import com.bandex.base.enums.ApiMsgEnum;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by fanshuai on 16/10/25.
 */
@Service
@ApiService(descript = "用户基本信息服务")
public class UserInfoApiImpl extends BaseServiceImpl implements UserInfoApi {

    @Value("img.host")
    private String imgHost;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private CommonSportProjectMapper sportProjectMapper;
    @SuppressWarnings("rawtypes")
    @ApiMethod(needLogin = true,descript = "查询用户基本信息", value = "user-info-load", apiParams = {@ApiParam(name = "user_token",descript = "当前用户token(*)")   })
    @Override
    public ApiResponse loadUserInfo(ApiRequest apiReq) {
        Map retMap = new HashMap();
        Long userId = apiReq.getCurrentUserId();
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUserId(userId);
        userInfoDto.setNickName(userInfo.getNickName());
        userInfoDto.setUserIcon(super.getUserIcon(this.getCdnUrl(null, userInfo.getUserIcon(),null)));
        userInfoDto.setBirthday(userInfo.getBirthday()!=null?userInfo.getBirthday().getTime():null);
        userInfoDto.setHobby(userInfo.getHobby());
        userInfoDto.setGymnasium(userInfo.getGymnasium());
        userInfoDto.setHeight(userInfo.getHeight());
        userInfoDto.setWeight(userInfo.getWeight());
        userInfoDto.setSex(userInfo.getSex());
        userInfoDto.setUserIntegral(userInfo.getUserIntegral()==null?0: userInfo.getUserIntegral());
        retMap.put("userInfo",userInfoDto);
        List<CommonSportProject> sportProjectList = sportProjectMapper.selectAll();

        List<Map> sportProjectMapList = new ArrayList<>(sportProjectList.size());
        for (CommonSportProject sportProject:sportProjectList){
            Map sportProjectMap = new HashMap();
            sportProjectMap.put("id",sportProject.getId());
            sportProjectMap.put("sportName",sportProject.getSportName());
            sportProjectMapList.add(sportProjectMap);
        }
        retMap.put("sportProjectList",sportProjectMapList);
        return new ApiResponse(ApiMsgEnum.SUCCESS,1,retMap);
    }

    @SuppressWarnings("rawtypes")
    @ApiMethod(needLogin = true,descript = "修改用户基本信息", value = "user-info-update", apiParams = {@ApiParam(name = "user_token",descript = "当前用户token(*)")   })
    @Override
    public ApiResponse updateUserInfo(ApiRequest apiReq) {
        try {
            checkParam_updateUserInfo(apiReq);
        } catch (Exception e) {
            Map retMap = new HashMap();
            retMap.put("errorMsg",e.getMessage());
            return new ApiResponse(ApiMsgEnum.DATA_FORMAT_EXCEPTION,1,retMap);
        }
        try {
            Long userId = apiReq.getCurrentUserId();
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
            String nickName = apiReq.getString("nickName");
            Integer sex = apiReq.getInt("sex");
            String birthday_str = apiReq.getString("birthday");
            Date birthday = null;
            try {
                birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthday_str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Integer height = apiReq.getInt("height");
            Double weight = apiReq.getDouble("weight");
            String hobby = apiReq.getString("hobby");
            String gymnasium = apiReq.getString("gymnasium");
            userInfo.setNickName(nickName);
            userInfo.setSex(sex);
            userInfo.setBirthday(birthday);
            userInfo.setHeight(height);
            userInfo.setWeight(weight);
            userInfo.setHobby(hobby);
            userInfo.setGymnasium(gymnasium);
            userInfoMapper.updateByPrimaryKey(userInfo);
            return new ApiResponse(ApiMsgEnum.SUCCESS);
        }catch (Exception e){
            return new ApiResponse(ApiMsgEnum.FAIL);
        }
    }

    @SuppressWarnings("rawtypes")
    @ApiMethod(needLogin = true,descript = "修改图片为自定义上传图片", value = "user-info-updateIcon", apiParams = {@ApiParam(name = "user_token",descript = "当前用户token(*)"),@ApiParam(name = "fileData",descript = "自定义图片base64编码(*)")   })
    @Override
    public ApiResponse updateUserIcon(ApiRequest apiReq) {
        Long userId = apiReq.getCurrentUserId();
        String userIcon = apiReq.getString("userIcon");
        if (StringUtils.isNullOrEmpty(userIcon)){
            String fileData = apiReq.getString("fileData");
            String filePath = FileUtils.saveBytesToFile("userIcon",fileData);
            userIcon=filePath;
        }
        UserInfo userInfo=userInfoMapper.selectByPrimaryKey(userId);
        userInfo.setUserIcon(userIcon);
        int updatedNum = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        if (updatedNum>0){
            //update success
            return new ApiResponse(ApiMsgEnum.SUCCESS,1,this.getCdnUrl(null,userIcon,null));
        }else {
            //update fail
            return new ApiResponse(ApiMsgEnum.FAIL);
        }
    }

    private void checkParam_updateUserInfo(ApiRequest apiReq) throws Exception {
        String nickName = apiReq.getString("nickName");
        if (StringUtils.isNullOrEmpty(nickName)||nickName.length()>20){
            throw new Exception("昵称不能为空且小于20字符");
        }
        Integer sex = apiReq.getInt("sex");
        if (sex==null ||(sex!=1 && sex!=2)){
            throw new  Exception("性别选择不正确");
        }
        String birthday_str = apiReq.getString("birthday");
        Date birthday = null;
        try {
            birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthday_str);
        } catch (ParseException e) {
            throw new  Exception("生日选择不正确");
        }
        Integer height = apiReq.getInt("height");
        if (height!=null && (height<1 || height>230)){
            throw new  Exception("请填写正确的身高");
        }
        Double weight = apiReq.getDouble("weight");
        if (weight!=null && (weight<1 || weight>300)){
            throw new  Exception("请填写正确的体重");
        }
        String hobby = apiReq.getString("hobby");
        if (StringUtils.isNullOrEmpty(hobby)){
            List<CommonSportProject>  commonSportProjects=sportProjectMapper.selectAll();
            for(String ho : hobby.split(",")){
                if (!hasRightHobby(ho,commonSportProjects)){
                    throw new  Exception("请填写正确的爱好运动");
                }
            }
        }
        String gymnasium = apiReq.getString("gymnasium");
    }
    private boolean hasRightHobby(String hobby,List<CommonSportProject>  commonSportProjects){
        try {
            int hobbyId=Integer.parseInt(hobby);
            for (CommonSportProject commonSportProject:commonSportProjects){
                if (commonSportProject.getId()==hobbyId){
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            return false;
        }

    }

}
