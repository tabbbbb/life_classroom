/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: RechargerException
 * Author:   Administrator
 * Date:     2019/12/10 0010 15:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.exception.life.user;

import com.ruoyi.common.response.UserResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/10 0010
 * @since 1.0.0
 */
public class RechargerException extends RuntimeException{

    private UserResponse userResponse;

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public RechargerException(Integer errcode, String errmsg,Long userId){
        super(errmsg);
        userResponse = UserResponse.fail(errcode,errmsg+"，用户编号："+userId);
    }


}
