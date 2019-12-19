/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: OrderException
 * Author:   Administrator
 * Date:     2019/12/17 0017 17:40
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
 * @create 2019/12/17 0017
 * @since 1.0.0
 */
public class OrderException extends RuntimeException{

    private UserResponse userResponse;

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public OrderException(Integer errcode, String errmsg){
        super(errmsg);
        userResponse = UserResponse.fail(errcode,errmsg);
    }

}
