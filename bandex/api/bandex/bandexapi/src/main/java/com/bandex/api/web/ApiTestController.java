package com.bandex.api.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sh.zj100.common.util.HttpClientUtil;
import sh.zj100.common.util.SimpleTokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ApiTestController {
	@Value("${bandex.api.server}")
	private String defaultApiServer;

	@Value("${bandex.api.id}")
	private String defaultApiId;

	@Value("${bandex.api.secert}")
	private String defaultApiSecret;

	@RequestMapping(value = "/apitest")
	public String apitest(ModelMap modelMap) {
		modelMap.addAttribute("defaultApiServer", defaultApiServer);
		modelMap.addAttribute("defaultApiId", defaultApiId);
		modelMap.addAttribute("defaultApiSecret", defaultApiSecret);
		modelMap.addAttribute("functionCodeCatalogMap", SpringBeanProxy.getFunctionCodeCatalogMap());
		modelMap.addAttribute("functionCodeListMap", SpringBeanProxy.getFunctionCodeListMap());
		return "/apitest";
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/doApiTest")
	public String doApiTest(HttpServletRequest req, HttpServletResponse rsp, @RequestParam String apiServer) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Enumeration em = req.getParameterNames();
        //em里面默认有7个参数，[apiId, functioncode, apiServer, t, apiSecret, paramValue, paramName]；
        //但是只需要apiId, functioncode,和从系统中读取的密钥secreyKey 一起生成一个token值
		while (em.hasMoreElements()) {
			String name = (String) em.nextElement();
			if ("apiServer".equals(name) || "apiSecret".equals(name) || "t".equals(name) || "paramName".equals(name) || "paramValue".equals(name)) {
				continue;
			}
			String value = req.getParameter(name);
			paramMap.put(name, value);
		}
        String secreyKey = req.getParameter("apiSecret");
        String token = SimpleTokenUtil.buildToken(paramMap, secreyKey);
		String[] paramNameArr = req.getParameterValues("paramName");
		String[] paramValueArr = req.getParameterValues("paramValue");
		if (paramNameArr != null && paramNameArr.length > 0) {
			int n = 0;
			for (String paramName : paramNameArr) {
				if (paramName != null && !"".equals(paramName.trim())) {
					paramMap.put(paramName, paramValueArr[n]);
				}
				n++;
			}
		}
		paramMap.put("debug", "true");
		paramMap.put("token", token);
		String retJson = HttpClientUtil.doHttpPost(apiServer + "/apicenter", paramMap);
		return WebHelper.outputJson(retJson, rsp);
	}
}
