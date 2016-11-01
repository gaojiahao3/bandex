package com.bandex.apicenter.appapi.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bandex.apicenter.dao.OrderInfoMapper;
import com.bandex.apicenter.dao.OrderItemMapper;
import com.bandex.apicenter.dto.OrderDetailDto;
import com.bandex.apicenter.dto.OrderItemListDto;
import com.bandex.apicenter.model.OrderInfo;
import com.bandex.apicenter.service.impl.BaseServiceImpl;
import com.bandex.base.annotations.ApiMethod;
import com.bandex.base.annotations.ApiParam;
import com.bandex.base.annotations.ApiService;
import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;
import com.bandex.base.enums.ApiMsgEnum;

@Service
@ApiService(descript = "订单相关API")
public class OrderApiImpl extends BaseServiceImpl implements com.bandex.apicenter.appapi.OrderApi {
	@Autowired
	private OrderInfoMapper orderInfoMapper;

	@Autowired
	private OrderItemMapper orderItemMapper;

	@SuppressWarnings("rawtypes")
	@Override
	@ApiMethod(needLogin = true, descript = "生成订单", value = "order-create", apiParams = {})
	public ApiResponse createOrder(ApiRequest apiReq) {
		String linkMan = apiReq.getString("linkMan");
		String linkTel = apiReq.getString("linkTel");
		String orderAddress = apiReq.getString("orderAddress");

		OrderInfo record = new OrderInfo();
		record.setLinkMan(linkMan);
		record.setLinkTel(linkTel);
		record.setOrderAddress(orderAddress);
		this.orderInfoMapper.insert(record);
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ApiResponse pay(ApiRequest apiReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	@ApiMethod(needLogin = true, descript = "取消订单", value = "order-cancel", apiParams = { @ApiParam(descript = "订单编号(*)", name = "orderCode") })
	public ApiResponse cancelOrder(ApiRequest apiReq) {
		String orderCode = apiReq.getString("orderCode");
		if (StringUtils.isEmpty(orderCode)) {
			return new ApiResponse(ApiMsgEnum.MISS_PARAMETER);
		}
		OrderInfo oi = this.orderInfoMapper.selectByOrderCode(orderCode);
		if (oi == null || (oi.getDeleteFlag() != null && oi.getDeleteFlag().intValue() == 1) || oi.getOrderState() == null || oi.getOrderState().intValue() != 0) {
			return new ApiResponse(ApiMsgEnum.OrderCannotCancel);
		}
		OrderInfo record = new OrderInfo();
		record.setId(oi.getId());
		record.setOrderState(8);
		record.setModifyTime(new Date());
		this.orderInfoMapper.updateByPrimaryKeySelective(record);
		return new ApiResponse(ApiMsgEnum.OrderCancelSuccess);
	}

	@SuppressWarnings("rawtypes")
	@Override
	@ApiMethod(needLogin = true, descript = "确认收货", value = "order-complete", apiParams = { @ApiParam(descript = "订单编号(*)", name = "orderCode") })
	public ApiResponse completeOrder(ApiRequest apiReq) {
		String orderCode = apiReq.getString("orderCode");
		if (StringUtils.isEmpty(orderCode)) {
			return new ApiResponse(ApiMsgEnum.MISS_PARAMETER);
		}
		OrderInfo oi = this.orderInfoMapper.selectByOrderCode(orderCode);
		if (oi == null || (oi.getDeleteFlag() != null && oi.getDeleteFlag().intValue() == 1) || oi.getOrderState() == null || oi.getOrderState().intValue() != 2) {
			return new ApiResponse(ApiMsgEnum.OrderStateException);
		}
		OrderInfo record = new OrderInfo();
		record.setId(oi.getId());
		record.setOrderState(3);
		record.setModifyTime(new Date());
		this.orderInfoMapper.updateByPrimaryKeySelective(record);
		return new ApiResponse(ApiMsgEnum.OrderCompleteSuccess);
	}

	@SuppressWarnings("rawtypes")
	@Override
	@ApiMethod(needLogin = true, descript = "订单详情", value = "order-detail", apiParams = { @ApiParam(descript = "订单编号(*)", name = "orderCode") })
	public ApiResponse orderDetail(ApiRequest apiReq) {
		String orderCode = apiReq.getString("orderCode");
		if (StringUtils.isEmpty(orderCode)) {
			return new ApiResponse(ApiMsgEnum.MISS_PARAMETER);
		}
		OrderDetailDto dto = this.orderInfoMapper.selectOrderDetailByOrderCode(orderCode);
		if (dto != null) {
			if (dto.getOrderTimestamp() != null) {
				dto.setPayDeadlineTimestamp(dto.getOrderTimestamp() + (15 * 60 * 1000));
			}
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
		return new ApiResponse<OrderDetailDto>(ApiMsgEnum.SUCCESS, null, dto);
	}

	@SuppressWarnings("rawtypes")
	@Override
	@ApiMethod(needLogin = true, descript = "查看物流", value = "order-viewLogistics", apiParams = { @ApiParam(descript = "订单编号(*)", name = "orderCode") })
	public ApiResponse viewLogistics(ApiRequest apiReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	@ApiMethod(needLogin = true, descript = "申请退货", value = "order-applyReturnGoods", apiParams = { @ApiParam(descript = "订单编号(*)", name = "orderCode"),
			@ApiParam(descript = "退货原因(*)", name = "returnReason"), @ApiParam(descript = "退货快递单号(*)", name = "returnLogisticCode") })
	public ApiResponse applyReturnGoods(ApiRequest apiReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	@ApiMethod(needLogin = true, descript = "查看退货状态", value = "order-viewReturnStatus", apiParams = { @ApiParam(descript = "退货单号(*)", name = "returnCode") })
	public ApiResponse viewReturnStatus(ApiRequest apiReq) {
		// TODO Auto-generated method stub
		return null;
	}

}
