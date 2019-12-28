package com.ruoyi.web.controller.user;

import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.service.user.LifeUserService;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.exception.file.InvalidExtensionException;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import com.ruoyi.framework.userlogin.LoginResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * 用户Controller
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
@RestController
@RequestMapping("/user/user")
@Api(value = "/life/life",description = "用户服务")
public class LifeUserController extends BaseController
{


    @Autowired
    private LifeUserService userService;

    @Autowired
    private ServerConfig serverConfig;



    @PutMapping("password")
    @ApiOperation(value = "设置密码")
    public UserResponse setPassword(@ApiIgnore @LoginInfo UserLoginInfo loginInfo, @RequestBody @ApiParam(name = "body",value = "password:密码") String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return userService.setPassword(loginInfo.getId(),body);
    }


    @PostMapping("avatar")
    @ApiOperation(value = "设置头像")
    public UserResponse setAvatarUrl(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,@ApiIgnore MultipartFile file){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        String fileUpPath = Global.getUserAvatarPath();
        try {
            String avatarUrl = FileUploadUtils.upload(fileUpPath,file,MimeTypeUtils.IMAGE_EXTENSION);
            LifeUser setAvatarUser = new LifeUser();
            setAvatarUser.setImgUrl(serverConfig.getUrl()+avatarUrl);
            setAvatarUser.setUserId(loginInfo.getId());
            if (userService.updateLifeUser(setAvatarUser) == 0){
                return UserResponse.fail(UserResponseCode.USER_AVATAR_UPDATE_ERROR,"修改头像错误");
            }

        } catch (IOException e) {
            e.printStackTrace();
            return UserResponse.fail(UserResponseCode.UP_FILE_ERROR,"文件上传错误：文件上传错误");
        } catch (InvalidExtensionException e) {
            e.printStackTrace();
            return UserResponse.fail(UserResponseCode.UP_FILE_ERROR,"文件上传错误：格式错误");
        }
        return UserResponse.succeed();
    }


    @PostMapping("userproperty")
    @ApiOperation(value = "设置用户的普通参数(改什么填什么)")
    public UserResponse setNickName(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,
                                    @RequestBody @ApiParam(name = "body",value = "nickname:昵称,birthday:生日,sex:0女1男,address:xx省 xx市 xx区/县") String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return userService.setProperty(loginInfo.getId(),body);
    }


    @GetMapping ("succeedbalance")
    @ApiImplicitParams({
                    @ApiImplicitParam(name = "outTradeNo"),
                    @ApiImplicitParam(name = "price")
    })
    public UserResponse succeedBalance(String outTradeNo,Integer price){
        return userService.rechargeBalanceSucceed(outTradeNo,new BigDecimal(price));
    }


    @GetMapping ("userHome")
    @ApiOperation(value = "用户信息")
    public UserResponse userHome(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return userService.getUserHome(loginInfo.getId());
    }


    @PostMapping("updatepwdlogin")
    @ApiOperation(value = "修改密码，输入旧密码，更改新密码")
    public UserResponse updatePassword(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,@RequestBody @ApiParam(name = "boyd",value = "oldPwd：旧密码，newPwd：新密码") String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return userService.loginUpdatePassword(loginInfo.getId(),body);
    }

    @PostMapping("updatepwdcode")
    @ApiOperation(value = "修改密码，获取短信验证码修改新密码")
    public UserResponse updatePassword(@RequestBody @ApiParam(name = "boyd",value = "phone:手机号,code:验证码,newPwd:新密码") String body){
        return userService.codeUpdatePassword(body);
    }




    @PostMapping("setpaypwd")
    @ApiOperation(value = "设置支付密码")
    public UserResponse setPayPassword(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,@RequestBody @ApiParam(name = "boyd",value = "payPwd:密码") String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return userService.setPayPassword(loginInfo.getId(),body);
    }

    @PostMapping("updatepaypwd")
    @ApiOperation(value = "修改支付密码",notes = "获取短信验证码修改支付密码")
    public UserResponse updatePayPassword(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,@RequestBody @ApiParam(name = "boyd",value = "code:验证码,payPwd:新密码") String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return userService.updatePayPassword(loginInfo.getId(),body);
    }




}
