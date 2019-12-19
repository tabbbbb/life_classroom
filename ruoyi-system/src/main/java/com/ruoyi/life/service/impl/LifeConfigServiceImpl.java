package com.ruoyi.life.service.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeConfig;
import com.ruoyi.life.mapper.LifeConfigMapper;
import com.ruoyi.life.service.LifeConfigService;
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
public class LifeConfigServiceImpl implements LifeConfigService
{
    @Resource
    private LifeConfigMapper lifeConfigMapper;

    /**
     * 查询全局配置
     * 
     * @param id 全局配置ID
     * @return 全局配置
     */
    @Override
    public LifeConfig selectLifeConfigById(Long id)
    {
        return lifeConfigMapper.selectLifeConfigById(id);
    }

    /**
     * 查询全局配置列表
     * 
     * @param lifeConfig 全局配置
     * @return 全局配置
     */
    @Override
    public List<LifeConfig> selectLifeConfigList(LifeConfig lifeConfig)
    {
        return lifeConfigMapper.selectLifeConfigList(lifeConfig);
    }

    /**
     * 新增全局配置
     * 
     * @param lifeConfig 全局配置
     * @return 结果
     */
    @Override
    public int insertLifeConfig(LifeConfig lifeConfig)
    {
        return lifeConfigMapper.insertLifeConfig(lifeConfig);
    }

    /**
     * 修改全局配置
     * 
     * @param lifeConfig 全局配置
     * @return 结果
     */
    @Override
    public int updateLifeConfig(LifeConfig lifeConfig)
    {
        return lifeConfigMapper.updateLifeConfig(lifeConfig);
    }

    /**
     * 删除全局配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeConfigByIds(String ids)
    {
        return lifeConfigMapper.deleteLifeConfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除全局配置信息
     * 
     * @param id 全局配置ID
     * @return 结果
     */
    @Override
    public int deleteLifeConfigById(Long id)
    {
        return lifeConfigMapper.deleteLifeConfigById(id);
    }
}
