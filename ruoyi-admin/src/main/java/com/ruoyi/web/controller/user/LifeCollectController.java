/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeCollectController
 * Author:   Administrator
 * Date:     2019/12/19 0019 10:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.user;

import com.ruoyi.common.response.UserResponse;
import com.ruoyi.framework.userlogin.LoginResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.life.service.LifeCollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/19 0019
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user/collect")
@Api(value = "/life/collect",description = "用户收藏")
public class LifeCollectController {

    @Resource
    private LifeCollectService collectService;


    @PostMapping("collect")
    @ApiOperation(value = "收藏或取消收藏")
    public UserResponse collect(@ApiIgnore @LoginInfo UserLoginInfo loginInfo, @RequestBody @ApiParam(value = "courseId:xxx") String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        return collectService.collect(loginInfo.getId(),body);
    }

}