package com.bandex.apicenter.appapi;

import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;

/**
 * 通用API
 * 
 * @author Daniel
 */
public interface CommonApi {
	/**
	 * 
	 * 获取配置
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	ApiResponse getConfig(ApiRequest apiReq);

	/**
	 * 发送短信验证码
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	ApiResponse sendSms(ApiRequest apiReq);

	/**
	 * 获取推送token
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	ApiResponse getPushToken(ApiRequest apiReq);

}
