/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeAutoService
 * Author:   Administrator
 * Date:     2019/12/2 0002 13:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch;

import com.ruoyi.common.response.MchUserResponse;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeBusiness;
import com.ruoyi.life.domain.LifeBusinessUser;
import com.ruoyi.life.domain.LifeUser;

import java.util.Map;

/**
 * 用户认证
 */
public interface LifeMchAutoService {


    /**
     * 手机号注册和登录
     * @param body
     * @return
     */
    MchUserResponse register(String body);

    /**
     * 手机号登录
     * @param body
     * @return
     */
    MchUserResponse phoneLogin(String body);


    /**
     * 微信登录
     * @param map
     * @return
     */
    MchUserResponse wxLogin(Map<String, String> map);


    /**
     * 绑定手机或者修改
     * @return
     */
    MchUserResponse bindPhone(Long userId, String body);


    /**
     * 绑定
     * @param userId 用户id
     * @param body 参数
     * @return
     */
    MchUserResponse bindWx(Long userId, String body);


    /**
     * 绑定手机号修改时间
     * @param userId
     * @param body
     * @return
     */
    MchUserResponse bindUpdateTime(Long userId, String body);

    /**
     * 根据手机号获取user信息
     * @param phone
     * @return
     */
     LifeBusinessUser phoneIsBind(String phone);



}
