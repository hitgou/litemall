package org.linlinjava.litemall.db.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.linlinjava.litemall.db.dao.LitemallQwfbArticleDetailMapper;
import org.linlinjava.litemall.db.dao.QwfbArticleDetailCustomMapper;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticleDetail;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticleDetail.Column;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticleDetailExample;
import org.linlinjava.litemall.db.domain.QwfbArticleDetailCustom;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

@Service
public class QwfbArticleDetailService {
    private final Column[] columns = Column.excludes(Column.deleted);
    private final Column[] columnsList = Column.excludes(Column.deleted, Column.content);

    @Resource
    private LitemallQwfbArticleDetailMapper qwfbArticleDetailMapper;

    @Resource
    private QwfbArticleDetailCustomMapper qwfbArticleDetailCustomMapper;

    public List<LitemallQwfbArticleDetail> getPlatNoPublishedList(Integer userId, Integer platformId) {
        // 仅包含最近30天以内的文章
        return qwfbArticleDetailCustomMapper.getPlatNoPublishedList(userId, platformId,
                LocalDateTime.now().minusDays(30));
    }

    public List<QwfbArticleDetailCustom> getArticleDetailList(Integer userId, Long articleId) {
        // 仅包含最近30天以内的文章
        return qwfbArticleDetailCustomMapper.getArticleDetailList(userId, articleId);
    }

    public List<QwfbArticleDetailCustom> getDetailList(Integer userId, Integer status, int page, int limit) {
        // int start = (page - 1) * limit;

        PageHelper.startPage(page, limit);

        // return qwfbArticleDetailCustomMapper.getDetailList(userId, start, limit);
        return qwfbArticleDetailCustomMapper.getDetailList(userId, status);
    }

    public List<QwfbArticleDetailCustom> getPublishedQueue(Integer userId, LocalDateTime fetchTime, int page,
            int limit) {
        PageHelper.startPage(page, limit);

        return qwfbArticleDetailCustomMapper.getPublishedQueue(userId, fetchTime);
    }

    public LitemallQwfbArticleDetail findById(Long articleId, Integer accountId, Integer userId) {
        LitemallQwfbArticleDetailExample example = new LitemallQwfbArticleDetailExample();
        LitemallQwfbArticleDetailExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(articleId).andAccountIdEqualTo(accountId).andUserIdEqualTo(userId);

        return qwfbArticleDetailMapper.selectOneByExample(example);
    }

    public LitemallQwfbArticleDetail findById(Long articleDetailId, Integer userId) {
        LitemallQwfbArticleDetailExample example = new LitemallQwfbArticleDetailExample();
        LitemallQwfbArticleDetailExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(articleDetailId).andUserIdEqualTo(userId).andDeletedEqualTo(false);

        return qwfbArticleDetailMapper.selectOneByExample(example);
    }

    public List<LitemallQwfbArticleDetail> findListByArticleId(Long articleId, Integer userId) {
        LitemallQwfbArticleDetailExample example = new LitemallQwfbArticleDetailExample();
        LitemallQwfbArticleDetailExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(articleId).andUserIdEqualTo(userId).andDeletedEqualTo(false);

        return qwfbArticleDetailMapper.selectByExampleSelective(example, columnsList);
    }

    public Long getDetailsCountByStatus(Integer userId, Long articleId, List<String> statusList) {
        LitemallQwfbArticleDetailExample example = new LitemallQwfbArticleDetailExample();
        LitemallQwfbArticleDetailExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(articleId).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        if (statusList != null && statusList.size() > 0) {
            criteria = criteria.andStatusHintIn(statusList);
        }

        Long count = qwfbArticleDetailMapper.countByExample(example);

        return count;
    }

    public Long getDetailsCountByStatuss(Integer userId, Long articleId, List<Integer> statusList) {
        LitemallQwfbArticleDetailExample example = new LitemallQwfbArticleDetailExample();
        LitemallQwfbArticleDetailExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(articleId).andUserIdEqualTo(userId).andDeletedEqualTo(false)
                .andStatusIn(statusList);

        Long count = qwfbArticleDetailMapper.countByExample(example);

        return count;
    }

    public Long getDetailsCountByStatus(Integer userId, Long articleId, Integer status) {
        LitemallQwfbArticleDetailExample example = new LitemallQwfbArticleDetailExample();
        LitemallQwfbArticleDetailExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(articleId).andUserIdEqualTo(userId).andDeletedEqualTo(false)
                .andStatusEqualTo(status);

        Long count = qwfbArticleDetailMapper.countByExample(example);

        return count;
    }

