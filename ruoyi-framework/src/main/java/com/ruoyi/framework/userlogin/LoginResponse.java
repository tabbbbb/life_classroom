/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LoginResponse
 * Author:   Administrator
 * Date:     2019/12/3 0003 10:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.framework.userlogin;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/3 0003
 * @since 1.0.0
 */

import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.framework.userlogin.token.UserToken;

/**
 * 登录状态返回
 */
public class LoginResponse extends UserResponse {



    private  static UserResponse notLogin(){
        return fail(UserResponseCode.NO_LOGIN,"请登录");
    }

    /**
     * 根据登录信息返回
     * @param loginInfo
     * @return
     */
    public static UserResponse toMessage(UserLoginInfo loginInfo){
        if (loginInfo == null){
            return notLogin();
        }else{
            if (loginInfo.isEnabled()){
                return null;
            }else{
                UserToken.removeLoginCache(loginInfo.getToken());
                return fail(UserResponseCode.LOGIN_STATIC_ERROR,loginInfo.getMessage());
            }
        }

    }



}
