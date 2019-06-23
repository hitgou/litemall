package org.linlinjava.litemall.qwfb.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.core.util.StringUtil;
import org.linlinjava.litemall.db.domain.LitemallPlatform;
import org.linlinjava.litemall.db.domain.LitemallPlatformWithBLOBs;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccount;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccount.Column;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccountGroup;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticle;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticleDetail;
import org.linlinjava.litemall.db.domain.QwfbArticleDetailCustom;
import org.linlinjava.litemall.db.service.QwfbAccountGroupService;
import org.linlinjava.litemall.db.service.QwfbAccountService;
import org.linlinjava.litemall.db.service.QwfbArticleDetailService;
import org.linlinjava.litemall.db.service.QwfbArticleService;
import org.linlinjava.litemall.qwfb.message.MessageProxyService;
import org.linlinjava.litemall.qwfb.net.MessageKey;
import org.linlinjava.litemall.qwfb.vm.PublishAccountGroupVM;
import org.linlinjava.litemall.qwfb.vm.PublishAccountGroupVM.PlatformVM;
import org.linlinjava.litemall.qwfb.vm.PublishAccountGroupVM.PublishAccountVM;
import org.linlinjava.litemall.qwfb.vm.PublishArticleVM;
import org.linlinjava.litemall.qwfb.vm.UpdateArticleVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.hitgou.common.message.MessageInfo;
import com.hitgou.common.util.RedisKey;

@Service
public class QwfbPublishBLLService {
    private final Log logger = LogFactory.getLog(QwfbPublishBLLService.class);
    private final Column[] columnsAccount = new Column[] { Column.id };

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
    private QwfbArticleBLLService qwfbArticleBLLService;

    @Autowired
    private QwfbArticleDetailService qwfbArticleDetailService;

    @Autowired
    private PlatformBLLService platformBLLService;

    @Autowired
    private MessageProxyService messageService;

    public Object getAccountList(Integer userId) {
        List<LitemallQwfbAccount> accountList = qwfbAccountService.querySelective(userId);

        return ResponseUtil.ok(accountList);
    }

