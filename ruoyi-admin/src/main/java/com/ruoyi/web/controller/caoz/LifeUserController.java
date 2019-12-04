package com.ruoyi.web.controller.caoz;

import com.ruoyi.caoz.domain.LifeUser;
import com.ruoyi.caoz.service.LifeUserService;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.framework.userlogin.LoginResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jodd.util.StringUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 用户Controller
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
@RestController
@RequestMapping("/user/user")
@Api(value = "/user/user",description = "用户服务")
public class LifeUserController extends BaseController
{


    @Autowired
    private LifeUserService userService;




    @PutMapping("password")
    @ApiOperation(value = "设置密码")
    public UserResponse setPassword(@ApiIgnore @LoginInfo UserLoginInfo loginInfo, @RequestBody @ApiParam(name = "body",value = "password:密码") String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return userService.setPassword(loginInfo.getId(),body);
    }



}
