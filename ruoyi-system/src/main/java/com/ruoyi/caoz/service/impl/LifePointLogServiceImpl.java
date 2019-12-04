package com.ruoyi.caoz.service.impl;


import com.ruoyi.caoz.domain.LifePointLog;
import com.ruoyi.caoz.mapper.LifePointLogMapper;
import com.ruoyi.caoz.service.LifePointLogService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 积分日志Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
@Service
public class LifePointLogServiceImpl implements LifePointLogService
{
    @Resource
    private LifePointLogMapper lifePointLogMapper;

    /**
     * 查询积分日志
     * 
     * @param logId 积分日志ID
     * @return 积分日志
     */
    @Override
    public LifePointLog selectLifePointLogById(Integer logId)
    {
        return lifePointLogMapper.selectLifePointLogById(logId);
    }

    /**
     * 查询积分日志列表
     * 
     * @param lifePointLog 积分日志
     * @return 积分日志
     */
    @Override
    public List<LifePointLog> selectLifePointLogList(LifePointLog lifePointLog)
    {
        return lifePointLogMapper.selectLifePointLogList(lifePointLog);
    }

    /**
     * 新增积分日志
     * 
     * @param lifePointLog 积分日志
     * @return 结果
     */
    @Override
    public int insertLifePointLog(LifePointLog lifePointLog)
    {
        return lifePointLogMapper.insertLifePointLog(lifePointLog);
    }

    /**
     * 修改积分日志
     * 
     * @param lifePointLog 积分日志
     * @return 结果
     */
    @Override
    public int updateLifePointLog(LifePointLog lifePointLog)
    {
        return lifePointLogMapper.updateLifePointLog(lifePointLog);
    }

    /**
     * 删除积分日志对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifePointLogByIds(String ids)
    {
        return lifePointLogMapper.deleteLifePointLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除积分日志信息
     * 
     * @param logId 积分日志ID
     * @return 结果
     */
    @Override
    public int deleteLifePointLogById(Integer logId)
    {
        return lifePointLogMapper.deleteLifePointLogById(logId);
    }
}
