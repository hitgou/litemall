package org.linlinjava.litemall.db.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.linlinjava.litemall.db.dao.LitemallQwfbAccountGroupMapper;
import org.linlinjava.litemall.db.dao.LitemallQwfbAccountMapper;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccount;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccountExample;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccountGroup;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccountGroup.Column;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccountGroupExample;
import org.springframework.stereotype.Service;

@Service
public class QwfbAccountGroupService {
    @Resource
    private LitemallQwfbAccountGroupMapper qwfbAccountGroupMapper;

    @Resource
    private LitemallQwfbAccountMapper qwfbAccountMapper;

    public List<LitemallQwfbAccountGroup> querySelective(Integer userId) {
        LitemallQwfbAccountGroupExample example = new LitemallQwfbAccountGroupExample();
        LitemallQwfbAccountGroupExample.Criteria criteria = example.createCriteria();

        if (userId != null && userId > 0) {
            criteria.andUserIdEqualTo(userId);
        }

        criteria.andDeletedEqualTo(false);

        example.orderBy(LitemallQwfbAccountGroup.Column.id.desc());

        return qwfbAccountGroupMapper.selectByExample(example);
    }

    public List<LitemallQwfbAccountGroup> querySelective(Integer userId, Column... columns) {
        LitemallQwfbAccountGroupExample example = new LitemallQwfbAccountGroupExample();
        LitemallQwfbAccountGroupExample.Criteria criteria = example.createCriteria();

        if (userId != null && userId > 0) {
            criteria.andUserIdEqualTo(userId);
        }

        criteria.andDeletedEqualTo(false);

        example.orderBy(LitemallQwfbAccountGroup.Column.id.desc());

        return qwfbAccountGroupMapper.selectByExampleSelective(example, columns);
    }

    public List<LitemallQwfbAccount> queryAccountList(Integer userId, Integer accountGroupId) {
        LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
        LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andAccountGroupIdEqualTo(accountGroupId).andDeletedEqualTo(false);

        return qwfbAccountMapper.selectByExample(example);
    }

    public List<LitemallQwfbAccount> queryAccountList(Integer userId, Integer accountGroupId, Boolean logined) {
        LitemallQwfbAccountExample example = new LitemallQwfbAccountExample();
        LitemallQwfbAccountExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andAccountGroupIdEqualTo(accountGroupId).andDeletedEqualTo(false);
        if (logined) {
            criteria.andLastLoginTimeIsNotNull();
        } else {
            criteria.andLastLoginTimeIsNull();
        }

        return qwfbAccountMapper.selectByExample(example);
    }

    public int updateById(LitemallQwfbAccountGroup qwfbAccountGroup, Integer userId) {
        LitemallQwfbAccountGroupExample example = new LitemallQwfbAccountGroupExample();
        LitemallQwfbAccountGroupExample.Criteria criteria = example.createCriteria();

        criteria.andIdEqualTo(qwfbAccountGroup.getId());
        if (userId != null && userId > 0) {
            criteria.andUserIdEqualTo(userId);
        }

        LitemallQwfbAccountGroup updated = new LitemallQwfbAccountGroup();
        updated.setId(qwfbAccountGroup.getId());
        updated.setUpdateTime(LocalDateTime.now());
        updated.setName(qwfbAccountGroup.getName());

        return qwfbAccountGroupMapper.updateByExampleSelective(updated, example);
    }

    public void deleteById(Integer userId, Integer id) {
        LitemallQwfbAccountGroupExample example = new LitemallQwfbAccountGroupExample();
        LitemallQwfbAccountGroupExample.Criteria criteria = example.createCriteria();

        if (userId != null && userId > 0) {
            criteria.andUserIdEqualTo(userId);
        }

        if (id != null && id > 0) {
            criteria.andIdEqualTo(id);
        }

        qwfbAccountGroupMapper.logicalDeleteByExample(example);
    }

    public void add(LitemallQwfbAccountGroup qwfbAccountGroup) {
        LitemallQwfbAccountGroup updated = new LitemallQwfbAccountGroup();
        updated.setId(qwfbAccountGroup.getId());
        updated.setUpdateTime(LocalDateTime.now());
        updated.setName(qwfbAccountGroup.getName());
        updated.setAddTime(LocalDateTime.now());
        updated.setUpdateTime(LocalDateTime.now());
        updated.setUserId(qwfbAccountGroup.getUserId());

        qwfbAccountGroupMapper.insertSelective(updated);
    }

    public LitemallQwfbAccountGroup findById(Integer userId, Integer id) {
        LitemallQwfbAccountGroupExample example = new LitemallQwfbAccountGroupExample();
        LitemallQwfbAccountGroupExample.Criteria criteria = example.createCriteria();

        criteria.andUserIdEqualTo(userId);
        criteria.andIdEqualTo(id);

        return qwfbAccountGroupMapper.selectOneByExample(example);
    }

}