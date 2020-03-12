/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeLeagueClassController
 * Author:   Administrator
 * Date:     2019/12/19 0019 9:58
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
import com.ruoyi.life.domain.LifeLeagueClass;
import com.ruoyi.life.domain.vo.user.LifeAddLeagueClassVo;
import com.ruoyi.life.domain.vo.user.LifeOrderAndSpecificationVo;
import com.ruoyi.life.service.user.LifeLeagueClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/19 0019
 * @since 1.0.0
 */
@RestController
@RequestMapping("/life/league")
@Api(value = "/life/league",description = "小团课")
public class LifeLeagueClassController {

    @Resource
    private LifeLeagueClassService leagueClassService;

    @ApiOperation(value = "添加小团课")
    @PutMapping("/add")
    public UserResponse insertLeagueClass(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,@ApiParam(name = "addLeagueClassVo") @RequestBody LifeAddLeagueClassVo addLeagueClassVo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        leagueClassService.insertLeagueClass(loginInfo.getId(),addLeagueClassVo);
        return UserResponse.succeed();
    }


    @ApiOperation(value = "删除小团课")
    @DeleteMapping ("/delete")
    public UserResponse deleteLeagueClass(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,@ApiParam(name = "leagueClassIds") @RequestBody  List<Long> leagueClassIds){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        leagueClassService.deleteLeagueClass(loginInfo.getId(),leagueClassIds);
        return UserResponse.succeed();
    }


    @ApiOperation(value = "生成小团课订单")
    @PostMapping("/createLeagueClassOrder")
    public UserResponse createLeagueClassOrder(@ApiIgnore @LoginInfo UserLoginInfo loginInfo, @ApiParam(name = "orderAndSpecificationVo") @RequestBody LifeOrderAndSpecificationVo orderAndSpecificationVo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(leagueClassService.createLeagueClassOrder(orderAndSpecificationVo,loginInfo.getId()));
    }


    @ApiOperation(value = "获取小团课vo")
    @GetMapping("/getLeagueClassVo")
    public UserResponse getLeagueClassVo(@ApiIgnore @LoginInfo UserLoginInfo loginInfo){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return UserResponse.succeed(leagueClassService.getLifeLeagueClassVo(loginInfo.getId()));
    }

}
