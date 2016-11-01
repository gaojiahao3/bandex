package com.bandex.api.service.member;

import com.bandex.api.dto.ApiRequest;
import com.bandex.api.dto.ApiResponse;
import com.bandex.api.model.UserInfo;

import java.util.List;

/**
 * 会员相关的API
 * 
 * @author jason
 */
public interface MemberService {

	ApiResponse<UserInfo> getUserInfo(ApiRequest apiRequest);

    ApiResponse<UserInfo> registeUser(ApiRequest apiRequest);

    ApiResponse<UserInfo> userLogin(ApiRequest apiRequest);

    ApiResponse<UserInfo> checkMobileNo(ApiRequest apiRequest);

    public ApiResponse<UserInfo> sendSMS(ApiRequest apiRequest);

    public ApiResponse<UserInfo> registerSendSms(ApiRequest apiRequest);


}
