/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeVipController
 * Author:   Administrator
 * Date:     2019/12/4 0004 17:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.user;


import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.life.domain.vo.user.LifeWxPayVipVo;
import com.ruoyi.life.service.user.LifeVipService;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.framework.userlogin.LoginResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * vip
 */
@RestController
@RequestMapping("/user/vip")
@Api(value = "/user/vip",description = "vip",tags = "用户端")
public class LifeVipController {

    @Resource
    private LifeVipService vipService;







    @PostMapping("priceRechargeVip")
    @ApiOperation(value = "余额充值会员")
    public UserResponse priceRechargeVip(@ApiIgnore @LoginInfo UserLoginInfo loginInfo, @RequestBody @ApiParam(name = "body",value = "vipId:选择vip") String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return vipService.priceRechargeVip(loginInfo.getId(),body);
    }

    /**
     * 获取此用户最大的会员
     * @return
     */
    @GetMapping("bigVip")
    @ApiOperation(value = "获取此用户最大的会员",notes = "需要token")
    public UserResponse getBigVip(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(vipService.getBigVip(loginInfo.getId()));
    }



    /**
     * 获取会员列表
     * @return
     */
    @GetMapping("get")
    @ApiOperation(value = "获取会员列表",notes = "")
    public UserResponse getVipList(){
        return UserResponse.succeed(vipService.selectLifeVipList(null));
    }



    @PostMapping("wxRechargeVip")
    @ApiOperation(value = "微信充值会员")
    public UserResponse wxRechargeVip(@ApiIgnore @LoginInfo UserLoginInfo loginInfo, @RequestBody LifeWxPayVipVo wxPayVipVo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(vipService.recharge(loginInfo.getId(),wxPayVipVo));
    }

}
