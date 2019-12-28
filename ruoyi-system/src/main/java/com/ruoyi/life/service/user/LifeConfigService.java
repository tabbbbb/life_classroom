package com.ruoyi.life.service.user;


import com.ruoyi.life.domain.LifeConfig;

import java.util.List;

/**
 * 全局配置Service接口
 * 
 * @author ruoyi
 * @date 2019-12-16
 */
public interface LifeConfigService
{
    /**
     * 查询全局配置
     * 
     * @param id 全局配置ID
     * @return 全局配置
     */
    public LifeConfig selectLifeConfigById(Long id);

    /**
     * 查询全局配置列表
     * 
     * @param lifeConfig 全局配置
     * @return 全局配置集合
     */
    public List<LifeConfig> selectLifeConfigList(LifeConfig lifeConfig);

    /**
     * 新增全局配置
     * 
     * @param lifeConfig 全局配置
     * @return 结果
     */
    public int insertLifeConfig(LifeConfig lifeConfig);

    /**
     * 修改全局配置
     * 
     * @param lifeConfig 全局配置
     * @return 结果
     */
    public int updateLifeConfig(LifeConfig lifeConfig);

    /**
     * 批量删除全局配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeConfigByIds(String ids);

    /**
     * 删除全局配置信息
     * 
     * @param id 全局配置ID
     * @return 结果
     */
    public int deleteLifeConfigById(Long id);
}
