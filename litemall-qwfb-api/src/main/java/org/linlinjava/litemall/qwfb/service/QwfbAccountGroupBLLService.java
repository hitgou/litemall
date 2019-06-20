package org.linlinjava.litemall.qwfb.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import javax.annotation.Resource;

import org.linlinjava.litemall.db.domain.LitemallQwfbAccountGroup;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccountGroup.Column;
import org.linlinjava.litemall.db.service.QwfbAccountGroupService;
import org.linlinjava.litemall.db.service.QwfbAccountService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitgou.common.util.RedisKey;

@Service
public class QwfbAccountGroupBLLService {

    ExecutorService executor = Executors.newFixedThreadPool(2);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private QwfbAccountGroupService qwfbAccountGroupService;

    @Resource
    private QwfbAccountService qwfbAccountService;

    @Resource
    private QwfbPublishBLLService qwfbPublishBLLService;

    public List<LitemallQwfbAccountGroup> querySelective(Integer userId) {
        return qwfbAccountGroupService.querySelective(userId);
    }

    public List<LitemallQwfbAccountGroup> querySelective(Integer userId, Column... columns) {
        return qwfbAccountGroupService.querySelective(userId, columns);
    }

    public int updateById(LitemallQwfbAccountGroup qwfbAccountGroup, Integer userId) {
        return qwfbAccountGroupService.updateById(qwfbAccountGroup, userId);
    }

    @Transactional
    public void deleteById(Integer userId, Integer id) {
        qwfbAccountGroupService.deleteById(userId, id);
        // 将改组下的账号的分组ID设置为 0
        qwfbAccountService.resetGroup(id, 0, userId);

        refreshPublishAccountGroupListCacheAyns(userId);
    }

    public void add(LitemallQwfbAccountGroup qwfbAccountGroup, Integer userId) {
        qwfbAccountGroup.setUserId(userId);
        qwfbAccountGroupService.add(qwfbAccountGroup);

        refreshPublishAccountGroupListCacheAyns(userId);
    }

    public LitemallQwfbAccountGroup findById(Integer userId, Integer id) {
        return qwfbAccountGroupService.findById(userId, id);
    }

    public void removePublishAccountGroupListCache(Integer userId) {
        String key = RedisKey.getKey(RedisKey.Key_publish_account_group_list, userId);
        redisTemplate.delete(key);
    }

    public void refreshPublishAccountGroupListCache(Integer userId) {
        String key = RedisKey.getKey(RedisKey.Key_publish_account_group_list, userId);
        redisTemplate.delete(key);

        qwfbPublishBLLService.getAccountGroupList(userId);
    }

    public void refreshPublishAccountGroupListCacheAyns(Integer userId) {
        String key = RedisKey.getKey(RedisKey.Key_publish_account_group_list, userId);
        redisTemplate.delete(key);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                qwfbPublishBLLService.getAccountGroupList(userId);
                return "task finished!";
            }
        }, executor);
        future.thenAccept(e -> System.out.println(e + " ok"));
    }
}
