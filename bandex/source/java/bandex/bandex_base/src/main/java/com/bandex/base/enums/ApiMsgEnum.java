package com.bandex.base.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * API消息代码<br>
 * 0000-0999表示系统级错误代码<br>
 * 1000-1999表示用户体系错误代码<br>
 * 2000-2999表示内容体系错误代码<br>
 * 3000-3999表示公用体系错误代码<br>
 * 4000-4999表示订单体系错误代码<br>
 * 
 * @author Daniel
 */
public enum ApiMsgEnum {
	// 这一部分是系统级错误代码（从0000开始到0999）////////////////
	/**
	 * 操作成功
	 */
	SUCCESS(Boolean.TRUE, "0000", "成功", null),

	/**
	 * 操作失败
	 */
	FAIL(Boolean.FALSE, "0001", "失败", null),

	/**
	 * 签名错误
	 */
	SIGN_ERROR(Boolean.FALSE, "0002", "签名错误", null),

	/**
	 * 服务器内部错误
	 */
	SERVER_INTERNAL_ERROR(Boolean.FALSE, "0003", "服务器内部错误", null),

	/**
	 * 只支持post请求
	 */
	POST_ONLY(Boolean.FALSE, "0005", "只支持post请求", null),

	/**
	 * 缺少参数
	 */
	MISS_PARAMETER(Boolean.FALSE, "0006", "缺少参数", null),

	/**
	 * 数据格式错误
	 */
	DATA_FORMAT_EXCEPTION(Boolean.FALSE, "0007", "数据格式错误", null),

	/**
	 * 请求被禁止
	 */
	FORBIDDEN(Boolean.FALSE, "0008", "请求被禁止", null),

	/**
	 * 请求错误
	 */
	BAD_REQUEST(Boolean.FALSE, "0009", "请求错误", null),

	/**
	 * 有引用存在
	 */
	REFERENCE_EXISTED(Boolean.FALSE, "0010", "有引用存在", null),

	/**
	 * 文件上传错误
	 */
	FILE_UPLOAD_EXCEPTION(Boolean.FALSE, "0100", "文件上传异常", null),

	/**
	 * 文件大小错误
	 */
	FILE_SIZE_EXCEPTION(Boolean.FALSE, "0101", "文件大小异常", null),

	/**
	 * 文件对象错误
	 */
	FILE_ITEM_EXCEPTION(Boolean.FALSE, "0102", "文件对象异常", null),

	/**
	 * 文件上传成功
	 */
	FILE_UPLOAD_SUCCESS(Boolean.TRUE, "0103", "文件上传成功", null),

	// 这一部分是用户体系错误代码（从1000开始到1999）////////////////
	/**
	 * 验证码发送成功
	 */
	ValidateCodeSendSuccess(Boolean.TRUE, "1000", "验证码发送成功", "验证码发送成功"),

	/**
	 * 注册成功
	 */
	RegisterSuccess(Boolean.TRUE, "1001", "注册成功", null),

	/**
	 * 注册失败
	 */
	RegisterFail(Boolean.FALSE, "1002", "注册失败", null),

	/**
	 * 用户名不能为空
	 */
	UsernameIsNullException(Boolean.FALSE, "1003", "用户名不能为空", null),

	/**
	 * 用户名长度不能小于10个字符
	 */
	UsernameLengthException(Boolean.FALSE, "1004", "用户名长度不能小于10个字符", null),

	/**
	 * 用户名被注册
	 */
	UsernameBeenRegistered(Boolean.FALSE, "1005", "用户名被注册", null),

	/**
	 * 密码不能为空
	 */
	PasswordIsNullException(Boolean.FALSE, "1006", "密码不能为空", null),

	/**
	 * 密码长度不能小于6个字符
	 */
	PasswordLengthException(Boolean.FALSE, "1007", "密码长度不能小于6个字符", null),

	/**
	 * 手机号不合法
	 */
	PhoneInvalid(Boolean.FALSE, "1008", "手机号不合法", null),

	/**
	 * 手机号已存在
	 */
	PhoneExisted(Boolean.FALSE, "1009", "手机号已存在", null),

	/**
	 * 验证码错误
	 */
	SmsCodeError(Boolean.FALSE, "1010", "验证码错误", null),

	/**
	 * 邮箱不合法
	 */
	EmailInvalid(Boolean.FALSE, "1011", "邮箱不合法", null),

	/**
	 * 邮箱已存在
	 */
	EmailExisted(Boolean.FALSE, "1012", "邮箱已存在", null),

	/**
	 * 验证码错误
	 */
	EmailCodeError(Boolean.FALSE, "1013", "验证码错误", null),

	/**
	 * 暂不支持此注册方式
	 */
	RegisterWayNonsupport(Boolean.FALSE, "1014", "暂不支持此注册方式", null),

