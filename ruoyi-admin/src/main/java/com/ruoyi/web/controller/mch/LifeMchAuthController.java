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
package com.ruoyi.web.controller.mch;

import com.ruoyi.common.response.MchUserResponse;
import com.ruoyi.common.response.MchUserResponseCode;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.sms.NotifySms;
import com.ruoyi.common.sms.cache.SmsCache;
import com.ruoyi.common.sms.enums.TemplatesType;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.framework.userlogin.LoginResponse;
import com.ruoyi.framework.userlogin.MchLoginResponse;
import com.ruoyi.framework.userlogin.WxLoginUserInfo;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.MchUserLoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.framework.userlogin.token.UserToken;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.service.mch.LifeMchAutoService;
import com.ruoyi.life.service.user.LifeAutoService;
import com.ruoyi.life.service.user.LifePointService;
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
@RequestMapping("/mchUser/auth")
@Api(value = "/life/MchAuth",description = "用户认证")
public class LifeMchAuthController {

    @Autowired
    private NotifySms notifySms;

    @Autowired
    private LifeMchAutoService mchAutoService;

    @PostMapping("phoneLogin")
    @ApiOperation(value = "手机号登录")
    public Object login(@ApiParam(name = "body",value = "phone:手机号,password:密码" ) @RequestBody String body){
        MchUserResponse response = mchAutoService.phoneLogin(body);
        toResponse(response);
        return response;
    }


    @PostMapping("wxLogin")
    @ApiOperation(value = "微信登录或注册")
    public Object wxLogin(@RequestBody  WxLoginUserInfo wxLoginUserInfo){
        MchUserResponse response = mchAutoService.wxLogin(wxLoginUserInfo.toMap());
        toResponse(response);
        return response;
    }




    @PutMapping("registerLogin")
    @ApiOperation(value = "手机号注册或登录")
    public Object register(@ApiParam(name = "body",value = "phone:手机号,code:短信,invitationCard:邀请人邀请码,companyInvitationCard:公司邀请码") @RequestBody String body){
        MchUserResponse response = mchAutoService.register(body);
        toResponse(response);
        return response;
    }

    @PostMapping("send")
    @ApiOperation(value = "发送验证码到手机",response = UserResponse.class,notes = "")
    public Object send(@RequestBody @ApiParam(value = "phone:xxx",name = "body")  String body){

        String phone = JacksonUtil.parseString(body,"phone");
        if (phone == null || phone.length() != 11){
            return MchUserResponse.fail(MchUserResponseCode.SEND_CODE_ERROR,"手机号输入错误");
        }
        Integer random = (int)(Math.floor(Math.random()*900000)) + 100000;
        if (SmsCache.compareSmsCache(phone)){
            return MchUserResponse.fail(MchUserResponseCode.SEND_CODE_ERROR,"验证码有效期内不能重复发送");
        }
        notifySms.notifySend(phone,TemplatesType.code,new String[]{random+"","2"});
        SmsCache.putSmsCache(phone,random+"");
        return MchUserResponse.succeed();
    }


    @PostMapping("logout")
    @ApiOperation(value = "退出登录",response = UserResponse.class,notes = "")
    public Object logout(@ApiIgnore @LoginInfo MchUserLoginInfo loginInfo){
        UserToken.removeLoginCache(loginInfo.getToken());
        return UserResponse.succeed();
    }


    @PostMapping("bindPhone")
    @ApiOperation(value = "绑定手机或者修改",response = UserResponse.class,notes = "")
    public MchUserResponse bindPhone(@ApiIgnore @LoginInfo MchUserLoginInfo loginInfo,@RequestBody @ApiParam(name = "body",value = "phone:手机号,code:短信验证码")  String body){
        MchUserResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return mchAutoService.bindPhone(loginInfo.getId(),body);
    }


    @PostMapping("verifyCode")
    @ApiOperation(value = "修改手机号验证验证码",response = UserResponse.class,notes = "")
    public MchUserResponse bindUpdateTime(@ApiIgnore @LoginInfo MchUserLoginInfo loginInfo,@RequestBody @ApiParam(name = "body",value = "code:短信验证码")  String body){
        MchUserResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return mchAutoService.bindUpdateTime(loginInfo.getId(),body);
    }




    @PostMapping("bindWx")
    @ApiOperation(value = "绑定微信",response = UserResponse.class,notes = "")
    public Object bindWx(@ApiIgnore @LoginInfo MchUserLoginInfo loginInfo,@RequestBody @ApiParam(name = "body",value = "code:微信code")  String body){
        MchUserResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return mchAutoService.bindWx(loginInfo.getId(),body);
    }



    @PostMapping("getToken")
    @ApiOperation(value = "获取某用户的token",response = UserResponse.class,notes = "")
    public Object getToken(Long userId){
        return UserResponse.succeed(UserToken.addToken(userId));
    }



    @GetMapping("phoneRegisterFlag")
    @ApiOperation(value = "判断用户手机号是否注册",response = UserResponse.class,notes = "返回值：false：未注册")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="phone",value="手机号",dataTypeClass = String.class)
    })
    public Boolean getToken(String phone){
        return mchAutoService.phoneIsBind(phone) != null;
    }




    /**
     * 将token设置到返回值中返回
     * @param response
     */
    private void toResponse(MchUserResponse response){
        if (response.getCode() == MchUserResponseCode.SUCCEED){
            LifeUser user = (LifeUser) response.getData();
            MchUserLoginInfo info = UserToken.addMchToken(user.getUserId());
            Map<String,Object> map = new HashMap<>();
            map.put("info",info);
            //map.put("points",pointService.selectNotSetChildPoint(info.getId()));
            response.setData(map);
        }
    }

}
