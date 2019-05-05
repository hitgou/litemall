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

    public PublishArticleVM(Long articleId, Long detailId, String title, String content, Integer platformId,
            Integer accountId, String categoryId, String categoryName, Integer status, String statusHint,
            LocalDateTime lastPublishTime) {
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
        this.lastPublishTime = lastPublishTime;
    }

    public void setArticle(String title, String content, Byte type, Integer coverMode, Integer accountGroupId) {
        if (StringUtil.isNullOrEmpty(this.title)) {
            this.title = title;
        }

        if (StringUtil.isNullOrEmpty(this.content)) {
            this.content = content;
        }

        this.type = type;
        this.coverMode = coverMode;
        this.status = status;
        this.accountGroupId = accountGroupId;
    }

}
