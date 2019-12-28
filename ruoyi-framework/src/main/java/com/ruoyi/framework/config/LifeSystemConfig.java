/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SystemConfig
 * Author:   Administrator
 * Date:     2019/12/16 0016 13:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.framework.config;

import com.ruoyi.life.domain.LifeConfig;
import com.ruoyi.life.service.user.LifeConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/16 0016
 * @since 1.0.0
 */
@Component
public class LifeSystemConfig {



    @Autowired
    private LifeConfigService configService;

    @PostConstruct
    public void into(){
        Map <String,String> styMap = new HashMap<>();
        List<LifeConfig> list = configService.selectLifeConfigList(new LifeConfig());
        for (LifeConfig lifeConfig : list) {
            styMap.put(lifeConfig.getName(),lifeConfig.getConfig());
        }
        com.ruoyi.common.config.LifeConfig.setMap(styMap);
    }





}
