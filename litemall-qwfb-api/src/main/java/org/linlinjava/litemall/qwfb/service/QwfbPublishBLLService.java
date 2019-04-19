package org.linlinjava.litemall.qwfb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.db.domain.LitemallPlatform;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccount;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccountGroup;
import org.linlinjava.litemall.db.service.QwfbAccountGroupService;
import org.linlinjava.litemall.db.service.QwfbAccountService;
import org.linlinjava.litemall.qwfb.util.RedisKey;
import org.linlinjava.litemall.qwfb.vm.PublishAccountGroupVM;
import org.linlinjava.litemall.qwfb.vm.PublishAccountGroupVM.PlatformVM;
import org.linlinjava.litemall.qwfb.vm.PublishAccountGroupVM.PublishAccountVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class QwfbPublishBLLService {
    private final Log logger = LogFactory.getLog(QwfbPublishBLLService.class);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private QwfbAccountGroupService qwfbAccountGroupService;

    @Autowired
    private PlatformBLLService platformService;

    @Autowired
    private QwfbAccountService qwfbAccountService;

    public List<PublishAccountGroupVM> getAccountGroupList(Integer userId) {
        // 从 redis 缓存中获取，如果没有，则查询数据库并填充 redis
        String key = RedisKey.getKey(RedisKey.Key_publish_account_group_list, userId);
        // List<PublishAccountGroupVM> publishAccountGroupVMList = null;
        if (!redisTemplate.hasKey(key)) {
            ListOperations<String, Object> listOperations = redisTemplate.opsForList();
            final List<PublishAccountGroupVM> publishAccountGroupVMList = (List) listOperations.range(key, 0, -1);
            // 获取账号分组列表
            List<LitemallQwfbAccountGroup> accountGroupDBList = qwfbAccountGroupService.querySelective(userId);

            LitemallQwfbAccountGroup defaultGroup = new LitemallQwfbAccountGroup();
            defaultGroup.setId(0);
            defaultGroup.setName("默认组");
            accountGroupDBList.add(0, defaultGroup);

            List<LitemallPlatform> platformList = platformService.getPlatformList();
            Map<Integer, LitemallPlatform> platforms = new HashMap<>();
            platformList.forEach(item -> {
                platforms.put(item.getId(), item);
            });

            accountGroupDBList.forEach(item -> {
                PublishAccountGroupVM publishAccountGroupVM = new PublishAccountGroupVM();
                publishAccountGroupVM.AccountGroupId = item.getId();
                publishAccountGroupVM.AccountGroupName = item.getName();

                publishAccountGroupVM.AccountList = new ArrayList<>();
                publishAccountGroupVM.PlatformMaps = new HashMap<>();
                List<LitemallQwfbAccount> accountDBList = qwfbAccountService.querySelective(userId);
                accountDBList.forEach(accountDBItem -> {
                    LitemallPlatform litemallPlatform = platforms.get(accountDBItem.getPlatformId());

                    if (accountDBItem.getAccountGroupId() == item.getId()) {
                        PublishAccountVM publishAccountVM = new PublishAccountVM();
                        publishAccountVM.AccountId = accountDBItem.getId();
                        publishAccountVM.AccountName = accountDBItem.getShowName();
                        publishAccountVM.PlatformId = accountDBItem.getPlatformId();
                        publishAccountVM.PlatformName = litemallPlatform.getName();
                        publishAccountGroupVM.AccountList.add(publishAccountVM);

                        if (!publishAccountGroupVM.PlatformMaps.containsKey(accountDBItem.getPlatformId())) {
                            PlatformVM platformVM = new PlatformVM();
                            platformVM.PlatformId = litemallPlatform.getId();
                            platformVM.PlatformName = litemallPlatform.getName();
                            platformVM.ShortName = litemallPlatform.getShortName();
                            publishAccountGroupVM.PlatformMaps.put(platformVM.PlatformId, platformVM);
                        }
                    }
                });

                publishAccountGroupVMList.add(publishAccountGroupVM);
            });

            // 根据分组填充平台信息
            listOperations.rightPushAll(key, publishAccountGroupVMList.toArray());

            return publishAccountGroupVMList;
        } else {
            ListOperations<String, Object> listOperations = redisTemplate.opsForList();
            return (List) listOperations.range(key, 0, -1);
        }
    }

}
