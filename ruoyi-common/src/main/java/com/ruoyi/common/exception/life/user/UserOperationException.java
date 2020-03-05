/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: UserOperationException
 * Author:   Administrator
 * Date:     2020-03-05 15:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.exception.life.user;

import com.ruoyi.common.response.UserResponse;

/**
* 用户操作异常
 */
public class UserOperationException extends RuntimeException {
    private UserResponse userResponse;

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public UserOperationException(Integer errcode, String errmsg){
        super(errmsg);
        userResponse = UserResponse.fail(errcode,errmsg);
    }
}
