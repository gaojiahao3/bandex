package com.bandex.apicenter.service;

import java.util.Date;

import org.springframework.data.geo.Point;

import com.bandex.apicenter.dto.UserSessionDto;

public interface RedisService {
	/**
	 * 司机位置添加
	 * 
	 * @param carTypeId
	 * @param driverId
	 * @param lng
	 * @param lat
	 * @author Daniel
	 */
	void driverGeoAdd(Integer carTypeId, Integer driverId, double lng, double lat);

	/**
	 * 
	 * 司机位置获取
	 * 
	 * @param driverId
	 * @return
	 * @author Daniel
	 */
	Point driverGeoGet(Integer driverId);

	// /**
	// * 司机位置匹配
	// *
	// * @param carTypeId
	// * @param lng
	// * @param lat
	// * @param radius
	// * @return
	// * @author Daniel
	// */
	// GeoResults<GeoLocation<Integer>> driverGeoRadius(Integer carTypeId, double lng, double lat, double radius);

	/**
	 * 
	 * 司机位置删除
	 * 
	 * @param carTypeId
	 * @param driverId
	 * @author Daniel
	 */
	void driverGeoRemove(Integer carTypeId, Integer driverId);

	/**
	 * 订单位置添加
	 * 
	 * @param carTypeId
	 * @param orderId
	 * @param lng
	 * @param lat
	 * @author Daniel
	 */
	void orderGeoAdd(Integer carTypeId, Integer orderId, double lng, double lat);

	// /**
	// * 订单位置匹配
	// *
	// * @param carTypeId
	// * @param lng
	// * @param lat
	// * @param radius
	// * @return
	// * @author Daniel
	// */
	// GeoResults<GeoLocation<Integer>> orderGeoRadius(Integer carTypeId, double lng, double lat, double radius);

	/**
	 * 订单位置删除
	 * 
	 * @param carTypeId
	 * @param orderId
	 * @author Daniel
	 */
	void orderGeoRemove(Integer carTypeId, Integer orderId);

	/**
	 * 订单位置更新
	 * 
	 * @param orderId
	 * @param lng
	 * @param lat
	 * @author Daniel
	 */
	void orderGeoUpdate(Integer orderId, double lng, double lat);

	/**
	 * 订单状态变更
	 * 
	 * @param orderId
	 * @param changeStatus
	 * @param changeDatetime
	 * @author Daniel
	 */
	void orderStatusUpdate(Integer orderId, String changeStatus, Date changeDatetime);

	/**
	 * 订单推送日志添加
	 * 
	 * @param orderId
	 * @param pushData
	 * @author Daniel
	 */
	void orderPushLogAdd(Integer orderId, String pushData);

	/**
	 * 设置用户session
	 * 
	 * @param userToken
	 * @param sessionDto
	 * @author Daniel
	 */
	void setUserSession(String userToken, UserSessionDto sessionDto);

	/**
	 * 获取用户session
	 * 
	 * @param userToken
	 * @return
	 * @author Daniel
	 */
	UserSessionDto getUserSession(String userToken);

	/**
	 * 删除用户session
	 * 
	 * @param userToken
	 * @author Daniel
	 */
	void removeUserSession(String userToken);

	void set(String key, String value);

	void set(String key, String value, long timeoutInSeconds);

	String get(String key);

}
