/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeDonateController
 * Author:   Administrator
 * Date:     2019/12/21 0021 17:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.user;

import com.ruoyi.common.response.UserResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.life.service.LifeOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/21 0021
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user/donate")
@Api(value = "/life/donate",description = "捐赠")
public class LifeDonateController {

    @Autowired
    private LifeOrderService orderService;


    @PostMapping("donate")
    @ApiOperation(value = "捐赠")
    public UserResponse donateOrder(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        return orderService.donateOrder(loginInfo.getId());
    }


    @GetMapping("donate")
    @ApiOperation(value = "最近一周的捐赠")
    public UserResponse getDonate(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        return orderService.getDonate(loginInfo.getId());
    }

}