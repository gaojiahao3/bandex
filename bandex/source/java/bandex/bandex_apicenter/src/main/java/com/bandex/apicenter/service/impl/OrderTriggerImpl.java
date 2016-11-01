package com.bandex.apicenter.service.impl;

import org.springframework.stereotype.Service;

import com.bandex.apicenter.service.OrderTrigger;

@Service
public class OrderTriggerImpl extends BaseServiceImpl implements OrderTrigger {

	@Override
	public void afterCreateOrder(Integer orderId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterSendOrder(Integer orderId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterLockOrder(Integer orderId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterSendGoods(Integer orderId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterDeliveryGoods(Integer orderId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompleteOrder(Integer orderId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCancelOrder(Integer orderId) {
		// TODO Auto-generated method stub

	}

}
