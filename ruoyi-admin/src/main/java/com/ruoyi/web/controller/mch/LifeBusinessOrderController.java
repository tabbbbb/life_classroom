/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessOrderController
 * Author:   Administrator
 * Date:     2020-03-16 15:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.mch;

import com.ruoyi.common.response.MchResponse;
import com.ruoyi.framework.userlogin.MchLoginResponse;
import com.ruoyi.framework.userlogin.annotation.MchLoginInfo;
import com.ruoyi.framework.userlogin.info.MchUserLoginInfo;
import com.ruoyi.life.service.mch.LifeBusinessOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 商户订单
 */
@RestController
@RequestMapping("/mch/order")
@Api(value = "/mch/order",description = "商户订单")
public class LifeBusinessOrderController {

    @Autowired
    private LifeBusinessOrderService businessOrderService;

    @PostMapping("verify")
    @ApiOperation(value = "核销")
    public MchResponse getPhoneRegisterFlag(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo, String verificationCode) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        businessOrderService.verificationOrder(loginInfo.getId(),verificationCode);
        return MchResponse.succeed();
    }


    @GetMapping("orderHome")
    @ApiOperation(value = "订单中心")
    public MchResponse orderHome(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo, Integer [] statues,int page,int limit) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        return MchResponse.succeed(businessOrderService.getMchOrder(loginInfo.getId(),statues,page,limit));
    }


    @GetMapping("statisticsOrder")
    @ApiOperation(value = "订单统计")
    public MchResponse statisticsOrder(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo,int type,int page,int limit) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        return MchResponse.succeed( businessOrderService.getStatisticsMchOrder(loginInfo.getId(),type,page,limit));
    }


    @GetMapping("orderDetail")
    @ApiOperation(value = "订单详细")
    public MchResponse orderDetail(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo,String verificationCode) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        return MchResponse.succeed( businessOrderService.getMchOrderDetail(verificationCode));
    }

}
