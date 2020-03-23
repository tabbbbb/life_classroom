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

import com.ruoyi.life.domain.vo.mch.LifePhoneAndPasswordLoginVo;
import com.ruoyi.life.domain.vo.mch.LifePhoneRegisterDataVo;
import com.ruoyi.life.domain.vo.mch.LifeWxRegisterDataVo;

/**
 * 用户认证
 */
public interface LifeMchAutoService {


    /**
     * 微信注册
     * @param wxRegisterDataVo
     * @return
     */
    Long wxRegister(LifeWxRegisterDataVo wxRegisterDataVo);

    /**
     * 手机号注册
     * @param phoneRegisterDataVo
     * @return
     */
    Long phoneRegister(LifePhoneRegisterDataVo phoneRegisterDataVo);



    /**
     * 手机号和密码登录
     * @param phoneAndPasswordLoginVo
     * @return
     */
    Long phoneAndPasswordLogin(LifePhoneAndPasswordLoginVo phoneAndPasswordLoginVo);


    /**
     * 获取此手机号有没有注册
     * @return
     */
    boolean getPhoneRegisterFlag(String phone);
}
