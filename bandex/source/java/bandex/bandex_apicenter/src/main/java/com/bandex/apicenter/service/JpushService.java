package com.bandex.apicenter.service;

/**
 * 极光推送服务
 * 
 * @author Daniel
 */
public interface JpushService {
	/**
	 * 给指定设备推送消息
	 * 
	 * @param registrationIds
	 * @param msgContent
	 * @author Daniel
	 */
	void pushMsgByRegistrationIds(String[] registrationIds, String msgContent);

	/**
	 * 按设备别名推送消息
	 * 
	 * @param alias
	 * @param msgContent
	 * @author Daniel
	 */
	void pushMsgByAlias(String[] alias, String msgContent);

	/**
	 * 按设备标签推送消息
	 * 
	 * @param tags
	 * @param msgContent
	 * @author Daniel
	 */
	void pushMsgByTags(String[] tags, String msgContent);

	/**
	 * 给所有设备推送消息
	 * 
	 * @param msgContent
	 * @author Daniel
	 */
	void pushMsgToAll(String msgContent);
}
