package com.bandex.apicenter.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bandex.apicenter.dto.OauthAccessTokenDto;
import com.bandex.apicenter.dto.WeiboUserDto;
import com.bandex.apicenter.service.WeiboService;
import com.bandex.base.utils.HttpsUtil;
import com.bandex.base.utils.JsonUtil;

@Service
public class WeiboServiceImpl extends BaseServiceImpl implements WeiboService {

	@Override
	public WeiboUserDto getUserByCode(String code) {
		OauthAccessTokenDto accessTokenDto = this._getAccessToken(code);
		if (accessTokenDto != null) {
			return this._getUser(accessTokenDto.getAccess_token(), accessTokenDto.getUid());
		}
		return null;
	}

	private WeiboUserDto _getUser(String accessToken, String uid) {
		String url = "https://api.weibo.com/2/users/show.json?access_token=" + accessToken + "&uid=" + uid;
		String retJson = HttpsUtil.doHttpsGet(url);
		System.out.println("_getUser retJson=" + retJson);
		if (!StringUtils.isEmpty(retJson)) {
			WeiboUserDto weiboUserDto = JsonUtil.jsonToObject(retJson, WeiboUserDto.class);
			if (weiboUserDto != null) {
				weiboUserDto.setJsonData(retJson);
			}
			return weiboUserDto;
		}
		return null;
	}

	private OauthAccessTokenDto _getAccessToken(String code) {
		String url = "https://api.weibo.com/oauth2/access_token";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("client_id", this.weiboClientId);
		paramMap.put("client_secret", this.weiboClientSecret);
		paramMap.put("grant_type", GRANT_TYPE);
		paramMap.put("code", code);
		paramMap.put("redirect_uri", this.weiboRedirectUri);
		String retJson = HttpsUtil.doHttpsPost(url, paramMap, null);
		System.out.println("_getAccessToken retJson=" + retJson);
		if (!StringUtils.isEmpty(retJson)) {
			return JsonUtil.jsonToObject(retJson, OauthAccessTokenDto.class);
		}
		return null;
	}
}
