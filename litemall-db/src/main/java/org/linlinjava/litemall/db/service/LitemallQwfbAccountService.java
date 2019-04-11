package org.linlinjava.litemall.db.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.linlinjava.litemall.db.dao.LitemallQwfbAccountMapper;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccount;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccountExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

@Service
public class LitemallQwfbAccountService {
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

    public void deleteById(Integer id) {
        qwfbAccountMapper.logicalDeleteByPrimaryKey(id);
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
