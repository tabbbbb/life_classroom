package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.exception.life.user.UserOperationException;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.life.domain.LifeCouponReceive;
import com.ruoyi.life.domain.LifeHomePage;
import com.ruoyi.life.domain.LifeRecord;
import com.ruoyi.life.domain.vo.user.LifeHomePageCouponDataVo;
import com.ruoyi.life.mapper.LifeHomePageMapper;
import com.ruoyi.life.service.user.LifeCouponReceiveService;
import com.ruoyi.life.service.user.LifeHomePageService;
import com.ruoyi.life.service.user.LifeHomepageCouponService;
import com.ruoyi.life.service.user.LifeRecordService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Resource
    private LifeRecordService recordService;




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
        LifeRecord record = new LifeRecord();
        record.setUserId(userId);
        record.setCouponId(couponId);
        record.setHomepageId(homepageId);
        if (recordService.selectLifeRecordList(record).size() != 0){
            throw new UserOperationException(UserResponseCode.GET_COUPON_ERROR,"你已经领取过一次");
        }
        if (homepageCouponService.getCoupon(homepageId,couponId) == 0){
            throw new UserOperationException(UserResponseCode.GET_COUPON_ERROR,"手慢了，优惠券已被抢光");
        }
        LifeHomePage homePage = homePageMapper.selectLifeHomePageById(homepageId);
        recordService.insertLifeRecord(record);
        LifeCouponReceive couponReceive = new LifeCouponReceive();
        couponReceive.setStatus(0);
        couponReceive.setCouponId(couponId);
        couponReceive.setStartTime(LocalDateTime.now());
        couponReceive.setShareId(userId);
        couponReceive.setDestroy(Md5Utils.hash(userId+"_"+System.currentTimeMillis()+"_"+couponId));
        LocalDate end = homePage.getEndDate();
        couponReceive.setEndTime(LocalDateTime.of(end.getYear(),end.getMonthValue(),end.getDayOfMonth(),0,0,0));
        couponReceiveService.insertLifeCouponReceive(couponReceive);
    }
}
