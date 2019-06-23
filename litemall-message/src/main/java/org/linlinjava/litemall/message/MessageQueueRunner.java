package org.linlinjava.litemall.message;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.hitgou.common.message.MessageInfo;
import com.hitgou.common.util.RedisKey;

@Component
@Order(value = 2) // 执行顺序控制
public class MessageQueueRunner implements ApplicationRunner {
    private final Log logger = LogFactory.getLog(MessageQueueRunner.class);
    private final int BLOCK_TIMEOUT = 30;

    @Autowired
    SocketBLLService socketBLLService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // consumer code
        String key = RedisKey.Key_message_ArticleSendList;
        while (true) {
            try {
                logger.info("循环读取redis队列");
                Object obj = redisTemplate.opsForList().rightPop(key, BLOCK_TIMEOUT, TimeUnit.SECONDS);
                logger.info("读取redis队列完成");
                if (obj == null)
                    continue;

                // ObjectMapper mapper = new ObjectMapper();
                MessageInfo messageInfo = (MessageInfo) obj;
                socketBLLService.sendMessageToClient(messageInfo);
            } catch (Exception e) {
                logger.error(e);
            }
        }
    }

}
