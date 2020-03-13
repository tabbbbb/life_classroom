package com.ruoyi.life.service.user;


import com.ruoyi.life.domain.LifePointLog;

import java.util.List;
import java.util.Map;

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
    LifePointLog selectLifePointLogById(Integer logId);

    /**
     * 查询积分日志列表
     * 
     * @param lifePointLog 积分日志
     * @return 积分日志集合
     */
    List<LifePointLog> selectLifePointLogList(LifePointLog lifePointLog);

    /**
     * 新增积分日志
     * 
     * @param lifePointLog 积分日志
     * @return 结果
     */
    int insertLifePointLog(LifePointLog lifePointLog);

    /**
     * 修改积分日志
     * 
     * @param lifePointLog 积分日志
     * @return 结果
     */
    int updateLifePointLog(LifePointLog lifePointLog);

    /**
     * 批量删除积分日志
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLifePointLogByIds(String ids);

    /**
     * 删除积分日志信息
     * 
     * @param logId 积分日志ID
     * @return 结果
     */
    int deleteLifePointLogById(Integer logId);


    /**
     * 过期积分的日志
     * @return
     */
    int pastPointLog();


    /**
     * 获取用户消费日志
     * @return
     */
    List<LifePointLog> getUserLog(Long userId, Integer logType, Integer page, Integer limit);


    /**
     * 获取返佣获取的积分
     * @return
     */
    long getRebatePoint(Long userId);



    /**
     * 根据userId设置shareId
     * @param userId
     * @return
     */
    int setShareIdByUserId(Long userId,Long shareId);

}
