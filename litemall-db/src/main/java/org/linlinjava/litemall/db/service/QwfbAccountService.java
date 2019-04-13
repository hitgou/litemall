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
    private final Column[] columnsAccount = Column.excludes(Column.deleted, Column.sorted, Column.userId);

    @Resource
    private LitemallQwfbAccountMapper qwfbAccountMapper;

    public List<LitemallQwfbAccount> querySelective(Integer userId, Integer platformId, Integer accountGroupId,
            Integer page, Integer limit, String sort, String order) {
        LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
        LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();

        criteria.andUserIdEqualTo(userId);

        if (platformId != null && platformId > 0) {
            criteria.andPlatformIdEqualTo(platformId);
        }

        if (accountGroupId != null && accountGroupId > 0) {
            criteria.andAccountGroupIdEqualTo(accountGroupId);
        }

        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);

        return qwfbAccountMapper.selectByExample(example);
    }

    public int updateById(LitemallQwfbAccount ad) {
        ad.setUpdateTime(LocalDateTime.now());
        return qwfbAccountMapper.updateByPrimaryKeySelective(ad);
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

    public void deleteById(Integer id) {
        qwfbAccountMapper.logicalDeleteByPrimaryKey(id);
    }

    @Transactional
    public LitemallQwfbAccount precreate(LitemallUser user, Integer platformId) {
        LitemallQwfbAccount account = new LitemallQwfbAccount();
        account.setAddTime(LocalDateTime.now());
        account.setUpdateTime(LocalDateTime.now());
        account.setUserId(user.getId());
        account.setPlatformId(platformId);

        int accountId = qwfbAccountMapper.insertSelective(account);
        account = qwfbAccountMapper.selectByPrimaryKeySelective(accountId, columnsAccount);

        return account;
    }

    public void add(LitemallQwfbAccount ad) {
        ad.setAddTime(LocalDateTime.now());
        ad.setUpdateTime(LocalDateTime.now());
        qwfbAccountMapper.insertSelective(ad);
    }

    public LitemallQwfbAccount findById(Integer id) {
        return qwfbAccountMapper.selectByPrimaryKey(id);
    }

}
