package com.ruoyi.life.service.user;


import com.ruoyi.life.domain.LifeHomepageCoupon;
import com.ruoyi.life.domain.vo.system.LifeHomePageCouponEditDataVo;

import java.util.List;

/**
 * 首页轮播图对应优惠券Service接口
 * 
 * @author ruoyi
 * @date 2020-03-06
 */
public interface LifeHomepageCouponService
{
    /**
     * 获取优惠券是否存在
     * @param couponId
     * @return
     */
    boolean getCouponExist(Long homepageId,Long couponId);



    /**
     * 领取优惠券
     * @return
     */
    int getCoupon(Long homepageId,Long couponId);
}
