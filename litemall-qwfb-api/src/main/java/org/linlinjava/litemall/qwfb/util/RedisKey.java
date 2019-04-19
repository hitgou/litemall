package org.linlinjava.litemall.qwfb.util;

public class RedisKey {
    /**
     * 平台列表
     */
    public static final String Key_Platform_List = "hitgou.platform.list";

    /**
     * 用户验证码， + sessionId
     */
    public static final String Key_Validate = "hitgou.validate";

    /**
     * 用户验证码获取次数， + sessionId
     */
    public static final String Key_Validate_Count = "hitgou.validate.count";

    /**
     * 正在修改密码的key， + sessionId
     */
    public final static String Key_In_ChangePassword = "hitgou.changing.password";

    /**
     * 用户的 account group 数组，用于发布时的选择页面， + userId
     */
    public static final String Key_publish_account_group_list = "hitgou.publish.account.group.list";

    // public static String getKey(String prefix, String... keys) {
    // return prefix + "_" + String.join("_", keys);
    // }

    public static String getKey(String... keys) {
        return String.join("_", keys);
    }

    public static String getKey(String prefix, Integer id) {
        return prefix + "_" + id;
    }

}