    public Object getArticleList(Integer userId, String title, Integer status, Integer page, Integer limit) {
        List<LitemallQwfbArticle> articleList = qwfbArticleService.getArticleList(userId, title, status, page, limit);
        long total = PageInfo.of(articleList).getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("items", articleList);

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

            List<LitemallPlatformWithBLOBs> platformList = platformService.getPlatformList();
            Map<Integer, LitemallPlatformWithBLOBs> platforms = new HashMap<>();
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

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public LitemallQwfbArticle createOrUpdateArticle(LitemallQwfbArticle article, Integer userId) {
        if (article.getId() != null && article.getId() > 0) {
            LitemallQwfbArticle articleDb = qwfbArticleService.findById(article.getId(), userId);
            articleDb.setTitle(article.getTitle());
            articleDb.setContent(article.getContent());
            articleDb.setCoverMode(article.getCoverMode());
            qwfbArticleService.updateByPrimaryKey(articleDb);

            qwfbArticleDetailService.updateFetchTimeById(article.getId(), userId);

            notifyArticleChange(userId);

            return article;
        } else {
            return qwfbArticleService.add(article, userId);
        }
    }

    @Transactional
    public Object changeArticleByStep(Integer userId, Long articleId, Integer accountGroupId,
            Map<String, LitemallQwfbArticleDetail> articleDetails) {
        LitemallQwfbArticle article = qwfbArticleService.findById(articleId, userId);
        if (article == null || (article.getStatus() != 99 && article.getStatus() != 1)) {
            return ResponseUtil.badArgument();
        }

        LitemallQwfbAccountGroup accountGroup = qwfbAccountGroupService.findById(userId, accountGroupId);
        if (accountGroupId > 0 && accountGroup == null) {
            return ResponseUtil.badArgument();
        }

        List<LitemallPlatformWithBLOBs> platformList = platformService.getPlatformList();
        Map<Integer, LitemallPlatformWithBLOBs> platforms = new HashMap<>();
        platformList.forEach(item -> {
            platforms.put(item.getId(), item);
        });

        List<LitemallQwfbAccount> accountList = qwfbAccountGroupService.queryAccountList(userId, accountGroupId, true);
        for (int i = 0; i < accountList.size(); i++) {
            LitemallQwfbAccount account = accountList.get(i);
            LitemallPlatformWithBLOBs platform = platforms.get(account.getPlatformId());
            LitemallQwfbArticleDetail detail = articleDetails.get(account.getId() + "");
            detail.setPlatformId(account.getPlatformId());
            if (!StringUtil.isNullOrEmpty(platform.getCategoryRules())
                    && (detail == null || StringUtil.isNullOrEmpty(detail.getCategoryId()))) {
                return ResponseUtil.badArgument();
            }
        }

        // 更改article的group id
        article.setGroupId(accountGroupId);
        article.setStatus(1);
        article.setLastPublishTime(LocalDateTime.now());
        qwfbArticleService.updateByPrimaryKey(article);

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

        notifyArticleChange(userId);

        return null;
    }

    // public PublishArticleVM getPublishArticle(Integer userId, Long articleId) {
    // LitemallQwfbArticle article = getArticle(userId, articleId);
    //
    // PublishArticleVM publishArticleVM = new PublishArticleVM(article.getId(),
    // article.getTitle(),
    // article.getContent(), article.getType(), article.getCoverMode(),
    // article.getStatus(),
    // article.getGroupId(), article.getLastPublishTime());
    // publishArticleVM.articleDetailList = new ArrayList<>();
    //
    // List<LitemallQwfbArticleDetail> articleDetailList =
    // qwfbArticleDetailService.findListByArticleId(articleId,
    // userId);
    // articleDetailList.forEach(item -> {
    // PublishArticleVM.ArticleDetailVM articleDetailVM = new
    // ArticleDetailVM(item.getId(), item.getTitle(),
    // item.getContent(), item.getPlatformId(), item.getAccountId(),
    // item.getCategoryId(),
    // item.getCategoryName(), item.getStatus(), item.getStatushint());
    // publishArticleVM.articleDetailList.add(articleDetailVM);
    // });
    //
    // return publishArticleVM;
    // }

    public LitemallQwfbArticle getArticle(Integer userId, Long articleId) {
        return qwfbArticleService.findById(articleId, userId);
    }

    @Transactional
    public List<PublishArticleVM> getArticleQueueList(Integer userId, LocalDateTime lastAccessTime, Integer page,
            Integer limit) {
        List<QwfbArticleDetailCustom> articleDetailList = qwfbArticleDetailService.getPublishedQueue(userId,
                lastAccessTime, page, limit);
        if (articleDetailList.size() == 0) {
            return null;
        }

        List<Long> detailIdList = new ArrayList<>();
        List<PublishArticleVM> publishArticleVMList = new ArrayList<>();
        articleDetailList.forEach(articleDetail -> {
            PublishArticleVM publishArticleVM = new PublishArticleVM(articleDetail.getArticleId(),
                    articleDetail.getId(), articleDetail.getTitle(), articleDetail.getContent(),
                    articleDetail.getPlatformId(), articleDetail.getAccountId(), articleDetail.getCategoryId(),
                    articleDetail.getCategoryName(), articleDetail.getStatus(), articleDetail.getStatusHint(),
                    articleDetail.getDeleted(), articleDetail.getLastPublishedTime());
            publishArticleVM.setArticle(articleDetail.getType(), articleDetail.getCoverMode(),
                    articleDetail.getAccountGroupId());
            publishArticleVMList.add(publishArticleVM);
            detailIdList.add(articleDetail.getId());
        });

        qwfbArticleDetailService.updateFetchTimeById(detailIdList, userId, lastAccessTime);

        return publishArticleVMList;
    }

    public Object updateArticleList(Integer userId, List<UpdateArticleVM> articleDetailList) {
        if (articleDetailList.size() == 0) {
            return null;
        }

        qwfbArticleBLLService.initNoPublishedArticleList(userId);

        Integer platformId = articleDetailList.get(0).platformId;
        String key = RedisKey.getKey(RedisKey.Key_article_no_published_set, userId, platformId);
        // List<PublishAccountGroupVM> publishAccountGroupVMList = null;
        if (redisTemplate.hasKey(key)) {
            ListOperations<String, Object> listOperations = redisTemplate.opsForList();
            List articleDetailRedisList = listOperations.range(key, 0, -1);
            Iterator<LitemallQwfbArticleDetail> it = articleDetailRedisList.iterator();
            while (it.hasNext()) {
                LitemallQwfbArticleDetail redisArticleDetail = (LitemallQwfbArticleDetail) it.next();
                for (int i = 0; i < articleDetailList.size(); i++) {
                    UpdateArticleVM updateArticleVM = articleDetailList.get(i);
                    updateArticleVM.detailId = redisArticleDetail.getId();
                    updateArticleVM.articleId = redisArticleDetail.getArticleId();
                    if (updateArticleVM.title.equalsIgnoreCase(redisArticleDetail.getTitle())) {
                        // 找到文章，更新detail的状态、如果是发布完成，移出列表
                        qwfbArticleBLLService.updateArticleStatus(userId, updateArticleVM);
                        it.remove();
                        listOperations.remove(key, 1, redisArticleDetail);
                    }
                }
            }
        }

        notifyArticleChange(userId);

        return null;
    }

    public void initNoPublishedArticleList(Integer userId) {
        String key = RedisKey.getKey(RedisKey.Key_article_no_published_set, userId);
    }

    public void notifyArticleChange(Integer userId) {
        MessageInfo messageInfo = new MessageInfo(userId, MessageKey.Key_Article_Changed);
        redisTemplate.opsForList().leftPush(RedisKey.Key_message_ArticleSendList, messageInfo);
    }

}
