package com.ruoyi.web.controller.mch;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.exception.file.InvalidExtensionException;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import com.ruoyi.framework.userlogin.LoginResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.service.mch.LifeMchUserService;
import com.ruoyi.life.service.user.LifeUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/mchUser/user")
@Api(value = "/mchUser/user",description = "商户用户服务")
public class LifeMchUserController extends BaseController
{
    @Autowired
    private LifeMchUserService mchUserService;

}
