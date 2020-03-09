package com.ruoyi.life.service.user.impl;


import com.ruoyi.life.domain.LifeCoupon;
import com.ruoyi.life.mapper.LifeCouponMapper;
import com.ruoyi.life.service.user.LifeCouponService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 优惠卷Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
@Service
public class LifeCouponServiceImpl implements LifeCouponService
{
    @Resource
    private LifeCouponMapper couponMapper;

    /**
     * 查询优惠卷
     * 
     * @param couponId 优惠卷ID
     * @return 优惠卷
     */
    @Override
    public LifeCoupon selectLifeCouponById(Long couponId)
    {
        return couponMapper.selectLifeCouponById(couponId);
    }



}
