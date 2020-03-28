package com.ruoyi.web.controller.mch;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.response.MchResponse;
import com.ruoyi.framework.userlogin.MchLoginResponse;
import com.ruoyi.framework.userlogin.annotation.MchLoginInfo;
import com.ruoyi.framework.userlogin.info.MchUserLoginInfo;
import com.ruoyi.life.domain.LifeBusinessUser;
import com.ruoyi.life.domain.vo.mch.LifeUpdatePhoneVo;
import com.ruoyi.life.service.mch.LifeMchUserService;
import com.ruoyi.life.service.user.LifeFileUpService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 用户Controller
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
@RestController
@RequestMapping("/mch/user")
@Api(value = "/mch/user",description = "商户用户服务",tags = "商户端")
public class LifeMchUserController extends BaseController
{
    @Autowired
    private LifeMchUserService mchUserService;

    @Autowired
    private LifeFileUpService fileUpService;



    @PostMapping("setBusiness")
    @ApiOperation(value = "设置商户")
    public MchResponse setBusiness(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo, Long businessId) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        mchUserService.bindBusiness(loginInfo.getId(),businessId);
        return MchResponse.succeed();
    }


    @PostMapping("updateLifeBusinessUserParameter")
    @ApiOperation(value = "设置用户普通的参数")
    public MchResponse updateLifeBusinessUserParameter(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo, @RequestBody LifeBusinessUser businessUser) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        mchUserService.updateLifeBusinessUserParameter(loginInfo.getId(),businessUser);
        return MchResponse.succeed();
    }



    @PostMapping("updatePhone")
    @ApiOperation(value = "修改手机号")
    public MchResponse updatePhone(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo,@RequestBody LifeUpdatePhoneVo updatePhoneVo) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        mchUserService.updatePhone(loginInfo.getId(),updatePhoneVo);
        return MchResponse.succeed();
    }



    @GetMapping("getBusinessQrCode")
    @ApiOperation(value = "获取商户二维码")
    public MchResponse getBusinessQrCode(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        return MchResponse.succeed(mchUserService.getBusinessQrCode(loginInfo.getId()));
    }

    @GetMapping("getBusinessUserInfo")
    @ApiOperation(value = "获取商户用户信息")
    public MchResponse getBusinessUserInfo(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        return MchResponse.succeed(mchUserService.getBusinessUserInfo(loginInfo.getId()));
    }

    @GetMapping("getBusinessAllUser")
    @ApiOperation(value = "获取商户中的所有成员")
    public MchResponse getBusinessAllUser(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        return MchResponse.succeed(mchUserService.getBusinessAllUser(loginInfo.getId()));
    }


    @GetMapping("getBusinessInUser")
    @ApiOperation(value = "获取商户中的单个成员信息")
    public MchResponse getBusinessInUser(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo,Long selectUserId) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        return MchResponse.succeed(mchUserService.getBusinessInUser(loginInfo.getId(),selectUserId));
    }


    @DeleteMapping("deleteBusinessUser")
    @ApiOperation(value = "管理员删除某个或多个成员")
    public MchResponse deleteBusinessUser(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo,Long [] userIds) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        mchUserService.deleteBusinessUser(loginInfo.getId(),userIds);
        return MchResponse.succeed();
    }



    @GetMapping("getUserIsAdmin")
    @ApiOperation(value = "获取用户是否是管理员",notes = "true:是")
    public MchResponse getUserIsAdmin(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        return MchResponse.succeed(mchUserService.getUserIsAdmin(loginInfo.getId()));
    }


    @PutMapping("upload")
    @ApiOperation(value = "上传头像")
    public String upload(@ApiIgnore MultipartFile file){
        return fileUpService.fileUp(Global.getMchUserAvatar(),file);
    }

}
