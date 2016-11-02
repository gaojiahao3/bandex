package com.bandex.apicenter.service.impl;

import org.springframework.stereotype.Service;

import com.bandex.apicenter.service.IntegralService;
import com.bandex.base.enums.ApiMsgEnum;
import com.bandex.base.enums.UserActionTypeEnum;

@Service
public class IntegralServiceImpl extends BaseServiceImpl implements IntegralService {

	@Override
	public ApiMsgEnum reduceIntegral(UserActionTypeEnum actionEnum, Long actionId, Integer reduceIntegral) {
		// TODO Auto-generated method stub
		return ApiMsgEnum.SUCCESS;
	}

}
