package com.bandex.apicenter.web;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.bandex.base.constants.Constant;
import com.bandex.base.dto.ApiFinalResponse;
import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;
import com.bandex.base.utils.JsonUtil;
import com.bandex.base.web.WebHelper;
import com.google.gson.JsonObject;

public class BaseController {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected String buildApiFinalResponse(ApiRequest apiReq, ApiResponse apiRsp) {
		// 统一输出响应JSON
		ApiFinalResponse finalRsp = new ApiFinalResponse();
		finalRsp.setApiVersion(apiReq.getApiVersion());
		finalRsp.setApiCode(apiReq.getApiCode());
		finalRsp.setIsSuccess(apiRsp.getMsgEnum().getIsSuccess());
		finalRsp.setCode(apiRsp.getMsgEnum().getCode());
		if (apiRsp.getUserMsgArgs() != null && apiRsp.getUserMsgArgs().length > 0) {
			finalRsp.setUserMsg(MessageFormat.format(apiRsp.getMsgEnum().getUserMsg(), apiRsp.getUserMsgArgs()));
			finalRsp.setMsg(MessageFormat.format(apiRsp.getMsgEnum().getUserMsg(), apiRsp.getUserMsgArgs()));
		} else {
			finalRsp.setUserMsg(apiRsp.getMsgEnum().getUserMsg());
			finalRsp.setMsg(apiRsp.getMsgEnum().getMsg());
		}
		finalRsp.setCount(apiRsp.getCount());
		finalRsp.setResults(apiRsp.getResults());
		if (apiRsp.getCount() != null && apiRsp.getCount().intValue() > 0 && apiReq.getInt(Constant.PAGE_SIZE) != null && apiReq.getInt(Constant.PAGE_SIZE).intValue() > 0) {
			int pageSize = Integer.parseInt(apiReq.get(Constant.PAGE_SIZE).toString());
			int page = 1;
			if (apiReq.getInt(Constant.PAGE) != null && apiReq.getInt(Constant.PAGE).intValue() > 0) {
				page = apiReq.getInt(Constant.PAGE);
			}
			int totalPages = apiRsp.getCount() / pageSize;
			if (apiRsp.getCount() % pageSize > 0) {
				totalPages++;
			}
			finalRsp.setTotalPages(totalPages);
			finalRsp.setCurPage(page);
			finalRsp.setPageSize(pageSize);
		}
		return JsonUtil.objectToJson(finalRsp);
	}

	@SuppressWarnings("rawtypes")
	protected String outoutApiFinalResponse(ApiRequest apiReq, ApiResponse apiRsp, HttpServletResponse rsp) {
		String apiRspJson = this.buildApiFinalResponse(apiReq, apiRsp);
		return WebHelper.outputJson(apiRspJson, rsp);
	}

	protected void buildSysParamFromHeader(HttpServletRequest req, ApiRequest apiReq) {
		apiReq.setRequestIp(WebHelper.getRequestIp(req));
		apiReq.setRequestTimestamp(System.currentTimeMillis());
		apiReq.setUserAgent(WebHelper.extractRequestHeader(req, "User-Agent"));
		JsonObject clientEventObj = this.extractClientEventFromHeader(req);
		if (clientEventObj != null) {
			apiReq.setDeviceNo(this.extractValueFromClientEvent(clientEventObj, Constant.DEVICE_NO));
			apiReq.setMacAddress(this.extractValueFromClientEvent(clientEventObj, Constant.MAC_ADDRESS));
			apiReq.setOsVersion(this.extractValueFromClientEvent(clientEventObj, Constant.OS_VERSION));
			apiReq.setModelName(this.extractValueFromClientEvent(clientEventObj, Constant.MODEL_NAME));
			apiReq.setChannelCode(this.extractValueFromClientEvent(clientEventObj, Constant.CHANNEL_CODE));
			apiReq.setClientBundleId(this.extractValueFromClientEvent(clientEventObj, Constant.CLIENT_BUNDLE_ID));
			apiReq.setClientVersionName(this.extractValueFromClientEvent(clientEventObj, Constant.CLIENT_VERSION_NAME));
			apiReq.setClientVersionCode(this.extractValueFromClientEvent(clientEventObj, Constant.CLIENT_VERSION_CODE));
			apiReq.setPushDeviceId(this.extractValueFromClientEvent(clientEventObj, Constant.PUSH_DEVICE_ID));
			apiReq.setUserToken(this.extractValueFromClientEvent(clientEventObj, Constant.USER_TOKEN));
			if (!StringUtils.isEmpty(apiReq.getDeviceNo()) || !StringUtils.isEmpty(apiReq.getMacAddress())) {
				apiReq.setImeiMac((!StringUtils.isEmpty(apiReq.getDeviceNo()) ? apiReq.getDeviceNo() : "") + "------" + (!StringUtils.isEmpty(apiReq.getMacAddress()) ? apiReq.getMacAddress() : ""));
			}
		}
	}

	private String extractValueFromClientEvent(JsonObject clientEventObj, String key) {
		if (clientEventObj.has(key)) {
			return clientEventObj.get(key).getAsString();
		}
		return null;
	}

	private JsonObject extractClientEventFromHeader(HttpServletRequest req) {
		String xClientEvent = WebHelper.extractRequestHeader(req, "X-Client-Event");
		if (StringUtils.isEmpty(xClientEvent)) {
			return null;
		}
		JsonObject jsonObj = JsonUtil.jsonToObject(xClientEvent, JsonObject.class);
		return jsonObj;
	}
}
