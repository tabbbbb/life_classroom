/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: MchLoginResponse
 * Author:   Administrator
 * Date:     2020-03-14 11:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.framework.userlogin;

import com.ruoyi.common.response.MchResponse;
import com.ruoyi.common.response.MchUserResponseCode;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.framework.userlogin.info.MchUserLoginInfo;
import com.ruoyi.framework.userlogin.token.UserToken;

/**
 * 根据商户登录状态返回
 */
public class MchLoginResponse extends MchResponse  {

    private  static MchResponse notLogin(){
        return fail(UserResponseCode.NO_LOGIN,"请登录");
    }

    /**
     * 根据登录信息返回
     * @param loginInfo
     * @return
     */
    public static MchResponse toMessage(MchUserLoginInfo loginInfo){
        if (loginInfo == null){
            return notLogin();
        }else{
            if (loginInfo.isEnabled()){
                return null;
            }else{
                UserToken.removeLoginCache(loginInfo.getToken());
                return fail(MchUserResponseCode.LOGIN_STATIC_ERROR,loginInfo.getMessage());
            }
        }

    }

}
