package org.linlinjava.litemall.qwfb.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.core.util.StringUtil;
import org.linlinjava.litemall.db.domain.LitemallPlatform;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccount;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccountGroup;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticle;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticleDetail;
import org.linlinjava.litemall.db.service.QwfbAccountGroupService;
import org.linlinjava.litemall.db.service.QwfbAccountService;
import org.linlinjava.litemall.db.service.QwfbArticleDetailService;
import org.linlinjava.litemall.db.service.QwfbArticleService;
import org.linlinjava.litemall.qwfb.util.RedisKey;
import org.linlinjava.litemall.qwfb.vm.PublishAccountGroupVM;
import org.linlinjava.litemall.qwfb.vm.PublishAccountGroupVM.PlatformVM;
import org.linlinjava.litemall.qwfb.vm.PublishAccountGroupVM.PublishAccountVM;
import org.linlinjava.litemall.qwfb.vm.PublishArticleVM;
import org.linlinjava.litemall.qwfb.vm.PublishArticleVM.ArticleDetailVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;

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

    @Autowired
    private QwfbArticleService qwfbArticleService;

    @Autowired
    private QwfbArticleDetailService qwfbArticleDetailService;

    public Object getArticleList(Integer userId, String title, Integer status, Integer page, Integer limit) {
        List<LitemallQwfbArticle> goodsList = qwfbArticleService.getArticleList(userId, title, status, page, limit);
        long total = PageInfo.of(goodsList).getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("items", goodsList);

        return ResponseUtil.ok(data);
    }

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

    public LitemallQwfbArticle createArticle(LitemallQwfbArticle article, Integer userId) {
        return qwfbArticleService.add(article, userId);
    }

    @Transactional
    public Object changeArticleByStep(Integer userId, Long articleId, Integer accountGroupId,
            Map<String, LitemallQwfbArticleDetail> articleDetails) {
        LitemallQwfbArticle article = qwfbArticleService.findById(articleId, userId);
        if (article == null) {
            return ResponseUtil.badArgument();
        }

        LitemallQwfbAccountGroup accountGroup = qwfbAccountGroupService.findById(userId, accountGroupId);
        if (accountGroupId > 0 && accountGroup == null) {
            return ResponseUtil.badArgument();
        }

        // 更改article的group id
        article.setGroupId(accountGroupId);
        article.setStatus(1);
        qwfbArticleService.updateByPrimaryKey(article);

        List<LitemallPlatform> platformList = platformService.getPlatformList();
        Map<Integer, LitemallPlatform> platforms = new HashMap<>();
        platformList.forEach(item -> {
            platforms.put(item.getId(), item);
        });

        List<LitemallQwfbAccount> accountList = qwfbAccountGroupService.queryAccountList(userId, accountGroupId, true);
        for (int i = 0; i < accountList.size(); i++) {
            LitemallQwfbAccount account = accountList.get(i);
            LitemallPlatform platform = platforms.get(account.getPlatformId());
            LitemallQwfbArticleDetail detail = articleDetails.get(account.getId() + "");
            if (!StringUtil.isNullOrEmpty(platform.getCategoryRule())
                    && (detail == null || StringUtil.isNullOrEmpty(detail.getCategoryId()))) {
                return ResponseUtil.badArgument();
            }
        }

        // 判断分组是否跟之前的文章分组一致
        // 如果不一致，需要删除之前的detail
        qwfbArticleDetailService.deleteByArticleId(articleId, userId);
        articleDetails.keySet().forEach(accountIdString -> {
            Integer accountId = Integer.parseInt(accountIdString);
            LitemallQwfbArticleDetail inputArticleDetail = articleDetails.get(accountIdString);
            LitemallQwfbArticleDetail articleDetail = qwfbArticleDetailService.findById(articleId, accountId, userId);
            if (articleDetail != null) {
                articleDetail.setDeleted(false);
                articleDetail.setUpdateTime(LocalDateTime.now());
                articleDetail.setCategoryId(inputArticleDetail.getCategoryId());
                articleDetail.setCategoryName(inputArticleDetail.getCategoryName());
                qwfbArticleDetailService.updateById(articleDetail, userId);
            } else {
                articleDetail = new LitemallQwfbArticleDetail();
                articleDetail.setAccountGroupId(accountGroupId);
                articleDetail.setAccountId(accountId);
                articleDetail.setArticleId(articleId);
                articleDetail.setCategoryId(inputArticleDetail.getCategoryId());
                articleDetail.setCategoryName(inputArticleDetail.getCategoryName());
                articleDetail.setPlatformId(inputArticleDetail.getPlatformId());
                articleDetail.setUserId(userId);
                qwfbArticleDetailService.add(articleDetail);
            }
        });

        return null;
    }

    public PublishArticleVM getPublishArticle(Integer userId, Long articleId) {
        LitemallQwfbArticle article = getArticle(userId, articleId);

        PublishArticleVM publishArticleVM = new PublishArticleVM(article.getId(), article.getTitle(),
                article.getContent(), article.getType(), article.getCoverMode(), article.getStatus(),
                article.getGroupId());
        publishArticleVM.articleDetailList = new ArrayList<>();

        List<LitemallQwfbArticleDetail> articleDetailList = qwfbArticleDetailService.findListByArticleId(articleId,
                userId);
        articleDetailList.forEach(item -> {
            PublishArticleVM.ArticleDetailVM articleDetailVM = new ArticleDetailVM(item.getId(), item.getTitle(),
                    item.getContent(), item.getPlatformId(), item.getAccountId(), item.getCategoryId(),
                    item.getCategoryName(), item.getStatus(), item.getStatushint());
            publishArticleVM.articleDetailList.add(articleDetailVM);
        });

        return publishArticleVM;
    }

    public LitemallQwfbArticle getArticle(Integer userId, Long articleId) {
        return qwfbArticleService.findById(articleId, userId);
    }

    public PublishArticleVM getArticleQueueList(Integer userId, LocalDateTime lastAccessTime, Integer page,
            Integer limit) {
        LitemallQwfbArticle article = qwfbArticleService.findAfterTime(userId, lastAccessTime);
        if (article == null) {
            return null;
        }

        // article.setLastPublishTime(lastAccessTime);
        // qwfbArticleService.updateByPrimaryKey(article);

        PublishArticleVM publishArticleVM = new PublishArticleVM(article.getId(), article.getTitle(),
                article.getContent(), article.getType(), article.getCoverMode(), article.getStatus(),
                article.getGroupId());
        publishArticleVM.articleDetailList = new ArrayList<>();

        List<LitemallQwfbArticleDetail> articleDetailList = qwfbArticleDetailService
                .findListByArticleId(article.getId(), userId);
        articleDetailList.forEach(item -> {
            PublishArticleVM.ArticleDetailVM articleDetailVM = new ArticleDetailVM(item.getId(), item.getTitle(),
                    item.getContent(), item.getPlatformId(), item.getAccountId(), item.getCategoryId(),
                    item.getCategoryName(), item.getStatus(), item.getStatushint());
            publishArticleVM.articleDetailList.add(articleDetailVM);
        });

        return publishArticleVM;
    }

}
