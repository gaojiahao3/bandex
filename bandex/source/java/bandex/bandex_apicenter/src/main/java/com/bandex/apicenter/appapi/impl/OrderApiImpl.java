package com.bandex.apicenter.appapi.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.StringUtils;

import com.bandex.apicenter.dao.CommonProductMapper;
import com.bandex.apicenter.dao.OrderInfoMapper;
import com.bandex.apicenter.dao.OrderItemMapper;
import com.bandex.apicenter.dto.OrderConfirmDto;
import com.bandex.apicenter.dto.OrderConfirmResponseDto;
import com.bandex.apicenter.dto.OrderDetailDto;
import com.bandex.apicenter.dto.OrderItemListDto;
import com.bandex.apicenter.dto.PayTypeDto;
import com.bandex.apicenter.model.CommonProduct;
import com.bandex.apicenter.model.OrderInfo;
import com.bandex.apicenter.model.OrderItem;
import com.bandex.apicenter.service.AlipayService;
import com.bandex.apicenter.service.IntegralService;
import com.bandex.apicenter.service.WeixinService;
import com.bandex.apicenter.service.impl.BaseServiceImpl;
import com.bandex.apicenter.util.SerialNumberUtil;
import com.bandex.base.annotations.ApiMethod;
import com.bandex.base.annotations.ApiParam;
import com.bandex.base.annotations.ApiService;
import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;
import com.bandex.base.enums.ApiMsgEnum;
import com.bandex.base.enums.UserActionTypeEnum;

@Service
@ApiService(descript = "订单相关API")
public class OrderApiImpl extends BaseServiceImpl implements com.bandex.apicenter.appapi.OrderApi {
	private static final Logger loger = Logger.getLogger(OrderApiImpl.class);

	@Autowired
	private OrderInfoMapper orderInfoMapper;

	@Autowired
	private OrderItemMapper orderItemMapper;

	@Autowired
	private CommonProductMapper commonProductMapper;

	@Autowired
	private WeixinService weixinService;

	@Autowired
	private AlipayService alipayService;

	@Autowired
	private IntegralService integralService;

	@Resource
	private PlatformTransactionManager platformTransactionManager;

