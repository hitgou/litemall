
package org.linlinjava.litemall.qwfb.message;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.linlinjava.litemall.qwfb.net.SocketService;
import org.linlinjava.litemall.qwfb.util.RedisKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.AckCallback;

/**
 * @author Colin create on 2019/6/8
 */
@Service
public class MessageService {
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Value("${shiro.redis.timeout}")
    private Integer timeout;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private SocketService socketService;

    public void clientConnect(String clientId) {
        String key = RedisKey.getKey(RedisKey.Key_message_clientList);
        redisTemplate.opsForHash().put(key, clientId, LocalDateTime.now());
        // TODO 这里需要考虑如何移出过期的 client
        // redisTemplate.expire(key, timeout, TimeUnit.MILLISECONDS);
    }

    public void clientDisconnect(String clientId) {
        String keyList = RedisKey.getKey(RedisKey.Key_message_clientList);
        redisTemplate.opsForHash().delete(keyList, clientId);

        // 删除 clientid - token 存储值
        String key = RedisKey.getKey(RedisKey.Key_message_clientId_token_, clientId);
        Object tokenObject = redisTemplate.opsForValue().get(key);
        redisTemplate.delete(key);

        // 删除 token - clientid 存储值
        if (tokenObject != null) {
            String keyReverse = RedisKey.getKey(RedisKey.Key_message_token_clientId_, tokenObject.toString());
            redisTemplate.delete(keyReverse);
        }
    }

    public Integer login(String clientId, String token) {
        String sessionUserKey = RedisKey.getKey(RedisKey.Key_SessionId_UserId_, token);
        Object userIdObject = redisTemplate.opsForValue().get(sessionUserKey);
        if (userIdObject == null) {
            return null;
        }

        Integer userId = (Integer) userIdObject;

        // 新增 clientid - token 存储值
        String key = RedisKey.getKey(RedisKey.Key_message_clientId_token_, clientId);
        redisTemplate.opsForValue().set(key, token);
        redisTemplate.expire(key, timeout, TimeUnit.MILLISECONDS);

        // 新增 token - clientid 存储值
        String keyReverse = RedisKey.getKey(RedisKey.Key_message_token_clientId_, token);
        redisTemplate.opsForValue().set(keyReverse, clientId);
        redisTemplate.expire(keyReverse, timeout, TimeUnit.MILLISECONDS);

        // 新增 userId - clientid 存储值
        String keyUserIdClientId = RedisKey.getKey(RedisKey.Key_message_userId_clientId_, userId);
        redisTemplate.opsForValue().set(keyUserIdClientId, clientId);
        redisTemplate.expire(keyUserIdClientId, timeout, TimeUnit.MILLISECONDS);

        return userId;
    }

    public void logout(String clientId, String data) {
        String token = data;

        // 删除 clientid - token 存储值
        String key = RedisKey.getKey(RedisKey.Key_message_clientId_token_, clientId);
        redisTemplate.delete(key);

        // 删除 token - clientid 存储值
        String keyReverse = RedisKey.getKey(RedisKey.Key_message_token_clientId_, token);
        redisTemplate.delete(keyReverse);
    }

    public void sendMessageToClient(Integer userId, String eventType, String message, AckCallback<?> ackCallback) {
        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(5);
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                String key = RedisKey.getKey(RedisKey.Key_message_userId_clientId_, userId);
                Object clientObject = redisTemplate.opsForValue().get(key);
                if (clientObject != null) {
                    String clientId = clientObject.toString();
                    socketService.sendMessageToClient(clientId, eventType, message, ackCallback);
                }
            }
        });
    }

}