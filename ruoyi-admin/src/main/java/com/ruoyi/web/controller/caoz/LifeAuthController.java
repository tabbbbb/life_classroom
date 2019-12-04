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
package com.ruoyi.web.controller.caoz;

import com.ruoyi.caoz.domain.LifeUser;
import com.ruoyi.caoz.service.LifeAutoService;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.sms.NotifySms;
import com.ruoyi.common.sms.cache.SmsCache;
import com.ruoyi.common.sms.enums.TemplatesType;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.framework.userlogin.LoginResponse;
import com.ruoyi.framework.userlogin.WxLoginUserInfo;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.framework.userlogin.token.UserToken;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.naming.Name;
import java.util.Random;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/30 0030
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user/auth")
@Api(value = "/user/auth",description = "用户认证")
public class LifeAuthController {

    @Autowired
    private NotifySms notifySms;

    @Autowired
    private LifeAutoService autoService;


    @PostMapping("phonelogin")
    @ApiOperation(value = "手机号登录")
    public Object login(@ApiParam(name = "body",value = "phone:手机号,password:密码" ) @RequestBody String body){
        UserResponse response = autoService.phoneLogin(body);
        toResponse(response);
        return response;
    }


    @PostMapping("wxlogin")
    @ApiOperation(value = "微信登录或注册")
    public Object wxLogin(@RequestBody WxLoginUserInfo wxLoginUserInfo){
        UserResponse response = autoService.wxLogin(wxLoginUserInfo.toMap());
        toResponse(response);
        return response;
    }




    @PutMapping("registerandlogin")
    @ApiOperation(value = "手机号注册或登录")
    public Object register(@ApiParam(name = "body",value = "phone:手机号,code:短信,invitationCard:邀请人邀请码") @RequestBody String body){
        UserResponse response = autoService.register(body);
        toResponse(response);
        return response;
    }

    @PostMapping("send")
    @ApiOperation(value = "发送验证码到手机",response = UserResponse.class,notes = "")
    public Object send(@RequestBody @ApiParam(value = "phone:xxx",name = "body")  String body){
        String phone = JacksonUtil.parseString(body,"phone");
        Integer random = (int)(Math.floor(Math.random()*900000)) + 100000;
        notifySms.notifySend(phone,TemplatesType.code,new String[]{random+"","2"});
        SmsCache.putSmsCache(phone,random+"");
        return UserResponse.succeed();
    }


    @PostMapping("logout")
    @ApiOperation(value = "退出登录",response = UserResponse.class,notes = "")
    public Object logout(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        UserToken.removeLoginCache(loginInfo.getToken());
        return UserResponse.succeed();
    }


    @PostMapping("bindphone")
    @ApiOperation(value = "绑定手机号",response = UserResponse.class,notes = "")
    public UserResponse bindPhone(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,@RequestBody @ApiParam(name = "body",value = "phone:手机号,code:短信验证码")  String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return autoService.bindPhone(loginInfo.getId(),body);
    }


    @PostMapping("verifycode")
    @ApiOperation(value = "验证验证码",response = UserResponse.class,notes = "")
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
    @ApiImplicitParams(
            @ApiImplicitParam(name = "userId",value = "用户id")
    )
    public Object getToken(Long userId){
        return UserResponse.succeed(UserToken.addToken(userId));
    }






    /**
     * 将token设置到返回值中返回
     * @param response
     */
    private void toResponse(UserResponse response){
        if (response.getCode() == UserResponseCode.SUCCEED){
            LifeUser user = (LifeUser) response.getData();
            UserLoginInfo info = UserToken.addToken(user.getUserId());
            response.setData(info);
        }
    }

}
