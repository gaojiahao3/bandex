package com.bandex.apicenter.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bandex.apicenter.service.JpushService;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;

@Service
public class JpushServiceImpl extends BaseServiceImpl implements JpushService {
	private static final Logger loger = Logger.getLogger(JpushServiceImpl.class);

	@Override
	public void pushMsgByRegistrationIds(String[] registrationIds, String msgContent) {
		PushPayload payload = PushPayload.newBuilder().setAudience(Audience.registrationId(registrationIds)).setMessage(Message.content(msgContent)).build();
		this._pushMsg(payload);
	}

	@Override
	public void pushMsgByAlias(String[] alias, String msgContent) {
		PushPayload payload = PushPayload.newBuilder().setAudience(Audience.alias(alias)).setMessage(Message.content(msgContent)).build();
		this._pushMsg(payload);
	}

	@Override
	public void pushMsgByTags(String[] tags, String msgContent) {
		PushPayload payload = PushPayload.newBuilder().setAudience(Audience.tag(tags)).setMessage(Message.content(msgContent)).build();
		this._pushMsg(payload);
	}

	@Override
	public void pushMsgToAll(String msgContent) {
		PushPayload payload = PushPayload.messageAll(msgContent);
		this._pushMsg(payload);
	}

	private void _pushMsg(PushPayload payload) {
		JPushClient jpushClient = new JPushClient(this.jpushMasterSecret, this.jpushAppKey);
		loger.error("payload=" + payload.toJSON().toString());
		try {
			PushResult result = jpushClient.sendPush(payload);
			loger.info("Got result - " + result);
		} catch (APIConnectionException e) {
			// Connection error, should retry later
			loger.error("Connection error, should retry later", e);
		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			loger.error("Should review the error, and fix the request", e);
			loger.info("HTTP Status: " + e.getStatus());
			loger.info("Error Code: " + e.getErrorCode());
			loger.info("Error Message: " + e.getErrorMessage());
		}
	}

}
