package org.linlinjava.litemall.qwfb.vm;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UpdateArticleVM implements Serializable {
    private static final long serialVersionUID = 1L;

    public Long articleId;
    public Long detailId;
    public String title;
    public String headIconSite;
    public Integer platformId;

    public String publishedUrl;
    public String publishedId;

    public Integer recommendation; // 推荐
    public Integer read; // 阅读
    public Integer comment; // 评论
    public Integer forward; // 转发分享
    public Integer favorites; // 收藏
    public Integer thumbUp; // 点赞

    public Integer status;
    public String statusHint;

    public LocalDateTime lastPublishTime;

}
