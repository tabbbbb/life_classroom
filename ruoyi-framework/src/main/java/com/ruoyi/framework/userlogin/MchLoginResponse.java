package com.ruoyi.framework.userlogin;

import com.ruoyi.common.response.MchUserResponse;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.framework.userlogin.info.MchUserLoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.framework.userlogin.token.UserToken;

public class MchLoginResponse extends MchUserResponse {


    private  static MchUserResponse notLogin(){
        return fail(UserResponseCode.NO_LOGIN,"请登录");
    }

    /**
     * 根据登录信息返回
     * @param mchLoginInfo
     * @return
     */
    public static MchUserResponse toMessage(MchUserLoginInfo mchLoginInfo){
        if (mchLoginInfo == null){
            return notLogin();
        }else{
            if (mchLoginInfo.isEnabled()){
                return null;
            }else{
                UserToken.removeLoginCache(mchLoginInfo.getToken());
                return fail(UserResponseCode.LOGIN_STATIC_ERROR,mchLoginInfo.getMessage());
            }
        }

    }

}
