
package org.linlinjava.litemall.db.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticleDetail;
import org.linlinjava.litemall.db.domain.QwfbArticleDetailCustom;

public interface QwfbArticleDetailCustomMapper {

    List<LitemallQwfbArticleDetail> getPlatNoPublishedList(@Param("userId") Integer userId,
            @Param("platformId") Integer platformId, @Param("lastPublishedTime") LocalDateTime lastPublishedTime);

    // List<QwfbArticleDetailCustom> getDetailList(@Param("userId") Integer userId,
    // @Param("start") int start,
    // @Param("limit") int limit);
    List<QwfbArticleDetailCustom> getDetailList(@Param("userId") Integer userId, @Param("status") Integer status);

    List<QwfbArticleDetailCustom> getArticleDetailList(@Param("userId") Integer userId,
            @Param("articleId") Long articleId);

    List<QwfbArticleDetailCustom> getArticleDetailListDashboard(@Param("userId") Integer userId);

    List<QwfbArticleDetailCustom> getPublishedQueue(@Param("userId") Integer userId);

    // List<LitemallQwfbArticleDetail> getDetailList(@Param("userId") Integer
    // userId,
    // @Param("platformId") Integer platformId, @Param("lastPublishedTime")
    // LocalDateTime lastPublishedTime);

}