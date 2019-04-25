package org.linlinjava.litemall.db.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.linlinjava.litemall.db.dao.LitemallQwfbArticleDetailMapper;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticleDetail;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticleDetailExample;
import org.springframework.stereotype.Service;

@Service
public class QwfbArticleDetailService {
    // private final Column[] columnsAccount = Column.excludes(Column.deleted);

    @Resource
    private LitemallQwfbArticleDetailMapper qwfbArticleDetailMapper;

    public void deleteById(Long id, Integer userId) {
        LitemallQwfbArticleDetailExample example = new LitemallQwfbArticleDetailExample();
        LitemallQwfbArticleDetailExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andIdEqualTo(id);
        qwfbArticleDetailMapper.logicalDeleteByExample(example);
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

    public List<LitemallQwfbArticleDetail> findListByArticleId(Long articleId, Integer userId) {
        LitemallQwfbArticleDetailExample example = new LitemallQwfbArticleDetailExample();
        LitemallQwfbArticleDetailExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(articleId).andUserIdEqualTo(userId).andDeletedEqualTo(false);

        return qwfbArticleDetailMapper.selectByExample(example);
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

}