	/**
	 * 登录成功
	 */
	LoginSuccess(Boolean.TRUE, "1100", "登录成功", null),

	/**
	 * 用户名或密码错误
	 */
	UsernameOrPasswordException(Boolean.FALSE, "1101", "用户名或密码错误", null),

	/**
	 * 您的账号被锁定
	 */
	UserBeenLookedException(Boolean.FALSE, "1102", "您的账号被锁定", null),

	/**
	 * 用户不存在
	 */
	UserDosentExist(Boolean.FALSE, "1103", "用户不存在", null),

	/**
	 * 用户未登录
	 */
	UserUnloginException(Boolean.FALSE, "1104", "用户未登录", null),

	/**
	 * 退出成功
	 */
	LogoutSuccess(Boolean.TRUE, "1199", "退出成功", null),

	/**
	 * 资料修改成功
	 */
	ProfileUpdateSuccess(Boolean.TRUE, "1200", "资料修改成功", null),

	/**
	 * 资料修改失败
	 */
	ProfileUpdateFail(Boolean.FALSE, "1201", "资料修改失败", null),

	/**
	 * 密码修改成功
	 */
	PasswordUpdateSuccess(Boolean.TRUE, "1202", "密码修改成功", null),

	/**
	 * 当前密码不正确
	 */
	CurrentPasswordException(Boolean.FALSE, "1203", "当前密码不正确", null),

	/**
	 * 密码重置成功
	 */
	PasswordResetSuccess(Boolean.TRUE, "1204", "密码重置成功", null),

	/**
	 * 绑定成功
	 */
	PhoneBindSuccess(Boolean.TRUE, "1205", "绑定成功", null),

	/**
	 * 当前手机号为空
	 */
	CurrentPhoneIsNull(Boolean.FALSE, "1206", "当前手机号为空", null),

	/**
	 * 手机更改成功
	 */
	PhoneUpdateSuccess(Boolean.TRUE, "1206", "手机更改成功", null),

	/**
	 * 邮箱绑定成功
	 */
	EmailBindSuccess(Boolean.TRUE, "1207", "邮箱绑定成功", null),

	/**
	 * 邮箱更改成功
	 */
	EmailUpdateSuccess(Boolean.TRUE, "1208", "邮箱更改成功", null),

	/**
	 * 解绑成功
	 */
	PhoneUnbindSuccess(Boolean.TRUE, "1209", "解绑成功", null),

	/**
	 * SNS绑定成功
	 */
	SnsAccountBindSuccess(Boolean.TRUE, "1220", "SNS绑定成功", null),

	/**
	 * SNS绑定失败
	 */
	SnsAccountBindFail(Boolean.FALSE, "1221", "SNS绑定失败", null),

	/**
	 * 暂不支持此平台账号绑定
	 */
	UserBindPlatformNonsupport(Boolean.FALSE, "1222", "暂不支持此平台账号绑定", null),

	/**
	 * 资料获取成功
	 */
	ProfileGetSuccess(Boolean.TRUE, "1230", "资料获取成功", null),

	/**
	 * 请先绑定手机号
	 */
	UserNotBindPhone(Boolean.FALSE, "1300", "请先绑定手机号", null),

	/**
	 * 订单取消成功
	 */
	OrderCancelSuccess(Boolean.TRUE, "4000", "订单取消成功", "取消成功"),

	/**
	 * 此状态订单不能取消
	 */
	OrderCannotCancel(Boolean.FALSE, "4001", "此状态订单不能取消", "此状态不能取消"),

	/**
	 * 订单已完成
	 */
	OrderCompleteSuccess(Boolean.TRUE, "4002", "订单已完成", "收货完成"),

	/**
	 * 订单状态异常
	 */
	OrderStateException(Boolean.FALSE, "4003", "订单状态异常", "状态异常"),

	;

	public Boolean isSuccess;
	public String code;
	public String msg;
	public String userMsg;

	ApiMsgEnum(Boolean isSuccess, String code, String msg, String userMsg) {
		this.isSuccess = isSuccess;
		this.code = code;
		this.msg = msg;
		this.userMsg = userMsg;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUserMsg() {
		return userMsg;
	}

	public void setUserMsg(String userMsg) {
		this.userMsg = userMsg;
	}

	public static Map<String, String> getAll() {
		Map<String, String> retMap = new LinkedHashMap<String, String>();
		ApiMsgEnum[] enumArr = ApiMsgEnum.values();
		for (ApiMsgEnum aEnum : enumArr) {
			retMap.put(aEnum.getCode(), aEnum.getMsg());
		}
		return retMap;
	}

	public static ApiMsgEnum getByCode(String code) {
		ApiMsgEnum[] enumArr = ApiMsgEnum.values();
		for (ApiMsgEnum aEnum : enumArr) {
			if (aEnum.getCode().equals(code)) {
				return aEnum;
			}
		}
		return null;
	}
}
