package com.bandex.apicenter.appapi;

import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;

/**
 * 订单相关API
 * 
 * 订单状态（0：未付款，1：已付款，待发货，2：运输中，3：完成订单，4：已发起退货，5：退货中，6：退货完成，7：订单过期，8：订单删除）
 * 
 * @author Daniel
 */
public interface OrderApi {
	/**
	 * 下单
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	ApiResponse createOrder(ApiRequest apiReq);

	/**
	 * 
	 * 支付
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	ApiResponse pay(ApiRequest apiReq);

	/**
	 * 取消
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	ApiResponse cancelOrder(ApiRequest apiReq);

	/**
	 * 确认收货
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	ApiResponse completeOrder(ApiRequest apiReq);

	/**
	 * 详情
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	ApiResponse orderDetail(ApiRequest apiReq);

	/**
	 * 查看物流
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	ApiResponse viewLogistics(ApiRequest apiReq);

	/**
	 * 申请退货
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	ApiResponse applyReturnGoods(ApiRequest apiReq);

	/**
	 * 查看退货状态
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	ApiResponse viewReturnStatus(ApiRequest apiReq);
}
