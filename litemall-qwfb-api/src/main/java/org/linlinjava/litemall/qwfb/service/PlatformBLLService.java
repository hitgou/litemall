package org.linlinjava.litemall.qwfb.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.db.domain.LitemallPlatformWithBLOBs;
import org.linlinjava.litemall.db.service.LitemallPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.hitgou.common.util.RedisKey;

@Service
public class PlatformBLLService {
    private final Log logger = LogFactory.getLog(PlatformBLLService.class);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private LitemallPlatformService platformService;

    public List<LitemallPlatformWithBLOBs> getPlatformList() {
        // 下面的list不能指定具体的类型，否则加入redis的是一个arraylist，具体原因待查中
        List platformList = null;
        String key = RedisKey.getKey(RedisKey.Key_Platform_List);
        if (!redisTemplate.hasKey(key)) {
            ListOperations<String, Object> listOperations = redisTemplate.opsForList();
            platformList = platformService.querySelective();
            listOperations.rightPushAll(RedisKey.Key_Platform_List, platformList);
        } else {
            ListOperations<String, Object> listOperations = redisTemplate.opsForList();
            platformList = listOperations.range(key, 0, -1);
        }

        return platformList;
    }
}
