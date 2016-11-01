package com.bandex.api.service.member;

import com.bandex.api.annotations.FunctionCode;
import com.bandex.api.dao.UserInfoMapper;
import com.bandex.api.dto.ApiRequest;
import com.bandex.api.dto.ApiResponse;
import com.bandex.api.enums.RestResultEnum;
import com.bandex.api.model.UserInfo;
import com.bandex.api.web.SendSMSController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sh.zj100.common.util.Md5Util;
import sh.zj100.common.util.MemcachedUtil;
import sh.zj100.common.util.RandomIDUtil;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FunctionCode(value = "member", descript = "会员相关的API")
@Service
public class MemberServiceImpl implements MemberService {


    @Value("${sms.expired.time}")
    private Integer smsExpiredTime;

    @Value("${sms.repeat.time}")
    private Long smsRepeatTime;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public ApiResponse<UserInfo> getUserInfo(ApiRequest apiRequest) {
        return null;
    }

    @Override
    public ApiResponse<UserInfo> registeUser(ApiRequest apiRequest) {
        return null;
    }

    @Override
    public ApiResponse<UserInfo> userLogin(ApiRequest apiRequest) {
        return null;
    }

    @Override
    public ApiResponse<UserInfo> checkMobileNo(ApiRequest apiRequest) {
        return null;
    }

    @FunctionCode(value = "member.sendSMS", descript = "发送短信")
    @Override
    public ApiResponse<UserInfo> sendSMS(ApiRequest apiRequest) {
        Object telphoneObj = apiRequest.get("mobileNo");
        Object sendType=apiRequest.get("sendType");//0登录 1注册
        if (StringUtils.isEmpty(telphoneObj)) {
            return new ApiResponse<UserInfo>(RestResultEnum.MissParameterException);
        }
        if(StringUtils.isEmpty(sendType)){
            return new ApiResponse<UserInfo>(RestResultEnum.MissParameterException);
        }
        ApiResponse<UserInfo> apiResponse = null;
        try {
            String telphone=telphoneObj.toString();

            if(!isMobile(telphone)){
                return new ApiResponse<UserInfo>(RestResultEnum.ErrorTelephone);
            }
            int flag=1;
            Object codeObj=MemcachedUtil.getInstance().get(telphone+"smskey");
            String code;
            if(codeObj==null){
                 code= createRandomVcode();
            }else {
                code=codeObj.toString();
            }
            String content="";
            if(Integer.parseInt(sendType.toString())==0){//登陆
                 content="验证码："+code+",用于登陆!";
            }else {//注册
                content="验证码："+code+",用于注册!";
            }
            SendSMSController.sendGet(telphone,content);

            MemcachedUtil.getInstance().set(telphone+"smskey",smsExpiredTime,code);//设置验证码过期时间
            if(flag>0){
                apiResponse = new ApiResponse<UserInfo>(RestResultEnum.SUCCESS,1,null);//正常发送
            }else{
                apiResponse = new ApiResponse<UserInfo>(RestResultEnum.FAIL);//验证码发送失败
            }
        } catch (Exception e) {
            e.printStackTrace();
            apiResponse = new ApiResponse<UserInfo>(RestResultEnum.INVOKE_ERROR);//出现异常
        }
        return apiResponse;
    }

    @Override
    public ApiResponse<UserInfo> registerSendSms(ApiRequest apiRequest) {
        return null;
    }


    /**
     * 手机号验证
     *
     * @param  str
     * @return 验证通过返回true
     */
    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[0-9]{11}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    /**
     * 随机生成6位随机验证码
     */
    public static String createRandomVcode(){
        //验证码
        StringBuffer vcode = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            vcode.append((int)(Math.random() * 9));
        }
        return vcode.toString();
    }

}
