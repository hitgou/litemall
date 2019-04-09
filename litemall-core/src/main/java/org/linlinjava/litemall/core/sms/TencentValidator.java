package org.linlinjava.litemall.core.sms;

import java.net.URLEncoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.linlinjava.litemall.core.util.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 腾讯验证码服务：https://007.qq.com/captcha/#/gettingStart
 * 
 * @author fengzilin
 *
 */
@Configuration
public class TencentValidator {
    private final Log logger = LogFactory.getLog(TencentValidator.class);
    private static final String VERIFY_URI = "https://ssl.captcha.qq.com/ticket/verify?aid=%s&AppSecretKey=%s&Ticket=%s&Randstr=%s&UserIP=%s";

    /**
     * 主账号AccessKey的ID
     */
    @Value("${tencent.appId}")
    private String appId;

    /**
     * 主账号AccessKey的key
     */
    @Value("${tencent.appSecretKey}")
    private String appSecretKey;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecretKey() {
        return appSecretKey;
    }

    public void setAppSecretKey(String appSecretKey) {
        this.appSecretKey = appSecretKey;
    }

    /**
     * 校验验证码 https://007.qq.com/captcha/#/gettingStart
     * 
     * @param tel
     * @param code
     */
    public Boolean verify(String ticket, String rand, String tel) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet;
        CloseableHttpResponse response = null;
        try {
            String userIP = HttpUtil.getInternetIp();
            httpGet = new HttpGet(
                    String.format(VERIFY_URI, getAppId(), getAppSecretKey(), URLEncoder.encode(ticket, "UTF-8"),
                            URLEncoder.encode(rand, "UTF-8"), URLEncoder.encode(userIP, "UTF-8")));
            response = httpclient.execute(httpGet);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String res = EntityUtils.toString(entity);
                logger.debug(res);
                JSONObject result = JSON.parseObject(res);
                // 返回码
                int code = result.getInteger("response");
                // 恶意等级
                int evilLevel = result.getInteger("evil_level");
                // 验证成功
                if (code == 1) {
                    return true;
                } else
                    return false;
            }
        } catch (java.io.IOException e) {
            // 忽略
        } finally {
            try {
                response.close();
            } catch (Exception ignore) {
            }
        }

        return false;

    }

}
