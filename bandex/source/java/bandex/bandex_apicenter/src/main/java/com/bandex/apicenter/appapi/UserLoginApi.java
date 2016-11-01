package com.bandex.apicenter.appapi;

import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;

public interface UserLoginApi {

	@SuppressWarnings("rawtypes")
	ApiResponse login(ApiRequest apiReq);

	@SuppressWarnings("rawtypes")
	ApiResponse loginByWechat(ApiRequest apiReq);

	@SuppressWarnings("rawtypes")
	ApiResponse loginByWeibo(ApiRequest apiReq);

	@SuppressWarnings("rawtypes")
	ApiResponse logout(ApiRequest apiReq);
}
