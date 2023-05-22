package com.xhl.getprimarykey;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.dyvmsapi20170525.models.SingleCallByTtsRequest;
import com.aliyun.dyvmsapi20170525.models.SingleCallByTtsResponse;
import com.aliyun.dyvmsapi20170525.models.SingleCallByVoiceRequest;
import com.aliyun.tea.*;
import com.aliyun.teaopenapi.models.Config;
import netscape.javascript.JSObject;

public class Sample {

    /**
     * 使用AK&SK初始化账号Client
     *
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dyvmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dyvmsapi.aliyuncs.com";
        return new com.aliyun.dyvmsapi20170525.Client(config);
    }

    public static void main(String[] args_) throws Exception {
//        java.util.List<String> args = java.util.Arrays.asList(args_);
        com.aliyun.dyvmsapi20170525.Client client = Sample.createClient("LTAI5tMtTRBqjFoFnKR2QvJN", "GM1CoPNiyJg4Y0gI1NYzfuCbHPKy3V");
//        SingleCallByVoiceRequest singleCallByVoiceRequest = new SingleCallByVoiceRequest()
//                .setCalledShowNumber("0571000010989")
//                .setCalledNumber("15210905264")
//                .setVoiceCode("e271f3f2-e155-4366-a9f4-0fe55765****.wav");
//        // 复制代码运行请自行打印 API 的返回值
//        client.singleCallByVoice(singleCallByVoiceRequest);

        String tsParam = "{\"servername\":\"crm-transfer\",\"time\":\"2023年5月18号17点10分\"}";
        SingleCallByTtsRequest singleCallByTtsRequest = new SingleCallByTtsRequest()
//                .setCalledShowNumber("0571000010989")
                .setCalledNumber("15210905264")
                .setTtsCode("TTS_278365015")
                .setTtsParam(tsParam);
        SingleCallByTtsResponse singleCallByTtsResponse = client.singleCallByTts(singleCallByTtsRequest);
        System.out.println("-------" + JSONObject.toJSONString(singleCallByTtsResponse));

//        SingleCallByTtsRequest singleCallByTtsRequest1 = new SingleCallByTtsRequest()
////                .setCalledShowNumber("0571000010989")
//                .setCalledNumber("13521409066")
//                .setTtsCode("TTS_278365015")
//                .setTtsParam(tsParam);
//        SingleCallByTtsResponse singleCallByTtsResponse1 = client.singleCallByTts(singleCallByTtsRequest1);
//        System.out.println("-------" + JSONObject.toJSONString(singleCallByTtsResponse1));
    }

}
