package com.ruoyi.caoz.service;


import com.ruoyi.caoz.domain.LifeCouponReserve;

import java.util.List;

/**
 * 用户优惠卷Service接口
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public interface LifeCouponReserveService
{
    /**
     * 查询用户优惠卷
     * 
     * @param receiveId 用户优惠卷ID
     * @return 用户优惠卷
     */
    public LifeCouponReserve selectLifeCouponReserveById(Long receiveId);

    /**
     * 查询用户优惠卷列表
     * 
     * @param lifeCouponReserve 用户优惠卷
     * @return 用户优惠卷集合
     */
    public List<LifeCouponReserve> selectLifeCouponReserveList(LifeCouponReserve lifeCouponReserve);

    /**
     * 新增用户优惠卷
     * 
     * @param lifeCouponReserve 用户优惠卷
     * @return 结果
     */
    public int insertLifeCouponReserve(LifeCouponReserve lifeCouponReserve);

    /**
     * 修改用户优惠卷
     * 
     * @param lifeCouponReserve 用户优惠卷
     * @return 结果
     */
    public int updateLifeCouponReserve(LifeCouponReserve lifeCouponReserve);

    /**
     * 批量删除用户优惠卷
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeCouponReserveByIds(String ids);

    /**
     * 删除用户优惠卷信息
     * 
     * @param receiveId 用户优惠卷ID
     * @return 结果
     */
    public int deleteLifeCouponReserveById(Long receiveId);
}
