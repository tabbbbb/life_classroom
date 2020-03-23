package com.ruoyi.life.service.system;


import com.ruoyi.life.domain.LifeConfig;

import java.util.List;

/**
 * 全局配置Service接口
 * 
 * @author ruoyi
 * @date 2019-12-16
 */
public interface SysLifeConfigService
{


    /**
     * 查询全局配置列表
     * 
     * @param lifeConfig 全局配置
     * @return 全局配置集合
     */
    List<LifeConfig> selectLifeConfigList(LifeConfig lifeConfig);


    /**
     * 修改全局配置
     *
     * @return 结果
     */
    int updateLifeConfig(String name,String value);

}
