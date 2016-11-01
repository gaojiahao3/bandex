package com.bandex.base.enums;

import java.util.LinkedHashMap;
import java.util.Map;

import com.bandex.base.interfaces.Api;

/**
 * 后台API列表
 * 
 * @author Daniel
 */
public enum BackendApiMethodEnum implements Api {

	/**
	 * 后台管理员登录
	 */
	BACKEND_ADMIN_LOGIN("backend-admin-login", "后台管理员登录", ApiServerEnum.apicenter, ContentTypeEnum.sys_user, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("username", "用户名");
			paramMap.put("password", "密码");
			paramMap.put("login_ip", "登录IP");
			return paramMap;
		}
	},

	/**
	 * 后台管理员修改密码
	 */
	BACKEND_ADMIN_UPDATEPASSWORD("backend-admin-updatePassword", "后台管理员修改密码", ApiServerEnum.apicenter, ContentTypeEnum.sys_user, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("id", "用户ID");
			paramMap.put("new_password", "新密码");
			paramMap.put("old_password", "旧密码");
			return paramMap;
		}
	},

	/**
	 * 管理员列表
	 */
	BACKEND_ADMIN_LIST("backend-admin-list", "管理员列表", ApiServerEnum.apicenter, ContentTypeEnum.sys_user, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			return paramMap;
		}
	},

	/**
	 * 添加账号
	 */
	BACKEND_ADMIN_ADD("backend-admin-add", "添加账号", ApiServerEnum.apicenter, ContentTypeEnum.sys_user, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("realname", "姓名");
			paramMap.put("username", "用户名");
			paramMap.put("password", "密码");
			return paramMap;
		}
	},

	/**
	 * 根据ID获取信息
	 */
	BACKEND_ADMIN_GETBYID("backend-admin-getById", "根据ID获取信息", ApiServerEnum.apicenter, ContentTypeEnum.sys_user, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("id", "ID");
			return paramMap;
		}
	},

	/**
	 * 更新账号
	 */
	BACKEND_ADMIN_UPDATE("backend-admin-update", "更新账号", ApiServerEnum.apicenter, ContentTypeEnum.sys_user, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("id", "ID");
			paramMap.put("realname", "姓名");
			paramMap.put("password", "密码");
			return paramMap;
		}
	},

	/**
	 * 删除账号
	 */
	BACKEND_ADMIN_DELETE("backend-admin-delete", "删除账号", ApiServerEnum.apicenter, ContentTypeEnum.sys_user, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("ids", "管理员ID串");
			return paramMap;
		}
	},

	/**
	 * 禁用账号
	 */
	BACKEND_ADMIN_DISABLE("backend-admin-disable", "禁用账号", ApiServerEnum.apicenter, ContentTypeEnum.sys_user, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("ids", "管理员ID串");
			return paramMap;
		}
	},

	/**
	 * 启用账号
	 */
	BACKEND_ADMIN_ENABLE("backend-admin-enable", "启用账号", ApiServerEnum.apicenter, ContentTypeEnum.sys_user, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("ids", "管理员ID串");
			return paramMap;
		}
	},

	/**
	 * 系统菜单列表
	 */
	BACKEND_SYSMENU_LIST("backend-sysmenu-list", "系统菜单列表", ApiServerEnum.apicenter, ContentTypeEnum.sys_menu, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("page", "页码");
			paramMap.put("page_size", "每页多少条");
			return paramMap;
		}
	},

	/**
	 * 用户菜单列表
	 */
	BACKEND_SYSMENU_LISTBYUSERID("backend-sysmenu-listByUserId", "用户菜单列表", ApiServerEnum.apicenter, ContentTypeEnum.sys_menu, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("userId", "用户ID");
			return paramMap;
		}
	},

	/**
	 * 菜单tree列表
	 */
	BACKEND_SYSMENU_TREELIST("backend-sysmenu-treelist", "菜单tree列表", ApiServerEnum.apicenter, ContentTypeEnum.sys_menu, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			return paramMap;
		}
	},

	/**
	 * 菜单添加
	 */
	BACKEND_SYSMENU_ADD("backend-sysmenu-add", "菜单添加", ApiServerEnum.apicenter, ContentTypeEnum.sys_menu, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("menuName", "菜单名称");
			paramMap.put("menuCode", "功能码");
			paramMap.put("menuUrl", "菜单URL");
			paramMap.put("pid", "父菜单ID");
			paramMap.put("isShow", "是否显示");
			return paramMap;
		}
	},

	/**
	 * 获取一条菜单
	 */
	BACKEND_SYSMENU_GETBYID("backend-sysmenu-getById", "获取一条菜单", ApiServerEnum.apicenter, ContentTypeEnum.sys_menu, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("id", "菜单ID");
			return paramMap;
		}
	},

	/**
	 * 菜单修改
	 */
	BACKEND_SYSMENU_UPDATE("backend-sysmenu-update", "菜单修改", ApiServerEnum.apicenter, ContentTypeEnum.sys_menu, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("id", "菜单ID");
			paramMap.put("menuName", "菜单名称");
			paramMap.put("menuSummary", "描述");
			paramMap.put("menuCode", "功能码");
			paramMap.put("menuUrl", "菜单URL");
			paramMap.put("pid", "父菜单ID");
			paramMap.put("isShow", "是否显示");
			return paramMap;
		}
	},

	/**
	 * 菜单删除
	 */
	BACKEND_SYSMENU_DELETE("backend-sysmenu-delete", "菜单删除", ApiServerEnum.apicenter, ContentTypeEnum.sys_menu, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("id", "菜单ID");
			return paramMap;
		}
	},

	/**
	 * 角色列表
	 */
	BACKEND_SYSROLE_LIST("backend-sysrole-list", "角色列表", ApiServerEnum.apicenter, ContentTypeEnum.sys_role, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("page", "页码");
			paramMap.put("page_size", "每页多少条");
			return paramMap;
		}
	},

	/**
	 * 角色添加
	 */
	BACKEND_SYSROLE_ADD("backend-sysrole-add", "角色添加", ApiServerEnum.apicenter, ContentTypeEnum.sys_role, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("roleName", "角色名称");
			paramMap.put("roleDesc", "描述");
			return paramMap;
		}
	},

	/**
	 * 获取一条角色
	 */
	BACKEND_SYSROLE_GETBYID("backend-sysrole-getById", "获取一条角色", ApiServerEnum.apicenter, ContentTypeEnum.sys_role, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("id", "角色ID");
			return paramMap;
		}
	},

	/**
	 * 角色修改
	 */
	BACKEND_SYSROLE_UPDATE("backend-sysrole-update", "角色修改", ApiServerEnum.apicenter, ContentTypeEnum.sys_role, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("id", "角色ID");
			paramMap.put("roleName", "角色名称");
			paramMap.put("roleDesc", "描述");
			return paramMap;
		}
	},

	/**
	 * 角色删除
	 */
	BACKEND_SYSROLE_DELETE("backend-sysrole-delete", "角色删除", ApiServerEnum.apicenter, ContentTypeEnum.sys_role, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("ids", "角色ID");
			return paramMap;
		}
	},

	/**
	 * 角色菜单添加
	 */
	BACKEND_SYSROLEMENU_ADD("backend-sysrolemenu-add", "角色菜单添加", ApiServerEnum.apicenter, ContentTypeEnum.sys_role_menu, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("roleId", "角色ID");
			paramMap.put("menuIds", "多个菜单ID");
			return paramMap;
		}
	},

	/**
	 * 角色菜单列表
	 */
	BACKEND_SYSROLEMENU_LIST("backend-sysrolemenu-list", "角色菜单列表", ApiServerEnum.apicenter, ContentTypeEnum.sys_role_menu, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("roleId", "角色ID");
			return paramMap;
		}
	},

	/**
	 * 角色菜单修改
	 */
	BACKEND_SYSROLEMENU_UPDATE("backend-sysrolemenu-update", "角色菜单修改", ApiServerEnum.apicenter, ContentTypeEnum.sys_role_menu, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("roleId", "角色ID");
			paramMap.put("menuIds", "多个菜单ID");
			return paramMap;
		}
	},

	/**
	 * 用户角色修改
	 */
	BACKEND_SYSUSERROLE_UPDATE("backend-sysuserrole-update", "用户角色修改", ApiServerEnum.apicenter, ContentTypeEnum.sys_user_role, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("userId", "用户ID");
			paramMap.put("roleIds", "多个角色ID");
			return paramMap;
		}
	},

	/**
	 * 用户角色列表
	 */
	BACKEND_SYSUSERROLE_LIST("backend-sysuserrole-list", "用户角色列表", ApiServerEnum.apicenter, ContentTypeEnum.sys_user_role, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("userId", "用户ID");
			return paramMap;
		}
	},

	/**
	 * 附加服务项目列表
	 */
	BACKEND_APPENDSERVICELIST("backend-appendServiceList", "附加服务项目列表", ApiServerEnum.apicenter, ContentTypeEnum.append_service, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("page", "页码");
			paramMap.put("page_size", "每页多少条");
			return paramMap;
		}
	},
	/**
	 * 添加附加服务项目
	 */
	BACKEND_APPENDSERVICEADD("backend-appendServiceAdd", "添加附加服务项目", ApiServerEnum.apicenter, ContentTypeEnum.append_service, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("serviceName", "项目名称(*)");
			paramMap.put("servicePrice", "服务价格(*)");
			return paramMap;
		}
	},
	/**
	 * 根据附加服务项目ID获取信息
	 */
	BACKEND_APPENDSERVICEGETBYID("backend-appendServiceGetById", "根据附加服务项目ID获取信息", ApiServerEnum.apicenter, ContentTypeEnum.append_service, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("id", "ID(*)");
			return paramMap;
		}
	},
	/**
	 * 删除附加服务项目
	 */
	BACKEND_APPENDSERVICEDELETE("backend-appendServiceDelete", "删除附加服务项目", ApiServerEnum.apicenter, ContentTypeEnum.append_service, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("ids", "附加服务项目ID串(*)");
			return paramMap;
		}
	},
	/**
	 * 更新附加服务项目
	 */
	BACKEND_APPENDSERVICEUPDATE("backend-appendServiceUpdate", "更新附加服务项目", ApiServerEnum.apicenter, ContentTypeEnum.append_service, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("serviceName", "项目名称(*)");
			paramMap.put("servicePrice", "服务价格(*)");
			paramMap.put("id", "ID(*)");
			return paramMap;
		}
	},

	/**
	 * 用户管理
	 * 
	 * @author linlin
	 */
	BACKEND_CUSTOMER_LIST("backend-customer-list", "用户管理", ApiServerEnum.apicenter, ContentTypeEnum.customer_info, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("page", "页码");
			paramMap.put("page_size", "每页多少条");
			paramMap.put("phone", "手机号");
			return paramMap;
		}
	},

	/**
	 * 国家地区管理
	 * 
	 * @author linlin
	 */
	BACKEND_COUNTRYREGION_LIST("backend-countryRegion-list", "国家地区管理", ApiServerEnum.apicenter, ContentTypeEnum.countryRegion_info, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("page", "页码");
			paramMap.put("page_size", "每页多少条");
			paramMap.put("name", "名称");
			paramMap.put("parentId", "父ID");
			return paramMap;
		}
	},
	/**
	 * 车型管理
	 * 
	 * @author linlin
	 */
	BACKEND_CARTYPE_LIST("backend-carType-list", "车型管理", ApiServerEnum.apicenter, ContentTypeEnum.car_type, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("page", "页码");
			paramMap.put("page_size", "每页多少条");
			paramMap.put("name", "名称");
			return paramMap;
		}
	},

	/**
	 * 获取一条车型记录
	 */
	BACKEND_CARTYPE_GETBYID("backend-carType-getById", "获取一条车型记录", ApiServerEnum.apicenter, ContentTypeEnum.car_type, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("id", "车型ID");
			return paramMap;
		}
	},

	/**
	 * 车型记录添加
	 */
	BACKEND_CARTYPE_ADD("backend-carType-add", "车型记录添加", ApiServerEnum.apicenter, ContentTypeEnum.car_type, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("name", "车型名称");
			paramMap.put("widthLength", "汽车长宽");
			paramMap.put("maxWeight", "载重");
			paramMap.put("icon", "图片");
			return paramMap;
		}
	},

	/**
	 * 车型记录修改
	 */
	BACKEND_CARTYPE_UPDATE("backend-carType-update", "车型记录修改", ApiServerEnum.apicenter, ContentTypeEnum.car_type, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("id", "车型记录ID");
			paramMap.put("name", "车型名称");
			paramMap.put("widthLength", "汽车长宽");
			paramMap.put("maxWeight", "载重");
			paramMap.put("icon", "图片");
			return paramMap;
		}
	},

	/**
	 * 货运价格设置
	 * 
	 * @author linlin
	 */
	BACKEND_PRICINGINFO_LIST("backend-pricingInfo-list", "货运价格设置", ApiServerEnum.apicenter, ContentTypeEnum.car_type, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("page", "页码");
			paramMap.put("page_size", "每页多少条");
			paramMap.put("regionId", "地区ID");
			return paramMap;
		}
	},
	/**
	 * 订单管理
	 * 
	 * @author linlin
	 */
	BACKEND_ORDER_LIST("backend-order-list", "订单管理", ApiServerEnum.apicenter, ContentTypeEnum.order_info, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("page", "页码");
			paramMap.put("page_size", "每页多少条");
			paramMap.put("orderNo", "订单流水号");
			paramMap.put("customerName", "下单人姓名");
			paramMap.put("customerPhone", "下单人手机");
			return paramMap;
		}
	},
	/**
	 * 强制取消订单
	 * 
	 * @author linlin
	 */
	BACKEND_ORDER_CANCEL("backend-order-cancel", "强制取消订单", ApiServerEnum.apicenter, ContentTypeEnum.order_info, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("orderNo", "订单号");
			return paramMap;
		}
	},
	/**
	 * 查看订单详情
	 * 
	 * @author linlin
	 */
	BACKEND_ORDER_DETAILS("backend-order-details", "查看订单详情", ApiServerEnum.apicenter, ContentTypeEnum.order_info, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("orderNo", "订单号");
			return paramMap;
		}
	},
	/**
	 * 正式司机列表
	 * 
	 * @author wangyu
	 */
	BACKEND_DRIVER_FORMALLIST("backend-driver-formalList", "正式司机列表", ApiServerEnum.apicenter, ContentTypeEnum.driver_info, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			// paramMap.put("status", "司机状态");
			return paramMap;
		}
	},

	/**
	 * 待审核司机列表
	 * 
	 * @author wangyu
	 */
	BACKEND_DRIVER_PENDINGLIST("backend-driver-pendingList", "待审核司机列表", ApiServerEnum.apicenter, ContentTypeEnum.driver_info, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			return paramMap;
		}
	},

	/**
	 * 待审核司机列表
	 * 
	 * @author wangyu
	 */
	BACKEND_DRIVER_TRAININGLIST("backend-driver-trainingList", "待审核司机列表", ApiServerEnum.apicenter, ContentTypeEnum.driver_info, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			return paramMap;
		}
	},

	/**
	 * 公共数据列表返回
	 * 
	 * @author wangyu
	 */
	BACKEND_DRIVER_COMMONINFOLIST("backend-driver-commonInfoList", "公共数据列表", ApiServerEnum.apicenter, ContentTypeEnum.driver_info, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			return paramMap;
		}
	},

	/**
	 * 根据ID获取司机信息
	 */
	BACKEND_DRIVER_GETBYID("backend-driver-getById", "根据ID获取信息", ApiServerEnum.apicenter, ContentTypeEnum.driver_info, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			paramMap.put("id", "ID");
			return paramMap;
		}
	},

	/**
	 * 代理列表
	 * 
	 * @author wangyu
	 */
	BACKEND_AGENT_LIST("backend-agent-list", "代理列表", ApiServerEnum.apicenter, ContentTypeEnum.agent_info, false, true, false) {
		@Override
		public Map<String, String> getApiParams() {
			Map<String, String> paramMap = new LinkedHashMap<String, String>();
			return paramMap;
		}
	},

	;
	private String code;
	private String msg;
	private ApiServerEnum apiServer;
	private ContentTypeEnum contentType;
	private boolean privateApi;
	private boolean backendApi;
	private boolean webApi;

	/**
	 * 
	 * @param code
	 *            编码
	 * @param msg
	 *            描述
	 * @param apiServer
	 *            所属服务器
	 * @param contentType
	 *            所属业务
	 * @param privateApi
	 *            是否内部私有API
	 * @param backendApi
	 *            是否后台API
	 * @param webApi
	 *            是否WEB API
	 * @author Daniel
	 */
	BackendApiMethodEnum(String code, String msg, ApiServerEnum apiServer, ContentTypeEnum contentType, boolean privateApi, boolean backendApi, boolean webApi) {
		this.code = code;
		this.msg = msg;
		this.apiServer = apiServer;
		this.contentType = contentType;
		this.privateApi = privateApi;
		this.backendApi = backendApi;
		this.webApi = webApi;
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

	public boolean isPrivateApi() {
		return privateApi;
	}

	public boolean isBackendApi() {
		return backendApi;
	}

	public boolean isWebApi() {
		return webApi;
	}

	/**
	 * 获取所有API方法枚举
	 * 
	 * @return
	 * @author Daniel
	 */
	public static Map<String, BackendApiMethodEnum> getApiMethodEnumMap() {
		Map<String, BackendApiMethodEnum> retMap = new LinkedHashMap<String, BackendApiMethodEnum>();
		BackendApiMethodEnum[] enumArr = BackendApiMethodEnum.values();
		for (BackendApiMethodEnum aEnum : enumArr) {
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
			BackendApiMethodEnum[] enumArr = BackendApiMethodEnum.values();
			for (BackendApiMethodEnum aEnum : enumArr) {
				if (sEnum.name().equals(aEnum.getApiServer().name()) && !aEnum.isPrivateApi() && !aEnum.isBackendApi() && !aEnum.isWebApi()) {
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
		BackendApiMethodEnum mEnum = BackendApiMethodEnum.getApiMethodEnum(methodCode);
		if (mEnum != null) {
			return mEnum.getApiParams();
		}
		return null;
	}

	public static BackendApiMethodEnum getApiMethodEnum(String methodCode) {
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
		BackendApiMethodEnum aEnum = getApiMethodEnumMap().get(methodCode);
		if (aEnum != null) {
			return aEnum.getApiServer();
		}
		return null;
	}
}
