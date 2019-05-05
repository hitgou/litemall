package org.linlinjava.litemall.qwfb.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccount;
import org.linlinjava.litemall.db.domain.LitemallUser;
import org.linlinjava.litemall.db.service.QwfbAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QwfbAccountBLLService {
    private final Log logger = LogFactory.getLog(QwfbAccountBLLService.class);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private QwfbPublishBLLService qwfbPublishBLLService;

    @Autowired
    private QwfbAccountService qwfbAccountService;

    @Autowired
    QwfbAccountGroupBLLService qwfbAccountGroupBLLService;

    public List<LitemallQwfbAccount> querySelective(Integer userId) {
        return querySelective(userId, null, null, null, 1, 10000, null, null);
    }

    public List<LitemallQwfbAccount> querySelective(Integer userId, Integer accountGroupId) {
        return querySelective(userId, null, accountGroupId, null, 1, 10000, null, null);
    }

    public List<LitemallQwfbAccount> querySelective(Integer userId, Integer platformId, Integer accountGroupId,
            Integer expired, Integer page, Integer limit, String sort, String order) {
        return qwfbAccountService.querySelective(userId, platformId, accountGroupId, expired, page, limit, sort, order);
    }

    public void add(LitemallQwfbAccount ad, Integer userId) {
        ad.setUserId(userId);
        qwfbAccountService.add(ad);
        qwfbAccountGroupBLLService.refreshPublishAccountGroupListCacheAyns(userId);
    }

    public LitemallQwfbAccount findById(Integer id, Integer userId) {
        return qwfbAccountService.findById(id, userId);
    }

    public int updateById(LitemallQwfbAccount ad, Integer userId) {
        // 更新 redis 缓存
        int line = qwfbAccountService.updateById(ad, userId);

        qwfbAccountGroupBLLService.refreshPublishAccountGroupListCacheAyns(userId);

        return line;
    }

    public int changeGroup(Integer id, Integer accountGroupId, Integer userId) {
        int line = qwfbAccountService.changeGroup(id, accountGroupId, userId);
        qwfbAccountGroupBLLService.refreshPublishAccountGroupListCacheAyns(userId);
        return line;
    }

    public void deleteById(Integer id, Integer userId) {
        qwfbAccountService.deleteById(id, userId);
        qwfbAccountGroupBLLService.refreshPublishAccountGroupListCacheAyns(userId);
    }

    @Transactional
    public LitemallQwfbAccount precreate(LitemallUser user, Integer platformId) {
        return qwfbAccountService.precreate(user, platformId);
    }

    public void updateLoginInfo(LitemallUser user, Integer accountId, String accountName, String headIcon,
            String headIconSite, String loginName, String password, String authToken) {
        qwfbAccountService.updateLoginInfo(user, accountId, accountName, headIcon, headIconSite, loginName, password,
                authToken);
        qwfbAccountGroupBLLService.refreshPublishAccountGroupListCacheAyns(user.getId());
    }

    public void setExpired(Integer accountId, Integer userId) {
        qwfbAccountService.setExpired(accountId, userId);
        qwfbAccountGroupBLLService.refreshPublishAccountGroupListCacheAyns(userId);
    }

}
