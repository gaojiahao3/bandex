package com.bandex.apicenter.appapi.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bandex.apicenter.appapi.CommonApi;
import com.bandex.apicenter.service.SmsService;
import com.bandex.apicenter.service.impl.BaseServiceImpl;
import com.bandex.base.annotations.ApiMethod;
import com.bandex.base.annotations.ApiParam;
import com.bandex.base.annotations.ApiService;
import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;
import com.bandex.base.enums.ApiMsgEnum;
import com.bandex.base.utils.RandomIDUtil;

@Service
@ApiService(descript = "通用API")
public class CommonApiImpl extends BaseServiceImpl implements CommonApi {
	@Autowired
	private SmsService smsService;

	@ApiMethod(descript = "获取配置", value = "common-getConfig", apiParams = {})
	@SuppressWarnings("rawtypes")
	@Override
	public ApiResponse getConfig(ApiRequest apiReq) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("driverReportInterval", 30);
		retMap.put("mustUpdateFlag", 1);
		// TODO
		return new ApiResponse<Map<String, Object>>(ApiMsgEnum.SUCCESS, retMap.size(), retMap);
	}

	@SuppressWarnings("rawtypes")
	@ApiMethod(descript = "发送短信", value = "common-sendSms", apiParams = { @ApiParam(descript = "手机号(*)", name = "phone") })
	@Override
	public ApiResponse sendSms(ApiRequest apiReq) {
		String phone = apiReq.getString("phone");
		if (StringUtils.isEmpty(phone)) {
			return new ApiResponse(ApiMsgEnum.MISS_PARAMETER);
		}
		smsService.sendSms(null, phone, RandomIDUtil.getNumber(6));
		return new ApiResponse(ApiMsgEnum.ValidateCodeSendSuccess);
	}

	@Override
	// @ApiMethod(needLogin = true, descript = "获取推送token", value =
	// "common-getPushToken", apiParams = {})
	@SuppressWarnings("rawtypes")
	public ApiResponse getPushToken(ApiRequest apiReq) {
		String pushToken = null;
		// if ("customer".equals(apiReq.getUserType())) {
		// CustomerInfo ci =
		// customerInfoMapper.selectByPrimaryKey(apiReq.getCurrentUserId());
		// if (ci != null) {
		// if (!StringUtils.isEmpty(ci.getPushToken())) {
		// pushToken = ci.getPushToken();
		// } else {
		// pushToken = pushService.getToken(apiReq.getCurrentUserId(),
		// apiReq.getCurrentUserDisplayName(), userDefaultIcon);
		// CustomerInfo record2 = new CustomerInfo();
		// record2.setId(apiReq.getCurrentUserId());
		// record2.setPushToken(pushToken);
		// this.customerInfoMapper.updateByPrimaryKey(record2);
		// }
		// }
		// } else {
		// DriverInfo di =
		// driverInfoMapper.selectByPrimaryKey(apiReq.getCurrentUserId());
		// if (di != null) {
		// if (!StringUtils.isEmpty(di.getPushToken())) {
		// pushToken = di.getPushToken();
		// } else {
		// pushToken = pushService.getToken(apiReq.getCurrentUserId(),
		// apiReq.getCurrentUserDisplayName(), userDefaultIcon);
		// DriverInfo record2 = new DriverInfo();
		// record2.setId(apiReq.getCurrentUserId());
		// record2.setPushToken(pushToken);
		// this.driverInfoMapper.updateByPrimaryKey(record2);
		// }
		// }
		// }
		return new ApiResponse<String>(ApiMsgEnum.SUCCESS, (pushToken == null ? 0 : 1), pushToken);
	}

}
