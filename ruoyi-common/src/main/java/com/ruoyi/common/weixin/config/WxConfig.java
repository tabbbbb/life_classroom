/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: WxConfig
 * Author:   Administrator
 * Date:     2019/11/30 0030 16:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.weixin.config;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/30 0030
 * @since 1.0.0
 */
@EnableConfigurationProperties(WxProperties.class)
public class WxConfig {

    private WxProperties properties;

    @Bean
    public WxPayConfig wxPayConfig(){
        WxPayConfig wxPayConfig = new WxPayConfig();
        wxPayConfig.setAppId(properties.getAppId());
        wxPayConfig.setMchId(properties.getMchId());
        wxPayConfig.setMchKey(properties.getMchKey());
        wxPayConfig.setNotifyUrl(properties.getNotifyUrl());
        wxPayConfig.setSignType("MD5");
        wxPayConfig.setTradeType("JSAPI");
        return wxPayConfig;
    }

    @Bean
    public WxPayService wxPayService(){
        WxPayService wxPayService = new WxPayServiceImpl();
        wxPayService.setConfig(wxPayConfig());
        return wxPayService;
    }
}

