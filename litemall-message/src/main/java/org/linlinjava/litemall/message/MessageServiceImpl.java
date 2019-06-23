package org.linlinjava.litemall.message;

import java.util.concurrent.CompletableFuture;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.corundumstudio.socketio.AckCallback;
import com.hitgou.common.message.BusinessCallback;
import com.hitgou.common.message.MessageService;

/**
 * Default {@link MessageService}
 *
 * @see MessageService
 * @since 2.7.0
 */
@Service(version = "1.0.0")
public class MessageServiceImpl implements MessageService {
    private final Log logger = LogFactory.getLog(MessageServiceImpl.class);

    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;

    private static final int timeout = 10000;

    @Autowired
    private SocketBLLService socketBLLService;

    @Override
    public String priceChanged(String newPrice) {
        return String.format("[%s] newPrice, %s", serviceName, newPrice);
    }

//    @Override
//    public CompletableFuture<String> sendToClient(Integer userId, String eventType, String message,
//            BusinessCallback businessCallback) {
//        RpcContext savedContext = RpcContext.getContext();
//        // 建议为supplyAsync提供自定义线程池，避免使用JDK公用线程池
//        return CompletableFuture.supplyAsync(() -> {
//            socketBLLService.sendMessageToClient(userId, eventType, message, new AckCallback(Object.class, timeout) {
//                @Override
//                public void onTimeout() {
//                    businessCallback.onTimeout();
//                }
//
//                @Override
//                public void onSuccess(Object result) {
//                    businessCallback.onSuccess(result);
//                }
//            });
//            return "received";
//        });
//    }

}