package com.ruoyi.user.service;


import com.ruoyi.user.domain.LifePointLog;

import java.util.List;

/**
 * 积分日志Service接口
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public interface LifePointLogService
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
     * 批量删除积分日志
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifePointLogByIds(String ids);

    /**
     * 删除积分日志信息
     * 
     * @param logId 积分日志ID
     * @return 结果
     */
    public int deleteLifePointLogById(Integer logId);





    int pastPointLog();


}
