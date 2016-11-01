/**
 * 
 */
package com.bandex.api.enums;

/**
 * memcached key前缀枚举
 * 
 * @author daniel
 */
public enum MemcachedKeyEnum {
	/**
	 * 消息提醒
	 */
	REMIND,
	/**
	 * 新鲜事
	 */
	NEWS,
	/**
	 * 广告位
	 */
	BANNER,
	/**
	 * 数据字典
	 */
	ENUM,
	/**
	 * 用户试图登录次数
	 */
	USER_LOGIN_FAIL_TIMES,
	/**
	 * 用户session
	 */
	USER_SESSION,
	/**
	 * 用户session
	 */
	USER_SESSION_JSON,
	/**
	 * 用户注册激活
	 */
	USER_ACTIVATE_REG,
	/**
	 * 用户重置密码
	 */
	USER_RESET_PWD,
	/**
	 * 用户访问权限URL列表
	 */
	USER_ACCESS_AUTH_URL,
	/**
	 * 用户最后访问时间
	 */
	USER_VISIT_TIME,
	/**
	 * 敏感关键词
	 */
	KEYWORDS,
	/**
	 * 就业app消息
	 */
	USER_JOB_MESSAGE,
	/**
	 * 用户openapi的token
	 */
	USER_TOKEN,
	/**
	 * APP用户最后访问时间
	 */
	APP_USER_VISIT_TIME,
	/**
	 * 跟踪代码前缀
	 */
	TRACKCODE;
}
