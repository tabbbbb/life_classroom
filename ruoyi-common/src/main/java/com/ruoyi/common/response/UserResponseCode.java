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




}
