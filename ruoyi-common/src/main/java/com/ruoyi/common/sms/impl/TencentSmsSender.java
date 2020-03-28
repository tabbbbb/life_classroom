/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: TencentSmsSender
 * Author:   Administrator
 * Date:     2019/11/30 0030 13:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.sms.impl;

import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.sms.SmsSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/30 0030
 * @since 1.0.0
 */
public class TencentSmsSender implements SmsSender {

    private SmsSingleSender smsSingleSender;

    private SmsMultiSender smsMultiSender;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void setSmsMultiSender(SmsMultiSender smsMultiSender) {
        this.smsMultiSender = smsMultiSender;
    }

    public void setSmsSingleSender(SmsSingleSender smsSingleSender) {
        this.smsSingleSender = smsSingleSender;
    }

    @Override
    public void sendWithTemplate(String phone, int template, String[] params) {
        try {
            SmsSingleSenderResult result = smsSingleSender.sendWithParam("86", phone, template, params, "宁波楼宇食间网络科技", "", "");
            logger.debug(result.toString());
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendWithTemplate(String[] phone, int template, String[] params) {
        try {
            SmsMultiSenderResult result =smsMultiSender.sendWithParam("86",phone,template,params,"宁波楼宇食间网络科技","","");
            logger.debug(result.toString());
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
