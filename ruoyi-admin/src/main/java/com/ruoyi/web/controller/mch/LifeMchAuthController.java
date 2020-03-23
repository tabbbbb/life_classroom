/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeLoginController
 * Author:   Administrator
 * Date:     2019/11/30 0030 10:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.mch;

import com.ruoyi.common.response.MchResponse;
import com.ruoyi.framework.userlogin.token.MchToken;
import com.ruoyi.life.domain.vo.mch.LifePhoneAndPasswordLoginVo;
import com.ruoyi.life.domain.vo.mch.LifePhoneRegisterDataVo;
import com.ruoyi.life.domain.vo.mch.LifeWxRegisterDataVo;
import com.ruoyi.life.service.mch.LifeMchAutoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户认证
 */
@RestController
@RequestMapping("/mch/auth")
@Api(value = "/mch/auth",description = "商户用户认证")
public class LifeMchAuthController {

    @Autowired
    private LifeMchAutoService mchAutoService;



    @PostMapping("wxLoginOrRegister")
    @ApiOperation(value = "微信登录或者注册")
    public MchResponse wxRegister(@RequestBody LifeWxRegisterDataVo wxRegisterDataVo) {
        return MchResponse.succeed(MchToken.addToken(mchAutoService.wxRegister(wxRegisterDataVo)));
    }

    @PutMapping("phoneRegister")
    @ApiOperation(value = "手机号注册")
    public MchResponse phoneRegister(@RequestBody LifePhoneRegisterDataVo phoneRegisterDataVo) {
        return MchResponse.succeed(MchToken.addToken(mchAutoService.phoneRegister(phoneRegisterDataVo)));
    }


    @PostMapping("phoneAndPasswordLogin")
    @ApiOperation(value = "手机号密码登录")
    public MchResponse phoneAndPasswordLogin(@RequestBody  LifePhoneAndPasswordLoginVo phoneAndPasswordLoginVo) {
       return MchResponse.succeed(MchToken.addToken(mchAutoService.phoneAndPasswordLogin(phoneAndPasswordLoginVo)));
    }


    @GetMapping("getPhoneRegisterFlag")
    @ApiOperation(value = "获取手机号有没有注册")
    public MchResponse getPhoneRegisterFlag(String phone) {
        return MchResponse.succeed(mchAutoService.getPhoneRegisterFlag(phone));
    }


}
