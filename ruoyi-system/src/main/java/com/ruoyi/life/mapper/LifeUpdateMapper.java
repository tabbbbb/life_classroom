package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeUpdate;

import java.util.List;

/**
 * 修改Mapper接口
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
public interface LifeUpdateMapper 
{
    /**
     * 查询修改
     * 
     * @param updateId 修改ID
     * @return 修改
     */
    List<LifeUpdate> selectLifeUpdateById(Long updateId);

    /**
     * 查询修改列表
     * 
     * @param lifeUpdate 修改
     * @return 修改集合
     */
    List<LifeUpdate> selectLifeUpdateList(LifeUpdate lifeUpdate);

    /**
     * 新增修改
     * 
     * @param lifeUpdate 修改
     * @return 结果
     */
    int insertLifeUpdate(LifeUpdate lifeUpdate);

    /**
     * 修改修改
     * 
     * @param lifeUpdate 修改
     * @return 结果
     */
    int updateLifeUpdate(LifeUpdate lifeUpdate);

    /**
     * 删除修改
     * 
     * @param updateId 修改ID
     * @return 结果
     */
    int deleteLifeUpdateById(Long updateId);

    /**
     * 批量删除修改
     * 
     * @param updateIds 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeUpdateByIds(String[] updateIds);



    /**
     * 通过与不通过
     * @return
     */
    int confirmUpdate(Long updateId,Integer updateType,String failureExplain);


    /**
     * 根据id获取最近的修改记录
     * @return
     */
    LifeUpdate getLifeUpdateByBusinessId(Long updateId);

}
