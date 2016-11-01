package com.bandex.api.web;

import sh.zj100.common.util.HttpClientUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件名称：sendSMS_demo.java
 *
 * 文件作用：美联软通 http接口使用实例
 *
 * 创建时间：2012-05-18
 *
 *
 返回值											说明
 success:msgid								提交成功，发送状态请见4.1
 error:msgid									提交失败
 error:Missing username						用户名为空
 error:Missing password						密码为空
 error:Missing apikey						APIKEY为空
 error:Missing recipient						手机号码为空
 error:Missing message content				短信内容为空
 error:Account is blocked					帐号被禁用
 error:Unrecognized encoding					编码未能识别
 error:APIKEY or password error				APIKEY 或密码错误
 error:Unauthorized IP address				未授权 IP 地址
 error:Account balance is insufficient		余额不足
 error:Black keywords is:党中央				屏蔽词
 */
public class SendSMSController {

//    @Value("${sms.url}")
//    private String smsUrl;
//    @Value(("${sms.account}"))
//    private String smsAccount;
//    @Value(("${sms.password}"))
//    private String smsPassword;

    public static Boolean sendSMS(String userPhone,String content) throws IOException {
        // 创建StringBuffer对象用来操作字符串
        StringBuffer sb = new StringBuffer("http://m.5c.com.cn/api/send/?");
        sb.append("apikey=1ceda109b70c9d2f715681ce55299004&username=yipeitong&password=asdf1234");
        // 向StringBuffer追加手机号码
        sb.append("&mobile=");
        sb.append(userPhone);
        sb.append("&content=" + URLEncoder.encode(content, "GBK"));
        System.out.println(sb);
        URL url = new URL(sb.toString());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputline = in.readLine();
        System.out.println(inputline);
        int flag =validateReturn(inputline);
        if(flag>0){
            return true;
        }
        return false;
    }




    /**
     * 验证返回值
     */
    public static int validateReturn(String inputline ){
        int flag=0;
       if(inputline.contains("success")){
           flag=1;
       }
        return flag;
    }
    /**
     * 梦网科技
     * @param args
     * @throws java.io.UnsupportedEncodingException
     */
    public  static void main(String[] args) throws UnsupportedEncodingException {
//
        String result=  sendGet("13072159392", "老板，狂欢购物周开始啦，活动商品积分双倍送！！壳牌红喜力296元/箱，海量优惠任你拿！买汽配认准易配通，专业让您更放心。");
        System.out.println(result);
//        MongateCsGetStatusReportExEx();
    }

    /**
     * 发送手机短信
     * @param mobile
     * @param content
     * @return
     */
    public static String sendGet(String mobile, String content) {
        String urlStr="http://61.145.229.29:8892/MWGate/wmgw.asmx/MongateCsSpSendSmsNew";
        String account="JH0872";
        String password="325687";
        String mobiles[]=mobile.split(",");//手机号码个数
        Map<String,Object> param=new HashMap<String, Object>();
        param.put("userId",account);
        param.put("password",password);
        param.put("pszMobis",mobile.substring(0,mobile.length()-1));
        param.put("pszMsg",content);
        param.put("iMobiCount",mobiles.length);
        param.put("pszSubPort","*");
        String result=HttpClientUtil.doHttpPost(urlStr,param);
        System.out.println("----------------------发送短信返回结果"+result);
        return result;
    }

    public static String MongateCsGetStatusReportExEx(){
        String urlStr="http://61.145.229.29:8892/MWGate/wmgw.asmx/MongateQueryBalance";
        String account="JH0872";
        String password="325687";
        Map<String,Object> param=new HashMap<String, Object>();
        param.put("userId",account);
        param.put("password",password);
        String result=HttpClientUtil.doHttpPost(urlStr,param);
        System.out.println(result);
       return result;
    }

}