	@SuppressWarnings("rawtypes")
	@Override
	@ApiMethod(needLogin = true, descript = "生成订单", value = "order-create", apiParams = { @ApiParam(descript = "商品ID串(*)", name = "productIds"), @ApiParam(descript = "购买数量串(*)", name = "buyNums"),
			@ApiParam(descript = "商品颜色串(*)", name = "productColors"), @ApiParam(descript = "商品样式串(*)", name = "productRules") })
	public ApiResponse createOrder(ApiRequest apiReq) {
		Long[] productIdArr = apiReq.getLongArray("productIds");
		Integer[] buyNumArr = apiReq.getIntArray("buyNums");
		String[] productColorArr = apiReq.getStringArray("productColors");
		String[] productRuleArr = apiReq.getStringArray("productRules");
		if (productIdArr == null || productIdArr.length == 0 || buyNumArr == null || buyNumArr.length == 0 || productColorArr == null || productColorArr.length == 0 || productRuleArr == null
				|| productRuleArr.length == 0) {
			return new ApiResponse(ApiMsgEnum.MISS_PARAMETER);
		}
		if (productIdArr.length != buyNumArr.length || productIdArr.length != productColorArr.length || productIdArr.length != productRuleArr.length) {
			return new ApiResponse(ApiMsgEnum.BAD_REQUEST);
		}
		if (apiReq.getCurrentUserId() == null) {
			return new ApiResponse(ApiMsgEnum.UserUnloginException);
		}
		Map<Long, CommonProduct> productMap = new LinkedHashMap<Long, CommonProduct>();
		for (Long productId : productIdArr) {
			CommonProduct productRecord = commonProductMapper.selectByPrimaryKey(productId);
			if (productRecord == null || productRecord.getDeleteFlag() == null || productRecord.getDeleteFlag() != 0 || productRecord.getProudctState() == null
					|| productRecord.getProudctState() != 1) {
				return new ApiResponse(ApiMsgEnum.ProductStateException);
			}
			productMap.put(productId, productRecord);
		}
		int i = 0;
		double totalPrice = 0;
		for (Map.Entry<Long, CommonProduct> entry : productMap.entrySet()) {
			CommonProduct productRecord = entry.getValue();
			totalPrice += productRecord.getProductPrice() * buyNumArr[i];
			i++;
		}
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			String orderCode = SerialNumberUtil.nextOrderCode();
			OrderInfo record = new OrderInfo();
			record.setOrderCode(orderCode);
			record.setTotalPrice(totalPrice);
			record.setDiscountPrice(0D);
			record.setFreightPrice(0D);
			record.setFinalPrice(totalPrice);
			record.setOrderType(0);
			record.setOrderState(0);
			record.setOrderTime(new Date());
			record.setUserId(apiReq.getCurrentUserId());
			record.setNickName(apiReq.getCurrentUserDisplayName());
			record.setModifyTime(new Date());
			record.setDeleteFlag(0);
			this.orderInfoMapper.insert(record);
			Long orderId = record.getId();
			int x = 0;
			List<OrderItemListDto> itemList = new ArrayList<OrderItemListDto>();
			for (Map.Entry<Long, CommonProduct> entry : productMap.entrySet()) {
				Long productId = entry.getKey();
				CommonProduct productRecord = entry.getValue();
				OrderItem itemRecord = new OrderItem();
				itemRecord.setOrderId(orderId);
				itemRecord.setOrderCode(orderCode);
				itemRecord.setProductId(productId);
				itemRecord.setProductCode(productRecord.getProductCode());
				itemRecord.setProductName(productRecord.getProductName());
				itemRecord.setProductIcon(productRecord.getProductIcon());
				itemRecord.setProductColors(productColorArr[x]);
				itemRecord.setProductRules(productRuleArr[x]);
				itemRecord.setProductPrice(productRecord.getProductPrice());
				itemRecord.setBuyPrice(productRecord.getProductPrice() * buyNumArr[x]);
				itemRecord.setProductNeedIntegral(productRecord.getProductNeedIntegral());
				itemRecord.setBuyNum(buyNumArr[x]);
				itemRecord.setProductState(productRecord.getProudctState());
				itemRecord.setModifyTime(new Date());
				this.orderItemMapper.insert(itemRecord);

				OrderItemListDto itemDto = new OrderItemListDto();
				itemDto.setProductId(productId);
				itemDto.setProductName(itemRecord.getProductName());
				itemDto.setProductIcon(this.getCdnUrl(null, productRecord.getProductIcon(), null));
				itemDto.setProductColors(itemRecord.getProductColors());
				itemDto.setProductRules(itemRecord.getProductRules());
				itemDto.setBuyNum(itemRecord.getBuyNum());
				itemDto.setBuyPrice(itemRecord.getBuyPrice());
				itemList.add(itemDto);
				x++;
			}
			platformTransactionManager.commit(transactionStatus);
			// TODO 将此订单加入定时取消任务，过10分钟或者15分钟不支付自动取消
			// TODO 下单扣库存，还是支付成功扣库存
			OrderConfirmResponseDto retDto = new OrderConfirmResponseDto();
			OrderConfirmDto order = new OrderConfirmDto();
			order.setOrderCode(orderCode);
			order.setTotalPrice(totalPrice);
			// TODO 默认返回上一个订单地址？
			// order.setLinkMan(linkMan);
			// order.setLinkTel(linkTel);
			// order.setOrderAddress(orderAddress);
			retDto.setOrder(order);
			retDto.setItemList(itemList);
			retDto.setPayTypeList(this._getPayTypeList());
			return new ApiResponse<OrderConfirmResponseDto>(ApiMsgEnum.OrderCreateSuccess, 1, retDto);
		} catch (RuntimeException e) {
			loger.error(e);
			platformTransactionManager.rollback(transactionStatus);
			return new ApiResponse(ApiMsgEnum.BAD_REQUEST);
		}
	}

	private List<PayTypeDto> _getPayTypeList() {
		List<PayTypeDto> payTypeList = new ArrayList<PayTypeDto>();
		payTypeList.add(new PayTypeDto(0, "微信支付", this.getCdnUrl(null, "static/icon/weixinpay.png", null)));
		payTypeList.add(new PayTypeDto(1, "支付宝", this.getCdnUrl(null, "static/icon/alipay.png", null)));
		payTypeList.add(new PayTypeDto(2, "积分支付", this.getCdnUrl(null, "static/icon/pointspay.png", null)));
		return payTypeList;
	}

	@Override
	@SuppressWarnings("rawtypes")
	@ApiMethod(needLogin = true, descript = "确认订单", value = "order-confirm", apiParams = { @ApiParam(descript = "订单编号(*)", name = "orderCode"), @ApiParam(descript = "收货人(*)", name = "linkMan"),
			@ApiParam(descript = "收货电话(*)", name = "linkTel"), @ApiParam(descript = "收货地址(*)", name = "orderAddress"), @ApiParam(descript = "支付渠道ID(*)", name = "payTypeId") })
	public ApiResponse confirmOrder(ApiRequest apiReq) {
		String orderCode = apiReq.getString("orderCode");
		String linkMan = apiReq.getString("linkMan");
		String linkTel = apiReq.getString("linkTel");
		String orderAddress = apiReq.getString("orderAddress");
		Integer payTypeId = apiReq.getInt("payTypeId");
		if (StringUtils.isEmpty(orderCode) || StringUtils.isEmpty(linkMan) || StringUtils.isEmpty(linkTel) || StringUtils.isEmpty(orderAddress) || StringUtils.isEmpty(payTypeId)) {
			return new ApiResponse(ApiMsgEnum.MISS_PARAMETER);
		}
		if (!(payTypeId == 0 || payTypeId == 1 || payTypeId == 2)) {
			return new ApiResponse(ApiMsgEnum.BAD_REQUEST);
		}
		OrderInfo oi = this.orderInfoMapper.selectByOrderCode(orderCode);
		if (oi == null || (oi.getDeleteFlag() != null && oi.getDeleteFlag().intValue() == 1) || oi.getOrderState() == null || oi.getOrderState().intValue() != 0) {
			return new ApiResponse(ApiMsgEnum.OrderStateException);
		}
		if (apiReq.getCurrentUserId() == null || apiReq.getCurrentUserId().longValue() != oi.getUserId().longValue()) {
			return new ApiResponse(ApiMsgEnum.BAD_REQUEST);
		}
		OrderInfo record = new OrderInfo();
		record.setId(oi.getId());
		record.setLinkMan(linkMan);
		record.setLinkTel(linkTel);
		record.setOrderAddress(orderAddress);
		record.setPayType(payTypeId);
		this.orderInfoMapper.updateByPrimaryKeySelective(record);
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("payTypeId", payTypeId);
		if (payTypeId == 0) {
			// 微信支付
			String payString = weixinService.getPayString(orderCode, oi.getFinalPrice(), null, apiReq.getRequestIp());
			retMap.put("payString", payString);
			return new ApiResponse<Map<String, Object>>(ApiMsgEnum.SUCCESS, 1, retMap);
		} else if (payTypeId == 1) {
			// 支付宝
			String payString = alipayService.getPayString(orderCode, oi.getFinalPrice(), null, null);
			retMap.put("payString", payString);
			return new ApiResponse<Map<String, Object>>(ApiMsgEnum.SUCCESS, 1, retMap);
		} else {
			// 积分支付
			ApiMsgEnum msgEnum = integralService.reduceIntegral(UserActionTypeEnum.payOrder, oi.getId(), oi.getFinalPrice().intValue());
			return new ApiResponse<Map<String, Object>>(msgEnum, 1, retMap);
		}
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
		if (apiReq.getCurrentUserId() == null || apiReq.getCurrentUserId().longValue() != oi.getUserId().longValue()) {
			return new ApiResponse(ApiMsgEnum.BAD_REQUEST);
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
		if (apiReq.getCurrentUserId() == null || apiReq.getCurrentUserId().longValue() != oi.getUserId().longValue()) {
			return new ApiResponse(ApiMsgEnum.BAD_REQUEST);
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
