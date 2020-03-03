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

import com.ruoyi.common.config.Global;
import com.ruoyi.common.exception.file.InvalidExtensionException;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import com.ruoyi.framework.userlogin.LoginResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.service.user.LifeFileUpService;
import com.ruoyi.life.service.user.LifePointService;
import com.ruoyi.life.service.user.LifeUserChildService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.io.IOException;

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
@Api(value = "/user/child",description = "小孩")
public class LifeUserChildController {


    @Autowired
    private LifePointService pointService;


    @Autowired
    private LifeUserChildService userChildService;


    @Resource
    private LifeFileUpService fileUpService;

    @ApiOperation(value = "添加小孩")
    @PutMapping("child")
    public UserResponse setChild(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,
                                 @RequestBody @ApiParam(name = "body",value = "child:LifeUserChild,pointId:LifePoint.pointId") String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return userChildService.insertLifeUserChild(loginInfo.getId(),body);
    }

    @ApiOperation(value = "获取可选小孩")
    @GetMapping("child")
    public UserResponse getChild(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return userChildService.getChildByShareId(loginInfo.getId());
    }



    @GetMapping("childAll")
    @ApiOperation(value = "获取所有小孩",notes = "childUsable:可选，childDisabled：不可选，notSetPoint：没有设置小孩的会员")
    public UserResponse getChildAll(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return userChildService.getChildAllByShareId(loginInfo.getId());
    }


    @PostMapping("avatar")
    @ApiOperation(value = "设置小孩头像")
    public UserResponse setAvatarUrl(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,@ApiIgnore MultipartFile file){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(fileUpService.fileUp(Global.getUserChildPath(),file));
    }

}
