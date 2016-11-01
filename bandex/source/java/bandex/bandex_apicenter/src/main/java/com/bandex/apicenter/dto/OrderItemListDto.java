package com.bandex.apicenter.dto;

public class OrderItemListDto {
	private Long productId;
	private String productIcon;
	private String productName;
	private String productColors;
	private String productRules;
	private Integer buyNum;
	private Double buyPrice;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductIcon() {
		return productIcon;
	}

	public void setProductIcon(String productIcon) {
		this.productIcon = productIcon;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductColors() {
		return productColors;
	}

	public void setProductColors(String productColors) {
		this.productColors = productColors;
	}

	public String getProductRules() {
		return productRules;
	}

	public void setProductRules(String productRules) {
		this.productRules = productRules;
	}

	public Integer getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

}
