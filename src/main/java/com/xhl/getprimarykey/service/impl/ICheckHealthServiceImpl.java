package com.xhl.getprimarykey.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.dyvmsapi20170525.models.SingleCallByTtsRequest;
import com.aliyun.dyvmsapi20170525.models.SingleCallByTtsResponse;
import com.aliyun.teaopenapi.models.Config;
import com.xhl.getprimarykey.conf.RedisUtil;
import com.xhl.getprimarykey.feign.*;
import com.xhl.getprimarykey.service.ICheckHealthService;
import lombok.extern.java.Log;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@Log
public class ICheckHealthServiceImpl implements ICheckHealthService {

    @Value("void.accessKeyId")
    private  String voidAccessKeyId;
    @Value("void.accessKeySecret")
    private String voidAccessKeySecret;

    @Autowired
    AppPushFeignService appPushFeignService;
    @Autowired
    ChatGPTFeignService chatGPTFeignService;
    @Autowired
    CloudShareFeignService cloudShareFeignService;
    @Autowired
    CrawlerFeignService crawlerFeignService;
    @Autowired
    CRMFeignService crmFeignService;
    @Autowired
    CRMSeasFeignService crmSeasFeignService;
    @Autowired
    CRMTransferFeignService crmTransferFeignService;
    @Autowired
    CRMXXLJobFeignService crmxxlJobFeignService;
    @Autowired
    CussLoginFeignService cussLoginFeignService;
    @Autowired
    DashboardFeignService dashboardFeignService;
    @Autowired
    DelayqueneFeignService delayqueneFeignService;
    @Autowired
    DelayQueneCNFeignService delayQueneCNFeignService;
    @Autowired
    EDMWebFeignService edmWebFeignService;
    @Autowired
    Es2FeignService es2FeignService;
    @Autowired
    EsFeignService esFeignService;
    @Autowired
    FacebookFeignService facebookFeignService;
    @Autowired
    FileSysFeignService fileSysFeignService;
    @Autowired
    FormCustFeignService formCustFeignService;
    @Autowired
    InstagramFeignService instagramFeignService;
    @Autowired
    MailEDMFeignService mailEDMFeignService;
    @Autowired
    MailFeignService mailFeignService;
    @Autowired
    MailHKFeignService mailHKFeignService;
    @Autowired
    MailProcessDataFeignService mailProcessDataFeignService;
    @Autowired
    MailXXLJOBFeignService mailXXLJOBFeignService;
    @Autowired
    MarketingSiteFeignService marketingSiteFeignService;
    @Autowired
    MinorFeignService minorFeignService;
    @Autowired
    NewPrivilegeFeignService newPrivilegeFeignService;
    @Autowired
    OpenAPIFeignService openAPIFeignService;
    @Autowired
    OverSeaFeignService overSeaFeignService;
    @Autowired
    OverSeaXXLJobFeignService overSeaXXLJobFeignService;
    @Autowired
    PGatewayFeignService pGatewayFeignService;
    @Autowired
    PiwikFeignService piwikFeignService;
    @Autowired
    PiwikReadFeignService piwikReadFeignService;
    @Autowired
    ReceiveMailFeignService receiveMailFeignService;
    @Autowired
    ReportFeignService reportFeignService;
    @Autowired
    RuleFeignService ruleFeignService;
    @Autowired
    SendMailFeignService sendMailFeignService;
    @Autowired
    SocialFeignService socialFeignService;
    @Autowired
    TimeLineFeignService timeLineFeignService;
    @Autowired
    TranslationFeignService translationFeignService;
    @Autowired
    VisitorChatFeignService visitorChatFeignService;
    @Autowired
    WhatsAppFeignService whatsAppFeignService;
    @Autowired
    WhatsAppMinorBranchFeignService whatsAppMinorBranchFeignService;
    @Autowired
    WhatsAppWeb4jFeignService whatsAppWeb4jFeignService;
    @Autowired
    XddPluginFeignService xddPluginFeignService;
    @Autowired
    RedisUtil redisUtil;

