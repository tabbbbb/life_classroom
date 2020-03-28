/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeCouponReceiveController
 * Author:   Administrator
 * Date:     2020-03-05 9:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.user;

import com.ruoyi.common.response.UserResponse;
import com.ruoyi.framework.userlogin.LoginResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.life.service.user.LifeCouponReceiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
* 优惠券
 */
@RestController
@RequestMapping("/user/coupon")
@Api(value = "/user/coupon",description = "优惠券",tags = "用户端")
public class LifeCouponReceiveController {

    @Resource
    private LifeCouponReceiveService couponReceiveService;


    @GetMapping("userCoupon")
    @ApiOperation(value = "用户优惠券",notes = "需要token，-1为过期，0未使用，1已使用")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "status",value = "状态：-1为过期，0未使用，1已使用 ")
    })
    public UserResponse getUserCoupon(@ApiIgnore @LoginInfo UserLoginInfo loginInfo, int status){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(couponReceiveService.getUserCoupon(loginInfo.getId(),status));
    }


    @PostMapping("userCouponType2")
    @ApiOperation(value = "使用充值券",notes = "需要token")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "couponReceiveId",value = "优惠券id")
    })
    public UserResponse useCouponType2(@ApiIgnore @LoginInfo UserLoginInfo loginInfo, Long couponReceiveId){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        couponReceiveService.useCouponType2(loginInfo.getId(),couponReceiveId);
        return UserResponse.succeed();
    }
}
