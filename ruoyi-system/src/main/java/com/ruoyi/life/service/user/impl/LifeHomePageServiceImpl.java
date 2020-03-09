package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.life.user.UserOperationException;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.life.domain.LifeCoupon;
import com.ruoyi.life.domain.LifeHomePage;
import com.ruoyi.life.domain.LifeHomepageCoupon;
import com.ruoyi.life.domain.vo.user.LifeHomePageCouponDataVo;
import com.ruoyi.life.mapper.LifeHomePageMapper;
import com.ruoyi.life.service.user.LifeCouponReceiveService;
import com.ruoyi.life.service.user.LifeHomePageService;
import com.ruoyi.life.service.user.LifeHomepageCouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-05
 */
@Service
public class LifeHomePageServiceImpl implements LifeHomePageService
{
    @Resource
    private LifeHomePageMapper homePageMapper;

    @Resource
    private LifeCouponReceiveService couponReceiveService;

    @Resource
    private LifeHomepageCouponService homepageCouponService;




    /**
     * 查询首页信息列表
     * 
     * @param lifeHomePage 首页信息
     * @return 首页信息
     */
    @Override
    public List<LifeHomePage> selectLifeHomePageList(LifeHomePage lifeHomePage)
    {
        return homePageMapper.selectLifeHomePageList(lifeHomePage);
    }

    /**
     * @param homePageId
     * @return
     */
    @Override
    public List<LifeHomePageCouponDataVo> homepageCouponData(Long homePageId) {
        return homePageMapper.homepageCouponData(homePageId);
    }


    /**
     * 领取优惠券
     *
     * @param userId
     * @param couponId
     */
    @Override
    public void getCoupon(Long userId, Long couponId,Long homepageId) {
        if (!homepageCouponService.getCouponExist(homepageId,couponId)){
            throw new UserOperationException(UserResponseCode.GET_COUPON_ERROR,"没有此优惠券，请刷新重试");
        }

        if (homepageCouponService.getCoupon(homepageId,couponId) == 0){
            throw new UserOperationException(UserResponseCode.GET_COUPON_ERROR,"手慢了，优惠券已被抢光");
        }
        couponReceiveService.getCoupon(userId,couponId);
    }
}
