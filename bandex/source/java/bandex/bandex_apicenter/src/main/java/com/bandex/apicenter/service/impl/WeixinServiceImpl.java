package com.bandex.apicenter.service.impl;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bandex.apicenter.dto.OauthAccessTokenDto;
import com.bandex.apicenter.dto.WechatUserDto;
import com.bandex.apicenter.dto.WeixinOrderDto;
import com.bandex.apicenter.dto.WeixinOrderResultDto;
import com.bandex.apicenter.service.WeixinService;
import com.bandex.base.utils.HttpClientUtil;
import com.bandex.base.utils.JsonUtil;
import com.bandex.base.utils.MapUtil;
import com.bandex.base.utils.XmlUtil;
import com.tencent.common.MD5;
import com.tencent.common.RandomStringGenerator;

@Service
public class WeixinServiceImpl extends BaseServiceImpl implements WeixinService {
	private static final Logger loger = Logger.getLogger(WeixinServiceImpl.class);

	private static final String WX_PACKAGE = "Sign=WXPay";

	private static final String TRADE_TYPE = "APP";// JSAPI,NATIVE,APP,WAP

	// private static final String TRADE_TYPE_NATIVE = "NATIVE";// JSAPI,NATIVE,APP,WAP

	@Value("${weixinpay.appid}")
	private String weixinpayAppId;

	@Value("${weixinpay.mchid}")
	private String weixinpayMchId;

	@Value("${weixinpay.key}")
	private String weixinpayKey;

	@Value("${weixinpay.callbackUrl}")
	private String weixinpayCallbackUrl;

	@Value("${weixinpay.unifiedorderUrl}")
	private String weixinpayUnifiedorderUrl;

	public static void main(String[] args) {
		String weixinGetUserInfo = "https://api.weixin.qq.com/sns/userinfo?access_token={0}&openid={1}";
		String accessToken = "OezXcEiiBSKSxW0eoylIeEyE8aTQY1m89Yjpvuj-_IQZQX3NO9mSYVCJEdwBOV8WRBdCZDCwccoj8rOYOOa4ZUi5xlg1JiA2vfkhDESvDb-ZoDa8igV0Ek_R0JtgtSuDWqH59AI1o00sPGxZ2vvr9Q";
		String openid = "oSoGCjuGk4fNb2VcczrUUSfa-n5o";
		String json = doHttpGet(MessageFormat.format(weixinGetUserInfo, accessToken, openid));
		loger.info("_getUserInfo=" + json);
		WechatUserDto dto = JsonUtil.jsonToObject(json, WechatUserDto.class);
		if (dto != null && dto.getOpenid() != null) {
			dto.setData(json);
		}
	}

	private OauthAccessTokenDto _getAccessToken(String code) {
		// 支持多个客户端，多个APPID
		String getAccessTokenUrl = MessageFormat.format(this.weixinAccessToken, code);
		String json = new HttpClientUtil().doHttpGet(getAccessTokenUrl, null);
		loger.info("_getAccessToken=" + json);
		OauthAccessTokenDto dto = JsonUtil.jsonToObject(json, OauthAccessTokenDto.class);
		if (dto != null && dto.getAccess_token() != null) {
			return dto;
		}
		return null;
	}

	private WechatUserDto _getUserInfo(String accessToken, String openid) {
		String json = doHttpGet(MessageFormat.format(this.weixinGetUserInfo, accessToken, openid));
		loger.info("_getUserInfo=" + json);
		WechatUserDto dto = JsonUtil.jsonToObject(json, WechatUserDto.class);
		if (dto != null && dto.getOpenid() != null) {
			dto.setData(json);
			return dto;
		}
		return null;
	}

	@Override
	public WechatUserDto getUserInfoByCode(String code) {
		OauthAccessTokenDto accessTokenDto = _getAccessToken(code.toString());
		if (accessTokenDto == null) {
			return null;
		}
		return _getUserInfo(accessTokenDto.getAccess_token(), accessTokenDto.getOpenid());
	}

