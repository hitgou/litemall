package org.linlinjava.litemall.qwfb.util;

public class RedisKey {
    /**
     * 用户验证码
     */
    public static final String Key_Validate = "hitgou.validate";

    /**
     * 用户验证码获取次数
     */
    public static final String Key_Validate_Count = "hitgou.validate.count";

    /**
     * 正在修改密码的key
     */
    public final static String Key_In_ChangePassword = "hitgou.changing.password";

    // public static String getKey(String prefix, String... keys) {
    // return prefix + "_" + String.join("_", keys);
    // }

    public static String getKey(String... keys) {
        return String.join("_", keys);
    }

}
