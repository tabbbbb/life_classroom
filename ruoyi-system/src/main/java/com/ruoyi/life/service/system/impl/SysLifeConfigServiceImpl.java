package com.ruoyi.life.service.system.impl;


import com.ruoyi.life.domain.LifeConfig;
import com.ruoyi.life.mapper.LifeConfigMapper;

import com.ruoyi.life.service.system.SysLifeConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 全局配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-16
 */
@Service
public class SysLifeConfigServiceImpl implements SysLifeConfigService
{
    @Resource
    private LifeConfigMapper configMapper;



    /**
     * 查询全局配置列表
     * 
     * @param lifeConfig 全局配置
     * @return 全局配置
     */
    @Override
    public List<LifeConfig> selectLifeConfigList(LifeConfig lifeConfig)
    {
        return configMapper.selectLifeConfigList(lifeConfig);
    }


    /**
     * 修改全局配置
     *
     * @param name
     * @param value
     * @return 结果
     */
    @Override
    public int updateLifeConfig(String name, String value) {
        com.ruoyi.common.config.LifeConfig.setStyMap(name,value);
        return configMapper.set(name,value);
    }
}
