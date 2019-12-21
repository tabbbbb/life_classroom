/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeDataController
 * Author:   Administrator
 * Date:     2019/12/20 0020 10:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.user;

import com.ruoyi.common.response.UserResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.life.service.LifeOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDateTime;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/20 0020
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user/data")
@Api(value = "/life/data",description = "数据中心")
public class LifeDataController {

    @Autowired
    private LifeOrderService orderService;


    @GetMapping("dataDetail")
    @ApiOperation(value = "历史数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="startTime",value="开始时间",dataTypeClass = LocalDateTime.class),
            @ApiImplicitParam(paramType="query",name="endTime",value="结束时间",dataTypeClass = LocalDateTime.class)
    })
    public UserResponse getDataDetail(@ApiIgnore @LoginInfo UserLoginInfo loginInfo, LocalDateTime startTime,LocalDateTime endTime){
        return orderService.getDataDetail(loginInfo.getId(),startTime,endTime);
    }



    @GetMapping("dataHome")
    @ApiOperation(value = "数据中心首页")
    public UserResponse dataHome(){
        return null;
    }

}
