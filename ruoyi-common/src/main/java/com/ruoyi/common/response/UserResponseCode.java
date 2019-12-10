/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: UserResponseCode
 * Author:   Administrator
 * Date:     2019/11/30 0030 17:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.response;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/30 0030
 * @since 1.0.0
 */
public class UserResponseCode {

    /**
     * 成功
     */
    public static final Integer SUCCEED = 111111;

    /**
     * 错误
     */
    public static final Integer ERROR = 100000;

    /**
     * 未登录
     */
    public static final Integer NO_LOGIN = 100001;

    /**
     * 注册错误（添加用户失败）
     */
    public static final Integer REGISTER_ERROR = 100002;

    /**
     * 验证码错误
     */
    public static final Integer CODE_ERROR = 100003;

    /**
     * 绑定或修改手机号错误
     */
    public static final Integer BIND_PHONE_ERROR = 100004;


    /**
     * 绑定微信错误
     */
    public static final Integer BIND_WX_ERROR = 100005;


    /**
     * 设置密码错误
     */
    public static final Integer SET_PASSWORD_ERROR = 100006;


    /**
     * 密码已存在，不能设置
     */
    public static final Integer PASSWORD_EXIST_ERROR = 100007;


    /**
     * 登录状态异常
     */
    public static final  Integer LOGIN_STATIC_ERROR = 100008;


    /**
     * 修改时间到期
     */
    public static final Integer UPDATE_TIME_PAST = 100009;


    /**
     * 手机号未注册
     */
    public static final Integer PHONE_NOT_REGISTER = 100010;


    /**
     * 登录密码输入错误
     */
    public static final Integer LOGIN_PASSWORD_ERROR = 100011;


    /**
     * 微信登录错误
     */
    public static final Integer WX_LOGIN_ERROR = 100012;


    /**
     * 文件上传错误
     */
    public static final Integer UP_FILE_ERROR = 100013;


    /**
     * 头像修改错误
     */
    public static final Integer USER_AVATAR_UPDATE_ERROR = 100014;


    /**
     * 昵称修改错误
     */
    public static final Integer USER_NICKNAME_UPDATE_ERROR = 100015;


    /**
     * 生日修改错误
     */
    public static final Integer USER_BIRTHDAY_UPDATE_ERROR = 100016;



    /**
     * 性别修改错误
     */
    public static final Integer USER_SEX_UPDATE_ERROR = 100017;



    /**
     * 地址修改错误
     */
    public static final Integer USER_ADDRESS_UPDATE_ERROR = 100017;



    /**
     * 绑定家属错误
     */
    public static final Integer USER_BIND_RELATION_UPDATE_ERROR = 100017;


    /**
     * 修改用户信息错误
     */
    public static final Integer USER_UPDATE_INFO_ERROR = 100018;


    /**
     * 充值错误
     */
    public static final Integer USER_RECHARGE_ERROR = 100019;


    /**
     * 添加小孩错误
     */
    public static final Integer USER_ADD_CHILD_ERROR = 100020;


    /**
     * 绑定小孩错误
     */
    public static final Integer USER_BIND_CHILD_ERROR = 100021;


}
