package com.bandex.api.web;

import org.springframework.web.util.WebUtils;
import sh.zj100.common.util.JsonUtil;
import sh.zj100.common.util.RandomValidateCodeUtil;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * controller的基类
 * 
 * @author Jason
 */
public abstract class BaseController {
	protected static final String MSG = "msg";
	protected static final String IS_SUCCESS = "isSuccess";
	protected static final String VALIDATE_CODE = "validateCode";

	/**
	 * 获取当前操作人ID
	 * 
	 * @return
	 * @author daniel
	 */
	protected String getCurrentUserId(HttpServletRequest request) {
		return null;
	}


	/**
	 * 获取当前操作人IP
	 * 
	 * @param request
	 * @return
	 * @author daniel
	 */
	protected String getRequestIp(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

	/**
	 * 输出JSON
	 * 
	 * @param json
	 * @param response
	 * @return
	 * @author daniel
	 */
	protected String outputJson(String json, HttpServletResponse response) {
		return this.output(json, response, "text/html;charset=UTF-8");
	}

	protected String outputText(String text, HttpServletResponse response) {
		return this.output(text, response, "text/html;charset=UTF-8");
	}

	protected String outputXml(String xml, HttpServletResponse response) {
		return this.output(xml, response, "text/xml;charset=UTF-8");
	}

	protected String output(String str, HttpServletResponse response, String contentType) {
		response.reset();
		response.setContentType(contentType);
		try {
			PrintWriter out = response.getWriter();
			out.print(str);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 输出消息
	 * 
	 * @param isSuccess
	 * @param msg
	 * @param response
	 * @return
	 * @author daniel
	 */
	protected String outputMsg(boolean isSuccess, String msg, HttpServletResponse response) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put(IS_SUCCESS, isSuccess);
		retMap.put(MSG, msg);
		String json = JsonUtil.objectToJson(retMap);
		return this.outputJson(json, response);
	}

	/**
	 * 适用于jsonp方式调用返回
	 * 
	 * @param jsonpcallback
	 * @param isSuccess
	 * @param msg
	 * @param response
	 * @author daniel
	 */
	protected String outputForJsonp(String jsonpcallback, boolean isSuccess, String msg, HttpServletResponse response) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put(IS_SUCCESS, isSuccess);
		retMap.put(MSG, msg);
		String json = JsonUtil.objectToJson(retMap);
		return this.outputJson(jsonpcallback + "(" + json + ")", response);
	}
	
	/**
	 * 生成图片验证码
	 * @param request
	 * @param response
	 * @param width 图片宽度
	 * @param height 图片高度
	 * @param lineSize 干扰线数量
	 * @param stringNum 字符数量
	 * @author Daniel
	 */
	protected void generateValidateCode(HttpServletRequest request, HttpServletResponse response,int width, int height, int lineSize, int stringNum){
		response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
		response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);

		// BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
		RandomValidateCodeUtil validateCodeUtil=new RandomValidateCodeUtil(width,height,lineSize,stringNum);
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();// 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
		g.setColor(validateCodeUtil.getRandColor(110, 133));
		// 绘制干扰线
		for (int i = 1; i <= lineSize; i++) {
			validateCodeUtil.drowLine(g);
		}
		// 绘制随机字符
		String randomString = "";
		for (int i = 1; i <= stringNum; i++) {
			randomString = validateCodeUtil.drowString(g, randomString, i);
		}
		WebUtils.setSessionAttribute(request, VALIDATE_CODE, randomString);
		g.dispose();
		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());// 将内存中的图片通过流动形式输出到客户端
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
