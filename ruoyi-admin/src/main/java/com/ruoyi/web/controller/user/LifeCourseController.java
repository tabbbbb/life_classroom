/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeCourseController
 * Author:   Administrator
 * Date:     2019/12/13 0013 10:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.user;

import com.ruoyi.common.response.UserResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.life.domain.vo.user.LifeCourseConditionVo;
import com.ruoyi.life.service.user.LifeCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/13 0013
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user/course")
@Api(value = "/user/course",description = "课程",tags = "用户端")
public class LifeCourseController {

    @Autowired
    private LifeCourseService courseService;


    @GetMapping("course")
    @ApiOperation(value = "课程首页条件查询")
    @ApiImplicitParams(
            @ApiImplicitParam(paramType="query",name="conditionVo",value="课程首页条件",dataTypeClass = LifeCourseConditionVo.class)
    )
    public UserResponse getCourse(LifeCourseConditionVo conditionVo,@LoginInfo UserLoginInfo loginInfo){
        Long userId = null;
        if (loginInfo != null){
            userId = loginInfo.getId();
        }
        return courseService.selectLifeCourseBySearchVo(conditionVo,userId);
    }


    @GetMapping("courseDetail")
    @ApiOperation(value = "课程详细")
    @ApiImplicitParams({
                    @ApiImplicitParam(paramType="query",name="courseId",value="课程id",dataTypeClass = Long.class),
                    @ApiImplicitParam(paramType="query",name="lon",value="经度",dataTypeClass = BigDecimal.class),
                    @ApiImplicitParam(paramType="query",name="lat",value="纬度",dataTypeClass = BigDecimal.class)
            })
    public UserResponse getCourseDetail(@ApiIgnore @LoginInfo UserLoginInfo loginInfo, Long courseId, BigDecimal lon, BigDecimal lat){
        Long userId = null;
        if (loginInfo != null){
            userId = loginInfo.getId();
        }
        return courseService.getLifeCourseDetailByCourseId(courseId,userId,lon,lat);
    }

}
