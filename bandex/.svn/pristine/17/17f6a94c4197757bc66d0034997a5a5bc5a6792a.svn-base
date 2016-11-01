package com.bandex.apicenter.appapi.impl;

import com.bandex.apicenter.appapi.AppIndexDataApi;
import com.bandex.apicenter.dao.UserInfoMapper;
import com.bandex.apicenter.model.UserInfo;
import com.bandex.apicenter.service.impl.BaseServiceImpl;
import com.bandex.base.annotations.ApiMethod;
import com.bandex.base.annotations.ApiParam;
import com.bandex.base.annotations.ApiService;
import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;
import com.bandex.base.enums.ApiMsgEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fanshuai on 16/10/25.
 */
@Service
@ApiService(descript = "app首页数据API")
public class AppIndexDataApiImpl extends BaseServiceImpl implements AppIndexDataApi {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @SuppressWarnings("rawtypes")
    @ApiMethod(descript = "app首页加载数据", value = "index-data", apiParams = { @ApiParam(name = "user_token",descript = "当前用户token(*)") })
    @Override
    public ApiResponse loadIndexData(ApiRequest apiReq) {
        try {
            Long userId = apiReq.getCurrentUserId();
            Map retData = new HashMap();
            if (userId==null){
                retData.put("userIcon",super.getUserIcon(null));
                retData.put("userIntegral","0");
            }else {
                UserInfo userInfo=userInfoMapper.selectByPrimaryKey(userId);
                retData.put("userIcon",super.getUserIcon(userInfo.getUserIcon()));
                retData.put("userIntegral",userInfo.getUserIntegral()==null?0:userInfo.getUserIntegral());
            }
            return new ApiResponse(ApiMsgEnum.SUCCESS,1,retData);
        }catch (Exception e){
            Map retData = new HashMap();
            retData.put("userIcon",super.getUserIcon(null));
            retData.put("userIntegral","0");
            return new ApiResponse(ApiMsgEnum.SUCCESS,1,retData);
        }

    }
}
