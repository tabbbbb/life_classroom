/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeOrderController
 * Author:   Administrator
 * Date:     2019/12/4 0004 19:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.user;

import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.weixin.WxOperation;
import com.ruoyi.framework.userlogin.LoginResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.life.domain.vo.user.LifeCreateOrderVo;
import com.ruoyi.life.domain.vo.user.LifeOrderAndSpecificationVo;
import com.ruoyi.life.domain.vo.user.LifePayOrderVo;
import com.ruoyi.life.service.system.SysLifeOrderService;
import com.ruoyi.life.service.user.LifeOrderService;
import com.ruoyi.life.service.user.LifeUserChildService;
import com.ruoyi.quartz.LifeScheduler;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/4 0004
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user/order")
@Api(value = "/user/order",description = "订单")
public class LifeOrderController {


    @Autowired
    private LifeOrderService orderService;

    @Autowired
    private WxOperation wxOperation;


    @Resource
    private LifeScheduler lifeScheduler;

    @PutMapping("order")
    @ApiOperation(value = "生成订单")
    public UserResponse payCourse(@LoginInfo @ApiIgnore UserLoginInfo loginInfo, @ApiParam(name = "orderAndSpecificationVo",value = "订单创建") @RequestBody LifeOrderAndSpecificationVo orderAndSpecificationVo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        LocalDateTime now = LocalDateTime.now();
        List<Long> orderIds = orderService.createOrder(now,orderAndSpecificationVo,loginInfo.getId(),false);
        lifeScheduler.past101Order(now);
        return UserResponse.succeed(orderIds);
    }


    @PostMapping("cancel")
    @ApiOperation(value = "取消订单")
    public UserResponse cancel(@LoginInfo @ApiIgnore UserLoginInfo loginInfo, @ApiParam(name = "orderIds",value = "例：[1,2,3]") @RequestBody List<Long> orderIds){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        orderService.cancelOrder(loginInfo.getId(),orderIds);
        return UserResponse.succeed();
    }




    @PostMapping("pay")
    @ApiOperation(value = "支付订单")
    public UserResponse pay(@LoginInfo @ApiIgnore UserLoginInfo loginInfo, @ApiParam(name = "支付订单vo",value = "")  @RequestBody LifePayOrderVo payOrderVo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        orderService.payOrder(loginInfo.getId(),payOrderVo.getPayPassword(),payOrderVo.getOrderIds());
        return UserResponse.succeed();
    }


    @PostMapping("refund")
    @ApiOperation(value = "退款")
    public UserResponse refund(@LoginInfo @ApiIgnore UserLoginInfo loginInfo,@ApiParam(name = "orderIds",value = "订单ids") @RequestBody List<Long> orderIds){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        orderService.refund(loginInfo.getId(),orderIds);
        return UserResponse.succeed();
    }


    @PostMapping("cancelRefund")
    @ApiOperation(value = "取消退款")
    public UserResponse cancelRefund(@LoginInfo @ApiIgnore UserLoginInfo loginInfo,@ApiParam(name = "orderIds",value = "订单ids") @RequestBody List<Long> orderIds){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        orderService.cancelRefund(loginInfo.getId(),orderIds);
        return UserResponse.succeed();
    }


    @GetMapping("getLifeOrderVo")
    @ApiOperation(value = "订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status",value = "订单状态"),
            @ApiImplicitParam(name = "flag",value = "最近三天，true为最近三天"),
            @ApiImplicitParam(name = "page",value = "开始页数"),
            @ApiImplicitParam(name = "limit",value = "条数")
    })
    public UserResponse getLifeOrderVo(@LoginInfo @ApiIgnore UserLoginInfo loginInfo, Long status, boolean flag, int page, int limit){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(orderService.getLifeOrderVo(loginInfo.getId(),status,flag,page,limit));
    }

    @GetMapping("getLifeOrderDetailVo")
    @ApiOperation(value = "订单详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId",value = "订单id"),
    })
    public UserResponse getLifeOrderVo(@LoginInfo @ApiIgnore UserLoginInfo loginInfo, Long orderId){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(orderService.getLifeOrderDetailData(orderId,loginInfo.getId()));
    }


    @GetMapping("getAccessToken")
    @ApiOperation(value = "获取access_token")
    public UserResponse getAccessToken(@LoginInfo @ApiIgnore UserLoginInfo loginInfo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(wxOperation.getAccessToken());
    }



    @ApiOperation(value = "获取可选用户")
    @GetMapping("saleUser")
    public UserResponse saleUser(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(orderService.getSaleUser(loginInfo.getId()));
    }

}
