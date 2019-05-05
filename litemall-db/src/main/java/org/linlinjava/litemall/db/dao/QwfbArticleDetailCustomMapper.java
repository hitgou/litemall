package org.linlinjava.litemall.db.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticleDetail;

public interface QwfbArticleDetailCustomMapper {

    List<LitemallQwfbArticleDetail> selectByExampleSelectiveCustom(@Param("userId") Integer userId,
            @Param("platformId") Integer platformId, @Param("lastPublishedTime") LocalDateTime lastPublishedTime);

}