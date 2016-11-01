package com.bandex.api.web;

import com.alibaba.fastjson.JSON;
import com.bandex.api.dto.ApiFinalResponse;
import com.bandex.api.dto.ApiRequest;
import com.bandex.api.dto.ApiResponse;
import com.bandex.api.enums.RestResultEnum;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import sh.zj100.common.util.JsonUtil;
import sh.zj100.common.util.SimpleTokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.*;

/**
 * API分发处理器<br>
 * 
 * 思路：<br>
 * 
 * 1.首先定义一个注解，如FunctionCode，value就是约定的user.login这种；<br>
 * 2.将这个注解应用于相应业务的service以及service方法上; <br>
 * 3.当请求进入时，拦截请求，封装请求参数至ApiRequest，并分发到相应的service上；<br>
 * 4.业务处理完成后，由总控制的地方，统一输出响应数据，如ApiResponse。<br>
 * 
 * 调用service之前还可以加一些验证beforeInvokeService等等，安全方面的考虑，比如token<br>
 * 
 * 调用service之后也可以做一些日志记录afterInvokeService<br>
 * 
 * @author Jason
 */
@Controller
public class ApiDispatchController {
	private final Log loger = LogFactory.getLog(ApiDispatchController.class);

	private static final String API_ID = "apiId";
	private static final String ACCESS_TOKEN = "token";
	private static final String FUNCTION_CODE = "functioncode";



	@Value("${api.version}")
	private String apiVersion;

    @Value("${bg.api.secert}")
    private String apiSecert;



