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
import com.ruoyi.framework.userlogin.LoginResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.life.domain.LifeDonate;
import com.ruoyi.life.domain.vo.user.LifeDataVo;
import com.ruoyi.life.service.user.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.time.LocalDate;
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
@Api(value = "/user/data",description = "数据中心",tags = "用户端")
public class LifeDataController {


    @Autowired
    private LifeDataService dataService;


    @PostMapping("dataDetail")
    @ApiOperation(value = "历史数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="start",value="开始时间",dataTypeClass = LocalDate.class),
            @ApiImplicitParam(paramType="query",name="end",value="结束时间",dataTypeClass = LocalDate.class)
    })
    public UserResponse getDataDetail(@ApiIgnore @LoginInfo UserLoginInfo loginInfo, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate start,@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(dataService.getHistoryData(loginInfo.getId(),start,end));
    }



    @GetMapping("dataHome")
    @ApiOperation(value = "数据中心首页")
    public UserResponse dataHome(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        Long userId = loginInfo.getId();
        return UserResponse.succeed(dataService.getDataHome(userId));
    }

}
