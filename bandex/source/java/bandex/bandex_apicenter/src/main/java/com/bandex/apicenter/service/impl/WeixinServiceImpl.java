package com.bandex.apicenter.service.impl;

import java.text.MessageFormat;

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
import org.springframework.stereotype.Service;

import com.bandex.apicenter.dto.OauthAccessTokenDto;
import com.bandex.apicenter.dto.WechatUserDto;
import com.bandex.apicenter.service.WeixinService;
import com.bandex.base.utils.HttpClientUtil;
import com.bandex.base.utils.JsonUtil;

@Service
public class WeixinServiceImpl extends BaseServiceImpl implements WeixinService {
	private static final Logger loger = Logger.getLogger(WeixinServiceImpl.class);

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

}
