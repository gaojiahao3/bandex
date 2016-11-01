package com.bandex.apicenter.dto;

import java.util.List;

public class OrderListDto {
	private String orderCode;

	private Integer orderState;

	private Double totalPrice;

	private Integer totalCount;

	private List<OrderItemListDto> itemList;

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<OrderItemListDto> getItemList() {
		return itemList;
	}

	public void setItemList(List<OrderItemListDto> itemList) {
		this.itemList = itemList;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
