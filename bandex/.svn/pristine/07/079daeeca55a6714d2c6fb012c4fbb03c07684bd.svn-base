package com.bandex.api.service.inner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sh.zj100.common.util.HttpClientUtil;
import sh.zj100.common.util.SimpleTokenUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2015/2/13.
 */
@Service
public class CommonRequest {
    @Value("${bg.api.id}")
    private String apiId;

    @Value("${bg.api.secert}")
    private String apiSecert;

    /**
     * 公共调用其他的服务的方法
     * @param paramMap
     * @param apiServer
     * @return
     */
    public String doApiRequest(Map<String, Object> paramMap,String apiServer) {
        Map<String, Object> paramMap1=new HashMap<String, Object>();
        paramMap1.put("apiId",apiId);
        paramMap1.put("functioncode",paramMap.get("functioncode"));
        String token = SimpleTokenUtil.buildToken(paramMap1, apiSecert);
        paramMap1.putAll(paramMap);
        paramMap1.put("token", token);
        String retJson = HttpClientUtil.doHttpPost(apiServer + "/apicenter", paramMap1);
        return retJson;
    }
}
