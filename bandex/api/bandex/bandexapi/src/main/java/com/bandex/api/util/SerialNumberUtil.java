package com.bandex.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 工具类 - 编号生成
 */
public class SerialNumberUtil {
    public static final String ORDER_PREFIX = "DD";
    public static final String LOGISTIC_PREFIX = "WL";
    public static final String PRINT_PREFIX = "DY";
    public static final String RETURN_PREFIX = "TH";
    public static final String PRODUCT_PREFIX = "PR";
    private static long orderCode;
    private static long logisticCode;
    private static long printCode;

    public static void main(String[] args) {
        System.out.println(SerialNumberUtil.nextOrderCode());
        System.out.println(SerialNumberUtil.nextLogisticCode());
        System.out.println(SerialNumberUtil.nextPrintCode());
        System.out.println(SerialNumberUtil.nextReturnOrderCode());
    }

    public static synchronized String nextOrderCode() {
        int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
        int r2=(int)(Math.random()*(10));
        long now = System.currentTimeMillis();//一个13位的时间戳
        String str1 = String.valueOf(now);
        String str2 = str1.substring(str1.length()-8,str1.length());
        String paymentID =String.valueOf(r1)+String.valueOf(str2)+String.valueOf(r2);
        return ORDER_PREFIX +paymentID;
    }
    public static synchronized String nextLogisticCode() {
        int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
        int r2=(int)(Math.random()*(10));
        long now = System.currentTimeMillis();//一个13位的时间戳
        String str1 = String.valueOf(now);
        String str2 = str1.substring(str1.length()-8,str1.length());
        String paymentID =String.valueOf(r1)+String.valueOf(str2)+String.valueOf(r2);// 订单ID
        return LOGISTIC_PREFIX +paymentID;
    }
    public static synchronized String nextPrintCode() {
        int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
        int r2=(int)(Math.random()*(10));
        long now = System.currentTimeMillis();//一个13位的时间戳
        String str1 = String.valueOf(now);
        String str2 = str1.substring(str1.length()-8,str1.length());
        String paymentID =String.valueOf(r1)+String.valueOf(str2)+String.valueOf(r2);
        return PRINT_PREFIX +paymentID;
    }
    public static synchronized String nextReturnOrderCode() {
        int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
        int r2=(int)(Math.random()*(10));
        long now = System.currentTimeMillis();//一个13位的时间戳
        String str1 = String.valueOf(now);
        String str2 = str1.substring(str1.length()-8,str1.length());
        String paymentID =String.valueOf(r1)+String.valueOf(str2)+String.valueOf(r2);
        return RETURN_PREFIX +paymentID;
    }
    public static synchronized String nextProductCode() {
        int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
        int r2=(int)(Math.random()*(10));
        long now = System.currentTimeMillis();//一个13位的时间戳
        String str1 = String.valueOf(now);
        String str2 = str1.substring(str1.length()-8,str1.length());
        String paymentID =String.valueOf(r1)+String.valueOf(str2)+String.valueOf(r2);
        return PRODUCT_PREFIX +paymentID;
    }
    public static synchronized String nextLogisticBatchId() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMddhh");
        String dateStr = sdf.format(new Date());
        System.out.println(dateStr);
        return dateStr;
    }
    public static synchronized String nextExCarReportBatchId() {
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyyMMddHHmmss");
        String assignBatchId=dateformat.format(new Date());
        return assignBatchId;
    }
    public static synchronized String nextWIDbatchNo() {
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyyMMddmmssddd");
        String wIDbatchNo=dateformat.format(new Date());
        return wIDbatchNo;
    }
}