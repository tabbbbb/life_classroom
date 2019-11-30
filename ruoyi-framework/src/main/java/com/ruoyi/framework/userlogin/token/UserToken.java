/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: UserToken
 * Author:   Administrator
 * Date:     2019/11/29 0029 16:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.framework.userlogin.token;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/29 0029
 * @since 1.0.0
 */

import com.ruoyi.caoz.domain.LifeUser;
import com.ruoyi.common.utils.CharUtil;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户token保存
 */
public class UserToken {
    private Map<String,UserLoginInfo> tokenMap = new HashMap<>();

    private Map<Long,UserLoginInfo> idTokenMap = new HashMap<>();

    /**
     * 获取token
     * @param token
     * @return
     */
    public boolean getTokenFlag(String token){
        UserLoginInfo userLoginInfo = get(token);
        if (userLoginInfo != null) {
            if (userLoginInfo.getEndTime().plusDays(1).isBefore(LocalDateTime.now())){
                removeToken(token);
                removeIdToken(token);
                return false;
            }
            return true;
        }else{
            return false;
        }
    }

    private UserLoginInfo get(String key){
        return tokenMap.get(key);
    }

    public void addToken(Long id){
        if (idTokenMap.containsKey(id)){
            setTokenMapStatus(id);
        }
        String token = CharUtil.getRandomString(32);
        while (tokenMap.containsKey(token)){
            token = CharUtil.getRandomString(32);
        }
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.setId(id);
        userLoginInfo.setEnabled(true);
        userLoginInfo.setEndTime(LocalDateTime.now());
        userLoginInfo.setToken(token);
        tokenMap.put(userLoginInfo.getToken(),userLoginInfo);
        idTokenMap.put(id,userLoginInfo);
    }


    private void setTokenMapStatus(Long id){
        UserLoginInfo userLoginInfo = idTokenMap.get(id);
        userLoginInfo.setEnabled(false);
        userLoginInfo.setMessage("您的账号在另一端登录");
    }



    /**
     * 删除token
     * @param token
     */
    public void removeToken(String token){
        if (tokenMap.containsKey(token)){
            tokenMap.remove(token);
        }
    }

    /**
     * 删除idToken
     */
    public void removeIdToken(String token){
        for (Long id : idTokenMap.keySet()) {
            if (idTokenMap.get(id).getToken().equals(token)){
                idTokenMap.remove(id);
                break;
            }
        }
    }














}
