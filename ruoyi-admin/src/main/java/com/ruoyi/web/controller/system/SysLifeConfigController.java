/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: SysLifeConfig
 * Author:   Administrator
 * Date:     2020-03-23 10:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.system;

import com.ruoyi.common.config.LifeConfig;
import com.ruoyi.life.service.system.SysLifeConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.ModalExclude;
import sun.security.krb5.Config;

import javax.annotation.Resource;

/**
 * 系统配置
 */
@Controller
@RequestMapping("/life/config")
public class SysLifeConfigController {


    @Resource
    private SysLifeConfigService configService;


    @GetMapping()
    @RequiresPermissions("life:config:view")
    public String config()
    {
        return "/life/config/config";
    }

    @PostMapping("set")
    @RequiresPermissions("life:config:set")
    @ResponseBody
    public void set(String name,String value)
    {
       configService.updateLifeConfig(name,value);
    }

    @GetMapping("config")
    @RequiresPermissions("life:config:view")
    @ResponseBody
    public Object configData()
    {
        return LifeConfig.getStyMap();
    }

}
