package com.bandex.apicenter.appapi.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.StringUtils;

import com.bandex.apicenter.appapi.UserLoginApi;
import com.bandex.apicenter.dao.UserInfoMapper;
import com.bandex.apicenter.dao.UserLoginMapper;
import com.bandex.apicenter.dto.UserSessionDto;
import com.bandex.apicenter.dto.WechatUserDto;
import com.bandex.apicenter.dto.WeiboUserDto;
import com.bandex.apicenter.model.UserInfo;
import com.bandex.apicenter.model.UserLogin;
import com.bandex.apicenter.service.RedisService;
import com.bandex.apicenter.service.SmsService;
import com.bandex.apicenter.service.WeiboService;
import com.bandex.apicenter.service.WeixinService;
import com.bandex.apicenter.service.impl.BaseServiceImpl;
import com.bandex.base.annotations.ApiMethod;
import com.bandex.base.annotations.ApiParam;
import com.bandex.base.annotations.ApiService;
import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;
import com.bandex.base.enums.ApiMsgEnum;
import com.bandex.base.utils.RandomIDUtil;

@Service
@ApiService(descript = "用户登录相关API")
public class UserLoginApiImpl extends BaseServiceImpl implements UserLoginApi {
	private static final Logger loger = Logger.getLogger(UserLoginApiImpl.class);
	@Autowired
	private UserLoginMapper userLoginMapper;

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Autowired
	private SmsService smsService;

	@Autowired
	private RedisService redisService;

	@Autowired
	private WeixinService weixinService;

	@Autowired
	private WeiboService weiboService;

	@Resource
	private PlatformTransactionManager platformTransactionManager;

	@SuppressWarnings("rawtypes")
	@ApiMethod(descript = "用户登录", value = "user-login", apiParams = { @ApiParam(descript = "手机号(*)", name = "phone"), @ApiParam(descript = "验证码(*)", name = "validateCode") })
	@Override
	public ApiResponse login(ApiRequest apiReq) {
		String phone = apiReq.getString("phone");
		String validateCode = apiReq.getString("validateCode");
		if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(validateCode)) {
			return new ApiResponse(ApiMsgEnum.MISS_PARAMETER);
		}
		if (!smsService.verifySmsCode(phone, validateCode)) {
			return new ApiResponse(ApiMsgEnum.SmsCodeError);
		}
		UserSessionDto sessionDto = new UserSessionDto();
		UserLogin user = this.userLoginMapper.selectByPhone(phone);
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			Long userId = null;
			if (user == null) {
				UserLogin record = new UserLogin();
				record.setUserTelphone(phone);
				this.userLoginMapper.insert(record);
				userId = record.getUserId();

				UserInfo userInfoRecord = new UserInfo();
				userInfoRecord.setUserId(userId);
				userInfoRecord.setModifyTime(new Date());
				this.userInfoMapper.insert(userInfoRecord);

				sessionDto.setIcon(super.getUserIcon(null));
				sessionDto.setPhone(record.getUserTelphone());
				sessionDto.setDisplayName(this.getDisplayName(record.getUserTelphone(), null));
				// sessionDto.setPushToken(pushToken);
			} else {
				userId = user.getUserId();

				UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
				sessionDto.setIcon(super.getUserIcon(userInfo.getUserIcon()));
				sessionDto.setPhone(user.getUserTelphone());
				sessionDto.setDisplayName(this.getDisplayName(user.getUserTelphone(), userInfo.getNickName()));
				// sessionDto.setPushToken(customer.getPushToken());
			}
			String loginToken = RandomIDUtil.getNewUUID();
			// 用户session写入缓存
			sessionDto.setUserId(userId);
			sessionDto.setUserToken(loginToken);
			redisService.setUserSession(loginToken, sessionDto);

