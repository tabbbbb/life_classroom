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

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Api(value = "/user/course",description = "课程")
public class LifeCourseController {


    @GetMapping("course")
    public void getCourse(){

    }

}
