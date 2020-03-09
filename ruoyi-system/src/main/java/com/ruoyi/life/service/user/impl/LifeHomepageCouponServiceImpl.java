/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeHomepageCouponServiceImpl
 * Author:   Administrator
 * Date:     2020-03-06 17:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.user.impl;

import com.ruoyi.life.mapper.LifeHomepageCouponMapper;
import com.ruoyi.life.service.user.LifeHomepageCouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class LifeHomepageCouponServiceImpl implements LifeHomepageCouponService {

    @Resource
    private LifeHomepageCouponMapper homepageCouponMapper;
    /**
     * 获取优惠券是否存在
     *
     * @param couponId
     * @return
     */
    @Override
    public boolean getCouponExist(Long homepageId,Long couponId) {
        return homepageCouponMapper.getCouponExist(homepageId,couponId) >= 1;
    }

    /**
     * 领取优惠券
     *
     * @param homepageId
     * @param couponId
     * @return
     */
    @Override
    public int getCoupon(Long homepageId, Long couponId) {
        return homepageCouponMapper.getCoupon(homepageId,couponId);
    }
}
