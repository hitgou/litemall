package org.linlinjava.litemall.qwfb.vm;

import java.io.Serializable;
import java.util.List;

public class PublishArticleVM implements Serializable {
    private static final long serialVersionUID = 1L;

    public Long articleId;
    public String title;
    public String content;
    public Byte type;
    public Integer coverMode;
    public Integer status;
    public Integer accountGroupId;
    public String accountGroupName;
    public List<ArticleDetailVM> articleDetailList;

    public PublishArticleVM(Long articleId, String title, String content, Byte type, Integer coverMode, Integer status,
            Integer accountGroupId) {
        this.articleId = articleId;
        this.title = title;
        this.content = content;
        this.type = type;
        this.coverMode = coverMode;
        this.status = status;
        this.accountGroupId = accountGroupId;
    }

    public static class ArticleDetailVM {
        public Long detailId;
        public String title;
        public String content;
        public Integer platform;
        public Integer accountId;
        public String categoryId;
        public String categoryName;
        public Integer status;
        public String statusHint;

        public ArticleDetailVM(Long detailId, String title, String content, Integer platform, Integer accountId,
                String categoryId, String categoryName, Integer status, String statusHint) {
            this.detailId = detailId;
            this.title = title;
            this.content = content;
            this.platform = platform;
            this.accountId = accountId;
            this.categoryId = categoryId;
            this.categoryName = categoryName;
            this.status = status;
            this.statusHint = statusHint;
        }
    }

}
