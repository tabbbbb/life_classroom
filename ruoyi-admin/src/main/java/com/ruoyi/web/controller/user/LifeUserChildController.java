/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeUserChildController
 * Author:   Administrator
 * Date:     2019/12/5 0005 17:10
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
import com.ruoyi.life.service.LifePointService;
import com.ruoyi.life.service.LifeUserChildService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/5 0005
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user/child")
@Api(value = "/life/child",description = "小孩")
public class LifeUserChildController {


    @Autowired
    private LifePointService pointService;


    @Autowired
    private LifeUserChildService userChildService;

    @PutMapping("child")
    public UserResponse setChild(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,
                                 @RequestBody @ApiParam(name = "body",value = "child:LifeUserChild,pointId:LifePoint.pointId") String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return userChildService.insertLifeUserChild(loginInfo.getId(),body);
    }


    @GetMapping("child")
    public UserResponse getChild(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return userChildService.getChileByUserId(loginInfo.getId());
    }





}
