package com.bandex.apicenter.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bandex.apicenter.service.AlipayService;

@Service
public class AlipayServiceImpl extends BaseServiceImpl implements AlipayService {

	private static final String ALGORITHM = "RSA";
	private static final String SIGN_ALGORITHMS = "SHA1WithRSA";
	private static final String DEFAULT_CHARSET = "UTF-8";

	@Value("${alipay.partner}")
	private String alipayPartner;

	@Value("${alipay.seller}")
	private String alipaySeller;

	@Value("${alipay.rsaPrivate}")
	private String alipayRsaPrivate;

	@Value("${alipay.callbackUrl}")
	private String alipayCallbackUrl;

	public String sign(String content, String privateKey) {
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
			KeyFactory keyf = KeyFactory.getInstance(ALGORITHM);
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);
			Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
			signature.initSign(priKey);
			signature.update(content.getBytes(DEFAULT_CHARSET));
			byte[] signed = signature.sign();
			return Base64.encodeBase64String(signed);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getPayString(String orderCode, Double payPrice, String subject, String body) {
		StringBuilder buf = new StringBuilder();
		buf.append("partner=").append("\"").append(alipayPartner).append("\"");
		buf.append("&seller_id=").append("\"").append(alipaySeller).append("\"");
		buf.append("&out_trade_no=").append("\"").append(orderCode).append("\"");
		buf.append("&subject=").append("\"").append(subject).append("\"");
		buf.append("&body=").append("\"").append(body).append("\"");
		buf.append("&total_fee=").append("\"").append(payPrice.toString()).append("\"");
		buf.append("&notify_url=").append("\"").append(alipayCallbackUrl + "/" + orderCode).append("\"");
		buf.append("&service=").append("\"").append("mobile.securitypay.pay").append("\"");
		buf.append("&payment_type=").append("\"").append("1").append("\"");
		buf.append("&_input_charset=").append("\"").append("utf-8").append("\"");
		buf.append("&it_b_pay=").append("\"").append("30m").append("\"");
		buf.append("&return_url=").append("\"").append("m.alipay.com").append("\"");
		String orderInfo = buf.toString();
		String sign = sign(orderInfo, alipayRsaPrivate);
		try {
			sign = URLEncoder.encode(sign, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		buf.append("&sign=").append("\"").append(sign).append("\"");
		buf.append("&sign_type=").append("\"").append("RSA").append("\"");
		return buf.toString();
	}

}
