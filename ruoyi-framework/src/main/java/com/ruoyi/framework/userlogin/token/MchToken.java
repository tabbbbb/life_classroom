/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: MchToken
 * Author:   Administrator
 * Date:     2020-03-14 10:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.framework.userlogin.token;

import com.ruoyi.common.utils.CharUtil;
import com.ruoyi.framework.userlogin.annotation.MchLoginInfo;
import com.ruoyi.framework.userlogin.info.MchUserLoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 商户token
 */
public class MchToken {
    private static Map<String, MchUserLoginInfo> mchTokenMap = new Hashtable<>();

    private static Map<Long,MchUserLoginInfo> mchIdTokenMap = new Hashtable<>();

    /**
     * 获取token
     * @param token
     * @return
     */
    public static boolean getTokenFlag(String token){
        MchUserLoginInfo mchLoginInfo = get(token);
        if (mchLoginInfo != null) {
            if (mchLoginInfo.getEndTime().plusDays(1).isBefore(LocalDateTime.now())){
                removeLoginCache(token);
                return false;
            }
            return true;
        }else{
            return false;
        }
    }


    public static MchUserLoginInfo get(String key){
        return mchTokenMap.get(key);
    }




    public static MchUserLoginInfo addToken(Long id){
        if (mchIdTokenMap.containsKey(id)){
            setTokenMapStatus(id);
        }
        String token = CharUtil.getRandomString(32);
        while (mchTokenMap.containsKey(token)){
            token = CharUtil.getRandomString(32);
        }
        MchUserLoginInfo mchLoginInfo = new MchUserLoginInfo();
        mchLoginInfo.setId(id);
        mchLoginInfo.setEnabled(true);
        mchLoginInfo.setEndTime(LocalDateTime.now());
        mchLoginInfo.setToken(token);
        mchTokenMap.put(mchLoginInfo.getToken(),mchLoginInfo);
        mchIdTokenMap.put(id,mchLoginInfo);
        return mchLoginInfo;
    }


    private static void setTokenMapStatus(Long id){
        MchUserLoginInfo mchLoginInfo = mchIdTokenMap.get(id);
        mchLoginInfo.setEnabled(false);
        mchLoginInfo.setMessage("您的账号在另一端登录");
    }



    /**
     * 删除token
     * @param token
     */
    public static void removeToken(String token){
        if (mchTokenMap.containsKey(token)){
            mchTokenMap.remove(token);
        }
    }

    /**
     * 删除idToken
     */
    public static void removeIdToken(String token){
        for (Long id : mchIdTokenMap.keySet()) {
            if (mchIdTokenMap.get(id).getToken().equals(token)){
                mchIdTokenMap.remove(id);
                break;
            }
        }
    }

    /**
     * 删除登录缓存
     */
    public static void removeLoginCache(String token){
        if (mchTokenMap.containsKey(token)){
            Long id = get(token).getId();
            mchIdTokenMap.remove(id);
            mchTokenMap.remove(token);
        }
    }
}
