package org.linlinjava.litemall.db.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class LitemallQwfbArticleDetail {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table litemall_qwfb_article_detail
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static final Boolean NOT_DELETED = false;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table litemall_qwfb_article_detail
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static final Boolean IS_DELETED = true;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.title
     *
     * @mbg.generated
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.article_id
     *
     * @mbg.generated
     */
    private Integer articleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.account_group_id
     *
     * @mbg.generated
     */
    private Integer accountGroupId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.platform_id
     *
     * @mbg.generated
     */
    private Integer platformId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.account_id
     *
     * @mbg.generated
     */
    private Integer accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.category_id
     *
     * @mbg.generated
     */
    private Integer categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.category_name
     *
     * @mbg.generated
     */
    private String categoryName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.published_url
     *
     * @mbg.generated
     */
    private String publishedUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.published_id
     *
     * @mbg.generated
     */
    private String publishedId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.published_type
     *
     * @mbg.generated
     */
    private Integer publishedType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.published_attempt_times
     *
     * @mbg.generated
     */
    private Integer publishedAttemptTimes;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.last_published_time
     *
     * @mbg.generated
     */
    private LocalDateTime lastPublishedTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.statusHint
     *
     * @mbg.generated
     */
    private String statushint;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.add_time
     *
     * @mbg.generated
     */
    private LocalDateTime addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.update_time
     *
     * @mbg.generated
     */
    private LocalDateTime updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.deleted
     *
     * @mbg.generated
     */
    private Boolean deleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_article_detail.content
     *
     * @mbg.generated
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.id
     *
     * @return the value of litemall_qwfb_article_detail.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.id
     *
     * @param id the value for litemall_qwfb_article_detail.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.title
     *
     * @return the value of litemall_qwfb_article_detail.title
     *
     * @mbg.generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.title
     *
     * @param title the value for litemall_qwfb_article_detail.title
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.user_id
     *
     * @return the value of litemall_qwfb_article_detail.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.user_id
     *
     * @param userId the value for litemall_qwfb_article_detail.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.article_id
     *
     * @return the value of litemall_qwfb_article_detail.article_id
     *
     * @mbg.generated
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.article_id
     *
     * @param articleId the value for litemall_qwfb_article_detail.article_id
     *
     * @mbg.generated
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.account_group_id
     *
     * @return the value of litemall_qwfb_article_detail.account_group_id
     *
     * @mbg.generated
     */
    public Integer getAccountGroupId() {
        return accountGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.account_group_id
     *
     * @param accountGroupId the value for litemall_qwfb_article_detail.account_group_id
     *
     * @mbg.generated
     */
    public void setAccountGroupId(Integer accountGroupId) {
        this.accountGroupId = accountGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.platform_id
     *
     * @return the value of litemall_qwfb_article_detail.platform_id
     *
     * @mbg.generated
     */
    public Integer getPlatformId() {
        return platformId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.platform_id
     *
     * @param platformId the value for litemall_qwfb_article_detail.platform_id
     *
     * @mbg.generated
     */
    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.account_id
     *
     * @return the value of litemall_qwfb_article_detail.account_id
     *
     * @mbg.generated
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.account_id
     *
     * @param accountId the value for litemall_qwfb_article_detail.account_id
     *
     * @mbg.generated
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.category_id
     *
     * @return the value of litemall_qwfb_article_detail.category_id
     *
     * @mbg.generated
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.category_id
     *
     * @param categoryId the value for litemall_qwfb_article_detail.category_id
     *
     * @mbg.generated
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.category_name
     *
     * @return the value of litemall_qwfb_article_detail.category_name
     *
     * @mbg.generated
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.category_name
     *
     * @param categoryName the value for litemall_qwfb_article_detail.category_name
     *
     * @mbg.generated
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.published_url
     *
     * @return the value of litemall_qwfb_article_detail.published_url
     *
     * @mbg.generated
     */
    public String getPublishedUrl() {
        return publishedUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.published_url
     *
     * @param publishedUrl the value for litemall_qwfb_article_detail.published_url
     *
     * @mbg.generated
     */
    public void setPublishedUrl(String publishedUrl) {
        this.publishedUrl = publishedUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.published_id
     *
     * @return the value of litemall_qwfb_article_detail.published_id
     *
     * @mbg.generated
     */
    public String getPublishedId() {
        return publishedId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.published_id
     *
     * @param publishedId the value for litemall_qwfb_article_detail.published_id
     *
     * @mbg.generated
     */
    public void setPublishedId(String publishedId) {
        this.publishedId = publishedId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.published_type
     *
     * @return the value of litemall_qwfb_article_detail.published_type
     *
     * @mbg.generated
     */
    public Integer getPublishedType() {
        return publishedType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.published_type
     *
     * @param publishedType the value for litemall_qwfb_article_detail.published_type
     *
     * @mbg.generated
     */
    public void setPublishedType(Integer publishedType) {
        this.publishedType = publishedType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.published_attempt_times
     *
     * @return the value of litemall_qwfb_article_detail.published_attempt_times
     *
     * @mbg.generated
     */
    public Integer getPublishedAttemptTimes() {
        return publishedAttemptTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.published_attempt_times
     *
     * @param publishedAttemptTimes the value for litemall_qwfb_article_detail.published_attempt_times
     *
     * @mbg.generated
     */
    public void setPublishedAttemptTimes(Integer publishedAttemptTimes) {
        this.publishedAttemptTimes = publishedAttemptTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.last_published_time
     *
     * @return the value of litemall_qwfb_article_detail.last_published_time
     *
     * @mbg.generated
     */
    public LocalDateTime getLastPublishedTime() {
        return lastPublishedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.last_published_time
     *
     * @param lastPublishedTime the value for litemall_qwfb_article_detail.last_published_time
     *
     * @mbg.generated
     */
    public void setLastPublishedTime(LocalDateTime lastPublishedTime) {
        this.lastPublishedTime = lastPublishedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.status
     *
     * @return the value of litemall_qwfb_article_detail.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.status
     *
     * @param status the value for litemall_qwfb_article_detail.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.statusHint
     *
     * @return the value of litemall_qwfb_article_detail.statusHint
     *
     * @mbg.generated
     */
    public String getStatushint() {
        return statushint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.statusHint
     *
     * @param statushint the value for litemall_qwfb_article_detail.statusHint
     *
     * @mbg.generated
     */
    public void setStatushint(String statushint) {
        this.statushint = statushint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.add_time
     *
     * @return the value of litemall_qwfb_article_detail.add_time
     *
     * @mbg.generated
     */
    public LocalDateTime getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.add_time
     *
     * @param addTime the value for litemall_qwfb_article_detail.add_time
     *
     * @mbg.generated
     */
    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.update_time
     *
     * @return the value of litemall_qwfb_article_detail.update_time
     *
     * @mbg.generated
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.update_time
     *
     * @param updateTime the value for litemall_qwfb_article_detail.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.deleted
     *
     * @return the value of litemall_qwfb_article_detail.deleted
     *
     * @mbg.generated
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.deleted
     *
     * @param deleted the value for litemall_qwfb_article_detail.deleted
     *
     * @mbg.generated
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_article_detail.content
     *
     * @return the value of litemall_qwfb_article_detail.content
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_article_detail.content
     *
     * @param content the value for litemall_qwfb_article_detail.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_article_detail
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", userId=").append(userId);
        sb.append(", articleId=").append(articleId);
        sb.append(", accountGroupId=").append(accountGroupId);
        sb.append(", platformId=").append(platformId);
        sb.append(", accountId=").append(accountId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", publishedUrl=").append(publishedUrl);
        sb.append(", publishedId=").append(publishedId);
        sb.append(", publishedType=").append(publishedType);
        sb.append(", publishedAttemptTimes=").append(publishedAttemptTimes);
        sb.append(", lastPublishedTime=").append(lastPublishedTime);
        sb.append(", status=").append(status);
        sb.append(", statushint=").append(statushint);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_article_detail
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LitemallQwfbArticleDetail other = (LitemallQwfbArticleDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getArticleId() == null ? other.getArticleId() == null : this.getArticleId().equals(other.getArticleId()))
            && (this.getAccountGroupId() == null ? other.getAccountGroupId() == null : this.getAccountGroupId().equals(other.getAccountGroupId()))
            && (this.getPlatformId() == null ? other.getPlatformId() == null : this.getPlatformId().equals(other.getPlatformId()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getCategoryName() == null ? other.getCategoryName() == null : this.getCategoryName().equals(other.getCategoryName()))
            && (this.getPublishedUrl() == null ? other.getPublishedUrl() == null : this.getPublishedUrl().equals(other.getPublishedUrl()))
            && (this.getPublishedId() == null ? other.getPublishedId() == null : this.getPublishedId().equals(other.getPublishedId()))
            && (this.getPublishedType() == null ? other.getPublishedType() == null : this.getPublishedType().equals(other.getPublishedType()))
            && (this.getPublishedAttemptTimes() == null ? other.getPublishedAttemptTimes() == null : this.getPublishedAttemptTimes().equals(other.getPublishedAttemptTimes()))
            && (this.getLastPublishedTime() == null ? other.getLastPublishedTime() == null : this.getLastPublishedTime().equals(other.getLastPublishedTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getStatushint() == null ? other.getStatushint() == null : this.getStatushint().equals(other.getStatushint()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_article_detail
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getArticleId() == null) ? 0 : getArticleId().hashCode());
        result = prime * result + ((getAccountGroupId() == null) ? 0 : getAccountGroupId().hashCode());
        result = prime * result + ((getPlatformId() == null) ? 0 : getPlatformId().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getCategoryName() == null) ? 0 : getCategoryName().hashCode());
        result = prime * result + ((getPublishedUrl() == null) ? 0 : getPublishedUrl().hashCode());
        result = prime * result + ((getPublishedId() == null) ? 0 : getPublishedId().hashCode());
        result = prime * result + ((getPublishedType() == null) ? 0 : getPublishedType().hashCode());
        result = prime * result + ((getPublishedAttemptTimes() == null) ? 0 : getPublishedAttemptTimes().hashCode());
        result = prime * result + ((getLastPublishedTime() == null) ? 0 : getLastPublishedTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getStatushint() == null) ? 0 : getStatushint().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_article_detail
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public void andLogicalDeleted(boolean deleted) {
        setDeleted(deleted ? IS_DELETED : NOT_DELETED);
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table litemall_qwfb_article_detail
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        id("id", "id", "BIGINT", false),
        title("title", "title", "VARCHAR", false),
        userId("user_id", "userId", "INTEGER", false),
        articleId("article_id", "articleId", "INTEGER", false),
        accountGroupId("account_group_id", "accountGroupId", "INTEGER", false),
        platformId("platform_id", "platformId", "INTEGER", false),
        accountId("account_id", "accountId", "INTEGER", false),
        categoryId("category_id", "categoryId", "INTEGER", false),
        categoryName("category_name", "categoryName", "VARCHAR", false),
        publishedUrl("published_url", "publishedUrl", "VARCHAR", false),
        publishedId("published_id", "publishedId", "VARCHAR", false),
        publishedType("published_type", "publishedType", "INTEGER", false),
        publishedAttemptTimes("published_attempt_times", "publishedAttemptTimes", "INTEGER", false),
        lastPublishedTime("last_published_time", "lastPublishedTime", "TIMESTAMP", false),
        status("status", "status", "INTEGER", true),
        statushint("statusHint", "statushint", "VARCHAR", false),
        addTime("add_time", "addTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        deleted("deleted", "deleted", "BIT", false),
        content("content", "content", "LONGVARCHAR", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_qwfb_article_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_qwfb_article_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_qwfb_article_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_qwfb_article_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_qwfb_article_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_qwfb_article_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_qwfb_article_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_qwfb_article_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_qwfb_article_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_qwfb_article_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_qwfb_article_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_qwfb_article_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_qwfb_article_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_qwfb_article_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_qwfb_article_detail
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }
    }
}