package com.ruoyi.web.controller.user;

import com.ruoyi.common.response.UserResponse;
import com.ruoyi.framework.userlogin.LoginResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.life.service.user.LifePointLogService;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

/**
 *  积分日志
 */
@RestController
@RequestMapping("/user/log")
@Api(value = "/user/log",description = "积分日志",tags = "用户端")
public class LifePointLogController {

    @Resource
    private LifePointLogService pointLogService;



    @PostMapping("getUserLog")
    @ApiOperation(value = "获取用户消费记录")
    public UserResponse getUserLog(@ApiIgnore @LoginInfo UserLoginInfo loginInfo, Integer[] logType , Integer page, Integer limit){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(pointLogService.getUserLog(loginInfo.getId(),logType,page,limit));
    }

}
