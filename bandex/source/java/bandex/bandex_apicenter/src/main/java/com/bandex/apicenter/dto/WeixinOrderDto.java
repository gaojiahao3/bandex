package com.bandex.apicenter.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class WeixinOrderDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7230335650666477346L;

	// 微信分配的公众号ID（开通公众号之后可以获取到）
	private String appid;

	// 微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
	private String mch_id;

	// 随机字符串，不长于32 位
	private String nonce_str;

	// 签名
	private String sign;

	// 要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
	private String body;

	// 商户系统内部的订单号(唯一)
	private String out_trade_no;

	// 订单总金额，单位为“分”，只能整数
	private Integer total_fee;

	// 订单生成的机器IP
	private String spbill_create_ip;

	// 回调地址
	private String notify_url;

	// 交易类型
	private String trade_type;

	// trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
	private String product_id;

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

}
