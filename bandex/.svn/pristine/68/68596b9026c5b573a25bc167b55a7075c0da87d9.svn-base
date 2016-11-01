package com.bandex.apicenter.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.bandex.apicenter.dto.UserSessionDto;
import com.bandex.apicenter.service.RedisService;
import com.bandex.base.utils.JsonUtil;

@Service
public class RedisServiceImpl extends BaseServiceImpl implements RedisService {
	/**
	 * 所有司机的坐标
	 */
	private static final String DRIVERS_GEO_LIST = "drivers-geo-list-";

	/**
	 * 单个司机坐标
	 */
	private static final String DRIVER_GEO_LIST = "driver-geo-list-";

	/**
	 * 所有订单的坐标
	 */
	private static final String ORDERS_GEO_LIST = "orders-geo-list-";

	/**
	 * 单个订单坐标
	 */
	private static final String ORDER_GEO_LIST = "order-geo-list-";

	/**
	 * 单个订单状态
	 */
	private static final String ORDER_STATUS_LIST = "order-status-list-";

	/**
	 * 单个订单推送日志
	 */
	private static final String ORDER_PUSH_LOG = "order-push-log-";

	/**
	 * 单个用户session
	 */
	private static final String USER_SESSION_PREFIX = "user-session-";

	// @Autowired
	// private RedisTemplate<String, String> template;

	// @Resource(name = "redisTemplate")
	// private ListOperations<String, String> listOps;

	@Resource(name = "redisTemplate")
	private ValueOperations<String, String> valueOps;

	// @Resource(name = "redisTemplate")
	// private GeoOperations<String, Integer> driversGeoOps;

	@Resource(name = "redisTemplate")
	private ListOperations<String, Point> driverGeoList;

	// @Resource(name = "redisTemplate")
	// private GeoOperations<String, Integer> ordersGeoOps;

	@Resource(name = "redisTemplate")
	private ListOperations<String, Point> orderGeoList;

	@Resource(name = "redisTemplate")
	private ListOperations<String, String> orderStatusList;

	@Resource(name = "redisTemplate")
	private ListOperations<String, String> orderPushLog;

	@Override
	public void driverGeoAdd(Integer carTypeId, Integer driverId, double lng, double lat) {
		// driversGeoOps.geoAdd(DRIVERS_GEO_LIST + carTypeId, new Point(lng, lat), driverId);
		driverGeoList.leftPush(DRIVER_GEO_LIST + driverId, new Point(lng, lat));
	}

	@Override
	public Point driverGeoGet(Integer driverId) {
		return driverGeoList.index(DRIVER_GEO_LIST + driverId, 0);
	}

	// @Override
	// public GeoResults<GeoLocation<Integer>> driverGeoRadius(Integer carTypeId, double lng, double lat, double radius) {
	// return driversGeoOps.geoRadius(DRIVERS_GEO_LIST + carTypeId, new Circle(new Point(lng, lat), radius), GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance());
	// }

	@Override
	public void driverGeoRemove(Integer carTypeId, Integer driverId) {
		// driversGeoOps.geoRemove(DRIVERS_GEO_LIST + carTypeId, driverId);
	}

	@Override
	public void orderGeoAdd(Integer carTypeId, Integer orderId, double lng, double lat) {
		// ordersGeoOps.geoAdd(ORDERS_GEO_LIST + carTypeId, new Point(lng, lat), orderId);
		orderGeoList.leftPush(ORDER_GEO_LIST + orderId, new Point(lng, lat));
	}

	// @Override
	// public GeoResults<GeoLocation<Integer>> orderGeoRadius(Integer carTypeId, double lng, double lat, double radius) {
	// return ordersGeoOps.geoRadius(ORDERS_GEO_LIST + carTypeId, new Circle(new Point(lng, lat), radius), GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance());
	// }

	@Override
	public void orderGeoRemove(Integer carTypeId, Integer orderId) {
		// ordersGeoOps.geoRemove(ORDERS_GEO_LIST + carTypeId, orderId);
	}

	@Override
	public void orderGeoUpdate(Integer orderId, double lng, double lat) {
		orderGeoList.leftPush(ORDER_GEO_LIST + orderId, new Point(lng, lat));
	}

	@Override
	public void orderStatusUpdate(Integer orderId, String changeStatus, Date changeDatetime) {
		Map<String, Object> statusMap = new HashMap<String, Object>();
		statusMap.put("orderId", orderId);
		statusMap.put("changeStatus", changeStatus);
		statusMap.put("changeDatetime", changeDatetime);
		orderStatusList.leftPush(ORDER_STATUS_LIST + orderId, JsonUtil.objectToJson(statusMap));
	}

	@Override
	public void orderPushLogAdd(Integer orderId, String pushData) {
		orderPushLog.leftPush(ORDER_PUSH_LOG + orderId, pushData);
	}

	@Override
	public void setUserSession(String userToken, UserSessionDto sessionDto) {
		// this.setToMemcached(userToken, JsonUtil.objectToJson(sessionDto), null);
		this.set(USER_SESSION_PREFIX + userToken, JsonUtil.objectToJson(sessionDto), 30 * 24 * 60 * 60);
	}

	@Override
	public UserSessionDto getUserSession(String userToken) {
		String value = this.get(USER_SESSION_PREFIX + userToken);
		if (value != null) {
			return JsonUtil.jsonToObject(value, UserSessionDto.class);
		}
		return null;
	}

	@Override
	public void removeUserSession(String userToken) {
		// this.removeFromMemcached(USER_SESSION_PREFIX + userToken);
		this.set(USER_SESSION_PREFIX + userToken, null, 1);
	}

	@Override
	public void set(String key, String value) {
		valueOps.set(key, value);
	}

	@Override
	public void set(String key, String value, long timeoutInSeconds) {
		valueOps.set(key, value, timeoutInSeconds, TimeUnit.SECONDS);
	}

	@Override
	public String get(String key) {
		return valueOps.get(key);
	}

}
