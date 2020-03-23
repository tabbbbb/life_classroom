package com.ruoyi.life.service.system;


import com.ruoyi.life.domain.LifeUpdate;

import java.util.List;

/**
 * 修改Service接口
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
public interface SysLifeUpdateService
{
    /**
     * 查询修改
     * 
     * @param updateId 修改ID
     * @return 修改
     */
     List<LifeUpdate> selectLifeUpdateById(Long updateId);


    /**
     * 删除修改信息
     * 
     * @param updateId 修改ID
     * @return 结果
     */
    int deleteLifeUpdateById(Long updateId);


    /**
     * 确定修改
     * @return
     */
    int confirmUpdate(Long updateId,Integer updateType,String failureExplain);

}
