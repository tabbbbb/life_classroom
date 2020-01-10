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
import com.ruoyi.framework.userlogin.LoginResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.life.domain.vo.user.LifePayOrderVo;
import com.ruoyi.life.service.system.SysLifeOrderService;
import com.ruoyi.life.service.user.LifeOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
@Api(value = "/life/order",description = "订单")
public class LifeOrderController {


    @Autowired
    private LifeOrderService orderService;


    @PutMapping("order")
    @ApiOperation(value = "支付")
    public UserResponse payCourse(@LoginInfo @ApiIgnore UserLoginInfo loginInfo, @ApiParam(name = "payOrderVo",value = "payOrderVo:LifePayOrderVo.class") @RequestBody LifePayOrderVo payOrderVo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return orderService.payCourse(payOrderVo,loginInfo.getId());
    }



}
