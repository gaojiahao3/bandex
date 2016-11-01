package com.bandex.apicenter.service;

/**
 * 订单触发器
 * 
 * @author Daniel
 */
public interface OrderTrigger {
	/**
	 * 下单之后
	 * 
	 * @param orderId
	 * @author Daniel
	 */
	void afterCreateOrder(Integer orderId);

	/**
	 * 叫车之后
	 * 
	 * @param order
	 * @author Daniel
	 */
	void afterSendOrder(Integer orderId);

	/**
	 * 接单之后
	 * 
	 * @param orderId
	 * @author Daniel
	 */
	void afterLockOrder(Integer orderId);

	/**
	 * 货已上车之后
	 * 
	 * @param orderId
	 * @author Daniel
	 */
	void afterSendGoods(Integer orderId);

	/**
	 * 货已到达之后
	 * 
	 * @param orderId
	 * @author Daniel
	 */
	void afterDeliveryGoods(Integer orderId);

	/**
	 * 订单完成之后
	 * 
	 * @param orderId
	 * @author Daniel
	 */
	void afterCompleteOrder(Integer orderId);

	/**
	 * 订单取消之后
	 * 
	 * @param orderId
	 * @author Daniel
	 */
	void afterCancelOrder(Integer orderId);
}
