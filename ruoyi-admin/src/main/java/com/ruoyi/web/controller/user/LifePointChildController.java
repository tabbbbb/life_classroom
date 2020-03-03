/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifePointChildController
 * Author:   Administrator
 * Date:     2019/12/6 0006 11:04
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
import com.ruoyi.life.service.user.LifePointChildService;
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
 * @create 2019/12/6 0006
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user/pointchild")
@Api(value = "/user/pointchild",description = "小孩和会员期间关联")
public class LifePointChildController {

    @Autowired
    private LifePointChildService pointChildService;


    @PutMapping("pointchild")
    @ApiOperation(value = "设置小孩在此会员期间使用",notes = "")
    public UserResponse setPointEnable(@ApiIgnore @LoginInfo UserLoginInfo loginInfo,
                                       @RequestBody @ApiParam(name = "body",value = "childIds:xxx,xxx（小孩id）,pointId:LifePoint.pointId（积分记录id）")
                                               String body){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        return pointChildService.insertListChild(loginInfo.getId(),body);
    }

}
