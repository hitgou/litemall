package org.linlinjava.litemall.message.socket;

import java.util.ArrayList;
import java.util.List;

public class MessageKey {
    // ====================== 用户登录相关 =====================//
    /**
     * 登录返回结果列表
     */
    public static final String Key_Login_Result = "loginResult";

    /**
     * 文章发生变化
     */
    public static final String Key_Article_Changed = "articleChanged";

    // public static String getKey(String prefix, String... keys) {
    // return prefix + "_" + String.join("_", keys);
    // }

    public static String getKey(String key) {
        return key;
    }

    public static String getKey(String... keys) {
        return String.join("_", keys);
    }

    public static String getKey(String prefix, Integer userId) {
        return prefix + "_" + userId;
    }

    public static String getKey(String prefix, Integer... ids) {
        List<String> idList = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            idList.add(ids[i].toString());
        }

        return prefix + "_" + String.join("_", idList);
    }

}