	/**
	 * HTTP GET请求
	 * 
	 * @param url
	 * @param paramMap
	 * @return
	 * @author daniel
	 */
	public static String doHttpGet(String url) {
		String retStr = null;
		HttpClient httpClient = new DefaultHttpClient();
		HttpParams params = httpClient.getParams();
		HttpConnectionParams.setConnectionTimeout(params, 15000);
		HttpConnectionParams.setSoTimeout(params, 15000);
		HttpGet httpGet = new HttpGet(url);
		HttpResponse httpResponse = null;
		int httpStatusCode = 0;
		try {
			httpResponse = httpClient.execute(httpGet);
			httpStatusCode = httpResponse.getStatusLine().getStatusCode();
			if (HttpStatus.SC_OK == httpStatusCode) {
				HttpEntity httpEntity = httpResponse.getEntity();
				if (httpEntity != null) {
					retStr = EntityUtils.toString(httpEntity, "UTF-8");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return retStr;
	}

	@Override
	public String getPayString(String orderCode, Double payPrice, String body, String ip) {
		WeixinOrderDto wxOrderDto = new WeixinOrderDto();
		wxOrderDto.setAppid(this.weixinpayAppId);
		wxOrderDto.setMch_id(this.weixinpayMchId);
		wxOrderDto.setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		wxOrderDto.setBody(body);
		wxOrderDto.setOut_trade_no(orderCode);
		wxOrderDto.setTotal_fee(new BigDecimal(payPrice.toString()).multiply(new BigDecimal("100")).intValue());
		wxOrderDto.setSpbill_create_ip(ip);
		wxOrderDto.setNotify_url(this.weixinpayCallbackUrl + "/" + orderCode);
		wxOrderDto.setTrade_type(TRADE_TYPE);
		Map<String, Object> wxOrderMap = MapUtil.objectToMap(wxOrderDto);
		String sign = this._sign(wxOrderMap, this.weixinpayKey);
		wxOrderDto.setSign(sign);
		String wxOrderXml = XmlUtil.objectToXml(wxOrderDto);
		loger.info("wxOrderXml=" + wxOrderXml);
		String wxOrderResult = new HttpClientUtil().doHttpStream(weixinpayUnifiedorderUrl, wxOrderXml);
		loger.info("wxOrderResult=" + wxOrderResult);
		if (!StringUtils.isEmpty(wxOrderResult)) {
			WeixinOrderResultDto wxResultDto = (WeixinOrderResultDto) XmlUtil.xmlToObject(wxOrderResult, WeixinOrderResultDto.class);
			if (wxResultDto != null && "SUCCESS".equals(wxResultDto.getReturn_code())) {
				if ("SUCCESS".equals(wxResultDto.getResult_code())) {
					String createOrderString = this._createOrderString(wxResultDto.getPrepay_id());
					loger.info("createOrderString=" + createOrderString);
					return createOrderString;
				}
			}
		}
		return null;
	}

	private String _createOrderString(String prepayId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("appid", weixinpayAppId);
		paramMap.put("partnerid", weixinpayAppId);
		paramMap.put("prepayid", prepayId);
		paramMap.put("package", WX_PACKAGE);
		paramMap.put("noncestr", RandomStringGenerator.getRandomStringByLength(32));
		paramMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
		paramMap.put("sign", this._sign(paramMap, this.weixinpayKey));
		return JsonUtil.objectToJson(paramMap);
	}

	private String _sign(Map<String, Object> paramMap, String apiSecret) {
		Map<String, Object> signMap = new TreeMap<String, Object>();
		signMap.putAll(paramMap);
		StringBuffer str = new StringBuffer();
		for (Entry<String, Object> entry : signMap.entrySet()) {
			String key = entry.getKey();
			if ("sign".equals(key)) {
				continue;
			}
			Object value = entry.getValue();
			if (value != null && !"".equals(value.toString().trim()) && !"null".equals(value.toString())) {
				str.append(key);
				str.append("=");
				str.append(value.toString());
				str.append("&");
			}
		}
		str.append("key=" + apiSecret);
		return MD5.MD5Encode(str.toString()).toUpperCase();
	}

}
