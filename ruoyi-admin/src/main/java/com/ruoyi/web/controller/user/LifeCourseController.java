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

import java.math.BigDecimal;

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
@Api(value = "/life/course",description = "课程")
public class LifeCourseController {

    @Autowired
    private LifeCourseService courseService;


    @GetMapping("course")
    @ApiOperation(value = "课程首页条件查询")
    @ApiImplicitParams(
            @ApiImplicitParam(paramType="query",name="conditionVo",value="课程首页条件",dataTypeClass = LifeCourseConditionVo.class)
    )
    public UserResponse getCourse(LifeCourseConditionVo conditionVo){
        return UserResponse.succeed(courseService.selectLifeCourseBySearchVo(conditionVo));
    }


    @GetMapping("courseDetail")
    @ApiOperation(value = "课程详细")
    @ApiImplicitParams({
                    @ApiImplicitParam(paramType="query",name="courseId",value="课程id",dataTypeClass = Long.class),
                    @ApiImplicitParam(paramType="query",name="lon",value="经度",dataTypeClass = BigDecimal.class),
                    @ApiImplicitParam(paramType="query",name="lat",value="纬度",dataTypeClass = BigDecimal.class)
            })
    public UserResponse getCourseDetail(Long courseId, BigDecimal lon, BigDecimal lat){
        return UserResponse.succeed(courseService.getLifeCourseDetailByCourseId(courseId,lon,lat));
    }

}
