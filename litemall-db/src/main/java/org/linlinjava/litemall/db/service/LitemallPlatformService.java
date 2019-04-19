package org.linlinjava.litemall.db.service;

import java.util.List;

import javax.annotation.Resource;

import org.linlinjava.litemall.db.dao.LitemallPlatformMapper;
import org.linlinjava.litemall.db.domain.LitemallPlatform;
import org.linlinjava.litemall.db.domain.LitemallPlatform.Column;
import org.linlinjava.litemall.db.domain.LitemallPlatformExample;
import org.springframework.stereotype.Service;

@Service
public class LitemallPlatformService {
    private final Column[] result = new Column[] { Column.id, Column.name, Column.shortName, Column.status,
            Column.loginUrl, Column.homeUrl, Column.publishArticleUrl, Column.publishVedioUrl, Column.des,
            Column.extraDes };

    @Resource
    private LitemallPlatformMapper platformMapper;

    public List<LitemallPlatform> querySelective() {
        LitemallPlatformExample example = new LitemallPlatformExample();
        LitemallPlatformExample.Criteria criteria = example.createCriteria();

        criteria.andDeletedEqualTo(false);

        return platformMapper.selectByExampleSelective(example, result);
    }

}
