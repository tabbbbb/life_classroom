/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeUserTargetController
 * Author:   Administrator
 * Date:     2019/12/20 0020 14:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.user;

import com.ruoyi.common.response.UserResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.life.domain.LifeUserTarget;
import com.ruoyi.life.service.LifeUserTargetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/20 0020
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user/target")
@Api(value = "/life/target",description = "目标")
public class LifeUserTargetController {

    @Autowired
    private LifeUserTargetService userTargetService;


    @PutMapping("target")
    @ApiOperation(value = "添加目标")
    public UserResponse addTarget(@ApiIgnore @LoginInfo UserLoginInfo loginInfo, @ApiParam(name = "body", value= "classifyId:xxx") @RequestBody String body){
        return userTargetService.addTarget(loginInfo.getId(),body);
    }



}
