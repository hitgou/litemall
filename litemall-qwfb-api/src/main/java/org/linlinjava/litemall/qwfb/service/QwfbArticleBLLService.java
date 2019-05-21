package org.linlinjava.litemall.qwfb.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.core.util.StringUtil;
import org.linlinjava.litemall.db.domain.LitemallPlatformWithBLOBs;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccount.Column;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticle;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticleDetail;
import org.linlinjava.litemall.db.domain.QwfbArticleDetailCustom;
import org.linlinjava.litemall.db.service.QwfbArticleDetailService;
import org.linlinjava.litemall.db.service.QwfbArticleService;
import org.linlinjava.litemall.qwfb.util.RedisKey;
import org.linlinjava.litemall.qwfb.vm.UpdateArticleVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QwfbArticleBLLService {
    private final Log logger = LogFactory.getLog(QwfbArticleBLLService.class);
    private final Column[] columnsAccount = new Column[] { Column.id };

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private PlatformBLLService platformService;

    @Autowired
    private QwfbArticleService qwfbArticleService;

    @Autowired
    private QwfbArticleDetailService qwfbArticleDetailService;

    public void initNoPublishedArticleList(Integer userId) {
        // 获取当前的平台数
        List<LitemallPlatformWithBLOBs> platformList = platformService.getPlatformList();
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        for (LitemallPlatformWithBLOBs platform : platformList) {
            String key = RedisKey.getKey(RedisKey.Key_article_no_published_set, userId, platform.getId());
            List articleDetailList = qwfbArticleDetailService.getPlatNoPublishedList(userId, platform.getId());
            if (articleDetailList.size() > 0) {
                redisTemplate.delete(key);
                listOperations.rightPushAll(key, articleDetailList);
            }
        }
    }

    public Object getDetailList(Integer userId, Long articleId) {
        LitemallQwfbArticle articleDb = qwfbArticleService.findById(articleId, userId);
        if (articleDb == null) {
            return ResponseUtil.badArgument();
        }

        List<QwfbArticleDetailCustom> articleList = qwfbArticleDetailService.getArticleDetailList(userId, articleId);
        articleList.forEach(item -> {
            if (StringUtil.isNullOrEmpty(item.getTitle())) {
                item.setTitle(articleDb.getTitle());
            }
        });

        return ResponseUtil.ok(articleList);
    }

    /**
     * 
     * @param userId
     * @param articleDetailId
     * @param status
     *            这里detail只会有 2、3、4 种状态<br>
     *            99-草稿、1-待发布、2-发布中、3-发布成功、4-发布失败、5-部分发送失败
     */
    @Transactional
    public Object updateArticlePublished(Integer userId, UpdateArticleVM articleDetail) {
        Long articleDetailId = articleDetail.detailId;
        Integer status = articleDetail.status;
        LitemallQwfbArticleDetail articleDetailDb = qwfbArticleDetailService.findById(articleDetailId, userId);
        LitemallQwfbArticle articleDb = qwfbArticleService.findById(articleDetailDb.getArticleId(), userId);
        if (articleDetailDb == null || articleDb == null) {
            return ResponseUtil.badArgument();
        }

        if (articleDetail.status == 2 && articleDetailDb.getStatus() != 2) {
            articleDetailDb.setPublishedAttemptTimes(articleDetailDb.getPublishedAttemptTimes() + 1);
        }
        articleDetailDb.setPublishedUrl(articleDetail.publishedUrl);
        articleDetailDb.setPublishedId(articleDetail.publishedId);
        // articleDetailDb.setPublishedType(articleDetail.publishedId);
        articleDetailDb.setStatus(status);

        if (articleDetail.status == 3) {
            articleDetail.statusHint = " ";
        }
        articleDetailDb.setStatusHint(articleDetail.statusHint);
        articleDetailDb.setLastPublishedTime(LocalDateTime.now());
        qwfbArticleDetailService.updateById(articleDetailDb, userId);

        Long totalCount = qwfbArticleDetailService.getDetailsCountByStatus(userId, articleDb.getId(),
                new ArrayList<>());
        Long failedCount = qwfbArticleDetailService.getDetailsCountByStatus(userId, articleDb.getId(), 4);
        Long successCount = qwfbArticleDetailService.getDetailsCountByStatus(userId, articleDb.getId(), 4);
        // 全部发送完成
        Integer articleStatus = 2;
        if (successCount + failedCount == totalCount) {
            articleStatus = failedCount > 0 ? 5 : 3;
        }
        articleDb.setStatus(articleStatus);
        articleDb.setLastPublishTime(LocalDateTime.now());
        qwfbArticleService.updateByPrimaryKey(articleDb);

        return null;
    }

    /**
     * 
     * @param userId
     * @param articleDetailId
     * @param status
     *            这里detail只会有 2、3、4 种状态<br>
     *            99-草稿、1-待发布、2-发布中、3-发布成功、4-发布失败、5-部分发送失败
     */
    public void updateArticleStatus(Integer userId, UpdateArticleVM articleDetail) {
        Long articleDetailId = articleDetail.detailId;
        Integer status = articleDetail.status;
        LitemallQwfbArticleDetail articleDetailDb = qwfbArticleDetailService.findById(articleDetailId, userId);
        LitemallQwfbArticle articleDb = qwfbArticleService.findById(articleDetailDb.getArticleId(), userId);
        articleDetailDb.setPublishedUrl(articleDetail.publishedUrl);
        articleDetailDb.setPublishedId(articleDetail.publishedId);
        // articleDetailDb.setPublishedType(articleDetail.publishedId);
        articleDetailDb.setStatus(status);
        if (articleDetail.status == 3) {
            articleDetail.statusHint = " ";
        }
        articleDetailDb.setStatus(articleDetail.status);
        articleDetailDb.setStatusHint(articleDetail.statusHint);
        qwfbArticleDetailService.updateById(articleDetailDb, userId);

        Long totalCount = qwfbArticleDetailService.getDetailsCountByStatus(userId, articleDb.getId(),
                new ArrayList<>());
        Long failedCount = qwfbArticleDetailService.getDetailsCountByStatus(userId, articleDb.getId(), 4);

        // 状态，99-草稿、0-其他、1-待发布、2-发布中、3-发布成功、4-发布失败、5-部分发送失败、6-发布待确认、7-待审核；
        List<Integer> successStatusList = new ArrayList<>();
        successStatusList.add(3);
        successStatusList.add(7);
        Long successCount = qwfbArticleDetailService.getDetailsCountByStatuss(userId, articleDb.getId(),
                successStatusList);
        // 全部发送完成
        Integer articleStatus = 2;
        if (successCount + failedCount == totalCount) {
            articleStatus = failedCount > 0 ? 5 : 3;
        }
        articleDb.setStatus(articleStatus);
        qwfbArticleService.updateByPrimaryKey(articleDb);
    }

}
