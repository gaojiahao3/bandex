package com.bandex.api.service.inner;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by user on 2015/2/2.
 * @author  Jason.yan
 */
@Service
public class CommonService  implements Serializable {

    private static final long serialVersionUID = -3030551267639253952L;

//    public void updateLogisticOrderState(String batchId,Long supplierId,Integer state){
//        //修改物流单状态，记录物流历史
//        Map<String, Object> paramMap1=new HashMap<String, Object>();
//        paramMap1.put("functioncode","logistic.updateLogisticOrderState");
//        paramMap1.put("supplierId",supplierId);
//        paramMap1.put("batchId",batchId);
//        paramMap1.put("state",state);
//        paramMap1.put("apiInvoking",18);
//        String returnJson=commonRequest.doApiRequest(paramMap1,garageServerUrl);
//    }



    public static void main(String args[]) throws Exception {
//        String orderStr="{\"userId\":100,\"totalPrice\":800,\"orderAddress\":\"漕河泾开发区虹漕路456号\",\"linkman\":\"严志雄\",\"linkTel\":\"15001847608\",\"record\":[{\"id\":\"8\",\"proId\":\"2\",\"proName\":\"宝马X5保险杠\",\"productPic\":\"/20150101/default/xxxx.jpg\",\"proPrice\":\"500\",\"proNum\":\"2\",\"emerLever\":\"1\",\"emerName\":\"加急\",\"emerPrice\":\"50\",\"orderPrice\":\"1000\",\"freight\":\"50\"},{\"id\":\"9\",\"proId\":\"3\",\"proName\":\"奥迪TT保险杠\",\"productPic\":\"/20150101/default/yyyy.jpg\",\"proPrice\":\"400\",\"proNum\":\"1\",\"emerLever\":\"1\",\"emerName\":\"加急\",\"emerPrice\":\"50\",\"orderPrice\":\"400\",\"freight\":\"50\"}]}";
//        System.out.println(orderStr);
//        new CommonService().analyzeJson(orderStr);
//        HashMap<String, Object> paramMap1=new HashMap<String, Object>();
//        paramMap1.put("warehouseId",1);
//        new CommonService().mailToPerson(paramMap1);
    }
}
