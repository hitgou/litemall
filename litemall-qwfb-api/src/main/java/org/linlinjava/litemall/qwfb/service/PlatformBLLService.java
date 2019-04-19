package org.linlinjava.litemall.qwfb.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.core.redis.RedisConfig;
import org.linlinjava.litemall.db.domain.LitemallPlatform;
import org.linlinjava.litemall.db.service.LitemallPlatformService;
import org.linlinjava.litemall.qwfb.util.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class PlatformBLLService {
    private final Log logger = LogFactory.getLog(PlatformBLLService.class);

    @Resource
    private RedisConfig redisConfig;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private LitemallPlatformService platformService;

    public List<LitemallPlatform> getPlatformList() {
        List publishAccountGroupVMList = null;
        String key = RedisKey.getKey(RedisKey.Key_Platform_List);
        if (!redisTemplate.hasKey(key)) {
            ListOperations<String, Object> valueOperations = redisTemplate.opsForList();
            publishAccountGroupVMList = platformService.querySelective();
            valueOperations.leftPushAll(RedisKey.Key_Platform_List, publishAccountGroupVMList);
        } else {
            ListOperations<String, Object> valueOperations = redisTemplate.opsForList();
            publishAccountGroupVMList = valueOperations.range(key, 0, -1);
        }

        return publishAccountGroupVMList;
    }
}
