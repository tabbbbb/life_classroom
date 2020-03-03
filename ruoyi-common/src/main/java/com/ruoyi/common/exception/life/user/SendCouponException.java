/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: SendCouponException
 * Author:   Administrator
 * Date:     2020/3/3 0003 16:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.exception.life.user;

import com.ruoyi.common.response.UserResponse;

/**
 *优惠券赠送异常
 */
public class SendCouponException extends RuntimeException{
    private UserResponse userResponse;

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public SendCouponException(Integer errcode, String errmsg){
        super(errmsg);
        userResponse = UserResponse.fail(errcode,errmsg);
    }
}
