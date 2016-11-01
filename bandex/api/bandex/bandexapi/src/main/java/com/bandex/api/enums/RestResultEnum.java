package com.bandex.api.enums;

public enum RestResultEnum {
	// 这一部分是系统级错误代码（从0000开始）////////////////
	/**
	 * 操作成功
	 */
	SUCCESS(Boolean.TRUE, "0000", "成功"),
	/**
	 * 操作失败
	 */
	FAIL(Boolean.FALSE, "0001", "失败"),
	/**
	 * 签名错误
	 */
	TOKEN_ERROR(Boolean.FALSE, "0002", "签名错误"),
	/**
	 * 调用错误
	 */
	INVOKE_ERROR(Boolean.FALSE, "0003", "调用错误"),
	/**
	 * 未知错误
	 */
	UNKNOW_ERROR(Boolean.FALSE, "0004", "未知错误"),
	/**
	 * 只支持post请求
	 */
	ISNOT_POST(Boolean.FALSE, "0005", "只支持post请求"),
	/**
	 * 缺少参数
	 */
	MissParameterException(Boolean.FALSE, "0006", "缺少参数"),
	/**
	 * 参数错误
	 */
	ParameterException(Boolean.FALSE, "0007", "参数错误"),

	// 这一部分是业务级错误代码（从1000开始）////////////////
	/**
	 * 用户名不能为空
	 */
	UserNameIsNullException(Boolean.FALSE, "1000", "用户名不能为空"),
	/**
	 * 密码不能为空
	 */
	UserPasswordIsNullException(Boolean.FALSE, "1001", "密码不能为空"),
	/**
	 * 登录失败次数过多
	 */
	ExcessiveAttemptsException(Boolean.FALSE, "1002", "登录失败次数过多"),
	/**
	 * 用户名或密码错误
	 */
	UserNameOrPasswordException(Boolean.FALSE, "1003", "用户名或密码错误"),
	/**
	 * 用户未激活
	 */
	UserInactiveException(Boolean.FALSE, "1004", "用户未激活"),

	/**
	 * 用户被锁定
	 */
	UserLockedException(Boolean.FALSE, "1005", "用户被锁定"),
	/**
	 * 用户被删除
	 */
	UserRemovedException(Boolean.FALSE, "1006", "用户被删除"),
	/**
	 * 企业用户审核不通过
	 */
	AuditNotPassException(Boolean.FALSE, "1007", "企业用户审核不通过"),
	/**
	 * 用户已经被注册
	 */
	UserNameExistedException(Boolean.FALSE, "1008", "用户已经被注册"),

	/**
	 * 用户已经被绑定
	 */
	OpenIdExistedException(Boolean.FALSE, "1009", "用户已经被绑定"),
	/**
	 * 密码错误
	 */
	UserPasswordErrorException(Boolean.FALSE, "1010", "密码错误"),
	/**
	 * 请先注册
	 */
	NoRegisterException(Boolean.FALSE, "1011", "请先注册"),

	/**
	 * 简历名称已存在
	 */
	RESUMENAMEExistedException(Boolean.FALSE, "1012", "简历名称已存在"),
	/**
	 * 部门名称已存在
	 */
	DEPTNAMEExistedException(Boolean.FALSE, "1013", "部门名称已存在"),
	/**
	 * 已经发布职位的部门不允许删除
	 */
	NODELDEPTException(Boolean.FALSE, "1014", "已经发布职位的部门不允许删除"),
	/**
	 * 用户不存在
	 */
	USERNAMEException(Boolean.FALSE, "10015", "用户不存在"),

