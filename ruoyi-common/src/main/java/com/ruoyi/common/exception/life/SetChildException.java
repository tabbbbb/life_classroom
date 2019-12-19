/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SetChildException
 * Author:   Administrator
 * Date:     2019/12/19 0019 15:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.exception.life;

import com.ruoyi.common.response.UserResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/19 0019
 * @since 1.0.0
 */
public class SetChildException extends RuntimeException{
    private UserResponse userResponse;

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public SetChildException(Integer errcode, String errmsg){
        super(errmsg);
        userResponse = UserResponse.fail(errcode,errmsg);
    }

}
