package org.linlinjava.litemall.db.service;

import java.util.List;

import javax.annotation.Resource;

import org.linlinjava.litemall.db.dao.LitemallPlatformMapper;
import org.linlinjava.litemall.db.domain.LitemallPlatformExample;
import org.linlinjava.litemall.db.domain.LitemallPlatformWithBLOBs;
import org.linlinjava.litemall.db.domain.LitemallPlatformWithBLOBs.Column;
import org.springframework.stereotype.Service;

@Service
public class LitemallPlatformService {
    private final Column[] result = Column.excludes(Column.addTime, Column.deleted, Column.updateTime,
            Column.articlesUrl, Column.homeUrl, Column.loginUrl, Column.publishArticleUrl, Column.picsUrl,
            Column.publishPicsUrl, Column.publishVideoUrl, Column.picsUrl, Column.videosUrl);

    @Resource
    private LitemallPlatformMapper platformMapper;

    public List<LitemallPlatformWithBLOBs> querySelective() {
        LitemallPlatformExample example = new LitemallPlatformExample();
        LitemallPlatformExample.Criteria criteria = example.createCriteria();

        criteria.andDeletedEqualTo(false);

        return platformMapper.selectByExampleSelective(example, result);
    }

}