	MODULETYPENAMEExistedException(Boolean.FALSE, "10016", "模块分类名称已经存在"),
	/**
	 * 已经有重复的排序，请重新修改！
	 */
	SORTExistedException(Boolean.FALSE, "10017", "已经有重复的排序，请重新修改！"),
	/**
	 * 您已经添加过背景图，无需再重复添加！
	 */
	BackgroundimageException(Boolean.FALSE, "10018", "您已经添加过背景图，无需再重复添加！"),
	/**
	 * 您已经添加过背景图，无需再重复添加！
	 */
	POSITIONNAMEExistedException(Boolean.FALSE, "10019", "该职位已经存在！"),
	/**
	 * 该序号已经存在，请重新设置！
	 */
	OrderExistedException(Boolean.FALSE, "10021", "该序号已经存在，请重新设置！"),
	/**
	 * 活动标题已经存在，请重新设置！
	 */
	TopicNameExistedException(Boolean.FALSE, "10022", "活动标题已经存在，请重新设置！"),
	/**
	 * 活动名称已存在，请重新设置！
	 */
	QuestionTitleExistedException(Boolean.FALSE, "10023", "活动名称已存在，请重新设置！"),
    /**
     * 邮箱发送失败
     */
    SendEmailError(Boolean.FALSE, "100216", "邮件发送失败，请检查邮箱正确性"),
    /**
     * 用户已经激活
     */
    Activated(Boolean.FALSE,"100216","该账号已被激活，无需重复激活"),

	CommentCountException(Boolean.FALSE, "10020", "用户一天只能点评一次！"),

    CollectCompanyExistedException(Boolean.FALSE,"100218","已经收藏过企业,请重新选择企业!"),
    CollectCompanyExistedNumWarring(Boolean.TRUE,"100219","有些企业已经收藏,已跳过!"),
    FollowCompanyExistedException(Boolean.FALSE,"100220","已经关注过企业,请重新选择企业!"),

    PRIZERESULTCOUNT(Boolean.FALSE,"100222","您已经中奖，不允许重复抽奖!"),
    FollowCompanyExistedNumWarring(Boolean.TRUE,"100221","有些企业已经关注,已跳过!"),
    OUTOFPRIZENUM(Boolean.FALSE,"100223","作弊设置的此奖项数量已经达到项目设置的奖项数量的上限"),
    EXISTWEAID(Boolean.FALSE,"100224","项目中已经存在此微信ID的作弊"),
    NOTWINRATE(Boolean.FALSE,"100225","抱歉，您没中奖！"),

    HAVEPRIZETYPE(Boolean.FALSE,"100226","抱歉，请设置其他等级的奖项！"),
    SAMERATEWIN(Boolean.FALSE,"100227","不允许添加相同的中奖率！"),
    INVALIDPRIZETITLE(Boolean.FALSE,"100228","此活动已经失效!"),
    INVALIDPRIZECOUNT(Boolean.FALSE,"100229","您没有抽奖次数了!"),
    ENTERPRISENameExistedException(Boolean.FALSE, "100230", "此公司名称已经存在"),
    GUILDNameExistedException(Boolean.FALSE, "100231", "此协会名称已经存在"),


    FailureBDCode(Boolean.FALSE, "100300", "地推码失效"),
    InventoryShortage(Boolean.FALSE, "100301", "库存不足"),
    PendingShortage(Boolean.FALSE, "100302", "待分配配件不足"),
    CheckMoney(Boolean.FALSE, "100307", "金额最低不能低于0.01"),
    FailPay(Boolean.FALSE, "100308", "转账失败"),
    PwdFailPay(Boolean.FALSE, "100309", "密码错误，付款失败！"),
    UserNotBindLgArea(Boolean.FALSE, "100310", "用户商户未绑定物流区！"),

    LackOperateException(Boolean.FALSE, "100311", "您无法操作该缺货单"),
    ExistLockOrderException(Boolean.FALSE, "100312", "该订单已经被挂起，请确认后再操作"),
    NoAuthorityException(Boolean.FALSE, "100313", "您没有操作权限!"),
    ErrorTelephone(Boolean.FALSE, "100254", "请填写正确的手机号！"),
    SENDSMSERROR(Boolean.FALSE, "100255", "验证码发送失败！"),
    SMSCODEOUTTIME(Boolean.FALSE, "100256", "验证码错误！"),
    SMSCODEOMOREIME(Boolean.FALSE, "100257", "未超过60s不允许重新发送！"),
    SMSCODEERROR(Boolean.FALSE, "100258", "验证码校验失败！"),
    ;


	public Boolean isSuccess;
	public String code;
	public String msg;

	RestResultEnum(Boolean isSuccess, String code, String msg) {
		this.isSuccess = isSuccess;
		this.code = code;
		this.msg = msg;
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
}
