/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifePhoneController
 * Author:   Administrator
 * Date:     2020-03-14 10:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.common;

import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.sms.NotifySms;
import com.ruoyi.common.sms.cache.SmsCache;
import com.ruoyi.common.sms.enums.TemplatesType;
import com.ruoyi.common.utils.JacksonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送短信
 */
@RestController
@RequestMapping("/common/sms")
@Api(value = "/common/sms",description = "发送短信")
public class LifeSmsController {


    @Autowired
    private NotifySms notifySms;


    @PostMapping("send")
    @ApiOperation(value = "发送验证码到手机",response = UserResponse.class,notes = "")
    public Object send(String phone){
        if (phone == null || phone.length() != 11){
            return UserResponse.fail(UserResponseCode.SEND_CODE_ERROR,"手机号输入错误");
        }
        Integer random = (int)(Math.floor(Math.random()*900000)) + 100000;
        if (SmsCache.compareSmsCache(phone)){
            return UserResponse.fail(UserResponseCode.SEND_CODE_ERROR,"验证码有效期内不能重复发送");
        }
        notifySms.notifySend(phone,TemplatesType.code,new String[]{random+"","2"});
        SmsCache.putSmsCache(phone,random+"");
        return UserResponse.succeed();
    }
}
