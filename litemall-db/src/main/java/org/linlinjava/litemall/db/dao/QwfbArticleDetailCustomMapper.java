
package org.linlinjava.litemall.db.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticleDetail;
import org.linlinjava.litemall.db.domain.QwfbArticleDetailCustom;

public interface QwfbArticleDetailCustomMapper {

    List<LitemallQwfbArticleDetail> getPlatNoPublishedList(@Param("userId") Integer userId,
            @Param("platformId") Integer platformId, @Param("lastPublishedTime") LocalDateTime lastPublishedTime);

    List<QwfbArticleDetailCustom> getArticleDetailList(@Param("userId") Integer userId,
            @Param("articleId") Long articleId);

    List<QwfbArticleDetailCustom> getArticleDetailListDashboard(@Param("userId") Integer userId);

    // List<LitemallQwfbArticleDetail> getDetailList(@Param("userId") Integer
    // userId,
    // @Param("platformId") Integer platformId, @Param("lastPublishedTime")
    // LocalDateTime lastPublishedTime);

}