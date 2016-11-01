package com.bandex.apicenter.appapi.impl;

import com.bandex.apicenter.appapi.UserIntegrationApi;
import com.bandex.apicenter.dao.UserIntegrationDetailMapper;
import com.bandex.apicenter.dto.UserIntegrationDetailDto;
import com.bandex.apicenter.model.UserIntegrationDetail;
import com.bandex.apicenter.service.impl.BaseServiceImpl;
import com.bandex.base.annotations.ApiMethod;
import com.bandex.base.annotations.ApiParam;
import com.bandex.base.annotations.ApiService;
import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;
import com.bandex.base.enums.ApiMsgEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fanshuai on 16/10/26.
 */
@Service
@ApiService(descript = "用户积分服务")
public class UserIntegrationApiImpl extends BaseServiceImpl implements UserIntegrationApi {
    @Autowired
    private UserIntegrationDetailMapper integrationDetailMapper;

    @ApiMethod(needLogin = true,descript = "用户积分明细", value =  "user-integration-detail", apiParams = {@ApiParam(name = "user_token",descript = "当前用户token(*)")   })
    @Override
    public ApiResponse queryIntegraDetail(ApiRequest apiReq) {
        Map retMap = new HashMap();
        Long userId=apiReq.getCurrentUserId();
        List<UserIntegrationDetail> userIntegrationDetails = integrationDetailMapper.selectAllByUserId(userId,getPageIndex(apiReq), getAppPageSize(apiReq));
        if (userIntegrationDetails ==null){
            userIntegrationDetails =new ArrayList<>();
        }
        List<UserIntegrationDetailDto> integrationDetailDtoList  = new ArrayList<>(userIntegrationDetails.size());
        for (UserIntegrationDetail userIntegrationDetail: userIntegrationDetails){
            UserIntegrationDetailDto integrationDetailDto = new UserIntegrationDetailDto();
            integrationDetailDto.setId(userIntegrationDetail.getId());
            integrationDetailDto.setRemark(userIntegrationDetail.getRemark());
            integrationDetailDto.setIntegralNum(userIntegrationDetail.getIntegralNum());
            integrationDetailDto.setCreateTime(userIntegrationDetail.getCreateTime()==null?null:userIntegrationDetail.getCreateTime().getTime());
            integrationDetailDtoList.add(integrationDetailDto);
        }
        retMap.put("integrationDetailList",integrationDetailDtoList);
        return new ApiResponse(ApiMsgEnum.SUCCESS,(getPageIndex(apiReq)+ userIntegrationDetails.size()),retMap);
    }

}
