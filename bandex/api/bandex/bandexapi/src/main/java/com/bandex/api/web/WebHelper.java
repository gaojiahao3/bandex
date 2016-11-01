package com.bandex.api.web;

import com.bandex.api.dto.UserDto;
import com.bandex.api.enums.MemcachedKeyEnum;
import org.springframework.web.util.WebUtils;
import sh.zj100.common.util.JsonUtil;
import sh.zj100.common.util.MemcachedUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class WebHelper {
	protected static final String MSG = "msg";
	protected static final String IS_SUCCESS = "isSuccess";

	// public static String callepeitApiForJson(epeitApiRequest restReq) {
	// Map<String, Object> paramMap = new HashMap<String, Object>();
	// if (restReq != null) {
	// for (Entry<String, Object> entry : restReq.entrySet()) {
	// // if (entry.getValue() != null) {
	// // try {
	// // paramMap.put(entry.getKey(),
	// // java.net.URLEncoder.encode(String.valueOf(entry.getValue()),
	// // "UTF-8"));
	// // } catch (UnsupportedEncodingException e) {
	// // e.printStackTrace();
	// // }
	// // } else {
	// paramMap.put(entry.getKey(), entry.getValue());
	// // }
	// }
	// }
	// String epeitApiServer = restReq.getepeitApiServer();
	// String epeitApiId = restReq.getepeitApiId();
	// String epeitApiSecert = restReq.getepeitApiSecert();
	// String functioncode = restReq.getFunctionEnum().getKey();
	// paramMap.put("apiId", epeitApiId);
	// paramMap.put("functioncode", functioncode);
	// String token = SimpleTokenUtil.buildToken(paramMap, epeitApiSecert);
	// paramMap.put("token", token);
	// String retJson = HttpClientUtil.doHttpPost(epeitApiServer +
	// "/apicenter", paramMap);
	// return retJson;
	// }

	public static void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
		response.sendRedirect(response.encodeRedirectURL(url));
	}

	public static String getCurrRequestUrl(HttpServletRequest request) throws UnsupportedEncodingException {
		StringBuffer currRequestUrl = request.getRequestURL();
		Enumeration<String> parameterNames = request.getParameterNames();
		boolean flag = true;
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String value = request.getParameter(paramName);
			if (flag) {
				// currRequestUrl.append("?" + paramName + "=" + value);
				currRequestUrl.append("?" + paramName + "=" + URLEncoder.encode(value, "UTF-8"));
				flag = false;
			} else {
				// currRequestUrl.append("&" + paramName + "=" + value);
				currRequestUrl.append("&" + paramName + "=" + URLEncoder.encode(value, "UTF-8"));
				flag = false;
			}
		}
		return currRequestUrl.toString();
	}

	//
	// public static void onLoginSuccess(HttpServletRequest request,
	// HttpServletResponse response, LoginTokenPo loginToken, UserDto userDto,
	// String cookieDomain) {
	// if (userDto == null) {
	// return;
	// }
	// String cookieUserId = userDto.getCookieUserId();
	// request.setAttribute(Constant.COOKIE_USER_ID, cookieUserId);
	// WebUtils.setSessionAttribute(request, Constant.COOKIE_USER_ID,
	// cookieUserId);
	// // 构造cookie
	// List<Cookie> cookieList = new ArrayList<Cookie>();
	// cookieList.add(buildCookie(Constant.COOKIE_USER_ID, cookieUserId,
	// cookieDomain, "/", Constant.COOKIE_USER_MAX_AGE));
	// if (loginToken.getRememberLogin() == Boolean.TRUE) {
	// cookieList.add(buildCookie(Constant.COOKIE_USER_INFO,
	// EncryptUtil.encryptByBase64(loginToken.getUsername()), cookieDomain, "/",
	// Constant.COOKIE_USER_MAX_AGE));
	// }
	// // 写入cookie
	// if (WebHelper.isAjaxRequest(request)) {
	// UserDto currentUserDto = userDto;
	// HeaderDto headerDto = getHeaderDto(currentUserDto);
	// Map<String, Object> retMap = new HashMap<String, Object>();
	// retMap.put(IS_SUCCESS, true);
	// retMap.put(MSG, null);
	// retMap.put("cookieList", cookieList);
	// retMap.put("currentUserDto", userDto);
	// retMap.put("headerDto", headerDto);
	// String json = JsonUtil.objectToJson(retMap);
	// outputJson(json, response);
	// } else {
	// for (Cookie c : cookieList) {
	// response.addCookie(c);
	// }
	// }
	// }
	//
	// public static Cookie buildCookie(String name, String value, String
	// domain, String path, int maxAge) {
	// Cookie c = new Cookie(name, value);
	// if (domain != null && !"".equals(domain.trim())) {
	// c.setDomain(domain);
	// }
	// c.setPath(path);
	// c.setMaxAge(maxAge);
	// return c;
	// }
	//
	// /**
	// * 获得Memcached中的用户
	// *
	// * @param request
	// * @return
	// * @author Daniel
	// */
	// public static UserDto getUserDtoFromMemcached(HttpServletRequest request)
	// {
	// String cookieUserId = getCookieUserId(request);
	// UserDto userDto = null;
	// if (cookieUserId != null) {
	// userDto = getUserDtoFromMemcached(cookieUserId);
	// }
	// return userDto;
	// }
	//
	/**
	 * 
	 * 获得Memcached中的用户
	 * 
	 * @param cookieUserId
	 * @return
	 * @author Lynch
	 */
	public static UserDto getUserDtoFromMemcached(String cookieUserId) {
		UserDto userDto = null;
		if (cookieUserId != null) {
			// String memKeySession = MemcachedKeyEnum.USER_SESSION.name() + "-"
			// + cookieUserId;
			// userDto = (UserDto)
			// MemcachedUtil.getInstance().get(memKeySession);
			String memKeySessionJson = MemcachedKeyEnum.USER_SESSION_JSON.name() + "-" + cookieUserId;
			String json = (String) MemcachedUtil.getInstance().get(memKeySessionJson);
			userDto = JsonUtil.fastjson2Object(json, UserDto.class);
		}
		return userDto;
	}

	//
	// /**
	// * 根据token获取Memcached中的用户
	// *
	// * @param token
	// * @return
	// * @author zhaozuowen
	// */
	// public static UserDto getUserDtoByToken(String token) {
	// String cookieUserId = EncryptUtil.decryptByBase64(token);
	// UserDto userDto = null;
	// if (cookieUserId != null) {
	// userDto = getUserDtoFromMemcached(cookieUserId);
	// }
	// return userDto;
	// }
	//
	// /**
	// * 用户信息修改后刷新Memcached中的信息
	// *
	// * @param request
	// * @param userDto
	// * @return
	// * @author yijinchuan
	// */
	// public static void refreshMemcachedUserInfo(HttpServletRequest request,
	// UserDto userDto) {
	// String cookieUserId = getCookieUserId(request);
	// if (cookieUserId != null && !"".equals(cookieUserId)) {
	// userDto.setCookieUserId(cookieUserId);
	// // String memKey = MemcachedKeyEnum.USER_SESSION.name() + "-" +
	// // cookieUserId;
	// // MemcachedUtil.getInstance().set(memKey,
	// // MemcachedUtil.SESSION_SECOND, userDto);
	// String memKeyJson = MemcachedKeyEnum.USER_SESSION_JSON.name() + "-" +
	// cookieUserId;
	// MemcachedUtil.getInstance().set(memKeyJson,
	// JsonUtil.object2Fastjson(userDto));
	// }
	// }
	//
	// /**
	// * 设置头部数据
	// *
	// * @param userDto
	// * @return
	// * @author yijinchuan
	// */
	// public static HeaderDto getHeaderDto(UserDto userDto) {
	// // 设置头部数据
	// HeaderDto headerDto = new HeaderDto();
	// Long userId = userDto.getUserId();
	// RemindTypeEnum[] remindEnumArr = RemindTypeEnum.values();
	// Integer totalRemindCount = 0;
	// List<HeaderRemindDto> remindList = new ArrayList<HeaderRemindDto>();
	// HeaderRemindDto headerRemindDto = null;
	// for (RemindTypeEnum remindEnum : remindEnumArr) {
	// // 根据消息类型枚举读取未读消息信息
	// String memcachedKey = MemcachedKeyEnum.REMIND + "-" + remindEnum.name() +
	// "-" + userId;
	// Integer count = (Integer) MemcachedUtil.getInstance().get(memcachedKey);
	// headerRemindDto = new HeaderRemindDto();
	// headerRemindDto.setType(remindEnum.name());
	// headerRemindDto.setCount(count == null ? 0 : count);
	// remindList.add(headerRemindDto);
	// totalRemindCount += (count == null ? 0 : count);
	// }
	// headerDto.setTotalRemindCount(totalRemindCount);
	// headerDto.setRemindList(remindList);
	// return headerDto;
	// }
	//
	// /**
	// * 是否已登录
	// *
	// * @param request
	// * @param response
	// * @return
	// * @author Daniel
	// */
	// public static boolean isLogon(HttpServletRequest request,
	// HttpServletResponse response) {
	// UserDto userDto = getUserDtoFromMemcached(request);
	// if (userDto != null) {
	// // 表示已登录
	// return true;
	// }
	// return false;
	// }
	//
	// /**
	// * 上次是否记住了登录
	// *
	// * @param request
	// * @param response
	// * @return
	// * @author Daniel
	// */
	// public static boolean isRememberLogin(HttpServletRequest request,
	// HttpServletResponse response) {
	// String cookieUserName = getCookieUserInfo(request);
	// if (cookieUserName != null && !"".equals(cookieUserName.trim())) {
	// return true;
	// }
	// return false;
	// }
	//
	// /**
	// * 获得cookie中的用户ID
	// *
	// * @param request
	// * @return
	// * @author Daniel
	// */
	// public static String getCookieUserId(HttpServletRequest request) {
	// String cookieUserId = null;
	// if (StringUtils.isBlank(request.getParameter("token"))) {
	// cookieUserId = (String) request.getAttribute(Constant.COOKIE_USER_ID);
	// if (cookieUserId == null || "".equals(cookieUserId.trim())) {
	// cookieUserId = (String) WebUtils.getSessionAttribute(request,
	// Constant.COOKIE_USER_ID);
	// }
	// if (cookieUserId == null || "".equals(cookieUserId.trim())) {
	// Cookie cookie = WebUtils.getCookie(request, Constant.COOKIE_USER_ID);
	// if (cookie != null) {
	// return cookie.getValue();
	// }
	// }
	// } else {
	// cookieUserId =
	// EncryptUtil.decryptByBase64(request.getParameter("token"));
	// }
	// return cookieUserId;
	// }
	//
	// /**
	// * 获得cookie中的用户信息（就是用户名）
	// *
	// * @param request
	// * @return
	// * @author Daniel
	// */
	// public static String getCookieUserInfo(HttpServletRequest request) {
	// Cookie cookie = WebUtils.getCookie(request, Constant.COOKIE_USER_INFO);
	// if (cookie != null && cookie.getValue() != null &&
	// !"".equals(cookie.getValue().trim())) {
	// return EncryptUtil.decryptByBase64(cookie.getValue());
	// }
	// return null;
	// }

	/**
	 * 移除cookie
	 * 
	 * @param request
	 * @param response
	 * @param cookieName
	 */
	public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String domain) {
		Cookie cookie = WebUtils.getCookie(request, cookieName);
		if (cookie != null) {
			cookie.setMaxAge(0);
			if (domain != null && !"".equals(domain.trim())) {
				cookie.setDomain(domain);
			}
			cookie.setPath("/");
			response.addCookie(cookie);
		}
	}

	/**
	 * 获取当前操作人IP
	 * 
	 * @param request
	 * @return
	 * @author Daniel
	 */
	public static String getRequestIp(HttpServletRequest request) {
		// return request.getRemoteAddr();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 是否ajax请求
	 * 
	 * @param request
	 * @return
	 * @author Daniel
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		if ((request.getHeader("accept").indexOf("application/json") > -1) || (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1)) {
			return true;
		}
		return false;
	}

	/**
	 * 输出JSON
	 * 
	 * @param json
	 * @param response
	 * @return
	 * @author daniel
	 */
	public static String outputJson(String json, HttpServletResponse response) {
		return output(json, response, "text/html;charset=UTF-8");
	}

	public static String outputText(String text, HttpServletResponse response) {
		return output(text, response, "text/html;charset=UTF-8");
	}

	public static String outputXml(String xml, HttpServletResponse response) {
		return output(xml, response, "text/xml;charset=UTF-8");
	}

	public static String output(String str, HttpServletResponse response, String contentType) {
		response.reset();
		response.setCharacterEncoding("UTF-8");
		response.setContentType(contentType);
		try {
			PrintWriter out = response.getWriter();
			out.print(str);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 输出消息
	 * 
	 * @param isSuccess
	 * @param msg
	 * @param response
	 * @return
	 * @author daniel
	 */
	public static String outputMsg(boolean isSuccess, String msg, HttpServletResponse response) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put(IS_SUCCESS, isSuccess);
		retMap.put(MSG, msg);
		return outputMsg(retMap, response);
	}

	/**
	 * 输出消息
	 * 
	 * @param retMap
	 * @param response
	 * @return
	 * @author daniel
	 */
	public static String outputMsg(Map<String, Object> retMap, HttpServletResponse response) {
		String json = JsonUtil.objectToJson(retMap);
		return outputJson(json, response);
	}

	/**
	 * 适用于jsonp方式调用返回
	 * 
	 * @param jsonpCallback
	 * @param isSuccess
	 * @param msg
	 * @param response
	 * @author daniel
	 */
	public static String outputForJsonp(String jsonpCallback, boolean isSuccess, String msg, HttpServletResponse response) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put(IS_SUCCESS, isSuccess);
		retMap.put(MSG, msg);
		return outputForJsonp(jsonpCallback, retMap, response);
	}

	public static String outputForJsonp(String jsonpCallback, Map<String, Object> retMap, HttpServletResponse response) {
		String json = JsonUtil.objectToJson(retMap);
		return outputForJsonp(jsonpCallback, json, response);
	}

	public static String outputForJsonp(String jsonpCallback, String json, HttpServletResponse response) {
		return outputJson(jsonpCallback + "(" + json + ")", response);
	}

	public static Map<String, Object> buildParamMapFromRequest(HttpServletRequest request) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = request.getParameter(name);
			paramMap.put(name, value);
		}
		return paramMap;
	}
}
