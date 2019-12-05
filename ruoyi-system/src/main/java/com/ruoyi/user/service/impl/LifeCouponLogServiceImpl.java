package com.ruoyi.user.service.impl;

import java.util.List;

import com.ruoyi.user.domain.LifeCouponLog;
import com.ruoyi.user.mapper.LifeCouponLogMapper;
import com.ruoyi.user.service.LifeCouponLogService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

import javax.annotation.Resource;

/**
 * 优惠卷使用日志Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
@Service
public class LifeCouponLogServiceImpl implements LifeCouponLogService
{
    @Resource
    private LifeCouponLogMapper lifeCouponLogMapper;

    /**
     * 查询优惠卷使用日志
     * 
     * @param logId 优惠卷使用日志ID
     * @return 优惠卷使用日志
     */
    @Override
    public LifeCouponLog selectLifeCouponLogById(Long logId)
    {
        return lifeCouponLogMapper.selectLifeCouponLogById(logId);
    }

    /**
     * 查询优惠卷使用日志列表
     * 
     * @param lifeCouponLog 优惠卷使用日志
     * @return 优惠卷使用日志
     */
    @Override
    public List<LifeCouponLog> selectLifeCouponLogList(LifeCouponLog lifeCouponLog)
    {
        return lifeCouponLogMapper.selectLifeCouponLogList(lifeCouponLog);
    }

    /**
     * 新增优惠卷使用日志
     * 
     * @param lifeCouponLog 优惠卷使用日志
     * @return 结果
     */
    @Override
    public int insertLifeCouponLog(LifeCouponLog lifeCouponLog)
    {
        lifeCouponLog.setCreateTime(DateUtils.getNowDate());
        return lifeCouponLogMapper.insertLifeCouponLog(lifeCouponLog);
    }

    /**
     * 修改优惠卷使用日志
     * 
     * @param lifeCouponLog 优惠卷使用日志
     * @return 结果
     */
    @Override
    public int updateLifeCouponLog(LifeCouponLog lifeCouponLog)
    {
        return lifeCouponLogMapper.updateLifeCouponLog(lifeCouponLog);
    }

    /**
     * 删除优惠卷使用日志对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCouponLogByIds(String ids)
    {
        return lifeCouponLogMapper.deleteLifeCouponLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除优惠卷使用日志信息
     * 
     * @param logId 优惠卷使用日志ID
     * @return 结果
     */
    @Override
    public int deleteLifeCouponLogById(Long logId)
    {
        return lifeCouponLogMapper.deleteLifeCouponLogById(logId);
    }
}
