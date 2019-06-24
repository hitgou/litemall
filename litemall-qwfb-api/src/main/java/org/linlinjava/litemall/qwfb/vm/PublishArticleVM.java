package org.linlinjava.litemall.qwfb.vm;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.linlinjava.litemall.core.util.StringUtil;

public class PublishArticleVM implements Serializable {
    private static final long serialVersionUID = 1L;

    public Long articleId;
    public String title;
    public String content;
    public Byte type;
    public Integer coverMode;
    public Integer accountGroupId;
    public String accountGroupName;

    public Long detailId;
    public Integer platformId;
    public Integer accountId;
    public String categoryId;
    public String categoryName;
    public Integer status;
    public String statusHint;
    public LocalDateTime lastPublishTime;
    public LocalDateTime publishFetchTime;
    public Boolean deleted;

    public PublishArticleVM(Long articleId, Long detailId, String title, String content, Integer platformId,
            Integer accountId, String categoryId, String categoryName, Integer status, String statusHint,
            Boolean deleted, LocalDateTime lastPublishTime, LocalDateTime publishFetchTime) {
        this.articleId = articleId;
        this.detailId = detailId;
        this.title = title;
        this.content = content;
        this.platformId = platformId;
        this.accountId = accountId;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.status = status;
        this.statusHint = statusHint;
        this.deleted = deleted;
        this.lastPublishTime = lastPublishTime;
        this.publishFetchTime = publishFetchTime;
    }

    public void setArticle(Byte type, Integer coverMode, Integer accountGroupId) {
        this.type = type;
        this.coverMode = coverMode;
        this.accountGroupId = accountGroupId;
    }

}
