package com.bandex.apicenter.appapi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bandex.apicenter.appapi.MyOrderApi;
import com.bandex.apicenter.dao.OrderInfoMapper;
import com.bandex.apicenter.dao.OrderItemMapper;
import com.bandex.apicenter.dto.OrderItemListDto;
import com.bandex.apicenter.dto.OrderListDto;
import com.bandex.apicenter.service.impl.BaseServiceImpl;
import com.bandex.base.annotations.ApiMethod;
import com.bandex.base.annotations.ApiParam;
import com.bandex.base.annotations.ApiService;
import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;
import com.bandex.base.enums.ApiMsgEnum;

@Service
@ApiService(descript = "我的订单API")
public class MyOrderApiImpl extends BaseServiceImpl implements MyOrderApi {
	@Autowired
	private OrderInfoMapper orderInfoMapper;

	@Autowired
	private OrderItemMapper orderItemMapper;

	@SuppressWarnings("rawtypes")
	private ApiResponse _getOrderList(ApiRequest apiReq) {
		this.setPageIndex(apiReq);
		List<OrderListDto> list = orderInfoMapper.selectMyOrderList(apiReq);
		if (list != null && list.size() > 0) {
			for (OrderListDto dto : list) {
				int totalCount = 0;
				List<OrderItemListDto> itemList = orderItemMapper.selectItemListByOrderCode(dto.getOrderCode());
				if (itemList != null && itemList.size() > 0) {
					for (OrderItemListDto itemDto : itemList) {
						itemDto.setProductIcon(this.getCdnUrl(null, itemDto.getProductIcon(), null));
						totalCount += itemDto.getBuyNum();
					}
				}
				dto.setTotalCount(totalCount);
				dto.setItemList(itemList);
			}
		}
		return new ApiResponse<List<OrderListDto>>(ApiMsgEnum.SUCCESS, null, list);
	}

	@SuppressWarnings("rawtypes")
	@Override
	@ApiMethod(needLogin = true, descript = "全部订单列表", value = "user-order-allList", apiParams = { @ApiParam(descript = "页码", name = "page"), @ApiParam(descript = "每页多少条", name = "pageSize") })
	public ApiResponse allList(ApiRequest apiReq) {
		return this._getOrderList(apiReq);
	}

	@SuppressWarnings("rawtypes")
	@Override
	@ApiMethod(needLogin = true, descript = "待支付订单列表", value = "user-order-waitPayList", apiParams = { @ApiParam(descript = "页码", name = "page"), @ApiParam(descript = "每页多少条", name = "pageSize") })
	public ApiResponse waitPayList(ApiRequest apiReq) {
		apiReq.put("orderState", 0);
		return this._getOrderList(apiReq);
	}

	@SuppressWarnings("rawtypes")
	@Override
	@ApiMethod(needLogin = true, descript = "待签收订单列表", value = "user-order-waitSignList", apiParams = { @ApiParam(descript = "页码", name = "page"), @ApiParam(descript = "每页多少条", name = "pageSize") })
	public ApiResponse waitSignList(ApiRequest apiReq) {
		apiReq.put("orderState", 2);
		return this._getOrderList(apiReq);
	}

	@SuppressWarnings("rawtypes")
	@Override
	@ApiMethod(needLogin = true, descript = "已签收订单列表", value = "user-order-signedList", apiParams = { @ApiParam(descript = "页码", name = "page"), @ApiParam(descript = "每页多少条", name = "pageSize") })
	public ApiResponse signedList(ApiRequest apiReq) {
		apiReq.put("orderState", 3);
		return this._getOrderList(apiReq);
	}

	@SuppressWarnings("rawtypes")
	@Override
	@ApiMethod(needLogin = true, descript = "售后订单列表", value = "user-order-returnedList", apiParams = { @ApiParam(descript = "页码", name = "page"), @ApiParam(descript = "每页多少条", name = "pageSize") })
	public ApiResponse returnedList(ApiRequest apiReq) {
		apiReq.put("orderState", 4);
		return this._getOrderList(apiReq);
	}

}
