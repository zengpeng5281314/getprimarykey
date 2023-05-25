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

    @Value(value = "${void.accessKeyId}")
    private String voidAccessKeyId;
    @Value(value = "${void.accessKeySecret}")
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
            int mailTeam = 0;
            int allTeam = 0;
            int whatsUpTeam = 0;

            String result = appPushFeignService.checkAppPushHealth();
            log.info("apppush:"+result);
            if ("接口调用异常！".equals(result)) {
                log.warning("appPush服务异常");
                serName.append("app推送服务， ");
                allTeam = 1;
            }

            result = chatGPTFeignService.checkChatGPTHealth();
            log.info("chatGPT:"+result);
            if ("接口调用异常！".equals(result)) {
                log.warning("chatGPT服务异常");
                serName.append("chatGPT， ");
                allTeam = 1;
            }
            result = cloudShareFeignService.checkCloudShareHealth();
            log.info("cloudShare:"+result);
            if ("接口调用异常！".equals(result)) {
                log.warning("cloudShare服务异常");
                serName.append("cloudShare， ");
                whatsUpTeam = 1;
            }
            result = crawlerFeignService.checkCrawlerHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("crawler服务异常");
                serName.append("crawler， ");
                whatsUpTeam = 1;
            }
            result = crmFeignService.checkCRMHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("crm服务异常");
                serName.append("crm， ");
                allTeam = 1;
            }
            result = crmSeasFeignService.checkCrmSeasHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("crmSeas服务异常");
                serName.append("crm公海， ");
                allTeam = 1;
            }
            result = crmTransferFeignService.checkCrmTransferHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("crmTransfer服务异常");
                serName.append("crmTransfer， ");
                allTeam = 1;
            }
            result = crmxxlJobFeignService.checkCRMXXLjobHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("crmxxlJob服务异常");
                serName.append("crm定时任务， ");
                allTeam = 1;
            }
            result = cussLoginFeignService.checkCussLoginHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("cussLogin服务异常");
                serName.append("cussLogin， ");
                allTeam = 1;
            }
            result = dashboardFeignService.checkDashboardHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("dashboard服务异常");
                serName.append("仪表盘， ");
                allTeam = 1;
            }
            result = delayqueneFeignService.checkDelayQueneHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("delayquene服务异常");
                serName.append("delayquene， ");
                allTeam = 1;
            }
            result = delayQueneCNFeignService.checkDelayQueneCNHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("delayQueneCN服务异常");
                serName.append("delayqueneCN， ");
                allTeam = 1;
            }
            result = edmWebFeignService.checkEdmWebHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("edmWeb服务异常");
                serName.append("edmWeb， ");
                mailTeam = 1;
            }
            result = es2FeignService.checkES2Health();
            if ("接口调用异常！".equals(result)) {
                log.warning("es2Feign服务异常");
                serName.append("es2， ");
                allTeam = 1;
            }
            result = esFeignService.checkESHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("esFeign服务异常");
                serName.append("es， ");
                allTeam = 1;
            }
            result = facebookFeignService.checkFaceBookHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("facebook服务异常");
                serName.append("facebook， ");
                whatsUpTeam = 1;
            }
            result = fileSysFeignService.checkFileSysHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("fileSys服务(7牛获取token服务)异常");
                serName.append("fileSys， ");
                allTeam = 1;
            }
            result = formCustFeignService.checkFormCustHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("formCust服务异常");
                serName.append("formCust， ");
                allTeam = 1;
            }
            result = instagramFeignService.checkInstagramHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("instagram服务异常");
                serName.append("instagram， ");
                whatsUpTeam = 1;
            }
            result = mailEDMFeignService.checkMailEDMHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("mailEDM服务异常");
                serName.append("mailEDM， ");
                mailTeam = 1;
            }
            result = mailFeignService.checkMailHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("mail服务异常");
                serName.append("mail， ");
                mailTeam = 1;
            }
            result = mailHKFeignService.checkMailHKHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("mailHK服务异常");
                serName.append("mailHK， ");
                mailTeam = 1;
            }
            result = mailProcessDataFeignService.checkMailProcessHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("mailProcessData服务异常");
                serName.append("mailProcessData， ");
                mailTeam = 1;
            }
            result = mailXXLJOBFeignService.checkMailXXLJOBHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("mailXXLJOB服务异常");
                serName.append("mailXXLJOB， ");
                mailTeam = 1;
            }
            result = marketingSiteFeignService.checkMarketingSiteHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("marketingSite服务异常");
                serName.append("marketingSite， ");
                whatsUpTeam = 1;
            }
            result = minorFeignService.checkMinorHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("minor服务异常");
                serName.append("minor， ");
                whatsUpTeam = 1;
            }
            result = newPrivilegeFeignService.checkNewPrivilegeHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("newPrivilege服务异常");
                serName.append("newPrivilege权限服务， ");
                allTeam = 1;
            }
            result = openAPIFeignService.checkOpenAPIHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("openAPI服务异常");
                serName.append("openAPI， ");
                allTeam = 1;
            }
            result = overSeaFeignService.checkOverseaHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("overSea服务异常");
                serName.append("overSea， ");
                allTeam = 1;
            }
            result = overSeaXXLJobFeignService.checkOverSeaXXLJobHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("overSeaXXLJob服务异常");
                serName.append("overSeaXXLJob， ");
                allTeam = 1;
            }
            result = pGatewayFeignService.checkPGatewayHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("pGateway服务异常");
                serName.append("pGateway， ");
                allTeam = 1;
            }
            result = piwikFeignService.checkPiwikhHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("piwik服务异常");
                serName.append("piwik， ");
                whatsUpTeam = 1;
            }
            result = piwikReadFeignService.checkPiwikReadHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("piwikRead服务异常");
                serName.append("piwikRead， ");
                whatsUpTeam = 1;
            }
            result = receiveMailFeignService.checkReceiveMailHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("receiveMail服务异常");
                serName.append("receiveMail， ");
                mailTeam = 1;
            }
            result = reportFeignService.checkReportHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("report服务异常");
                serName.append("report， ");
                allTeam = 1;
            }
            result = ruleFeignService.checkRuleHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("rule服务异常");
                serName.append("rule， ");
                allTeam = 1;
            }
            result = sendMailFeignService.checkSendMailHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("sendMail服务异常");
                serName.append("sendMail， ");
                mailTeam = 1;
            }
            result = socialFeignService.checkSocialHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("social服务异常");
                serName.append("social， ");
                whatsUpTeam = 1;
            }
            result = timeLineFeignService.checkTimeLineHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("timeLine服务异常");
                serName.append("timeLine， ");
                allTeam = 1;
            }
            result = translationFeignService.checkTranslationHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("translation服务异常");
                serName.append("translation， ");
                allTeam = 1;
            }
            result = visitorChatFeignService.checkVisitorChatHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("visitorChat服务异常");
                serName.append("visitorChat， ");
                whatsUpTeam = 1;
            }
            result = whatsAppFeignService.checkWhatsAppHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("whatsApp服务异常");
                serName.append("whatsApp， ");
                whatsUpTeam = 1;
            }
            result = whatsAppMinorBranchFeignService.checkWhatsAppMinorBranchHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("whatsAppMinorBranch服务异常");
                serName.append("whatsAppMinorBranch， ");
                whatsUpTeam = 1;
            }
            result = whatsAppWeb4jFeignService.checkWhatsAppWeb4jHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("whatsAppWeb4j服务异常");
                serName.append("whatsAppWeb4j， ");
                whatsUpTeam = 1;
            }
            result = xddPluginFeignService.checkXddPluginHealth();
            if ("接口调用异常！".equals(result)) {
                log.warning("xddPlug服务异常");
                serName.append("询多多， ");
                allTeam = 1;
            }
            log.info("服务检查结束");
            if(1==1)
                return;
            if (StringUtils.isNotBlank(serName.toString())) {
                //五分钟之内只调用一次电话通知接口
                if (redisUtil.setIfAbsentOutTime("sendVoid", serName.toString(), 5, TimeUnit.MINUTES)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
                    log.info("总输出服务异常：" + serName);
                    if (allTeam == 1) {
                        //打电话曾鹏
                        sendVoid(serName.toString(), sdf.format(new Date()), "15210905264");
                    }
                    if (whatsUpTeam == 1) {
                        //打电话一飞
                        sendVoid(serName.toString(), sdf.format(new Date()), "18883304636");
                    }
                    if(mailTeam == 1){
                        //打电话雷浩
                        sendVoid(serName.toString(), sdf.format(new Date()), "18516909283");
                    }
                    //打电话安宁
                    sendVoid(serName.toString(), sdf.format(new Date()), "13521409066");
                    //打电话杨哥
                    sendVoid(serName.toString(), sdf.format(new Date()), "15901281916");
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

    private void sendVoid(String serverName, String time, String phone) throws Exception {
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
                .setCalledNumber(phone)
                .setTtsCode("TTS_278365015")
                .setTtsParam(tsParam);
        SingleCallByTtsResponse singleCallByTtsResponse = client.singleCallByTts(singleCallByTtsRequest);
        System.out.println("调用打电话接口返回信息：" + JSONObject.toJSONString(singleCallByTtsResponse));

    }
}
