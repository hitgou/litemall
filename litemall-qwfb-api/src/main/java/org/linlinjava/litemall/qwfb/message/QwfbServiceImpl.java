
package org.linlinjava.litemall.qwfb.message;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.config.annotation.Service;
import com.hitgou.common.message.CallbackListener;
import com.hitgou.common.qwfb.api.QwfbService;

/**
 * @author Colin create on 2019/6/8
 */
@Service(version = "1.0.0")
public class QwfbServiceImpl implements QwfbService {

    private final Map<String, CallbackListener> listeners = new ConcurrentHashMap<String, CallbackListener>();

    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${spring.dubbo.application.name}")
    private String serviceName;

    @Override
    public String connect(String clientId) {
        return String.format("%s connect 1, %s", clientId, serviceName);
    }

}