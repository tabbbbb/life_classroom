/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeCourseLabelController
 * Author:   Administrator
 * Date:     2020-03-25 14:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.user;

import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.service.user.LifeCourseLabelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 */
@RestController
@RequestMapping("/user/label")
@Api(value = "/user/label",description = "课程类型",tags = "用户端")
public class LifeCourseLabelController {

    @Resource
    private LifeCourseLabelService courseLabelService;

    @GetMapping("get")
    @ApiOperation(value = "所有课程类型")
    public UserResponse getCourse(){
        return UserResponse.succeed(courseLabelService.getCourseLabel());
    }

}
