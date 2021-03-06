package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.life.user.SendCouponException;
import com.ruoyi.common.exception.life.user.UserOperationException;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.life.domain.*;
import com.ruoyi.life.domain.vo.user.LifeUserCouponVo;
import com.ruoyi.life.mapper.LifeCouponReceiveMapper;
import com.ruoyi.life.service.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户优惠卷Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
@Service
public class LifeCouponReceiveServiceImpl implements LifeCouponReceiveService
{
    @Resource
    private LifeCouponReceiveMapper couponReceiveMapper;


    @Autowired
    private LifeCouponService couponService;

    @Autowired
    private LifeVipCouponService vipCouponService;

    @Autowired
    private LifeUserService userService;

    @Autowired
    private LifePointService pointService;

    @Autowired
    private LifePointLogService pointLogService;

    /**
     * 查询用户优惠卷
     * 
     * @param receiveId 用户优惠卷ID
     * @return 用户优惠卷
     */
    @Override
    public LifeCouponReceive selectLifeCouponReceiveById(Long receiveId)
    {
        return couponReceiveMapper.selectLifeCouponReceiveById(receiveId);
    }

    /**
     * 查询用户优惠卷列表
     * 
     * @param lifeCouponReceive 用户优惠卷
     * @return 用户优惠卷
     */
    @Override
    public List<LifeCouponReceive> selectLifeCouponReceiveList(LifeCouponReceive lifeCouponReceive)
    {
        return couponReceiveMapper.selectLifeCouponReceiveList(lifeCouponReceive);
    }

    /**
     * 新增用户优惠卷
     * 
     * @param lifeCouponReceive 用户优惠卷
     * @return 结果
     */
    @Override
    public int insertLifeCouponReceive(LifeCouponReceive lifeCouponReceive)
    {

        return couponReceiveMapper.insertLifeCouponReceive(lifeCouponReceive);
    }

    /**
     * 修改用户优惠卷
     * 
     * @param lifeCouponReceive 用户优惠卷
     * @return 结果
     */
    @Override
    public int updateLifeCouponReceive(LifeCouponReceive lifeCouponReceive)
    {
        return couponReceiveMapper.updateLifeCouponReceive(lifeCouponReceive);
    }

    /**
     * 删除用户优惠卷对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCouponReceiveByIds(String ids)
    {
        return couponReceiveMapper.deleteLifeCouponReceiveByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户优惠卷信息
     * 
     * @param receiveId 用户优惠卷ID
     * @return 结果
     */
    @Override
    public int deleteLifeCouponReceiveById(Long receiveId)
    {
        return couponReceiveMapper.deleteLifeCouponReceiveById(receiveId);
    }

    /**
     * 送优惠券
     *
     * @param list 优惠卷ids
     * @return 结果
     */
    private int insertLifeCouponReceive(Long shareId, List<Map<String,Long>> list) {
        List<LifeCouponReceive> couponReceiveList = new ArrayList<>();
        LocalDateTime start = LocalDateTime.now();
        for (Map<String,Long> map : list) {
            LifeCoupon lifeCoupon = couponService.selectLifeCouponById(map.get("couponId"));
            LifeCouponReceive couponReceive = new LifeCouponReceive();
            LocalDateTime end = start.plusDays(lifeCoupon.getEnableDay()+1);
            couponReceive.setCouponId(lifeCoupon.getCouponId());
            couponReceive.setShareId(shareId);
            couponReceive.setStatus(0);
            couponReceive.setEndTime(end);
            couponReceive.setStartTime(start);

            for (int i = 0; i < map.get("number"); i++) {
                if (lifeCoupon.getIntervalDay() != null && lifeCoupon.getIntervalDay() != 0){
                    couponReceive.setStartTime(couponReceive.getEndTime().plusDays(lifeCoupon.getIntervalDay()));
                }
                int random = (int) (Math.random()*900000) + 100000;
                String destroy =shareId+"_"+System.currentTimeMillis()+"_"+random;
                couponReceive.setDestroy( Md5Utils.hash(destroy));
                couponReceiveList.add(couponReceive);
            }

        }
        return couponReceiveMapper.insertLifeCouponReceives(couponReceiveList);
    }


    @Override
    public int pastCoupon() {
        return couponReceiveMapper.pastCoupon();
    }


