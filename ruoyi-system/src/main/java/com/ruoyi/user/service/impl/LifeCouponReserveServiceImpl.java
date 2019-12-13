package com.ruoyi.user.service.impl;


import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.user.domain.LifeCompanyCoupon;
import com.ruoyi.user.domain.LifeCoupon;
import com.ruoyi.user.domain.LifeCouponReserve;
import com.ruoyi.user.domain.LifeVipCoupon;
import com.ruoyi.user.mapper.LifeCouponReserveMapper;
import com.ruoyi.user.service.LifeCouponReserveService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.user.service.LifeCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class LifeCouponReserveServiceImpl implements LifeCouponReserveService
{
    @Resource
    private LifeCouponReserveMapper couponReserveMapper;


    @Autowired
    private LifeCouponService couponService;


    /**
     * 查询用户优惠卷
     * 
     * @param receiveId 用户优惠卷ID
     * @return 用户优惠卷
     */
    @Override
    public LifeCouponReserve selectLifeCouponReserveById(Long receiveId)
    {
        return couponReserveMapper.selectLifeCouponReserveById(receiveId);
    }

    /**
     * 查询用户优惠卷列表
     * 
     * @param lifeCouponReserve 用户优惠卷
     * @return 用户优惠卷
     */
    @Override
    public List<LifeCouponReserve> selectLifeCouponReserveList(LifeCouponReserve lifeCouponReserve)
    {
        return couponReserveMapper.selectLifeCouponReserveList(lifeCouponReserve);
    }

    /**
     * 新增用户优惠卷
     * 
     * @param lifeCouponReserve 用户优惠卷
     * @return 结果
     */
    @Override
    public int insertLifeCouponReserve(LifeCouponReserve lifeCouponReserve)
    {
        lifeCouponReserve.setCreateTime(DateUtils.getNowDate());
        return couponReserveMapper.insertLifeCouponReserve(lifeCouponReserve);
    }

    /**
     * 修改用户优惠卷
     * 
     * @param lifeCouponReserve 用户优惠卷
     * @return 结果
     */
    @Override
    public int updateLifeCouponReserve(LifeCouponReserve lifeCouponReserve)
    {
        return couponReserveMapper.updateLifeCouponReserve(lifeCouponReserve);
    }

    /**
     * 删除用户优惠卷对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCouponReserveByIds(String ids)
    {
        return couponReserveMapper.deleteLifeCouponReserveByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户优惠卷信息
     * 
     * @param receiveId 用户优惠卷ID
     * @return 结果
     */
    @Override
    public int deleteLifeCouponReserveById(Long receiveId)
    {
        return couponReserveMapper.deleteLifeCouponReserveById(receiveId);
    }

    /**
     * 送优惠券
     *
     * @param list 优惠卷ids
     * @return 结果
     */
    private int insertLifeCouponReserve(Long shareId, List<Map<String,Long>> list) {
        List<LifeCouponReserve> couponReserveList = new ArrayList<>();
        LocalDateTime start = LocalDateTime.now().plusDays(1);
        for (Map<String,Long> map : list) {
            LifeCoupon lifeCoupon = couponService.selectLifeCouponById(map.get("couponId"));
            LifeCouponReserve couponReserve = new LifeCouponReserve();
            LocalDateTime end = LocalDateTime.of(start.getYear(),start.getMonth(),start.getDayOfMonth(),0,0,0).plusDays(lifeCoupon.getEnableDay());
            couponReserve.setCouponId(lifeCoupon.getCouponId());
            couponReserve.setShareId(shareId);
            couponReserve.setStatus(0);
            couponReserve.setEndTime(end);
            couponReserve.setStartTime(LocalDateTime.now());

            for (int i = 0; i < map.get("number"); i++) {
                if (lifeCoupon.getIntervalDay() != null && lifeCoupon.getIntervalDay() != 0){
                    couponReserve.setStartTime(couponReserve.getEndTime().plusDays(lifeCoupon.getIntervalDay()));
                }
                int random = (int) (Math.random()*900000) + 100000;
                String destroy =shareId+"_"+System.currentTimeMillis()+random;
                couponReserve.setDestroy( Md5Utils.hash(destroy));
                couponReserveList.add(couponReserve);
            }

        }
        return couponReserveMapper.insertLifeCouponReserves(couponReserveList);
    }


    @Override
    public int pastCoupon() {
        return couponReserveMapper.pastCoupon();
    }


    /**
     * 新增充值余额所送优惠券
     *
     * @param shareId
     * @param list    优惠卷ids
     * @return 结果
     */
    @Override
    public int insertLifeCouponReserveBalance(Long shareId, List<LifeCompanyCoupon> list) {
        List<Map<String,Long>> longList = new ArrayList<>();
        for (LifeCompanyCoupon coupon : list) {
            Map<String,Long> map = new HashMap<>();
            map.put("couponId",coupon.getCouponId());
            map.put("number", Long.valueOf(coupon.getNumber()));
            longList.add(map);
        }
        return this.insertLifeCouponReserve(shareId,longList);
    }

    /**
     * 新增充值vip所送优惠券
     *
     * @param shareId
     * @param list    优惠卷ids
     * @return 结果
     */
    @Override
    public int insertLifeCouponReserveVip(Long shareId, List<LifeVipCoupon> list) {
        List<Map<String,Long>> longList = new ArrayList<>();
        for (LifeVipCoupon coupon : list) {
            Map<String,Long> map = new HashMap<>();
            map.put("couponId",coupon.getCouponId());
            map.put("number", Long.valueOf(coupon.getNumber()));
            longList.add(map);
        }
        return this.insertLifeCouponReserve(shareId,longList);
    }

    /**
     * 获取增加的行数
     *
     * @param list
     * @return
     */
    @Override
    public int insertNumVip(List<LifeVipCoupon> list) {
        int num = 0;
        for (LifeVipCoupon vipCoupon : list) {
            num += vipCoupon.getNumber();
        }
        return num;
    }

    /**
     * 获取增加的行数
     *
     * @param list
     * @return
     */
    @Override
    public int insertNumBalance(List<LifeCompanyCoupon> list) {
        int num = 0;
        for (LifeCompanyCoupon companyCoupon : list) {
            num += companyCoupon.getNumber();
        }
        return num;
    }
}
