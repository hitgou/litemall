package org.linlinjava.litemall.qwfb.vm;

import java.util.Map;

import org.linlinjava.litemall.db.domain.LitemallQwfbArticleDetail;

public class ArticleStepVM {
    private Long articleId;
    private Integer accountGroupId;
    private Map<String, LitemallQwfbArticleDetail> articleDetails;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Integer getAccountGroupId() {
        return accountGroupId;
    }

    public void setAccountGroupId(Integer accountGroupId) {
        this.accountGroupId = accountGroupId;
    }

    public Map<String, LitemallQwfbArticleDetail> getArticleDetails() {
        return articleDetails;
    }

    public void setArticleDetails(Map<String, LitemallQwfbArticleDetail> articleDetails) {
        this.articleDetails = articleDetails;
    }
}
