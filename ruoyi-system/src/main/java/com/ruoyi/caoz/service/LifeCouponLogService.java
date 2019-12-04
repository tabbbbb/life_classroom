package com.ruoyi.caoz.service;


import com.ruoyi.caoz.domain.LifeCouponLog;

import java.util.List;

/**
 * 优惠卷使用日志Service接口
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public interface LifeCouponLogService
{
    /**
     * 查询优惠卷使用日志
     * 
     * @param logId 优惠卷使用日志ID
     * @return 优惠卷使用日志
     */
    public LifeCouponLog selectLifeCouponLogById(Long logId);

    /**
     * 查询优惠卷使用日志列表
     * 
     * @param lifeCouponLog 优惠卷使用日志
     * @return 优惠卷使用日志集合
     */
    public List<LifeCouponLog> selectLifeCouponLogList(LifeCouponLog lifeCouponLog);

    /**
     * 新增优惠卷使用日志
     * 
     * @param lifeCouponLog 优惠卷使用日志
     * @return 结果
     */
    public int insertLifeCouponLog(LifeCouponLog lifeCouponLog);

    /**
     * 修改优惠卷使用日志
     * 
     * @param lifeCouponLog 优惠卷使用日志
     * @return 结果
     */
    public int updateLifeCouponLog(LifeCouponLog lifeCouponLog);

    /**
     * 批量删除优惠卷使用日志
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeCouponLogByIds(String ids);

    /**
     * 删除优惠卷使用日志信息
     * 
     * @param logId 优惠卷使用日志ID
     * @return 结果
     */
    public int deleteLifeCouponLogById(Long logId);
}