    /**
     * 新增充值余额所送优惠券
     *
     * @param shareId
     * @param list    优惠卷ids
     * @return 结果
     */
    @Override
    public void insertLifeCouponReceiveBalance(Long shareId, List<LifeCompanyCoupon> list) {
        List<Map<String,Long>> longList = new ArrayList<>();
        for (LifeCompanyCoupon coupon : list) {
            Map<String,Long> map = new HashMap<>();
            map.put("couponId",coupon.getCouponId());
            map.put("number", Long.valueOf(coupon.getNumber()));
            longList.add(map);
        }
        if (insertLifeCouponReceive(shareId,longList) != insertNumBalance(longList)){
            throw new SendCouponException(UserResponseCode.SEND_COUPON_ERROR,"充值余额赠送优惠券失败");
        }
    }

    /**
     * 新增充值vip所送优惠券
     *
     * @param shareId
     * @param vipId    vipId
     * @return 结果
     */
    @Override
    public void insertLifeCouponReceiveVip(Long shareId, Long vipId) {
        LifeVipCoupon selectVipCoupon = new LifeVipCoupon();
        selectVipCoupon.setVipId(vipId);
        List<LifeVipCoupon> list = vipCouponService.selectLifeCouponIds(vipId);
        if (list.size() == 0) return ;
        List<Map<String,Long>> longList = new ArrayList<>();
        for (LifeVipCoupon coupon : list) {
            Map<String,Long> map = new HashMap<>();
            map.put("couponId",coupon.getCouponId());
            map.put("number", Long.valueOf(coupon.getNumber()));
            longList.add(map);
        }
        if (insertLifeCouponReceive(shareId,longList) != insertNumBalance(longList)){
            throw new SendCouponException(UserResponseCode.SEND_COUPON_ERROR,"充值vip赠送优惠券失败");
        }
    }



    /**
     * 获取增加的行数
     *
     * @param longList
     * @return
     */
    private int insertNumBalance(List<Map<String,Long>> longList) {
        int num = 0;
        for (Map<String, Long> map : longList) {
            num += map.get("number");
        }
        return num;
    }


    /**
     * 退回优惠券
     *
     * @param couponReceiveIds
     * @return
     */
    @Override
    public int backCoupon(List<Long> couponReceiveIds) {
        return couponReceiveMapper.backCoupon(couponReceiveIds);
    }


    /**
     * 获取用户优惠券
     *
     * @param userId
     * @param status
     * @return
     */
    @Override
    public List<LifeUserCouponVo> getUserCoupon(Long userId, int status) {
        return couponReceiveMapper.getUserCoupon(userId,status);
    }


    /**
     * 使用充值券
     *
     * @param userId
     * @param couponReceiveId
     * @return
     */
    @Override
    public void useCouponType2(Long userId, Long couponReceiveId) {
        Long couponId = couponReceiveMapper.getUserCouponByCouponReceive(userId,couponReceiveId);
        LifeCoupon coupon = couponService.selectLifeCouponById(couponId);
        if (coupon == null){
            throw new UserOperationException(UserResponseCode.USE_COUPON_TYPE_2,"优惠券不存在");
        }
        LifeUser user = userService.selectLifeUserById(userId);
        LifePoint point = new LifePoint();
        point.setVipId(-1L);
        point.setUsePoint(coupon.getPoint());
        point.setIsAddChild(0);
        point.setIsSetChild(0);
        point.setShareId(user.getShareId());
        point.setUserId(user.getUserId());
        point.setPointType(3);
        LocalDateTime start = LocalDateTime.now();
        point.setStartDate(start);
        point.setEndDate(start.plusDays(coupon.getEnableDay()+1));
        point.setPoint(coupon.getPoint());
        if (pointService.insertLifePoint(point) == 0){
            throw new UserOperationException(UserResponseCode.USE_COUPON_TYPE_2,"积分赠送失败");
        }
        LifePointLog pointLog = new LifePointLog();
        pointLog.setUserId(userId);
        pointLog.setShareId(user.getShareId());
        pointLog.setAddTime(start);
        pointLog.setExplain("使用"+coupon.getName());
        pointLog.setPoint(coupon.getPoint());
        pointLog.setLogType(3);
        if (pointLogService.insertLifePointLog(pointLog) == 0){
            throw new UserOperationException(UserResponseCode.USE_COUPON_TYPE_2,"积分日志添加失败");
        }
        if (useCoupon(couponReceiveId) == 0){
            throw new UserOperationException(UserResponseCode.USE_COUPON_TYPE_2,"优惠券不可使用");
        }

    }


    /**
     * 使用优惠券
     *
     * @param courseReceiveId
     * @return
     */
    @Override
    public int useCoupon(Long courseReceiveId) {
        return couponReceiveMapper.useCoupon(courseReceiveId);
    }



}
