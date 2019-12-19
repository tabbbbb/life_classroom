package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifePointLog;

import java.util.List;

/**
 * 积分日志Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-05
 */
public interface LifePointLogMapper 
{
    /**
     * 查询积分日志
     * 
     * @param logId 积分日志ID
     * @return 积分日志
     */
    public LifePointLog selectLifePointLogById(Integer logId);

    /**
     * 查询积分日志列表
     * 
     * @param lifePointLog 积分日志
     * @return 积分日志集合
     */
    public List<LifePointLog> selectLifePointLogList(LifePointLog lifePointLog);

    /**
     * 新增积分日志
     * 
     * @param lifePointLog 积分日志
     * @return 结果
     */
    public int insertLifePointLog(LifePointLog lifePointLog);

    /**
     * 修改积分日志
     * 
     * @param lifePointLog 积分日志
     * @return 结果
     */
    public int updateLifePointLog(LifePointLog lifePointLog);

    /**
     * 删除积分日志
     * 
     * @param logId 积分日志ID
     * @return 结果
     */
    public int deleteLifePointLogById(Integer logId);

    /**
     * 批量删除积分日志
     * 
     * @param logIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifePointLogByIds(String[] logIds);




    int pastPointLog();
}
