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
public class MchUserResponseCode {


    /**
     * 登录信息提示
     */
    public final static Integer LOGIN_STATIC_ERROR = 100001;


    /**
     * 微信登录异常
     */
    public final static Integer WX_LOGIN_ERROR = 100002;


    /**
     * 微信注册异常
     */
    public final static Integer WX_REGISTER_ERROR = 100003;


    /**
     * 手机号登录异常
     */
    public final static Integer PHONE_LOGIN_ERROR = 100004;


    /**
     * 手机号注册异常
     */
    public final static Integer PHONE_REGISTER_ERROR = 100005;


    /**
     * 修改手机号异常
     */
    public final static Integer UPDATE_PHONE_ERROR = 100006;



    /**
     * 设置商户用户异常
     */
    public final static Integer SET_BUSINESS_ERROR = 100007;


    /**
     * 分享二维码异常
     */
    public final static Integer GET_QR_CODE_ERROR = 100008;



    /**
     * 删除商户用户异常
     */
    public final static Integer DELETE_BUSINESS_USER_ERROR = 100009;


    /**
     * 获取商户中的用户异常
     */
    public final static Integer GET_BUSINESS_IN_USER_ERROR = 100010;



    /**
     * 添加商户异常
     */
    public final static Integer ADD_BUSINESS_ERROR = 100011;



    /**
     * 核销订单异常
     */
    public final static Integer VERIFICATION_ORDER_ERROR = 100012;



    /**
     * 商户课程添加或修改异常
     */
    public final static Integer ADD_UPDATE_BUSINESS_COURSE_ERROR = 100013;



    /**
     * 重新提交审核失败
     */
    public final static Integer ANEW_BUSINESS_ERROR = 100014;



    /**
     * 微信第一次注册异常
     */
    public final static Integer WX_FIRST_REGISTER_ERROR = 100015;


    /**
     * 商品上下架异常
     */
    public final static Integer SOLD_OUT_OR_PUTAWAY = 100016;



    /**
     * 商品删除异常
     */
    public final static Integer COURSE_DELETE_ERROR = 100017;

    /**
     * 生成wx二维码失败
     */
    public static final Integer WX_CREATE_QRCODE_ERROR = 100018;
}
