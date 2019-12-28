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
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/4 0004
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user/vip")
@Api(value = "/life/vip",description = "vip充值")
public class LifeVipController {

    @Resource
    private LifeVipService vipService;




//    @PostMapping("recharge")
//    @ApiOperation(value = "会员充值")
    public UserResponse recharge(@ApiIgnore @LoginInfo UserLoginInfo loginInfo, @RequestBody @ApiParam(name = "body",value = "vipId:选择,code:微信code") String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return vipService.recharge(loginInfo.getId(),body);
    }


//    @PostMapping("gg")
//    @ApiOperation(value = "充值成功")
    public UserResponse gg(@RequestBody @ApiParam(name = "body") String body){
        String outTradeNo = JacksonUtil.parseString(body,"outTradeNo");
        BigDecimal price = new BigDecimal(JacksonUtil.parseInteger(body,"price").doubleValue());;
        return vipService.rechargeSucceed(outTradeNo,price);
    }


    @PostMapping("priceRechargeVip")
    @ApiOperation(value = "充值成功")
    public UserResponse priceRechargeVip(@ApiIgnore @LoginInfo UserLoginInfo loginInfo, @RequestBody @ApiParam(name = "body",value = "vipId:选择vip") String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return vipService.priceRechargeVip(loginInfo.getId(),body);
    }



}
