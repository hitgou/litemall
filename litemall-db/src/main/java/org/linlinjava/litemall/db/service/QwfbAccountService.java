package org.linlinjava.litemall.db.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.linlinjava.litemall.db.dao.LitemallQwfbAccountMapper;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccount;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccount.Column;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccountExample;
import org.linlinjava.litemall.db.domain.LitemallUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

@Service
public class QwfbAccountService {
    private final Column[] columnsAccount = Column.excludes(Column.deleted, Column.sorted);

    @Resource
    private LitemallQwfbAccountMapper qwfbAccountMapper;

    public List<LitemallQwfbAccount> querySelective(Integer userId) {
        return querySelective(userId, null, null, null, 1, 10000, null, null);
    }

    public List<LitemallQwfbAccount> querySelective(Integer userId, Integer accountGroupId) {
        return querySelective(userId, null, accountGroupId, null, 1, 10000, null, null);
    }

    public List<LitemallQwfbAccount> querySelective(Integer userId, Integer platformId, Integer accountGroupId,
            Integer expired, Integer page, Integer limit, String sort, String order) {
        LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
        LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();

        criteria.andUserIdEqualTo(userId);
        criteria.andShowNameIsNotNull().andShowNameNotEqualTo("");

        if (platformId != null && platformId > 0) {
            criteria.andPlatformIdEqualTo(platformId);
        }

        if (accountGroupId != null && accountGroupId > 0) {
            criteria.andAccountGroupIdEqualTo(accountGroupId);
        }

        if (expired != null) {
            criteria.andExpiredEqualTo(expired);
        }

        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);

        return qwfbAccountMapper.selectByExample(example);
    }

    public List<LitemallQwfbAccount> getExpiredAccountList(Integer userId, Column[] selective) {
        LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
        LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andDeletedEqualTo(false).andExpiredEqualTo(1);

        return qwfbAccountMapper.selectByExampleSelective(example, selective);
    }

    public int updateById(LitemallQwfbAccount ad, Integer userId) {
        LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
        LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andIdEqualTo(ad.getId());

        ad.setUpdateTime(LocalDateTime.now());
        return qwfbAccountMapper.updateByExampleSelective(ad, example);
    }

    public int changeGroup(Integer id, Integer accountGroupId, Integer userId) {
        LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
        LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andIdEqualTo(id);

        LitemallQwfbAccount updated = new LitemallQwfbAccount();
        updated.setAccountGroupId(accountGroupId);
        updated.setUpdateTime(LocalDateTime.now());

        return qwfbAccountMapper.updateByExampleSelective(updated, example);
    }

    public void setExpired(Integer accountId, Integer userId) {
        LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
        LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andIdEqualTo(accountId);

        LitemallQwfbAccount updated = new LitemallQwfbAccount();
        updated.setExpired(1);
        updated.setUpdateTime(LocalDateTime.now());

        qwfbAccountMapper.updateByExampleSelective(updated, example);
    }

    public int resetGroup(Integer originalGroupId, Integer newGroupId, Integer userId) {
        LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
        LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andAccountGroupIdEqualTo(originalGroupId);

        LitemallQwfbAccount updated = new LitemallQwfbAccount();
        updated.setAccountGroupId(newGroupId);
        updated.setUpdateTime(LocalDateTime.now());

        return qwfbAccountMapper.updateByExampleSelective(updated, example);
    }

    public void deleteById(Integer id, Integer userId) {
        LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
        LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andIdEqualTo(id);
        qwfbAccountMapper.logicalDeleteByExample(example);
    }

    @Transactional
    public LitemallQwfbAccount precreate(LitemallUser user, Integer platformId) {
        LitemallQwfbAccount account = new LitemallQwfbAccount();
        account.setAddTime(LocalDateTime.now());
        account.setUpdateTime(LocalDateTime.now());
        account.setUserId(user.getId());
        account.setPlatformId(platformId);

        qwfbAccountMapper.insertSelective(account);
        account = qwfbAccountMapper.selectByPrimaryKeySelective(account.getId(), columnsAccount);

        return account;
    }

    public void updateLoginInfo(LitemallUser user, Integer accountId, String accountName, String headIcon,
            String headIconSite, String loginName, String password, String authToken) {
        LitemallQwfbAccount account = new LitemallQwfbAccount();
        account.setShowName(accountName);
        account.setHeadIcon(headIcon);
        account.setHeadIconSite(headIconSite);
        account.setLoginName(loginName);
        account.setPassword(password);
        account.setAuthToken(authToken);
        account.setExpired(0);
        account.setLastLoginTime(LocalDateTime.now());
        account.setUpdateTime(LocalDateTime.now());

        LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
        LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(accountId).andUserIdEqualTo(user.getId());
        qwfbAccountMapper.updateByExampleSelective(account, example);
    }

    public void add(LitemallQwfbAccount ad) {
        ad.setAddTime(LocalDateTime.now());
        ad.setUpdateTime(LocalDateTime.now());
        qwfbAccountMapper.insertSelective(ad);
    }

    public LitemallQwfbAccount findById(Integer accountId, Integer userId) {
        LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
        LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(accountId).andUserIdEqualTo(userId);

        return qwfbAccountMapper.selectOneByExample(example);
    }

}
