package org.linlinjava.litemall.qwfb.web;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.qwfb.message.MessageProxyService;
import org.linlinjava.litemall.qwfb.service.QwfbPublishBLLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hitgou.common.message.BusinessCallback;

@RestController
@RequestMapping("/test")
public class TestController {
    private final Log logger = LogFactory.getLog(TestController.class);

    @Autowired
    private MessageProxyService messageProxyService;

    @Autowired
    private QwfbPublishBLLService qwfbPublishBLLService;

    @GetMapping("/priceChanged")
    public Object priceChanged() {
        String newPrice = messageProxyService.priceChanged("$1.23");
        return newPrice;
    }

    @GetMapping("/send")
    public Object send() {
        // messageProxyService.sendMessageToClient(4, "nameChanged", "name changed", new
        // CallBack<Object>());
        return ResponseUtil.ok("存在");
    }

    @GetMapping("/articleChanged")
    public Object articleChanged(@NotNull Integer userId) {
        qwfbPublishBLLService.notifyArticleChange(userId);
        return ResponseUtil.ok("存在");
    }

    @GetMapping("/callTest")
    public Object callTest() {
        String result = messageProxyService.callTest(" input 1 ");
        return result;
    }

    @GetMapping("/insert")
    public Object insert() {
        String result = messageProxyService.insert();
        return result;
    }

    @GetMapping("/addListener")
    public Object addListener() {
        messageProxyService.addListener("foo.bar");
        return ResponseUtil.ok("存在 ");
    }

    public static class CallBack<T> implements BusinessCallback<T>, Serializable {
        private static final long serialVersionUID = 6423758160317810737L;

        private final Log logger = LogFactory.getLog(CallBack.class);

        public CallBack() {

        }

        @Override
        public void onSuccess(T result) {
            logger.debug("sendMessageToClient：" + result);
        }

        @Override
        public void onTimeout() {
            logger.debug("sendMessageToClient timeout");
        }

    }

}
