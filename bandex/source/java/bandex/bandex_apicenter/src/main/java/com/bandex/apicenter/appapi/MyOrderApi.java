package com.bandex.apicenter.appapi;

import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;

/**
 * 我的订单API
 * 
 * @author Daniel
 */
public interface MyOrderApi {
	/**
	 * 全部订单列表
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	ApiResponse allList(ApiRequest apiReq);

	/**
	 * 待付款订单列表
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	ApiResponse waitPayList(ApiRequest apiReq);

	/**
	 * 待签收订单列表
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	ApiResponse waitSignList(ApiRequest apiReq);

	/**
	 * 已签收订单列表
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	ApiResponse signedList(ApiRequest apiReq);

	/**
	 * 售后订单列表
	 * 
	 * @param apiReq
	 * @return
	 * @author Daniel
	 */
	@SuppressWarnings("rawtypes")
	ApiResponse returnedList(ApiRequest apiReq);
}
