package org.linlinjava.litemall.qwfb.util;

public class ResponseCode {
    public static final Integer ADMIN_INVALID_NAME = 601;
    public static final Integer ADMIN_INVALID_PASSWORD = 602;
    public static final Integer ADMIN_NAME_EXIST = 602;
    public static final Integer ADMIN_ALTER_NOT_ALLOWED = 603;
    public static final Integer ADMIN_DELETE_NOT_ALLOWED = 604;
    public static final Integer ADMIN_INVALID_ACCOUNT = 605;
    public static final Integer GOODS_UPDATE_NOT_ALLOWED = 610;
    public static final Integer GOODS_NAME_EXIST = 611;
    public static final Integer ORDER_CONFIRM_NOT_ALLOWED = 620;
    public static final Integer ORDER_REFUND_FAILED = 621;
    public static final Integer ORDER_REPLY_EXIST = 622;
    public static final Integer USER_INVALID_NAME = 630;
    public static final Integer USER_INVALID_PASSWORD = 631;
    public static final Integer USER_INVALID_MOBILE = 632;
    public static final Integer USER_NAME_EXIST = 633;
    public static final Integer USER_MOBILE_EXIST = 634;
    public static final Integer ROLE_NAME_EXIST = 640;
    public static final Integer ROLE_SUPER_SUPERMISSION = 641;

    // 注册相关
    public static final Integer USER_INVALID_InvationCode = 450; // 无效的邀请码
    public static final Integer USER_Tel_Need_Validate = 451; // 手机号码已存在
    public static final Integer USER_INVALID_Tel_Exist = 459; // 手机号码已存在
    public static final Integer USER_INVALID_Validation_Code_Exist = 461; // 手机验证码不正确
    public static final Integer USER_INVALID_Password_Not_Equal = 462; // 手机验证码不正确
    // public static final Integer USER_INVALID_InvationCode = 490; // 无效的邀请码

}
