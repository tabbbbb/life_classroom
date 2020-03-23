/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: WxMchProperties
 * Author:   Administrator
 * Date:     2020-03-14 9:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.weixin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 商户微信登录参数
 */
@ConfigurationProperties("life.wxmch")
public class WxMchProperties {

    private String appId;


    private String appSecret;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
