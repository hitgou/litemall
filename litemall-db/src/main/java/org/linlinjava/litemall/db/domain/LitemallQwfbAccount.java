package org.linlinjava.litemall.db.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class LitemallQwfbAccount implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static final Boolean NOT_DELETED = false;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static final Boolean IS_DELETED = true;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.login_name
     *
     * @mbg.generated
     */
    private String loginName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.login_style
     *
     * @mbg.generated
     */
    private String loginStyle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.show_name
     *
     * @mbg.generated
     */
    private String showName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.head_icon
     *
     * @mbg.generated
     */
    private String headIcon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.head_icon_site
     *
     * @mbg.generated
     */
    private String headIconSite;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.platform_id
     *
     * @mbg.generated
     */
    private Integer platformId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.account_group_id
     *
     * @mbg.generated
     */
    private Integer accountGroupId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.sorted
     *
     * @mbg.generated
     */
    private Integer sorted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.auth_token
     *
     * @mbg.generated
     */
    private String authToken;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.expired
     *
     * @mbg.generated
     */
    private Integer expired;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.last_login_time
     *
     * @mbg.generated
     */
    private LocalDateTime lastLoginTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.add_time
     *
     * @mbg.generated
     */
    private LocalDateTime addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.update_time
     *
     * @mbg.generated
     */
    private LocalDateTime updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_qwfb_account.deleted
     *
     * @mbg.generated
     */
    private Boolean deleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.id
     *
     * @return the value of litemall_qwfb_account.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.id
     *
     * @param id the value for litemall_qwfb_account.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.login_name
     *
     * @return the value of litemall_qwfb_account.login_name
     *
     * @mbg.generated
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.login_name
     *
     * @param loginName the value for litemall_qwfb_account.login_name
     *
     * @mbg.generated
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.password
     *
     * @return the value of litemall_qwfb_account.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.password
     *
     * @param password the value for litemall_qwfb_account.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.login_style
     *
     * @return the value of litemall_qwfb_account.login_style
     *
     * @mbg.generated
     */
    public String getLoginStyle() {
        return loginStyle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.login_style
     *
     * @param loginStyle the value for litemall_qwfb_account.login_style
     *
     * @mbg.generated
     */
    public void setLoginStyle(String loginStyle) {
        this.loginStyle = loginStyle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.show_name
     *
     * @return the value of litemall_qwfb_account.show_name
     *
     * @mbg.generated
     */
    public String getShowName() {
        return showName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.show_name
     *
     * @param showName the value for litemall_qwfb_account.show_name
     *
     * @mbg.generated
     */
    public void setShowName(String showName) {
        this.showName = showName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.head_icon
     *
     * @return the value of litemall_qwfb_account.head_icon
     *
     * @mbg.generated
     */
    public String getHeadIcon() {
        return headIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.head_icon
     *
     * @param headIcon the value for litemall_qwfb_account.head_icon
     *
     * @mbg.generated
     */
    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.head_icon_site
     *
     * @return the value of litemall_qwfb_account.head_icon_site
     *
     * @mbg.generated
     */
    public String getHeadIconSite() {
        return headIconSite;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.head_icon_site
     *
     * @param headIconSite the value for litemall_qwfb_account.head_icon_site
     *
     * @mbg.generated
     */
    public void setHeadIconSite(String headIconSite) {
        this.headIconSite = headIconSite;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.platform_id
     *
     * @return the value of litemall_qwfb_account.platform_id
     *
     * @mbg.generated
     */
    public Integer getPlatformId() {
        return platformId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.platform_id
     *
     * @param platformId the value for litemall_qwfb_account.platform_id
     *
     * @mbg.generated
     */
    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.account_group_id
     *
     * @return the value of litemall_qwfb_account.account_group_id
     *
     * @mbg.generated
     */
    public Integer getAccountGroupId() {
        return accountGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.account_group_id
     *
     * @param accountGroupId the value for litemall_qwfb_account.account_group_id
     *
     * @mbg.generated
     */
    public void setAccountGroupId(Integer accountGroupId) {
        this.accountGroupId = accountGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.user_id
     *
     * @return the value of litemall_qwfb_account.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.user_id
     *
     * @param userId the value for litemall_qwfb_account.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.sorted
     *
     * @return the value of litemall_qwfb_account.sorted
     *
     * @mbg.generated
     */
    public Integer getSorted() {
        return sorted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.sorted
     *
     * @param sorted the value for litemall_qwfb_account.sorted
     *
     * @mbg.generated
     */
    public void setSorted(Integer sorted) {
        this.sorted = sorted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.auth_token
     *
     * @return the value of litemall_qwfb_account.auth_token
     *
     * @mbg.generated
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.auth_token
     *
     * @param authToken the value for litemall_qwfb_account.auth_token
     *
     * @mbg.generated
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.expired
     *
     * @return the value of litemall_qwfb_account.expired
     *
     * @mbg.generated
     */
    public Integer getExpired() {
        return expired;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.expired
     *
     * @param expired the value for litemall_qwfb_account.expired
     *
     * @mbg.generated
     */
    public void setExpired(Integer expired) {
        this.expired = expired;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.last_login_time
     *
     * @return the value of litemall_qwfb_account.last_login_time
     *
     * @mbg.generated
     */
    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.last_login_time
     *
     * @param lastLoginTime the value for litemall_qwfb_account.last_login_time
     *
     * @mbg.generated
     */
    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.add_time
     *
     * @return the value of litemall_qwfb_account.add_time
     *
     * @mbg.generated
     */
    public LocalDateTime getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.add_time
     *
     * @param addTime the value for litemall_qwfb_account.add_time
     *
     * @mbg.generated
     */
    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.update_time
     *
     * @return the value of litemall_qwfb_account.update_time
     *
     * @mbg.generated
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.update_time
     *
     * @param updateTime the value for litemall_qwfb_account.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_qwfb_account.deleted
     *
     * @return the value of litemall_qwfb_account.deleted
     *
     * @mbg.generated
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_qwfb_account.deleted
     *
     * @param deleted the value for litemall_qwfb_account.deleted
     *
     * @mbg.generated
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
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
        sb.append(", loginName=").append(loginName);
        sb.append(", password=").append(password);
        sb.append(", loginStyle=").append(loginStyle);
        sb.append(", showName=").append(showName);
        sb.append(", headIcon=").append(headIcon);
        sb.append(", headIconSite=").append(headIconSite);
        sb.append(", platformId=").append(platformId);
        sb.append(", accountGroupId=").append(accountGroupId);
        sb.append(", userId=").append(userId);
        sb.append(", sorted=").append(sorted);
        sb.append(", authToken=").append(authToken);
        sb.append(", expired=").append(expired);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
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
        LitemallQwfbAccount other = (LitemallQwfbAccount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getLoginStyle() == null ? other.getLoginStyle() == null : this.getLoginStyle().equals(other.getLoginStyle()))
            && (this.getShowName() == null ? other.getShowName() == null : this.getShowName().equals(other.getShowName()))
            && (this.getHeadIcon() == null ? other.getHeadIcon() == null : this.getHeadIcon().equals(other.getHeadIcon()))
            && (this.getHeadIconSite() == null ? other.getHeadIconSite() == null : this.getHeadIconSite().equals(other.getHeadIconSite()))
            && (this.getPlatformId() == null ? other.getPlatformId() == null : this.getPlatformId().equals(other.getPlatformId()))
            && (this.getAccountGroupId() == null ? other.getAccountGroupId() == null : this.getAccountGroupId().equals(other.getAccountGroupId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSorted() == null ? other.getSorted() == null : this.getSorted().equals(other.getSorted()))
            && (this.getAuthToken() == null ? other.getAuthToken() == null : this.getAuthToken().equals(other.getAuthToken()))
            && (this.getExpired() == null ? other.getExpired() == null : this.getExpired().equals(other.getExpired()))
            && (this.getLastLoginTime() == null ? other.getLastLoginTime() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getLoginStyle() == null) ? 0 : getLoginStyle().hashCode());
        result = prime * result + ((getShowName() == null) ? 0 : getShowName().hashCode());
        result = prime * result + ((getHeadIcon() == null) ? 0 : getHeadIcon().hashCode());
        result = prime * result + ((getHeadIconSite() == null) ? 0 : getHeadIconSite().hashCode());
        result = prime * result + ((getPlatformId() == null) ? 0 : getPlatformId().hashCode());
        result = prime * result + ((getAccountGroupId() == null) ? 0 : getAccountGroupId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSorted() == null) ? 0 : getSorted().hashCode());
        result = prime * result + ((getAuthToken() == null) ? 0 : getAuthToken().hashCode());
        result = prime * result + ((getExpired() == null) ? 0 : getExpired().hashCode());
        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public void andLogicalDeleted(boolean deleted) {
        setDeleted(deleted ? IS_DELETED : NOT_DELETED);
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        id("id", "id", "INTEGER", false),
        loginName("login_name", "loginName", "VARCHAR", false),
        password("password", "password", "VARCHAR", true),
        loginStyle("login_style", "loginStyle", "VARCHAR", false),
        showName("show_name", "showName", "VARCHAR", false),
        headIcon("head_icon", "headIcon", "VARCHAR", false),
        headIconSite("head_icon_site", "headIconSite", "VARCHAR", false),
        platformId("platform_id", "platformId", "INTEGER", false),
        accountGroupId("account_group_id", "accountGroupId", "INTEGER", false),
        userId("user_id", "userId", "INTEGER", false),
        sorted("sorted", "sorted", "INTEGER", false),
        authToken("auth_token", "authToken", "VARCHAR", false),
        expired("expired", "expired", "INTEGER", false),
        lastLoginTime("last_login_time", "lastLoginTime", "TIMESTAMP", false),
        addTime("add_time", "addTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        deleted("deleted", "deleted", "BIT", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_qwfb_account
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_qwfb_account
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_qwfb_account
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_qwfb_account
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_qwfb_account
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_qwfb_account
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_qwfb_account
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_qwfb_account
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_qwfb_account
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_qwfb_account
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_qwfb_account
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
         * This method corresponds to the database table litemall_qwfb_account
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_qwfb_account
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_qwfb_account
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
         * This method corresponds to the database table litemall_qwfb_account
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