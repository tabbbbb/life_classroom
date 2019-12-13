/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: TencentSmsBean
 * Author:   Administrator
 * Date:     2019/11/30 0030 11:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.sms.config;

import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsSingleSender;
import com.ruoyi.common.sms.NotifySms;
import com.ruoyi.common.sms.impl.TencentSmsSender;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/30 0030
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(TencentSmsProperties.class)
public class TencentSmsBean {

    private final TencentSmsProperties properties;

    public TencentSmsBean(TencentSmsProperties properties){
        this.properties = properties;
    }

    @Bean
    public TencentSmsSender tencentSmsSender(){
        TencentSmsSender tencentSmsSender = new TencentSmsSender();
        SmsSingleSender smsSingleSender = new SmsSingleSender(properties.getAppId(),properties.getAppKey());
        tencentSmsSender.setSmsSingleSender(smsSingleSender);
        SmsMultiSender smsMultiSender = new SmsMultiSender(properties.getAppId(),properties.getAppKey());
        tencentSmsSender.setSmsMultiSender(smsMultiSender);
        return tencentSmsSender;
    }

    @Bean
    public NotifySms notifySms(){
        NotifySms notifySms = new NotifySms();
        notifySms.setTemplatesList(properties.getTemplate());
        notifySms.setSmsSender(tencentSmsSender());
        return notifySms;
    }


}