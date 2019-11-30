/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeLoginController
 * Author:   Administrator
 * Date:     2019/11/30 0030 10:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.caoz;

import com.ruoyi.common.json.JSONObject;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.sms.NotifySms;
import com.ruoyi.common.sms.enums.TemplatesType;
import com.ruoyi.common.utils.JacksonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/30 0030
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user/auth")
@Api(value = "/user/auth",description = "用户认证")
public class LifeAuthController {

    @Autowired
    private NotifySms notifySms;


    @PostMapping("login")
    public Object login(){
        return null;
    }



    @PutMapping("register")
    public Object register(){
        return null;
    }

    @PostMapping("send")
    @ApiOperation(value = "发送短信到手机",response = UserResponse.class,notes = "")
    public Object send(@RequestBody @ApiParam(value = "phone:xxx",name = "body") String body){
        String phone = JacksonUtil.parseString(body,"phone");
        Integer random = (int)(Math.floor(Math.random()*900000)) + 100000;
        notifySms.notifySend(phone,TemplatesType.code,new String[]{random+"","2"});
        return UserResponse.succeed();
    }

}
