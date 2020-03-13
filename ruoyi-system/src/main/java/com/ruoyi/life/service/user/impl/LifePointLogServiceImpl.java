package com.ruoyi.life.service.user.impl;


import com.github.pagehelper.PageHelper;
import com.ruoyi.life.domain.LifePointLog;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.mapper.LifePointLogMapper;
import com.ruoyi.life.service.user.LifePointLogService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.service.user.LifeUserService;
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
    private LifePointLogMapper pointLogMapper;

    @Resource
    private LifeUserService userService;

    /**
     * 查询积分日志
     * 
     * @param logId 积分日志ID
     * @return 积分日志
     */
    @Override
    public LifePointLog selectLifePointLogById(Integer logId)
    {
        return pointLogMapper.selectLifePointLogById(logId);
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
        return pointLogMapper.selectLifePointLogList(lifePointLog);
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
        return pointLogMapper.insertLifePointLog(lifePointLog);
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
        return pointLogMapper.updateLifePointLog(lifePointLog);
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
        return pointLogMapper.deleteLifePointLogByIds(Convert.toStrArray(ids));
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
        return pointLogMapper.deleteLifePointLogById(logId);
    }


    /**
     * 过期积分的日志
     * @return
     */
    @Override
    public int pastPointLog() {
        return pointLogMapper.pastPointLog();
    }


    /**
     * 获取用户消费日志
     *
     * @param userId
     * @param logType
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<LifePointLog> getUserLog(Long userId, Integer logType, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        LifeUser user = userService.selectLifeUserById(userId);
        return pointLogMapper.getUserLog(user.getShareId(),logType);
    }


    /**
     * 获取返佣获取的积分
     *
     * @param userId
     * @return
     */
    @Override
    public long getRebatePoint(Long userId) {
        return pointLogMapper.getRebatePoint(userId);
    }


    /**
     * 根据userId设置shareId
     * @param userId
     * @param shareId
     * @return
     */
    @Override
    public int setShareIdByUserId(Long userId, Long shareId) {
        return pointLogMapper.setShareIdByUserId(userId,shareId);
    }
}
