package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 全局配置Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-16
 */
public interface LifeConfigMapper 
{

    /**
     * 查询全局配置列表
     * 
     * @param lifeConfig 全局配置
     * @return 全局配置集合
     */
     List<LifeConfig> selectLifeConfigList(LifeConfig lifeConfig);

    int set(@Param("name") String name,@Param("value") String value);
}
