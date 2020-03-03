/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifePointController
 * Author:   Administrator
 * Date:     2019/12/6 0006 9:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.user;

import com.ruoyi.common.response.UserResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.life.service.user.LifePointService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
* 积分，又称vip
 */
@RestController
@RequestMapping("/user/point")
@Api(value = "/user/point",description = "积分记录，又称vip充值记录")
public class LifePointController {


    @Resource
    private LifePointService pointService;


}
