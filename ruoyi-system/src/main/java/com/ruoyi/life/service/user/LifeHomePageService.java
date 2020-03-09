package com.ruoyi.life.service.user;


import com.ruoyi.life.domain.LifeCoupon;
import com.ruoyi.life.domain.LifeHomePage;
import com.ruoyi.life.domain.vo.user.LifeHomePageCouponDataVo;

import java.util.List;

/**
 * 首页信息Service接口
 * 
 * @author ruoyi
 * @date 2020-03-05
 */
public interface LifeHomePageService
{


    /**
     * 查询首页信息列表
     * 
     * @param lifeHomePage 首页信息
     * @return 首页信息集合
     */
    List<LifeHomePage> selectLifeHomePageList(LifeHomePage lifeHomePage);




    /**
     * 优惠券信息
     * @param homePageId
     * @return
     */
    List<LifeHomePageCouponDataVo> homepageCouponData(Long homePageId);


    /**
     * 领取优惠券
     * @param userId
     * @param couponId
     */
    void getCoupon(Long userId,Long couponId,Long homepageId);
}
