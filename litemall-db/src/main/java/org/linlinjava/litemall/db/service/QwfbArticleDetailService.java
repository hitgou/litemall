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
import org.springframework.stereotype.Service;

@Service
public class QwfbArticleDetailService {
    private final Column[] columns = Column.excludes(Column.deleted);

    @Resource
    private LitemallQwfbArticleDetailMapper qwfbArticleDetailMapper;

    @Resource
    private QwfbArticleDetailCustomMapper qwfbArticleDetailCustomMapper;

    public List<LitemallQwfbArticleDetail> selectByExampleSelectiveCustom(Integer userId, Integer platformId) {
        // 仅包含最近30天以内的文章
        return qwfbArticleDetailCustomMapper.selectByExampleSelectiveCustom(userId, platformId,
                LocalDateTime.now().minusDays(30));
    }

    public void deleteByArticleId(Long articleId, Integer userId) {
        LitemallQwfbArticleDetailExample example = new LitemallQwfbArticleDetailExample();
        LitemallQwfbArticleDetailExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andArticleIdEqualTo(articleId);
        qwfbArticleDetailMapper.logicalDeleteByExample(example);
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

        return qwfbArticleDetailMapper.selectByExample(example);
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

    public int updateById(LitemallQwfbArticleDetail detail, Integer userId) {
        LitemallQwfbArticleDetailExample example = new LitemallQwfbArticleDetailExample();
        LitemallQwfbArticleDetailExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andIdEqualTo(detail.getId());

        detail.setUpdateTime(LocalDateTime.now());
        return qwfbArticleDetailMapper.updateByExampleSelective(detail, example);
    }

    public void add(LitemallQwfbArticleDetail detail) {
        detail.setAddTime(LocalDateTime.now());
        detail.setUpdateTime(LocalDateTime.now());
        qwfbArticleDetailMapper.insertSelective(detail);
    }

    /**
     * 获取指定时间以后的第一条文章 / 或者状态为 1/2 但发布时间已经超过 1 小时的文章
     * 
     * @param userId
     * @param lastAccessTime
     *            @return2019-01-01T00:00
     */
    public LitemallQwfbArticleDetail findAfterTime(Integer userId, LocalDateTime lastAccessTime,
            List<Integer> expiredAccountIdList) {
        LitemallQwfbArticleDetailExample example = new LitemallQwfbArticleDetailExample();
        LitemallQwfbArticleDetailExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andDeletedEqualTo(false).andLastPublishedTimeGreaterThan(lastAccessTime)
                .andStatusEqualTo(1).andAccountIdNotIn(expiredAccountIdList);

        // 状态为 1/2 但发布时间已经超过 1 小时的文章
        List<Integer> statusList = new ArrayList<>();
        statusList.add(1);
        statusList.add(2);
        LitemallQwfbArticleDetailExample.Criteria criteria1 = example.createCriteria();
        criteria1.andUserIdEqualTo(userId).andDeletedEqualTo(false)
                .andLastPublishedTimeLessThan(LocalDateTime.now().minusHours(1)).andStatusIn(statusList)
                .andAccountIdNotIn(expiredAccountIdList);
        example.or(criteria1);

        // 状态为 1/2 但还未发布
        LitemallQwfbArticleDetailExample.Criteria criteria2 = example.createCriteria();
        criteria2.andUserIdEqualTo(userId).andDeletedEqualTo(false).andLastPublishedTimeIsNull().andStatusIn(statusList)
                .andAccountIdNotIn(expiredAccountIdList);
        example.or(criteria2);

        LitemallQwfbArticleDetail article = qwfbArticleDetailMapper.selectOneByExampleWithBLOBs(example);
        if (article != null && article.getLastPublishedTime() == null) {
            article.setLastPublishedTime(lastAccessTime);
            qwfbArticleDetailMapper.updateByPrimaryKey(article);
        }

        example.orderBy("id asc ");

        return article;
    }

}
