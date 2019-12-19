package com.ruoyi.life.service;


import com.ruoyi.life.domain.LifeCoupon;

import java.util.List;

/**
 * 优惠卷Service接口
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public interface LifeCouponService
{
    /**
     * 查询优惠卷
     * 
     * @param couponId 优惠卷ID
     * @return 优惠卷
     */
    public LifeCoupon selectLifeCouponById(Long couponId);

    /**
     * 查询优惠卷列表
     * 
     * @param lifeCoupon 优惠卷
     * @return 优惠卷集合
     */
    public List<LifeCoupon> selectLifeCouponList(LifeCoupon lifeCoupon);


    /**
     * 根据id数组查询优惠卷集合
     * @param ids
     * @return
     */
    List<LifeCoupon> selectLifeCouponListByIds(Long [] ids);


    /**
     * 新增优惠卷
     * 
     * @param lifeCoupon 优惠卷
     * @return 结果
     */
    public int insertLifeCoupon(LifeCoupon lifeCoupon);

    /**
     * 修改优惠卷
     * 
     * @param lifeCoupon 优惠卷
     * @return 结果
     */
    public int updateLifeCoupon(LifeCoupon lifeCoupon);

    /**
     * 批量删除优惠卷
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeCouponByIds(String ids);

    /**
     * 删除优惠卷信息
     * 
     * @param couponId 优惠卷ID
     * @return 结果
     */
    public int deleteLifeCouponById(Long couponId);
}
