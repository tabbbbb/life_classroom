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
package com.ruoyi.caoz.service;

import com.ruoyi.caoz.mapper.LifeUserMapper;
import com.ruoyi.common.response.UserResponse;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/2 0002
 * @since 1.0.0
 */
public interface LifeAutoService {


    /**
     * 手机号注册和登录
     * @param body
     * @return
     */
    UserResponse register(String body);

    /**
     * 手机号登录
     * @param body
     * @return
     */
    UserResponse phoneLogin(String body);


    /**
     * 微信登录
     * @param map
     * @return
     */
    UserResponse wxLogin(Map<String,String> map);


    /**
     * 绑定手机
     * @return
     */
    UserResponse bindPhone(String body);


    /**
     * 绑定
     * @param body
     * @return
     */
    UserResponse bindWx(String body);



    UserResponse bindUpdateTime(String body);


}
