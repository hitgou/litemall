package org.linlinjava.litemall.core.sms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

@Configuration
public class SmsSender {
    private final Log logger = LogFactory.getLog(SmsSender.class);

    /**
     * 主账号AccessKey的ID
     */
    @Value("${aliyun.accessKeyId}")
    private String accessKeyId;

    /**
     * 主账号AccessKey的key
     */
    @Value("${aliyun.accessSecret}")
    private String accessSecret;

    /**
     * 短信模板ID。请在控制台模板管理页面模板CODE一列查看
     */
    @Value("${aliyun.sms.templatecode}")
    private String templateCode;

    /**
     * 短信签名名称。请在控制台签名管理页面签名名称一列查看
     */
    @Value("${aliyun.sms.signname}")
    private String signName;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    /**
     * 发送验证码
     * https://help.aliyun.com/document_detail/101414.html?spm=a2c4g.11186623.6.615.39e319d9u3Xis5
     * 
     * @param tel
     * @param code
     */
    public void sendValidateSms(String tel, String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", getAccessKeyId(), getAccessSecret());
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        // request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", tel);
        request.putQueryParameter("TemplateCode", getTemplateCode());
        request.putQueryParameter("SignName", getSignName());
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            logger.equals(e);
            e.printStackTrace();
        } catch (ClientException e) {
            logger.equals(e);
            e.printStackTrace();
        }

    }

}
