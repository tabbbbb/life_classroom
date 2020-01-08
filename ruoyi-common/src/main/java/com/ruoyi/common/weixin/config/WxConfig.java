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

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.ruoyi.common.weixin.WxOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@EnableConfigurationProperties(WxProperties.class)
@Configuration
public class WxConfig {

    @Autowired
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

    @Bean
    public WxMaConfig wxMaConfig() {
        WxMaInMemoryConfig config = new WxMaInMemoryConfig();
        config.setAppid(properties.getAppId());
        config.setSecret(properties.getAppSecret());
        return config;
    }


    @Bean
    public WxMaService wxMaService() {
        WxMaService service = new WxMaServiceImpl();
        service.setWxMaConfig(wxMaConfig());
        return service;
    }

    @Bean
    public WxOperation wxOperation(){
        WxOperation wxOperation = new WxOperation(wxMaService(),wxPayService(),properties);
        return wxOperation;
    }
}