    @SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/apicenter")
	public String apiDispatch(HttpServletRequest req, HttpServletResponse rsp) {
		ApiResponse apiRsp = null;
		try {
			ApiRequest apiReq = new ApiRequest();
            ApiRequest sysReq = new ApiRequest();
            Object sysUserId=req.getHeader("userid");
			// apiReq.putAll(req.getParameterMap());
			Enumeration em = req.getParameterNames();
			while (em.hasMoreElements()) {
				String name = (String) em.nextElement();
                if (API_ID.equals(name) || FUNCTION_CODE.equals(name) || ACCESS_TOKEN.equals(name)) {
                    sysReq.put(name, req.getParameter(name));
                }
				String value = req.getParameter(name);
				apiReq.put(name, value);
			}
			apiRsp = this.checkParam(sysReq);
			if (apiRsp != null) {
				return this.outputApiResponse(req, rsp, apiRsp);
			}
			// 此处可以把调用接口的IP,时间记录下来
			apiReq.setApiId(req.getParameter(API_ID));
			apiReq.setAccessToken(req.getParameter(ACCESS_TOKEN));
			apiReq.setFunctionCode(req.getParameter(FUNCTION_CODE));
			apiReq.setRequestIp(WebHelper.getRequestIp(req));
			apiReq.setRequestTime(new Date());
            apiReq.setCookies(req.getCookies());
            apiReq.setSession(req.getSession());
            apiReq.setRequest(req);
            apiReq.setResponse(rsp);

            if(!StringUtils.isEmpty(sysUserId)){
                apiReq.setSysUserId(sysUserId.toString());
            }
            apiReq.setParameters(apiReq.toString());
			loger.info("apiReq======" + apiReq.toString());

			// 此处可以加入统一的签名验证等系统级别的参数验证,具体的业务参数验证请在service做
			this.beforeInvokeService(apiReq);

			String functioncode = req.getParameter(FUNCTION_CODE);
            //验证权限
//            boolean flag=verificationAuthority(apiReq);
//            if(!flag){
//                apiRsp = new ApiResponse(RestResultEnum.NoAuthorityException);
//                return this.outputApiResponse(req, rsp, apiRsp);
//            }
			String[] tempArr = functioncode.split("\\.");// 目录暂时以这种方法反射
			if (tempArr != null && tempArr.length > 0) {
				String serviceFunctionCode = tempArr[0];
				Object bean = SpringBeanProxy.getBeanByFunctionCode(serviceFunctionCode);
				Method method = SpringBeanProxy.getMethodByFunctionCode(functioncode);
				try {
					Object rspObj = method.invoke(bean, new Object[] { apiReq });
					if (rspObj instanceof ApiResponse) {
						apiRsp = (ApiResponse) rspObj;
					}
					this.afterInvokeService(apiReq, rspObj);
				} catch (Exception e) {
					apiRsp = new ApiResponse(RestResultEnum.INVOKE_ERROR);
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (apiRsp == null) {
			apiRsp = new ApiResponse(RestResultEnum.UNKNOW_ERROR);
		}
		// 统一输出响应JSON
		return this.outputApiResponse(req, rsp, apiRsp);
	}

	/**
	 * 验证参数
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	private ApiResponse checkParam(ApiRequest apiReq) {
		loger.info("checkParam apiReq===" + apiReq.toString());
		ApiResponse apiRsp = null;
		if (!StringUtils.isEmpty(apiReq.get(API_ID)) && !StringUtils.isEmpty(apiReq.get(ACCESS_TOKEN)) && !StringUtils.isEmpty(apiReq.get(FUNCTION_CODE))) {
			String apiId = apiReq.get(API_ID).toString();
			String inputToken = apiReq.get(ACCESS_TOKEN).toString();
            String functionCode = apiReq.get(FUNCTION_CODE).toString();
            //apiReq.clear();
//            apiReq.setApiId(apiId);
//            apiReq.setFunctionCode(functionCode);
            loger.info("apiReq===" + apiReq );
			String rightToken = SimpleTokenUtil.buildToken(apiReq,apiSecert);
			loger.info("inputToken===" + inputToken + "	rightToken=" + rightToken);
			if (!inputToken.equals(rightToken)) {
				apiRsp = new ApiResponse(RestResultEnum.TOKEN_ERROR);
			}
		} else {
			apiRsp = new ApiResponse(RestResultEnum.MissParameterException);
		}
		return apiRsp;
	}

	/**
	 * 调用service之前
	 * 
	 * @param apiReq
	 * @author Daniel
	 */
	private void beforeInvokeService(ApiRequest apiReq) {

	}

	/**
	 * 调用service之后
	 * 
	 * @param apiReq
	 * @param rspObj
	 * @author Daniel
	 */
	private void afterInvokeService(ApiRequest apiReq, Object rspObj) {
//如果是登录或者注册则不调用此方法
        String functionCode = apiReq.getFunctionCode().toString();
        if(functionCode.equals("sysUser.login")||functionCode.equals("sysUser.isLogin")){
            System.out.println("4444444444444444444");
        }else{
//            Object cookieUserIdObj = apiReq.getSysUserId();
//            Object parameters=apiReq.getParameters();
//            System.out.println("=====================parameters:"+parameters);
//            SysUser sysUser = null;
//            if(cookieUserIdObj!=null){
//                sysUser =this.sysUserMapper.selectByPrimaryKey(Long.valueOf(cookieUserIdObj.toString()));
//                if(sysUser!=null){
//                    System.out.println("userDto:"+sysUser.getId());
//                    //记录日志
//                    SysLog sysLog = new SysLog();
//                    sysLog.setUserId(sysUser.getId());
//                    sysLog.setUserName(sysUser.getSysUserName());
//                    sysLog.setCreateTime(new Date());
//                    String[]  functionCodeArray;
//                    functionCodeArray = functionCode.split("\\.");
//                    String oopBusiness = functionCodeArray[0].toString();
//                    String oopCrud = functionCodeArray[1].toString();
//                    sysLog.setOperateType(oopCrud);
//                    sysLog.setOopBusiness(oopBusiness);
//                    sysLog.setOopIp(apiReq.getRequestIp());
//                    sysLog.setPlatformCode("orderAPI");
//                    Map<String,Map<String,String>> map =SpringBeanProxy.getFunctionCodeListMap();
//                    Map<String,String> map1 = map.get(oopBusiness);
//                    System.out.println("map1:"+map1.get(functionCode));
//                    String desc = map1.get(functionCode);
//                    if(!StringUtils.isEmpty(parameters)){
//                        sysLog.setParameters(parameters.toString());
//                    }
//                    sysLog.setOperateDesc(desc);
//                    this.sysLogMapper.insertSelective(sysLog);
//                }else{
//                    System.out.println("userDto is null");
//                }
//            }
        }
	}

//    /**
//     * 验证权限
//     * @param apiReq
//     * @return
//     */
//    private Boolean verificationAuthority(ApiRequest apiReq) {
//        HashMap<String,Object> map =new HashMap<String, Object>();
//        String functionCode = apiReq.getFunctionCode();
//        map.put("resourceType",2);//资源类型(1菜单,2按钮)
//        map.put("sysUserId",apiReq.getSysUserId());
//        loger.info("sysUserId====================" + apiReq.getSysUserId() );
//        if(apiReq.getSysUserId()==null) {
//            Object apiInvokingObj=apiReq.get("apiInvoking");
//            if(!StringUtils.isEmpty(apiInvokingObj)&&18==Integer.parseInt(apiInvokingObj.toString())){
//                return true;
//            }
//            return false;
//        }
//        List<SysResourcePo> resources=ehCacheServiceImpl.getUserResources(map);
//        for(SysResourcePo resource:resources){
//            String resourcePath= resource.getResourcePath();
//            if(resourcePath.equals(functionCode)){
//                return  true;
//            }
//        }
//        return  false;
//    }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private String outputApiResponse(HttpServletRequest req, HttpServletResponse rsp, ApiResponse apiRsp) {
		// 统一输出响应JSON
		ApiFinalResponse finalRsp = new ApiFinalResponse();
		finalRsp.setVersion(apiVersion);
		finalRsp.setFunctioncode(req.getParameter(FUNCTION_CODE));
		finalRsp.setIsSuccess(apiRsp.getReturnEnum().getIsSuccess());
		finalRsp.setCode(apiRsp.getReturnEnum().getCode());
		finalRsp.setMsg(apiRsp.getReturnEnum().getMsg());
		finalRsp.setTotal(apiRsp.getTotal());
		finalRsp.setRecord(apiRsp.getRecord());
		// finalRsp.setModelMap(apiRsp.getModelMap());
		String jsonString = null;
		if ("true".equals(req.getParameter("debug"))) {
			jsonString = JSON.toJSONString(finalRsp, true);
		} else {
			jsonString = JsonUtil.object2Fastjson(finalRsp);
		}
		loger.info("jsonString===" + jsonString);
		String jsonpCallback = req.getParameter("jsonpCallback");
		if (jsonpCallback != null && !"".equals(jsonpCallback.trim())) {
			return WebHelper.outputForJsonp(jsonpCallback, jsonString, rsp);
		} else {
			return WebHelper.outputJson(jsonString, rsp);
		}
	}

}
