package com.bandex.backend.web;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.bandex.backend.dto.SysMenuDto;
import com.bandex.backend.dto.SysUserDto;
import com.bandex.base.dto.ApiFinalResponse;
import com.bandex.base.enums.BackendApiMethodEnum;
import com.bandex.base.utils.JsonUtil;
import com.bandex.base.web.WebHelper;
import com.google.gson.reflect.TypeToken;

@Controller
public class BackendLoginController extends BackendBaseController {

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest req) {
		if (this.isLogon(req)) {
			return "redirect:/";
		}
		req.setAttribute("username", req.getParameter("username"));
		return "/login";
	}

	@RequestMapping(value = "/doLogin")
	public String doLogin(HttpServletRequest req, HttpServletResponse rsp, RedirectAttributes redirectAttributes) {
		if (this.isLogon(req)) {
			return "redirect:/";
		}
		Map<String, Object> appendMap = new HashMap<String, Object>();
		appendMap.put("login_ip", WebHelper.getRequestIp(req));
		String json = this.callApi(BackendApiMethodEnum.BACKEND_ADMIN_LOGIN, appendMap, req);
		Type type = new TypeToken<ApiFinalResponse<SysUserDto>>() {
		}.getType();
		ApiFinalResponse<SysUserDto> apiRsp = JsonUtil.jsonToObject(json, type);
		String retMsg = "登录失败";
		if (apiRsp != null) {
			if (apiRsp.getIsSuccess() == Boolean.TRUE) {
				SysUserDto authUser = apiRsp.getResults();
				WebUtils.setSessionAttribute(req, SESSION_ADMIN_DTO, authUser);
				List<SysMenuDto> menuList = null;
				// root用户拥有超级权限
				if ("root".equalsIgnoreCase(authUser.getUsername())) {
					menuList = _getUserMenuList(null);
				} else {
					menuList = _getUserMenuList(authUser.getId());
				}
				WebUtils.setSessionAttribute(req, SESSION_MENULIST_DTO, menuList);
				Map<String, Integer> menuCodeMap = new HashMap<String, Integer>();
				for (SysMenuDto dto : menuList) {
					menuCodeMap.put(dto.getMenuCode(), dto.getId());
				}
				WebUtils.setSessionAttribute(req, SESSION_MENU_MAP, menuCodeMap);
				return "redirect:/";
			} else {
				retMsg = apiRsp.getMsg();
			}
		}
		redirectAttributes.addFlashAttribute("msg", retMsg);
		redirectAttributes.addFlashAttribute("username", req.getParameter("username"));
		return "redirect:/login";
	}

	public List<SysMenuDto> _getUserMenuList(Integer userId) {
		Map<String, Object> appendMap = new HashMap<String, Object>();
		appendMap.put("userId", userId);
		String json = this.callApi(BackendApiMethodEnum.BACKEND_SYSMENU_LISTBYUSERID, appendMap, null);
		Type type = new TypeToken<ApiFinalResponse<List<SysMenuDto>>>() {
		}.getType();
		ApiFinalResponse<List<SysMenuDto>> apiRsp = JsonUtil.jsonToObject(json, type);
		if (apiRsp != null) {
			return apiRsp.getResults();
		}
		return null;
	}

}
