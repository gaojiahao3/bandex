package com.bandex.base.enums;

import java.util.LinkedHashMap;
import java.util.Map;

import com.bandex.base.interfaces.Api;

/**
 * APP API列表
 * 
 * @author Daniel
 */
public enum AppApiMethodEnum implements Api {
	/**
	 * 获取配置
	 */
	COMMON_GETCONFIG("common-getConfig", "获取配置", ApiServerEnum.apicenter, null, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			return paramMap;
		}
	},

	/**
	 * 发送短信
	 */
	COMMON_SENDSMS("common-sendSms", "发送短信", ApiServerEnum.apicenter, null, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("phone", "手机号(*)");
			return paramMap;
		}
	},

	/**
	 * 用户登录
	 */
	USER_LOGIN("user-login", "用户登录", ApiServerEnum.apicenter, null, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("phone", "手机号(*)");
			paramMap.put("validateCode", "验证码(*)");
			return paramMap;
		}
	},

	/**
	 * 微信登录
	 */
	USER_LOGINBYWECHAT("user-loginByWechat", "微信登录", ApiServerEnum.apicenter, null, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("authCode", "授权CODE(*)");
			return paramMap;
		}
	},

	/**
	 * 微博登录
	 */
	USER_LOGINBYWEIBO("user-loginByWeibo", "微博登录", ApiServerEnum.apicenter, null, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("authCode", "授权CODE(*)");
			return paramMap;
		}
	},

	/**
	 * 用户退出
	 */
	USER_LOGOUT("user-logout", "用户退出", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			return paramMap;
		}
	},

	/**
	 * 全部订单列表
	 */
	USER_ORDER_ALLLIST("user-order-allList", "全部订单列表", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("page", "页码");
			paramMap.put("pageSize", "每页多少条");
			return paramMap;
		}
	},

	/**
	 * 待支付订单列表
	 */
	USER_ORDER_WAITPAYLIST("user-order-waitPayList", "待支付订单列表", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("page", "页码");
			paramMap.put("pageSize", "每页多少条");
			return paramMap;
		}
	},

	/**
	 * 待签收订单列表
	 */
	USER_ORDER_WAITSIGNLIST("user-order-waitSignList", "待签收订单列表", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("page", "页码");
			paramMap.put("pageSize", "每页多少条");
			return paramMap;
		}
	},

	/**
	 * 已签收订单列表
	 */
	USER_ORDER_SIGNEDLIST("user-order-signedList", "已签收订单列表", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("page", "页码");
			paramMap.put("pageSize", "每页多少条");
			return paramMap;
		}
	},

	/**
	 * 售后订单列表
	 */
	USER_ORDER_RETURNEDLIST("user-order-returnedList", "售后订单列表", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("page", "页码");
			paramMap.put("pageSize", "每页多少条");
			return paramMap;
		}
	},

	/**
	 * 取消订单
	 */
	ORDER_CANCEL("order-cancel", "取消订单", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("orderCode", "订单编号(*)");
			return paramMap;
		}
	},

	/**
	 * 确认收货
	 */
	ORDER_COMPLETE("order-complete", "确认收货", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("orderCode", "订单编号(*)");
			return paramMap;
		}
	},

	/**
	 * 订单详情
	 */
	ORDER_DETAIL("order-detail", "订单详情", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("orderCode", "订单编号(*)");
			return paramMap;
		}
	},

	/**
	 * 查看物流
	 */
	ORDER_VIEWLOGISTICS("order-viewLogistics", "查看物流", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("orderCode", "订单编号(*)");
			return paramMap;
		}
	},

	/**
	 * 申请退货
	 */
	ORDER_APPLYRETURNGOODS("order-applyReturnGoods", "申请退货", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("orderCode", "订单编号(*)");
			paramMap.put("returnReason", "退货原因(*)");
			paramMap.put("returnLogisticCode", "退货快递单号(*)");
			return paramMap;
		}
	},

	/**
	 * 查看退货状态
	 */
	ORDER_VIEWRETURNSTATUS("order-viewReturnStatus", "查看退货状态", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("returnCode", "退货单号(*)");
			return paramMap;
		}
	},

	INDEX_DATA("index-data", "app首页数据", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			return paramMap;
		}
	},
	USER_INFO_LOAD("user-info-load", "用户基本信息", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			return paramMap;
		}
	},
	USER_INFO_UPDATE("user-info-update", "用户基本信息修改", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("nickName", "昵称(*)");
			paramMap.put("sex", "性别1男2女(*)");
			paramMap.put("birthday", "生日格式yyyy-MM-dd(*)");
			paramMap.put("height", "身高整数类型1到200(*)");
			paramMap.put("weight", "体重(*)");
			paramMap.put("hobby", "爱好运动，多个id逗号间隔(*)");
			paramMap.put("gymnasium", "常去场馆");
			return paramMap;
		}
	},
	USER_INFO_UPDATEICON("user-info-updateIcon", "用户基本信息修改", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("fileData", "自定义上传图片的base64编码(和userIcon传其一)");
			paramMap.put("userIcon", "选择的头像图片(和fileData传其一，userIcon优先)");
			return paramMap;
		}
	},



	USER_INTEGRATION_DETAIL("user-integration-detail", "用户积分获取明细", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("pageIndex", "翻页起始位置第一页0后面根据前面接口返回的count传");
			paramMap.put("pageSize", "一页多少条数据");
			return paramMap;
		}
	},
	FRIEND_LIST("friend-list", "好友列表兼容好友搜索", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("pageIndex", "翻页起始位置第一页0后面根据前面接口返回的count传");
			paramMap.put("pageSize", "一页多少条数据");
			paramMap.put("searchKey", "好友搜索时的关键字");
			return paramMap;
		}
	},
	FRIEND_DELETE("friend-delete", "删除好友", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("friendUserId", "删除的好友id(*)");
			return paramMap;
		}
	},
	FRIEND_APPLY_LIST("friend-apply-list", "好友申请列表", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("pageIndex", "翻页起始位置第一页0后面根据前面接口返回的count传");
			paramMap.put("pageSize", "一页多少条数据");
			return paramMap;
		}
	},

	FRIEND_APPLY_NEW("friend-apply-new", "好友申请提交", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("friendId", "申请成为好友的userId");
			return paramMap;
		}
	},

	FRIEND_APPLY_REJECT("friend-apply-reject", "拒绝好友申请", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("applyId", "好友申请的id");
			return paramMap;
		}
	},

	FRIEND_APPLY_ACCEPT("friend-apply-accept", "同意好友申请", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("applyId", "好友申请的id");
			return paramMap;
		}
	},

	USERGROUP_CREATE("userGroup-create", "创建好友分组", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("groupName", "组名(*)");
			paramMap.put("groupPic", "图标(*)");
			paramMap.put("groupDesc", "描述(*)");
			return paramMap;
		}
	},

	USERGROUP_LIST("userGroup-list", "分组列表", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			return paramMap;
		}
	},
	USERGROUP_INVITE("userGroup-invite", "分组好友邀请", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("groupId", "分组id(*)");
			paramMap.put("userIdList", "邀请的好友id列表逗号间隔(*)");

			return paramMap;
		}
	},
	USERGROUP_INVITE_ACCEPT("userGroup-invite-accept", "同意分组邀请", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("groupId", "分组id(*)");
			return paramMap;
		}
	},
	USERGROUP_INVITE_REJECT("userGroup-invite-reject", "拒绝分组邀请", ApiServerEnum.apicenter, null, true) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("user_token", "当前用户token(*)");
			paramMap.put("applyId", "好友申请的id");
			return paramMap;
		}
	},



	;

	private String code;
	private String msg;
	private ApiServerEnum apiServer;
	private ContentTypeEnum contentType;
	private boolean needLogin;

	/**
	 * @param code
	 *            编码
	 * @param msg
	 *            描述
	 * @param apiServer
	 *            所属服务器
	 * @param contentType
	 *            所属业务
	 * @param needLogin
	 *            是否需要登录
	 * @author Daniel
	 */
	AppApiMethodEnum(String code, String msg, ApiServerEnum apiServer, ContentTypeEnum contentType, boolean needLogin) {
		this.code = code;
		this.msg = msg;
		this.apiServer = apiServer;
		this.contentType = contentType;
		this.needLogin = needLogin;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public ApiServerEnum getApiServer() {
		return apiServer;
	}

	public ContentTypeEnum getContentType() {
		return contentType;
	}

	public boolean isNeedLogin() {
		return needLogin;
	}

	/**
	 * 获取所有API方法枚举
	 * 
	 * @return
	 * @author Daniel
	 */
	public static Map<String, AppApiMethodEnum> getApiMethodEnumMap() {
		Map<String, AppApiMethodEnum> retMap = new LinkedHashMap<String, AppApiMethodEnum>();
		AppApiMethodEnum[] enumArr = AppApiMethodEnum.values();
		for (AppApiMethodEnum aEnum : enumArr) {
			retMap.put(aEnum.getCode(), aEnum);
		}
		return retMap;
	}

	/**
	 * 根据服务器获取API方法（供对外的API测试工具使用）
	 * 
	 * @param apiServer
	 * @return
	 * @author Daniel
	 */
	public static Map<String, String> getApiMethodMapByServer(String apiServer) {
		ApiServerEnum sEnum = ApiServerEnum.getApiServerEnum(apiServer);
		Map<String, String> retMap = new LinkedHashMap<String, String>();
		if (sEnum != null) {
			AppApiMethodEnum[] enumArr = AppApiMethodEnum.values();
			for (AppApiMethodEnum aEnum : enumArr) {
				if (sEnum.name().equals(aEnum.getApiServer().name())) {
					retMap.put(aEnum.getCode(), aEnum.getMsg());
				}
			}
		}
		return retMap;
	}

	/**
	 * 根据API方法编号获取参数列表（供API测试工具使用）
	 * 
	 * @param methodCode
	 * @return
	 * @author Daniel
	 */
	public static Map<String, String> getApiParamMapByMethod(String methodCode) {
		AppApiMethodEnum mEnum = AppApiMethodEnum.getApiMethodEnum(methodCode);
		if (mEnum != null) {
			return mEnum.getApiParams();
		}
		return null;
	}

	public static AppApiMethodEnum getApiMethodEnum(String methodCode) {
		return getApiMethodEnumMap().get(methodCode);
	}

	/**
	 * 根据API方法编号获取所属服务器（供API总控制中心分发使用）
	 * 
	 * @param methodCode
	 * @return
	 * @author Daniel
	 */
	public static ApiServerEnum getApiServerEnum(String methodCode) {
		AppApiMethodEnum aEnum = getApiMethodEnumMap().get(methodCode);
		if (aEnum != null) {
			return aEnum.getApiServer();
		}
		return null;
	}

}
