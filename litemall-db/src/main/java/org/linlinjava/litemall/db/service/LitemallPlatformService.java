package org.linlinjava.litemall.db.service;

import java.util.List;

import javax.annotation.Resource;

import org.linlinjava.litemall.db.dao.LitemallPlatformMapper;
import org.linlinjava.litemall.db.domain.LitemallPlatform;
import org.linlinjava.litemall.db.domain.LitemallPlatformExample;
import org.linlinjava.litemall.db.domain.LitemallPlatform.Column;
import org.springframework.stereotype.Service;

@Service
public class LitemallPlatformService {
    private final Column[] result = new Column[] { Column.id, Column.name, Column.shortName, Column.status };
    
    @Resource
    private LitemallPlatformMapper platformMapper;

    public List<LitemallPlatform> querySelective() {
        LitemallPlatformExample example = new LitemallPlatformExample();
        LitemallPlatformExample.Criteria criteria = example.createCriteria();

        criteria.andDeletedEqualTo(false);

        return platformMapper.selectByExampleSelective(example, result);
    }

}