    @Override
    public void checkAllService() {
        try {
            StringBuffer serName = new StringBuffer();
            log.info("服务检查开始");
            String result = appPushFeignService.checkAppPushHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("appPush服务异常");
                serName.append("apppush， ");
            }

            result = chatGPTFeignService.checkChatGPTHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("chatGPT服务异常");
                serName.append("chatGPT， ");
            }
            result = cloudShareFeignService.checkCloudShareHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("cloudShare服务异常");
                serName.append("cloudShare， ");
            }
            result = crawlerFeignService.checkCrawlerHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("crawler服务异常");
                serName.append("crawler， ");
            }
            result = crmFeignService.checkCRMHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("crm服务异常");
                serName.append("crm， ");
            }
            result = crmSeasFeignService.checkCrmSeasHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("crmSeas服务异常");
                serName.append("crm公海， ");
            }
            result = crmTransferFeignService.checkCrmTransferHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("crmTransfer服务异常");
                serName.append("crmTransfer， ");
            }
            result = crmxxlJobFeignService.checkCRMXXLjobHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("crmxxlJob服务异常");
                serName.append("crm定时任务， ");
            }
            result = cussLoginFeignService.checkCussLoginHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("cussLogin服务异常");
                serName.append("cussLogin， ");
            }
            result = dashboardFeignService.checkDashboardHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("dashboard服务异常");
                serName.append("仪表盘， ");
            }
            result = delayqueneFeignService.checkDelayQueneHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("delayquene服务异常");
                serName.append("delayquene， ");
            }
            result = delayQueneCNFeignService.checkDelayQueneCNHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("delayQueneCN服务异常");
                serName.append("delayqueneCN， ");
            }
            result = edmWebFeignService.checkEdmWebHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("edmWeb服务异常");
                serName.append("edmWeb， ");
            }
            result = es2FeignService.checkES2Health();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("es2Feign服务异常");
                serName.append("es2， ");
            }
            result = esFeignService.checkESHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("esFeign服务异常");
                serName.append("es， ");
            }
            result = facebookFeignService.checkFaceBookHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("facebook服务异常");
                serName.append("facebook， ");
            }
            result = fileSysFeignService.checkFileSysHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("fileSys服务异常");
                serName.append("fileSys， ");
            }
            result = formCustFeignService.checkFormCustHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("formCust服务异常");
                serName.append("formCust， ");
            }
            result = instagramFeignService.checkInstagramHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("instagram服务异常");
                serName.append("instagram， ");
            }
            result = mailEDMFeignService.checkMailEDMHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("mailEDM服务异常");
                serName.append("mailEDM， ");
            }
            result = mailFeignService.checkMailHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("mail服务异常");
                serName.append("mail， ");
            }
            result = mailHKFeignService.checkMailHKHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("mailHK服务异常");
                serName.append("mailHK， ");
            }
            result = mailProcessDataFeignService.checkMailProcessHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("mailProcessData服务异常");
                serName.append("mailProcessData， ");
            }
            result = mailXXLJOBFeignService.checkMailXXLJOBHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("mailXXLJOB服务异常");

                serName.append("mailXXLJOB， ");
            }
            result = marketingSiteFeignService.checkMarketingSiteHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("marketingSite服务异常");
                serName.append("marketingSite， ");
            }
            result = minorFeignService.checkMinorHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("minor服务异常");
                serName.append("minor， ");
            }
            result = newPrivilegeFeignService.checkNewPrivilegeHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("newPrivilege服务异常");
                serName.append("newPrivilege， ");
            }
            result = openAPIFeignService.checkOpenAPIHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("openAPI服务异常");
                serName.append("openAPI， ");
            }
            result = overSeaFeignService.checkOverseaHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("overSea服务异常");
                serName.append("overSea， ");
            }
            result = overSeaXXLJobFeignService.checkOverSeaXXLJobHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("overSeaXXLJob服务异常");
                serName.append("overSeaXXLJob， ");
            }
            result = pGatewayFeignService.checkPGatewayHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("pGateway服务异常");
                serName.append("pGateway， ");
            }
            result = piwikFeignService.checkPiwikhHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("piwik服务异常");
                serName.append("piwik， ");
            }
            result = piwikReadFeignService.checkPiwikReadHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("piwikRead服务异常");
                serName.append("piwikRead， ");
            }
            result = receiveMailFeignService.checkReceiveMailHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("receiveMail服务异常");
                serName.append("receiveMail， ");
            }
            result = reportFeignService.checkReportHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("report服务异常");
                serName.append("report， ");
            }
            result = ruleFeignService.checkRuleHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("rule服务异常");
                serName.append("rule， ");
            }
            result = sendMailFeignService.checkSendMailHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("sendMail服务异常");
                serName.append("sendMail， ");
            }
            result = socialFeignService.checkSocialHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("social服务异常");
                serName.append("social， ");
            }
            result = timeLineFeignService.checkTimeLineHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("timeLine服务异常");
                serName.append("timeLine， ");
            }
            result = translationFeignService.checkTranslationHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("translation服务异常");
                serName.append("translation， ");
            }
            result = visitorChatFeignService.checkVisitorChatHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("visitorChat服务异常");
                serName.append("visitorChat， ");
            }
            result = whatsAppFeignService.checkWhatsAppHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("whatsApp服务异常");
                serName.append("whatsApp， ");
            }
            result = whatsAppMinorBranchFeignService.checkWhatsAppMinorBranchHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("whatsAppMinorBranch服务异常");
                serName.append("whatsAppMinorBranch， ");
            }
            result = whatsAppWeb4jFeignService.checkWhatsAppWeb4jHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("whatsAppWeb4j服务异常");
                serName.append("whatsAppWeb4j， ");
            }
            result = xddPluginFeignService.checkXddPluginHealth();
            if ("接口调用异常！".equals(result)) {
                //TODO 通知相关联系人
                log.warning("xddPlug服务异常");
                serName.append("询多多， ");
            }
            log.info("服务检查结束");
            if (StringUtils.isNotBlank(serName.toString())) {
                //五分钟之内只调用一次电话通知接口
                if (redisUtil.setIfAbsentOutTime("sendVoid", serName.toString(), 5, TimeUnit.MINUTES)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
                    log.info("总服务异常：" + serName);
                    sendVoid(serName.toString(), sdf.format(new Date()));
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * 使用AK&SK初始化账号Client
     *
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public com.aliyun.dyvmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dyvmsapi.aliyuncs.com";
        return new com.aliyun.dyvmsapi20170525.Client(config);
    }

    private void sendVoid(String serverName, String time) throws Exception {
        com.aliyun.dyvmsapi20170525.Client client = createClient(voidAccessKeyId, voidAccessKeySecret);
//        SingleCallByVoiceRequest singleCallByVoiceRequest = new SingleCallByVoiceRequest()
//                .setCalledShowNumber("0571000010989")
//                .setCalledNumber("15210905264")
//                .setVoiceCode("e271f3f2-e155-4366-a9f4-0fe55765****.wav");
//        // 复制代码运行请自行打印 API 的返回值
//        client.singleCallByVoice(singleCallByVoiceRequest);

        String tsParam = "{\"servername\":\"" + serverName + "\",\"time\":\"" + time + "\"}";
        SingleCallByTtsRequest singleCallByTtsRequest = new SingleCallByTtsRequest()
//                .setCalledShowNumber("0571000010989")
                .setCalledNumber("15210905264")
                .setTtsCode("TTS_278365015")
                .setTtsParam(tsParam);
        SingleCallByTtsResponse singleCallByTtsResponse = client.singleCallByTts(singleCallByTtsRequest);
        System.out.println("-------" + JSONObject.toJSONString(singleCallByTtsResponse));

    }
}
