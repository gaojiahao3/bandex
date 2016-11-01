package com.bandex.apicenter.dto;

public class OrderDetailDto extends OrderListDto {
	private Long orderTimestamp;
	private Long payDeadlineTimestamp;
	private String linkMan;
	private String linkTel;
	private String orderAddress;

	public Long getOrderTimestamp() {
		return orderTimestamp;
	}

	public void setOrderTimestamp(Long orderTimestamp) {
		this.orderTimestamp = orderTimestamp;
	}

	public Long getPayDeadlineTimestamp() {
		return payDeadlineTimestamp;
	}

	public void setPayDeadlineTimestamp(Long payDeadlineTimestamp) {
		this.payDeadlineTimestamp = payDeadlineTimestamp;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getLinkTel() {
		return linkTel;
	}

	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

}
