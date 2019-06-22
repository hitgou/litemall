
package org.linlinjava.litemall.qwfb.message;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hitgou.common.message.BusinessCallback;
import com.hitgou.common.message.CallbackListener;
import com.hitgou.common.message.CallbackService;
import com.hitgou.common.message.MessageService;
import com.hitgou.common.message.User;

/**
 * @author Colin create on 2019/6/8
 */
@Service
public class MessageProxyService {
    private static final Logger logger = LoggerFactory.getLogger(MessageProxyService.class);

    @Reference(version = "1.0.0", check = false)
    private MessageService messageService;

    @Reference(version = "1.0.0", check = false, timeout = 60000)
    private CallbackService callbackService;

    public String priceChanged(String newPrice) {
        String result = messageService.priceChanged(newPrice);
        return result;
    }

    public void sendMessageToClient(Integer userId, String eventType, String message,
            BusinessCallback<?> businessCallback) {
        CompletableFuture<String> future = messageService.sendToClient(userId, eventType, message, businessCallback);
        if (businessCallback != null) {
            // 增加回调
            future.whenComplete((response, ex) -> {
                if (ex != null) {
                    logger.error("MessageProxyService error", ex);
                } else {
                    logger.info(response);
                }
            });
        }
    }

    public String callTest(String newPrice) {
        String result = callbackService.test(newPrice);
        return result;
    }

    public String insert() {
        User user = new User();
        user.setAge(20);
        user.setUserName("Colin-Wang a");
        String result = callbackService.insert(user);
        return result;
    }

    public void addListener(String key) {
        CallbackListener c = new CallbackListenerImpl2();
        // c.changed(getChanged(key));
        callbackService.addListener(key, c);
    }

    private String getChanged(String key) {
        return " consumer: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

}