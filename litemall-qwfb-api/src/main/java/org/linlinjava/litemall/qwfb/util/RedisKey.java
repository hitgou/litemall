package org.linlinjava.litemall.qwfb.util;

import java.util.ArrayList;
import java.util.List;

public class RedisKey {
    /**
     * 平台列表
     */
    public static final String Key_Platform_List = "pf:list";

    // ====================== 用户登录相关 =====================//

    /**
     * 用户验证码， + sessionId
     */
    public static final String Key_Validate = "val";

    /**
     * sessionId 对应的用户id
     */
    public static final String Key_SessionId_UserId_ = "sessionId:%s:userId:";

    /**
     * 用户验证码获取次数， + sessionId
     */
    public static final String Key_Validate_Count = "val:count";

    /**
     * 正在修改密码的key， + sessionId
     */
    public final static String Key_In_ChangePassword = "ch:pwd";

    /**
     * 用户的 account group 数组，用于发布时的选择页面， + userId
     */
    public static final String Key_publish_account_group_list = "pub:acc:grp:lst";

    // ====================== redis 文章相关 =====================//
    /**
     * 用户的 account group 数组，用于发布时的选择页面， + userId<br>
     * 登录的时候加载该集合，保存用户30天以内的未发布完成的文章集合，用title作为key
     */
    public static final String Key_article_no_published_set = "arc:no:pub:set";

    // ====================== socket 消息相关 =====================//
    public static final String Key_message = "msg";

    public static final String Key_message_clientList = "msg:clientList";
    public static final String Key_message_clientId_token_ = "msg:clientId:%s:token:";
    public static final String Key_message_token_clientId_ = "msg:token:%s:clientId:";
    public static final String Key_message_userId_clientId_ = "msg:userId:%d:clientId:";

    // public static String getKey(String prefix, String... keys) {
    // return prefix + "_" + String.join("_", keys);
    // }

    public static String getKey(String key, Object... args) {
        return String.format(key, args);
    }

    // public static String getKey(String key) {
    // return key;
    // }

    // public static String getKey(String... keys) {
    // return String.join("_", keys);
    // }

    // public static String getKey(String prefix, Integer userId) {
    // return prefix + "_" + userId;
    // }

    // public static String getKey(String prefix, Integer... ids) {
    // List<String> idList = new ArrayList<>();
    // for (int i = 0; i < ids.length; i++) {
    // idList.add(ids[i].toString());
    // }
    //
    // return prefix + "_" + String.join("_", idList);
    // }

}
