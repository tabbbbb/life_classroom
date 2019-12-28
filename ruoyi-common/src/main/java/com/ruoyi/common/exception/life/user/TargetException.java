/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: TargetException
 * Author:   Administrator
 * Date:     2019/12/20 0020 15:29
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
 * @create 2019/12/20 0020
 * @since 1.0.0
 */
public class TargetException extends RuntimeException {

    private UserResponse userResponse;

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public TargetException(Integer errcode, String errmsg){
        super(errmsg);
        userResponse = UserResponse.fail(errcode,errmsg);
    }

}
