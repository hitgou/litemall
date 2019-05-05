package org.linlinjava.litemall.db.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.linlinjava.litemall.db.dao.LitemallQwfbArticleMapper;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticle;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticle.Column;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticleExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

@Service
public class QwfbArticleService {
    private final Column[] columnsArticle = Column.excludes(Column.deleted);
    private final Column[] columnsArticleList = Column.excludes(Column.deleted, Column.content);

    @Resource
    private LitemallQwfbArticleMapper qwfbArticleMapper;

    public List<LitemallQwfbArticle> getArticleList(Integer userId, String title, Integer status, Integer page,
            Integer size) {
        LitemallQwfbArticleExample example = new LitemallQwfbArticleExample();
        LitemallQwfbArticleExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }

        if (status != null && status > 0) {
            criteria.andStatusEqualTo(status);
        }

        criteria.andDeletedEqualTo(false).andUserIdEqualTo(userId);

        PageHelper.startPage(page, size);

        return qwfbArticleMapper.selectByExampleSelective(example, columnsArticleList);
    }

    public LitemallQwfbArticle findById(Long articleId, Integer userId) {
        LitemallQwfbArticleExample example = new LitemallQwfbArticleExample();
        LitemallQwfbArticleExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(articleId).andUserIdEqualTo(userId).andDeletedEqualTo(false);

        return qwfbArticleMapper.selectOneByExampleWithBLOBs(example);
    }

    /**
     * 获取指定时间以后的第一条文章 / 或者状态为 1/2 但发布时间已经超过 1 小时的文章
     * 
     * @param userId
     * @param lastAccessTime
     *            @return2019-01-01T00:00
     */
    public LitemallQwfbArticle findAfterTime(Integer userId, LocalDateTime lastAccessTime) {
        LitemallQwfbArticleExample example = new LitemallQwfbArticleExample();
        LitemallQwfbArticleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andDeletedEqualTo(false).andLastPublishTimeGreaterThan(lastAccessTime)
                .andStatusEqualTo(1);

        // 状态为 1/2 但发布时间已经超过 1 小时的文章
        List<Integer> statusList = new ArrayList<>();
        statusList.add(1);
        statusList.add(2);
        LitemallQwfbArticleExample.Criteria criteria1 = example.createCriteria();
        criteria1.andUserIdEqualTo(userId).andDeletedEqualTo(false)
                .andLastPublishTimeLessThan(LocalDateTime.now().minusHours(1)).andStatusIn(statusList);
        example.or(criteria1);

        // 状态为 1/2 但还未发布
        LitemallQwfbArticleExample.Criteria criteria2 = example.createCriteria();
        criteria2.andUserIdEqualTo(userId).andDeletedEqualTo(false).andLastPublishTimeIsNull().andStatusIn(statusList);
        example.or(criteria2);

        LitemallQwfbArticle article = qwfbArticleMapper.selectOneByExampleWithBLOBs(example);
        if (article != null && article.getLastPublishTime() == null) {
            article.setLastPublishTime(lastAccessTime);
            qwfbArticleMapper.updateByPrimaryKey(article);
        }

        return article;
    }

    @Transactional
    public LitemallQwfbArticle add(LitemallQwfbArticle article, Integer userId) {
        if (article.getId() != null && article.getId() > 0) {
            LitemallQwfbArticle articleDb = findById(article.getId(), userId);
            if (articleDb != null) {
                articleDb.setTitle(article.getTitle());
                articleDb.setContent(article.getContent());
                articleDb.setCoverMode(article.getCoverMode());
                articleDb.setUpdateTime(LocalDateTime.now());
                qwfbArticleMapper.updateByPrimaryKey(articleDb);
                return articleDb;
            }

            return null;
        } else {
            article.setAddTime(LocalDateTime.now());
            article.setUpdateTime(LocalDateTime.now());
            article.setUserId(userId);
            qwfbArticleMapper.insertSelective(article);
            return findById(article.getId(), userId);
        }
    }

    public int updateByPrimaryKey(LitemallQwfbArticle article) {
        article.setUpdateTime(LocalDateTime.now());
        return qwfbArticleMapper.updateByPrimaryKey(article);
    }

    // public List<LitemallQwfbAccount> querySelective(Integer userId) {
    // return querySelective(userId, null, null, 1, 10000, null, null);
    // }
    //
    // public List<LitemallQwfbAccount> querySelective(Integer userId, Integer
    // accountGroupId) {
    // return querySelective(userId, null, accountGroupId, 1, 10000, null, null);
    // }
    //
    // public List<LitemallQwfbAccount> querySelective(Integer userId, Integer
    // platformId, Integer accountGroupId,
    // Integer page, Integer limit, String sort, String order) {
    // LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
    // LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();
    //
    // criteria.andUserIdEqualTo(userId);
    // criteria.andShowNameIsNotNull().andShowNameNotEqualTo("");
    //
    // if (platformId != null && platformId > 0) {
    // criteria.andPlatformIdEqualTo(platformId);
    // }
    //
    // if (accountGroupId != null && accountGroupId > 0) {
    // criteria.andAccountGroupIdEqualTo(accountGroupId);
    // }
    //
    // criteria.andDeletedEqualTo(false);
    //
    // if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
    // example.setOrderByClause(sort + " " + order);
    // }
    //
    // PageHelper.startPage(page, limit);
    //
    // return qwfbAccountMapper.selectByExample(example);
    // }
    //
    // public int updateById(LitemallQwfbAccount ad, Integer userId) {
    // LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
    // LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();
    // criteria.andUserIdEqualTo(userId).andIdEqualTo(ad.getId());
    //
    // ad.setUpdateTime(LocalDateTime.now());
    // return qwfbAccountMapper.updateByExampleSelective(ad, example);
    // }
    //
    // public int changeGroup(Integer id, Integer accountGroupId, Integer userId) {
    // LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
    // LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();
    // criteria.andUserIdEqualTo(userId).andIdEqualTo(id);
    //
    // LitemallQwfbAccount updated = new LitemallQwfbAccount();
    // updated.setAccountGroupId(accountGroupId);
    // updated.setUpdateTime(LocalDateTime.now());
    //
    // return qwfbAccountMapper.updateByExampleSelective(updated, example);
    // }
    //
    // public int resetGroup(Integer originalGroupId, Integer newGroupId, Integer
    // userId) {
    // LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
    // LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();
    // criteria.andUserIdEqualTo(userId).andAccountGroupIdEqualTo(originalGroupId);
    //
    // LitemallQwfbAccount updated = new LitemallQwfbAccount();
    // updated.setAccountGroupId(newGroupId);
    // updated.setUpdateTime(LocalDateTime.now());
    //
    // return qwfbAccountMapper.updateByExampleSelective(updated, example);
    // }
    //
    // public void deleteById(Integer id, Integer userId) {
    // LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
    // LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();
    // criteria.andUserIdEqualTo(userId).andIdEqualTo(id);
    // qwfbAccountMapper.logicalDeleteByExample(example);
    // }
    //
    // @Transactional
    // public LitemallQwfbAccount precreate(LitemallUser user, Integer platformId) {
    // LitemallQwfbAccount account = new LitemallQwfbAccount();
    // account.setAddTime(LocalDateTime.now());
    // account.setUpdateTime(LocalDateTime.now());
    // account.setUserId(user.getId());
    // account.setPlatformId(platformId);
    //
    // qwfbAccountMapper.insertSelective(account);
    // account = qwfbAccountMapper.selectByPrimaryKeySelective(account.getId(),
    // columnsAccount);
    //
    // return account;
    // }
    //
    // public void updateLoginInfo(LitemallUser user, Integer accountId, String
    // accountName, String headIcon,
    // String loginName, String password, String authToken) {
    // LitemallQwfbAccount account = new LitemallQwfbAccount();
    // account.setShowName(accountName);
    // account.setHeadIcon(headIcon);
    // account.setLoginName(loginName);
    // account.setPassword(password);
    // account.setAuthToken(authToken);
    // account.setExpired(0);
    // account.setLastLoginTime(LocalDateTime.now());
    // account.setUpdateTime(LocalDateTime.now());
    //
    // LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
    // LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();
    // criteria.andIdEqualTo(accountId).andUserIdEqualTo(user.getId());
    // qwfbAccountMapper.updateByExampleSelective(account, example);
    // }
    //
}
