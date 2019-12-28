/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeCourseClassifyController
 * Author:   Administrator
 * Date:     2019/12/20 0020 9:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.user;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/20 0020
 * @since 1.0.0
 */

import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.service.user.LifeCourseClassifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/user/classify")
@Api(value = "/life/classify",description = "目标类型（课程类别）")
public class LifeCourseClassifyController {

    @Autowired
    private LifeCourseClassifyService courseClassifyService;



    @GetMapping("xlevel")
    @ApiOperation(value = "获取下级类别",notes = "0:获取一级标签")
    public UserResponse get1Classify(Long pid){
        return UserResponse.succeed(courseClassifyService.getSingleClassify(pid));
    }




}
