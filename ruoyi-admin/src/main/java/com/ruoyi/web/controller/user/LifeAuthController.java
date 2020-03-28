/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeLoginController
 * Author:   Administrator
 * Date:     2019/11/30 0030 10:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.user;

import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.domain.vo.user.LifeUserPhoneAndPasswordLoginVo;
import com.ruoyi.life.domain.vo.user.LifeUserPhoneRegisterVo;
import com.ruoyi.life.service.user.LifeAutoService;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.framework.userlogin.LoginResponse;
import com.ruoyi.life.domain.vo.user.WxLoginUserInfo;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.framework.userlogin.token.UserToken;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户认证
 */
@RestController
@RequestMapping("/user/auth")
@Api(value = "/user/auth",description = "用户认证",tags = "用户端")
public class LifeAuthController {



    @Autowired
    private LifeAutoService autoService;



    @PostMapping("phonelogin")
    @ApiOperation(value = "手机号登录")
    public Object login( @RequestBody LifeUserPhoneAndPasswordLoginVo userPhoneAndPasswordLoginVo){
        UserResponse response = autoService.phoneLogin(userPhoneAndPasswordLoginVo);
        toResponse(response);
        return response;
    }


    @PostMapping("wxlogin")
    @ApiOperation(value = "微信登录或注册")
    public Object wxLogin(@RequestBody  WxLoginUserInfo wxLoginUserInfo){
        Long userId = autoService.wxLogin(wxLoginUserInfo);
        return UserResponse.succeed(UserToken.addToken(userId));
    }




    @PutMapping("registerandlogin")
    @ApiOperation(value = "手机号注册")
    public Object register(@ApiParam(name = "body",value = "phone:手机号,code:短信,invitationCard:邀请人邀请码,companyInvitationCard:公司邀请码") @RequestBody LifeUserPhoneRegisterVo phoneRegisterVo ){
        Long userId = autoService.register(phoneRegisterVo);
        return UserResponse.succeed(UserToken.addToken(userId));
    }




    @PostMapping("logout")
    @ApiOperation(value = "退出登录",response = UserResponse.class,notes = "")
    public Object logout(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        UserToken.removeLoginCache(loginInfo.getToken());
        return UserResponse.succeed();
    }


    @PostMapping("bindphone")
    @ApiOperation(value = "绑定手机或者修改",response = UserResponse.class,notes = "")
    public UserResponse bindPhone(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,@RequestBody @ApiParam(name = "body",value = "phone:手机号,code:短信验证码")  String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return autoService.bindPhone(loginInfo.getId(),body);
    }


    @PostMapping("verifycode")
    @ApiOperation(value = "修改手机号验证验证码",response = UserResponse.class,notes = "")
    public UserResponse bindUpdateTime(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,@RequestBody @ApiParam(name = "body",value = "code:短信验证码")  String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return autoService.bindUpdateTime(loginInfo.getId(),body);
    }




    @PostMapping("bindwx")
    @ApiOperation(value = "绑定微信",response = UserResponse.class,notes = "")
    public Object bindWx(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,@RequestBody @ApiParam(name = "body",value = "code:微信code")  String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return autoService.bindWx(loginInfo.getId(),body);
    }



    @PostMapping("getToken")
    @ApiOperation(value = "获取某用户的token",response = UserResponse.class,notes = "")
    public Object getToken(Long userId){
        return UserResponse.succeed(UserToken.addToken(userId));
    }



    @GetMapping("phoneregisterflag")
    @ApiOperation(value = "判断用户手机号是否注册",response = UserResponse.class,notes = "返回值：false：未注册")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="phone",value="手机号",dataTypeClass = String.class)
    })
    public Boolean getToken(String phone){
        return autoService.phoneIsBind(phone) != null;
    }



    /**
     * 将token设置到返回值中返回
     * @param response
     */
    private void toResponse(UserResponse response){
        if (response.getCode() == UserResponseCode.SUCCEED){
            LifeUser user = (LifeUser) response.getData();
            UserLoginInfo info = UserToken.addToken(user.getUserId());
            Map<String,Object> map = new HashMap<>();
            map.put("info",info);
           // map.put("points",pointService.selectNotSetChildPoint(info.getId()));
            response.setData(map);
        }
    }

}