    public void add(LitemallQwfbArticleDetail detail) {
        LocalDateTime now = LocalDateTime.now();
        detail.setAddTime(now);
        detail.setPublishFetchTime(now);
        detail.setUpdateTime(now);
        qwfbArticleDetailMapper.insertSelective(detail);
    }

    public int updateById(LitemallQwfbArticleDetail detail, Integer userId) {
        LitemallQwfbArticleDetailExample example = new LitemallQwfbArticleDetailExample();
        LitemallQwfbArticleDetailExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andIdEqualTo(detail.getId());

        LocalDateTime now = LocalDateTime.now();
        detail.setPublishFetchTime(now);
        detail.setUpdateTime(now);
        return qwfbArticleDetailMapper.updateByExampleSelective(detail, example);
    }

    public int updateFetchTimeById(Long articleId, Integer userId) {
        LitemallQwfbArticleDetailExample example = new LitemallQwfbArticleDetailExample();
        LitemallQwfbArticleDetailExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andArticleIdEqualTo(articleId);

        LitemallQwfbArticleDetail detail = new LitemallQwfbArticleDetail();
        LocalDateTime now = LocalDateTime.now();
        detail.setPublishFetchTime(now);

        return qwfbArticleDetailMapper.updateByExampleSelective(detail, example);
    }

    public int updateFetchTimeById(List<Long> detailIdList, Integer userId, LocalDateTime fetchTime) {
        LitemallQwfbArticleDetailExample example = new LitemallQwfbArticleDetailExample();
        LitemallQwfbArticleDetailExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andIdIn(detailIdList);

        LitemallQwfbArticleDetail detail = new LitemallQwfbArticleDetail();
        detail.setPublishFetchTime(fetchTime);

        return qwfbArticleDetailMapper.updateByExampleSelective(detail, example);
    }

    public void deleteByArticleId(Long articleId, Integer userId) {
        LitemallQwfbArticleDetailExample example = new LitemallQwfbArticleDetailExample();
        LitemallQwfbArticleDetailExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andArticleIdEqualTo(articleId);

        LitemallQwfbArticleDetail detail = new LitemallQwfbArticleDetail();
        LocalDateTime now = LocalDateTime.now();
        detail.setPublishFetchTime(now);
        detail.setUpdateTime(now);
        qwfbArticleDetailMapper.updateByExampleSelective(detail, example);

        qwfbArticleDetailMapper.logicalDeleteByExample(example);
    }

    /**
     * 获取指定时间以后的第一条文章 / 或者状态为 1/2 但发布时间已经超过 1 小时的文章
     * 
     * @param userId
     * @param lastAccessTime
     *            @return2019-01-01T00:00
     */
    public LitemallQwfbArticleDetail findAfterTime(Integer userId, LocalDateTime lastAccessTime,
            List<Integer> expiredAccountIdList, List<Integer> validPlatformList) {
        lastAccessTime = LocalDateTime.now();

        LitemallQwfbArticleDetailExample example = new LitemallQwfbArticleDetailExample();
        LitemallQwfbArticleDetailExample.Criteria criteria = example.createCriteria();

        // 1、状态为1-待发布且发布时间小于 lastAccessTime 时间
        criteria.andUserIdEqualTo(userId).andDeletedEqualTo(false).andLastPublishedTimeLessThan(lastAccessTime)
                .andStatusEqualTo(1).andAccountIdNotIn(expiredAccountIdList).andPlatformIdIn(validPlatformList);

        // 2、状态为 2 但发布时间已经超过 1 小时的文章
        List<Integer> statusList = new ArrayList<>();
        // statusList.add(1);
        statusList.add(2);

        LitemallQwfbArticleDetailExample.Criteria criteria1 = example.createCriteria();
        criteria1.andUserIdEqualTo(userId).andDeletedEqualTo(false)
                .andLastPublishedTimeLessThan(LocalDateTime.now().minusHours(1)).andStatusIn(statusList)
                .andAccountIdNotIn(expiredAccountIdList).andPlatformIdIn(validPlatformList);
        example.or(criteria1);

        // 状态为 1/2 但还未发布
        // LitemallQwfbArticleDetailExample.Criteria criteria2 =
        // example.createCriteria();
        // criteria2.andUserIdEqualTo(userId).andDeletedEqualTo(false).andLastPublishedTimeIsNull().andStatusIn(statusList)
        // .andAccountIdNotIn(expiredAccountIdList);
        // example.or(criteria2);

        example.orderBy("id asc ");

        LitemallQwfbArticleDetail article = qwfbArticleDetailMapper.selectOneByExampleWithBLOBs(example);
        if (article != null) {
            article.setLastPublishedTime(LocalDateTime.now().plusHours(1));
            qwfbArticleDetailMapper.updateByPrimaryKey(article);
        }

        return article;
    }

}
