package org.linlinjava.litemall.db.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.linlinjava.litemall.db.dao.LitemallQwfbAccountGroupMapper;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccountGroup;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccountGroupExample;
import org.springframework.stereotype.Service;

@Service
public class LitemallQwfbAccountGroupService {
    @Resource
    private LitemallQwfbAccountGroupMapper qwfbAccountMapper;

    public List<LitemallQwfbAccountGroup> querySelective(Integer userId) {
        LitemallQwfbAccountGroupExample example = new LitemallQwfbAccountGroupExample();
        LitemallQwfbAccountGroupExample.Criteria criteria = example.createCriteria();

        if (userId != null && userId > 0) {
            criteria.andUserIdEqualTo(userId);
        }

        criteria.andDeletedEqualTo(false);

        example.orderBy(LitemallQwfbAccountGroup.Column.isDefault.desc(), LitemallQwfbAccountGroup.Column.id.desc());

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

        return qwfbAccountMapper.updateByExampleSelective(updated, example);
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

        criteria.andIsDefaultEqualTo(false);

        qwfbAccountMapper.logicalDeleteByExample(example);
    }

    public void add(LitemallQwfbAccountGroup qwfbAccountGroup) {
        LitemallQwfbAccountGroup updated = new LitemallQwfbAccountGroup();
        updated.setId(qwfbAccountGroup.getId());
        updated.setUpdateTime(LocalDateTime.now());
        updated.setName(qwfbAccountGroup.getName());
        updated.setAddTime(LocalDateTime.now());
        updated.setUpdateTime(LocalDateTime.now());
        updated.setUserId(qwfbAccountGroup.getUserId());

        qwfbAccountMapper.insertSelective(updated);
    }

    public LitemallQwfbAccountGroup findById(Integer userId, Integer id) {
        LitemallQwfbAccountGroupExample example = new LitemallQwfbAccountGroupExample();
        LitemallQwfbAccountGroupExample.Criteria criteria = example.createCriteria();

        if (userId != null && userId > 0) {
            criteria.andUserIdEqualTo(userId);
        }

        if (id != null && id > 0) {
            criteria.andIdEqualTo(id);
        }

        return qwfbAccountMapper.selectOneByExample(example);
    }
}