			platformTransactionManager.commit(transactionStatus);
			sessionDto.setUserId(null);
			return new ApiResponse<UserSessionDto>(ApiMsgEnum.LoginSuccess, 1, sessionDto);
		} catch (RuntimeException e) {
			loger.error(e);
			platformTransactionManager.rollback(transactionStatus);
			return new ApiResponse(ApiMsgEnum.BAD_REQUEST);
		}
	}

	@SuppressWarnings("rawtypes")
	@ApiMethod(descript = "微信登录", value = "user-loginByWechat", apiParams = { @ApiParam(descript = "授权CODE(*)", name = "authCode") })
	@Override
	public ApiResponse loginByWechat(ApiRequest apiReq) {
		String authCode = apiReq.getString("authCode");
		if (StringUtils.isEmpty(authCode)) {
			return new ApiResponse(ApiMsgEnum.MISS_PARAMETER);
		}
		WechatUserDto wechatUserDto = this.weixinService.getUserInfoByCode(authCode);
		if (wechatUserDto == null) {
			return new ApiResponse(ApiMsgEnum.SnsAccountBindFail);
		}
		UserSessionDto sessionDto = new UserSessionDto();
		UserLogin user = this.userLoginMapper.selectByWechatId(wechatUserDto.getOpenid());
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			Long userId = null;
			if (user == null) {
				UserLogin record = new UserLogin();
				record.setWechatId(wechatUserDto.getOpenid());
				this.userLoginMapper.insert(record);
				userId = record.getUserId();

				UserInfo userInfoRecord = new UserInfo();
				userInfoRecord.setUserId(userId);
				userInfoRecord.setModifyTime(new Date());
				userInfoRecord.setNickName(wechatUserDto.getNickname());
				userInfoRecord.setUserIcon(wechatUserDto.getHeadimgurl());
				userInfoRecord.setSex("1".equals(wechatUserDto.getSex()) ? 1 : 2);
				this.userInfoMapper.insert(userInfoRecord);

				sessionDto.setIcon(super.getUserIcon(wechatUserDto.getHeadimgurl()));
				sessionDto.setPhone(record.getUserTelphone());
				sessionDto.setDisplayName(this.getDisplayName(wechatUserDto.getNickname(), null));
				// sessionDto.setPushToken(pushToken);
			} else {
				userId = user.getUserId();

				UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
				sessionDto.setIcon(super.getUserIcon(userInfo.getUserIcon()));
				sessionDto.setPhone(user.getUserTelphone());
				sessionDto.setDisplayName(this.getDisplayName(user.getUserTelphone(), userInfo.getNickName()));
				// sessionDto.setPushToken(customer.getPushToken());
			}
			String loginToken = RandomIDUtil.getNewUUID();
			// 用户session写入缓存
			sessionDto.setUserId(userId);
			sessionDto.setUserToken(loginToken);
			redisService.setUserSession(loginToken, sessionDto);

			platformTransactionManager.commit(transactionStatus);
			sessionDto.setUserId(null);
			return new ApiResponse<UserSessionDto>(ApiMsgEnum.LoginSuccess, 1, sessionDto);
		} catch (RuntimeException e) {
			loger.error(e);
			platformTransactionManager.rollback(transactionStatus);
			return new ApiResponse(ApiMsgEnum.BAD_REQUEST);
		}
	}

	@SuppressWarnings("rawtypes")
	@ApiMethod(descript = "微博登录", value = "user-loginByWeibo", apiParams = { @ApiParam(descript = "授权CODE(*)", name = "authCode") })
	@Override
	public ApiResponse loginByWeibo(ApiRequest apiReq) {
		String authCode = apiReq.getString("authCode");
		if (StringUtils.isEmpty(authCode)) {
			return new ApiResponse(ApiMsgEnum.MISS_PARAMETER);
		}
		WeiboUserDto weiboUserDto = this.weiboService.getUserByCode(authCode);
		if (weiboUserDto == null) {
			return new ApiResponse(ApiMsgEnum.SnsAccountBindFail);
		}
		UserSessionDto sessionDto = new UserSessionDto();
		UserLogin user = this.userLoginMapper.selectByWeiboId(weiboUserDto.getId());
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			Long userId = null;
			if (user == null) {
				UserLogin record = new UserLogin();
				record.setWechatId(weiboUserDto.getId());
				this.userLoginMapper.insert(record);
				userId = record.getUserId();

				UserInfo userInfoRecord = new UserInfo();
				userInfoRecord.setUserId(userId);
				userInfoRecord.setModifyTime(new Date());
				userInfoRecord.setNickName(weiboUserDto.getScreenName());
				userInfoRecord.setUserIcon(weiboUserDto.getAvatarLarge());
				userInfoRecord.setSex("m".equals(weiboUserDto.getGender()) ? 1 : 2);
				this.userInfoMapper.insert(userInfoRecord);

				sessionDto.setIcon(super.getUserIcon(weiboUserDto.getAvatarLarge()));
				sessionDto.setPhone(record.getUserTelphone());
				sessionDto.setDisplayName(this.getDisplayName(weiboUserDto.getScreenName(), null));
				// sessionDto.setPushToken(pushToken);
			} else {
				userId = user.getUserId();

				UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
				sessionDto.setIcon(super.getUserIcon(userInfo.getUserIcon()));
				sessionDto.setPhone(user.getUserTelphone());
				sessionDto.setDisplayName(this.getDisplayName(user.getUserTelphone(), userInfo.getNickName()));
				// sessionDto.setPushToken(customer.getPushToken());
			}
			String loginToken = RandomIDUtil.getNewUUID();
			// 用户session写入缓存
			sessionDto.setUserId(userId);
			sessionDto.setUserToken(loginToken);
			redisService.setUserSession(loginToken, sessionDto);

			platformTransactionManager.commit(transactionStatus);
			sessionDto.setUserId(null);
			return new ApiResponse<UserSessionDto>(ApiMsgEnum.LoginSuccess, 1, sessionDto);
		} catch (RuntimeException e) {
			loger.error(e);
			platformTransactionManager.rollback(transactionStatus);
			return new ApiResponse(ApiMsgEnum.BAD_REQUEST);
		}
	}

	@SuppressWarnings("rawtypes")
	@ApiMethod(needLogin = true, descript = "用户退出", value = "user-logout")
	@Override
	public ApiResponse logout(ApiRequest apiReq) {
		redisService.removeUserSession(apiReq.getUserToken());
		return new ApiResponse(ApiMsgEnum.LogoutSuccess);
	}

}
