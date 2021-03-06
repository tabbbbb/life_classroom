package com.ruoyi.web.controller.user;

import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.domain.vo.user.LifeAddBalanceVo;
import com.ruoyi.life.domain.vo.user.LifeSetOrUpdatePayPasswordVo;
import com.ruoyi.life.domain.vo.user.LifeShareUserVo;
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
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;

/**
 * 用户Controller
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
@RestController
@RequestMapping("/user/user")
@Api(value = "/user/user",description = "用户服务",tags = "用户端")
public class LifeUserController
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





    @PostMapping("updatepwdlogin")
    @ApiOperation(value = "修改密码，输入旧密码，更改新密码")
    public UserResponse updatePassword(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,@RequestBody @ApiParam(name = "boyd",value = "oldPwd：旧密码，newPwd：新密码") String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return userService.loginUpdatePassword(loginInfo.getId(),body);
    }

    @PostMapping("updatepwdcode")
    @ApiOperation(value = "修改密码，获取短信验证码修改新密码")
    public UserResponse updatePassword(@RequestBody @ApiParam(name = "body",value = "phone:手机号,code:验证码,newPwd:新密码") String body){
        return userService.codeUpdatePassword(body);
    }



    /**
     * 获取此用户的星星，余额，最近到期的星星信息
     * @return
     */
    @GetMapping("userCapital")
    @ApiOperation(value = "获取此用户的星星，余额，最近到期的星星信息",notes = "需要token,返回值：{point:总积分，balance：余额，beOnTheVergeOfPoint：最近过期的积分记录}")
    public UserResponse userCapital(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        return UserResponse.succeed(userService.userCapital(loginInfo.getId()));
    }



    @PostMapping("setCompany")
    @ApiOperation(value = "设置公司",notes = "")
    public UserResponse setCompany(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,String invitationCode){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        userService.setCompany(loginInfo.getId(),invitationCode);
        return UserResponse.succeed();
    }


    @GetMapping("generalizeCompany")
    @ApiOperation(value = "推广人数",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "页码"),
            @ApiImplicitParam(name = "limit",value = "条数")
    })
    public UserResponse generalizePeopleNumber(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,int page,int limit){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(userService.generalizeUser(loginInfo.getId(),page,limit));
    }


    @GetMapping("getInvite")
    @ApiOperation(value = "邀请好友",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "页码"),
            @ApiImplicitParam(name = "limit",value = "条数")
    })
    public UserResponse getInvite(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,int page,int limit){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(userService.getInvite(loginInfo.getId(),page,limit));
    }




    @PostMapping("setOrUpdatePassword")
    @ApiOperation(value = "获取短信验证码修改或设置支付密码",notes = "获取短信验证码修改或设置支付密码")
    public UserResponse updatePayPassword(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,
                                          @RequestBody @ApiParam(name = "setOrUpdatePayPasswordVo",value = "{code:xxx,payPassword:xxx}")
                                                  LifeSetOrUpdatePayPasswordVo setOrUpdatePayPasswordVo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        userService.setOrUpdatePayPassword(setOrUpdatePayPasswordVo,loginInfo.getId());
        return UserResponse.succeed();
    }


    @PostMapping("getPayPassword")
    @ApiOperation(value = "查询是否有支付密码",notes = "true:有")
    public UserResponse getPayPassword(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(userService.getPayPassword(loginInfo.getId()));
    }



    @GetMapping("getBalance")
    @ApiOperation(value = "获取余额",notes = "")
    public UserResponse getBalance(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(userService.getBalance(loginInfo.getId()));
    }


    @GetMapping("getPersonInfo")
    @ApiOperation(value = "获取个人中心数据",notes = "")
    public UserResponse getPersonInfo(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(userService.getPersonInfo(loginInfo.getId()));
    }



    @PostMapping("bindShareUser")
    @ApiOperation(value = "绑定其他用户",notes = "")
    public UserResponse bindShareUser(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,@RequestBody LifeShareUserVo shareUserVo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        userService.bindShareUser(loginInfo.getId(),shareUserVo);
        return UserResponse.succeed();
    }

    @GetMapping ("userHome")
    @ApiOperation(value = "我的页面")
    public UserResponse userHome(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(userService.getUserHome(loginInfo.getId()));
    }

    @PostMapping("bindParentUser")
    @ApiOperation(value = "绑定上级用户",notes = "成为另一个用户的下级")
    public UserResponse bindShareUser(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,String invitationCard){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        userService.setParent(loginInfo.getId(),invitationCard,0);
        return UserResponse.succeed();
    }

    @GetMapping ("qrCode")
    @ApiOperation(value = "二维码")
    public UserResponse getQrCode(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(userService.getQrCode(loginInfo.getId()));
    }

    @PostMapping("addBalance")
    @ApiOperation(value = "充值余额",notes = "")
    public UserResponse addBalance(@ApiIgnore @LoginInfo UserLoginInfo loginInfo, LifeAddBalanceVo addBalanceVo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(userService.payBalance(loginInfo.getId(),addBalanceVo));
    }
}
