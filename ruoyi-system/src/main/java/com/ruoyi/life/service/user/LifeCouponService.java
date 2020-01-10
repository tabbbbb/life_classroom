package com.ruoyi.life.service.user;


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


}
