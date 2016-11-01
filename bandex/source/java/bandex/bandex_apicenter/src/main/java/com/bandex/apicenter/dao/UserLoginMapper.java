package com.bandex.apicenter.dao;

import com.bandex.apicenter.model.UserLogin;

public interface UserLoginMapper {
	int deleteByPrimaryKey(Long userId);

	int insert(UserLogin record);

	int insertSelective(UserLogin record);

	UserLogin selectByPrimaryKey(Long userId);

	UserLogin selectByPhone(String phone);

	UserLogin selectByWechatId(String wechatId);

	UserLogin selectByWeiboId(String weiboId);

	int updateByPrimaryKeySelective(UserLogin record);

	int updateByPrimaryKey(UserLogin record);
}